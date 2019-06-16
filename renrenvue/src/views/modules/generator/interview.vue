<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('generator:interview:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('generator:interview:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
        <el-button v-if="isAuth('generator:interview:save')" type="primary" @click="intwAddHandle()">新增预约</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="intwId"
        header-align="center"
        align="center"
        label="面试ID">
      </el-table-column>
      <el-table-column
        prop="intwResumeId"
        header-align="center"
        align="center"
        label="简历ID">
      </el-table-column>
      <el-table-column
        prop="intwName"
        header-align="center"
        align="center"
        label="应聘者姓名">
      </el-table-column>
      <el-table-column
        prop="intwMobile"
        header-align="center"
        align="center"
        label="应聘者电话">
      </el-table-column>
      <el-table-column
        prop="intwBookTime"
        header-align="center"
        align="center"
        label="预约时间">
      </el-table-column>
      <el-table-column
        prop="intwHrId"
        header-align="center"
        align="center"
        label="预约人">
      </el-table-column>
      <el-table-column
        prop="intwState"
        :formatter="statusFormat1"
        header-align="center"
        align="center"
        label="当前状态">
      </el-table-column>
      <el-table-column
        prop="intwTime"
        header-align="center"
        align="center"
        label="操作时间">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.intwId)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.intwId)">删除</el-button>
          <el-button type="text" size="small" @click="recordHandle(scope.row.intwResumeId)">面试</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
    <interview-add v-if="intwAddVisible" ref="intwAdd" @refreshDataList="getDataList"></interview-add>
    <!--interview-record v-if="recordVisible" ref="recordAdd" @refreshDataList="getDataList"></interview-record-->
    <info v-if="recordVisible" ref="recordAdd" @refreshDataList="getDataList"></info>
  </div>
</template>

<script>
  import AddOrUpdate from './interview-add-or-update'
  import InterviewAdd from './interview-add'
//import InterviewRecord from './interview-record'
  import Info from './info'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false,
        intwAddVisible: false,
        recordVisible: false,
      }
    },
    components: {
      AddOrUpdate,
      InterviewAdd,
    //InterviewRecord
      Info
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/generator/interview/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 修改status
      statusFormat1: function(row, column) {
          let statusW = "未面试";
          let status = row.intwState;
          switch(status) {
           case 1:
           statusW = "已面试";
           break;
           case 2:
           statusW = "未面试";
           break;
          }
          return statusW;
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 面试
      recordHandle (id){
        console.log("sdasdasd="+id)
        this.recordVisible = true;
        this.$nextTick(()=>{
        this.$refs.recordAdd.init(id);
        this.$refs.recordAdd.getDataList(id);
        })
      },
      //新增预约
      intwAddHandle (){
        this.intwAddVisible = true;
        this.$nextTick(()=>{
          this.$refs.intwAdd.init();
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.intwId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/generator/interview/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>

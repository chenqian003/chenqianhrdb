<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getSolrData(dataForm.key)">查询</el-button>
        <!-- <el-button v-if="isAuth('generator:resume:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button> -->
        <el-button v-if="isAuth('generator:resume:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
        <el-button type="primary" @click="getShare()">分享获取的简历</el-button>
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
        prop="resName"
        header-align="center"
        align="center"
        label="姓名">
      </el-table-column>
      <el-table-column
        prop="resGender"
        header-align="center"
        align="center"
        label="性别">
      </el-table-column>
      <el-table-column
        prop="resEducation"
        header-align="center"
        align="center"
        label="学历">
      </el-table-column>
      <el-table-column
        prop="resMajor"
        header-align="center"
        align="center"
        label="所学专业">
      </el-table-column>
      <el-table-column
        prop="resOutCollege"
        header-align="center"
        align="center"
        label="毕业时间">
      </el-table-column>
      <el-table-column
        prop="resWorkYear"
        header-align="center"
        align="center"
        label="工作年限">
      </el-table-column>
      <el-table-column
        prop="resCity"
        header-align="center"
        align="center"
        label="居住城市">
      </el-table-column>
      <el-table-column
        prop="resTime"
        header-align="center"
        align="center"
        label="录入时间">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="resDataHandle(scope.row.resId)">详情</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.resId)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <!-- <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination> -->

    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
    <!-- 详情页 -->
    <res-data v-if="resDataVisible" ref="resData" ></res-data>
  </div>
</template>

<script>
  import AddOrUpdate from './resume-add-or-update'
  import ResData from './resData'
  import Vue from 'vue'
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
        resDataVisible:false
      }
    },
    components: {
      AddOrUpdate,
      ResData
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/generator/resume/list'),
          method: 'get',
          params: this.$http.adornParams({
            // 'page': this.pageIndex,
            // 'limit': this.pageSize,
            // 'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.list
            this.changeDate();
            // this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            // this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },

      //获取分享的简历
      getShare(){
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/generator/resume/getShare'),
          method: 'get',
          params: this.$http.adornParams({

          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.list
            this.changeDate();
          } else {
            this.dataList = []
          }
          this.dataListLoading = false
        })
      },
      // 对resTime进行排序
      changeDate(){
        this.dataList.sort((a,b)=>{
          let aTimeString = a.resTime;
          let bTimeString = b.resTime;
          aTimeString = aTimeString.replace(/-/g,'/');
          bTimeString = bTimeString.replace(/-/g,'/');
          let aTime = new Date(aTimeString).getTime()
          let bTime = new Date(bTimeString).getTime()
          return bTime - aTime;
        })
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
      //详情页
      resDataHandle (id){
        this.resDataVisible = true
        this.$nextTick(()=>{
          this.$refs.resData.init(id)
        })
      },
      //查询solr数据
      getSolrData (val){
        this.dataListLoading = true;
        console.log(val);
        if(val){
          val = '*';
        }
        this.$http({
          url: this.$http.adornUrl('/generator/resume/getSolrData'),
          method: 'get',
          params: this.$http.adornParams({
            // 'page': this.pageIndex,
            // 'limit': this.pageSize,
            'keywords': val
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.list
            this.changeDate();
            // this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            // this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.resId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/generator/resume/delete'),
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

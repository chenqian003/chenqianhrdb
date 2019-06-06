<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('generator:occupation:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('generator:occupation:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
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
        prop="occId"
        header-align="center"
        align="center"
        label="职位ID">
      </el-table-column>
      <el-table-column
        prop="occName"
        header-align="center"
        align="center"
        label="职位名称">
      </el-table-column>
      <el-table-column
        prop="occCategoty"
        header-align="center"
        align="center"
        label="所属类别">
      </el-table-column>
      <el-table-column
        prop="occCity"
        header-align="center"
        align="center"
        label="所属城市">
      </el-table-column>
      <el-table-column
        prop="occTime"
        header-align="center"
        align="center"
        label="当前时间">
      </el-table-column>
      <el-table-column
        prop="occHr"
        header-align="center"
        align="center"
        label="发布人">
      </el-table-column>
      <el-table-column
        prop="occDescription"
        header-align="center"
        align="center"
        label="职位描述">
      </el-table-column>
      <el-table-column
        prop="occState"
        header-align="center"
        align="center"
        label="当前状态">
      </el-table-column>
      <el-table-column
        prop="occNature"
        header-align="center"
        align="center"
        label="工作性质">
      </el-table-column>
      <el-table-column
        prop="occSalaryRange"
        header-align="center"
        align="center"
        label="月薪范围">
      </el-table-column>
      <el-table-column
        prop="occWorkAddress"
        header-align="center"
        align="center"
        label="工作地点">
      </el-table-column>
      <el-table-column
        prop="occKeyworks"
        header-align="center"
        align="center"
        label="搜索关键字">
      </el-table-column>
      <el-table-column
        prop="occCompany"
        header-align="center"
        align="center"
        label="公司名称">
      </el-table-column>
      <el-table-column
        prop="occCompanydesc"
        header-align="center"
        align="center"
        label="公司简介">
      </el-table-column>
      <el-table-column
        prop="occCount"
        header-align="center"
        align="center"
        label="招聘人数">
      </el-table-column>
      <el-table-column
        prop="occWorkYear"
        header-align="center"
        align="center"
        label="工作年限">
      </el-table-column>
      <el-table-column
        prop="occEducation"
        header-align="center"
        align="center"
        label="学历">
      </el-table-column>
      <el-table-column
        prop="occBz1"
        header-align="center"
        align="center"
        label="备注1">
      </el-table-column>
      <el-table-column
        prop="occBz2"
        header-align="center"
        align="center"
        label="备注2">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.occId)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.occId)">删除</el-button>
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
  </div>
</template>

<script>
  import AddOrUpdate from './occupation-add-or-update'
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
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/generator/occupation/list'),
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
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.occId
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/generator/occupation/delete'),
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

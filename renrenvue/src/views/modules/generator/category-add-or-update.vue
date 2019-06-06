<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="父类别ID" prop="catParentId">
      <el-input v-model="dataForm.catParentId" placeholder="父类别ID"></el-input>
    </el-form-item>
    <el-form-item label="职位名称" prop="catName">
      <el-input v-model="dataForm.catName" placeholder="职位名称"></el-input>
    </el-form-item>
    <el-form-item label="备注1" prop="catBz1">
      <el-input v-model="dataForm.catBz1" placeholder="备注1"></el-input>
    </el-form-item>
    <el-form-item label="备注2" prop="catBz2">
      <el-input v-model="dataForm.catBz2" placeholder="备注2"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          catId: 0,
          catParentId: '',
          catName: '',
          catBz1: '',
          catBz2: ''
        },
        dataRule: {
          catParentId: [
            { required: true, message: '父类别ID不能为空', trigger: 'blur' }
          ],
          catName: [
            { required: true, message: '职位名称不能为空', trigger: 'blur' }
          ],
          catBz1: [
            { required: true, message: '备注1不能为空', trigger: 'blur' }
          ],
          catBz2: [
            { required: true, message: '备注2不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.catId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.catId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/category/info/${this.dataForm.catId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.catParentId = data.category.catParentId
                this.dataForm.catName = data.category.catName
                this.dataForm.catBz1 = data.category.catBz1
                this.dataForm.catBz2 = data.category.catBz2
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/category/${!this.dataForm.catId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'catId': this.dataForm.catId || undefined,
                'catParentId': this.dataForm.catParentId,
                'catName': this.dataForm.catName,
                'catBz1': this.dataForm.catBz1,
                'catBz2': this.dataForm.catBz2
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>

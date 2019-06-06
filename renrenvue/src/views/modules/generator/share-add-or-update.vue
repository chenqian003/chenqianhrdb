<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="shaSender">
      <el-input v-model="dataForm.shaSender" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shaRecevier">
      <el-input v-model="dataForm.shaRecevier" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shaReId">
      <el-input v-model="dataForm.shaReId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shaTime">
      <el-input v-model="dataForm.shaTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shaBz1">
      <el-input v-model="dataForm.shaBz1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shaBz2">
      <el-input v-model="dataForm.shaBz2" placeholder=""></el-input>
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
          shaId: 0,
          shaSender: '',
          shaRecevier: '',
          shaReId: '',
          shaTime: '',
          shaBz1: '',
          shaBz2: ''
        },
        dataRule: {
          shaSender: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shaRecevier: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shaReId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shaTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shaBz1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shaBz2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.shaId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.shaId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/share/info/${this.dataForm.shaId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.shaSender = data.share.shaSender
                this.dataForm.shaRecevier = data.share.shaRecevier
                this.dataForm.shaReId = data.share.shaReId
                this.dataForm.shaTime = data.share.shaTime
                this.dataForm.shaBz1 = data.share.shaBz1
                this.dataForm.shaBz2 = data.share.shaBz2
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
              url: this.$http.adornUrl(`/generator/share/${!this.dataForm.shaId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'shaId': this.dataForm.shaId || undefined,
                'shaSender': this.dataForm.shaSender,
                'shaRecevier': this.dataForm.shaRecevier,
                'shaReId': this.dataForm.shaReId,
                'shaTime': this.dataForm.shaTime,
                'shaBz1': this.dataForm.shaBz1,
                'shaBz2': this.dataForm.shaBz2
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

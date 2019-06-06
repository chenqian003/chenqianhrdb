<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="发起人ID" prop="friSender">
      <el-input v-model="dataForm.friSender" placeholder="发起人ID"></el-input>
    </el-form-item>
    <el-form-item label="接收人ID" prop="friReceiver">
      <el-input v-model="dataForm.friReceiver" placeholder="接收人ID"></el-input>
    </el-form-item>
    <el-form-item label="关系状态" prop="friState">
      <el-input v-model="dataForm.friState" placeholder="关系状态"></el-input>
    </el-form-item>
    <el-form-item label="验证消息" prop="friMsg">
      <el-input v-model="dataForm.friMsg" placeholder="验证消息"></el-input>
    </el-form-item>
    <el-form-item label="操作时间" prop="friTime">
      <el-input v-model="dataForm.friTime" placeholder="操作时间"></el-input>
    </el-form-item>
    <el-form-item label="备注1" prop="friBz1">
      <el-input v-model="dataForm.friBz1" placeholder="备注1"></el-input>
    </el-form-item>
    <el-form-item label="备注2" prop="friBz2">
      <el-input v-model="dataForm.friBz2" placeholder="备注2"></el-input>
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
          friId: 0,
          friSender: '',
          friReceiver: '',
          friState: '',
          friMsg: '',
          friTime: '',
          friBz1: '',
          friBz2: ''
        },
        dataRule: {
          friSender: [
            { required: true, message: '发起人ID不能为空', trigger: 'blur' }
          ],
          friReceiver: [
            { required: true, message: '接收人ID不能为空', trigger: 'blur' }
          ],
          friState: [
            { required: true, message: '关系状态不能为空', trigger: 'blur' }
          ],
          friMsg: [
            { required: true, message: '验证消息不能为空', trigger: 'blur' }
          ],
          friTime: [
            { required: true, message: '操作时间不能为空', trigger: 'blur' }
          ],
          friBz1: [
            { required: true, message: '备注1不能为空', trigger: 'blur' }
          ],
          friBz2: [
            { required: true, message: '备注2不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.friId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.friId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/friends/info/${this.dataForm.friId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.friSender = data.friends.friSender
                this.dataForm.friReceiver = data.friends.friReceiver
                this.dataForm.friState = data.friends.friState
                this.dataForm.friMsg = data.friends.friMsg
                this.dataForm.friTime = data.friends.friTime
                this.dataForm.friBz1 = data.friends.friBz1
                this.dataForm.friBz2 = data.friends.friBz2
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
              url: this.$http.adornUrl(`/generator/friends/${!this.dataForm.friId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'friId': this.dataForm.friId || undefined,
                'friSender': this.dataForm.friSender,
                'friReceiver': this.dataForm.friReceiver,
                'friState': this.dataForm.friState,
                'friMsg': this.dataForm.friMsg,
                'friTime': this.dataForm.friTime,
                'friBz1': this.dataForm.friBz1,
                'friBz2': this.dataForm.friBz2
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

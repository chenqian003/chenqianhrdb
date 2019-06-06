<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="简历ID" prop="recRId">
      <el-input v-model="dataForm.recRId" placeholder="简历ID"></el-input>
    </el-form-item>
    <el-form-item label="HR_ID" prop="recHrId">
      <el-input v-model="dataForm.recHrId" placeholder="HR_ID"></el-input>
    </el-form-item>
    <el-form-item label="沟通能力" prop="recCommunicate">
      <el-input v-model="dataForm.recCommunicate" placeholder="沟通能力"></el-input>
    </el-form-item>
    <el-form-item label="技能水平" prop="recSkill">
      <el-input v-model="dataForm.recSkill" placeholder="技能水平"></el-input>
    </el-form-item>
    <el-form-item label="学习能力" prop="recStudy">
      <el-input v-model="dataForm.recStudy" placeholder="学习能力"></el-input>
    </el-form-item>
    <el-form-item label="情商" prop="recEq">
      <el-input v-model="dataForm.recEq" placeholder="情商"></el-input>
    </el-form-item>
    <el-form-item label="面试印象" prop="recImpression">
      <el-input v-model="dataForm.recImpression" placeholder="面试印象"></el-input>
    </el-form-item>
    <el-form-item label="操作时间" prop="recTime">
      <el-input v-model="dataForm.recTime" placeholder="操作时间"></el-input>
    </el-form-item>
    <el-form-item label="备注1" prop="recBz1">
      <el-input v-model="dataForm.recBz1" placeholder="备注1"></el-input>
    </el-form-item>
    <el-form-item label="备注2" prop="recBz2">
      <el-input v-model="dataForm.recBz2" placeholder="备注2"></el-input>
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
          recId: 0,
          recRId: '',
          recHrId: '',
          recCommunicate: '',
          recSkill: '',
          recStudy: '',
          recEq: '',
          recImpression: '',
          recTime: '',
          recBz1: '',
          recBz2: ''
        },
        dataRule: {
          recRId: [
            { required: true, message: '简历ID不能为空', trigger: 'blur' }
          ],
          recHrId: [
            { required: true, message: 'HR_ID不能为空', trigger: 'blur' }
          ],
          recCommunicate: [
            { required: true, message: '沟通能力不能为空', trigger: 'blur' }
          ],
          recSkill: [
            { required: true, message: '技能水平不能为空', trigger: 'blur' }
          ],
          recStudy: [
            { required: true, message: '学习能力不能为空', trigger: 'blur' }
          ],
          recEq: [
            { required: true, message: '情商不能为空', trigger: 'blur' }
          ],
          recImpression: [
            { required: true, message: '面试印象不能为空', trigger: 'blur' }
          ],
          recTime: [
            { required: true, message: '操作时间不能为空', trigger: 'blur' }
          ],
          recBz1: [
            { required: true, message: '备注1不能为空', trigger: 'blur' }
          ],
          recBz2: [
            { required: true, message: '备注2不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.recId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.recId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/record/info/${this.dataForm.recId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.recRId = data.record.recRId
                this.dataForm.recHrId = data.record.recHrId
                this.dataForm.recCommunicate = data.record.recCommunicate
                this.dataForm.recSkill = data.record.recSkill
                this.dataForm.recStudy = data.record.recStudy
                this.dataForm.recEq = data.record.recEq
                this.dataForm.recImpression = data.record.recImpression
                this.dataForm.recTime = data.record.recTime
                this.dataForm.recBz1 = data.record.recBz1
                this.dataForm.recBz2 = data.record.recBz2
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
              url: this.$http.adornUrl(`/generator/record/${!this.dataForm.recId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'recId': this.dataForm.recId || undefined,
                'recRId': this.dataForm.recRId,
                'recHrId': this.dataForm.recHrId,
                'recCommunicate': this.dataForm.recCommunicate,
                'recSkill': this.dataForm.recSkill,
                'recStudy': this.dataForm.recStudy,
                'recEq': this.dataForm.recEq,
                'recImpression': this.dataForm.recImpression,
                'recTime': this.dataForm.recTime,
                'recBz1': this.dataForm.recBz1,
                'recBz2': this.dataForm.recBz2
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

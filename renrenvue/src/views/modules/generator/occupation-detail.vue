<template>
    <el-dialog
    :title="!dataForm.id ? '详情' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="职位名称" prop="occName">
      <el-input v-model="dataForm.occName" placeholder="职位名称"></el-input>
    </el-form-item>
    <el-form-item label="所属类别" prop="occCategoty">
      <el-input v-model="dataForm.occCategoty" placeholder="所属类别"></el-input>
    </el-form-item>
    <el-form-item label="所属城市" prop="occCity">
      <el-input v-model="dataForm.occCity" placeholder="所属城市"></el-input>
    </el-form-item>
    <el-form-item label="当前时间" prop="occTime">
      <el-input v-model="dataForm.occTime" placeholder="当前时间"></el-input>
    </el-form-item>
    <el-form-item label="发布人" prop="occHr">
      <el-input v-model="dataForm.occHr" placeholder="发布人"></el-input>
    </el-form-item>
    <el-form-item label="职位描述" prop="occDescription">
      <el-input v-model="dataForm.occDescription" placeholder="职位描述"></el-input>
    </el-form-item>
    <el-form-item label="当前状态" prop="occState">
      <el-input v-model="dataForm.occState" placeholder="当前状态"></el-input>
    </el-form-item>
    <el-form-item label="工作性质" prop="occNature">
      <el-input v-model="dataForm.occNature" placeholder="工作性质"></el-input>
    </el-form-item>
    <el-form-item label="月薪范围" prop="occSalaryRange">
      <el-input v-model="dataForm.occSalaryRange" placeholder="月薪范围"></el-input>
    </el-form-item>
    <el-form-item label="工作地点" prop="occWorkAddress">
      <el-input v-model="dataForm.occWorkAddress" placeholder="工作地点"></el-input>
    </el-form-item>
    <el-form-item label="搜索关键字" prop="occKeyworks">
      <el-input v-model="dataForm.occKeyworks" placeholder="搜索关键字"></el-input>
    </el-form-item>
    <el-form-item label="公司名称" prop="occCompany">
      <el-input v-model="dataForm.occCompany" placeholder="公司名称"></el-input>
    </el-form-item>
    <el-form-item label="公司简介" prop="occCompanydesc">
      <el-input v-model="dataForm.occCompanydesc" placeholder="公司简介"></el-input>
    </el-form-item>
    <el-form-item label="招聘人数" prop="occCount">
      <el-input v-model="dataForm.occCount" placeholder="招聘人数"></el-input>
    </el-form-item>
    <el-form-item label="工作年限" prop="occWorkYear">
      <el-input v-model="dataForm.occWorkYear" placeholder="工作年限"></el-input>
    </el-form-item>
    <el-form-item label="学历" prop="occEducation">
      <el-input v-model="dataForm.occEducation" placeholder="学历"></el-input>
    </el-form-item>
    <el-form-item label="备注1" prop="occBz1">
      <el-input v-model="dataForm.occBz1" placeholder="备注1"></el-input>
    </el-form-item>
    <el-form-item label="备注2" prop="occBz2">
      <el-input v-model="dataForm.occBz2" placeholder="备注2"></el-input>
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
   data() {
        return {
            visible: false,

        dataForm: {
          occId: 0,
          occName: '',
          occCategoty: '',
          occCity: '',
          occTime: '',
          occHr: '',
          occDescription: '',
          occState: '',
          occNature: '',
          occSalaryRange: '',
          occWorkAddress: '',
          occKeyworks: '',
          occCompany: '',
          occCompanydesc: '',
          occCount: '',
          occWorkYear: '',
          occEducation: '',
          occBz1: '',
          occBz2: ''
        },
        dataRule: {
          occName: [
            { required: true, message: '职位名称不能为空', trigger: 'blur' }
          ],
          occCategoty: [
            { required: true, message: '所属类别不能为空', trigger: 'blur' }
          ],
          occCity: [
            { required: true, message: '所属城市不能为空', trigger: 'blur' }
          ],
          occTime: [
            { required: true, message: '当前时间不能为空', trigger: 'blur' }
          ],
          occHr: [
            { required: true, message: '发布人不能为空', trigger: 'blur' }
          ],
          occDescription: [
            { required: true, message: '职位描述不能为空', trigger: 'blur' }
          ],
          occState: [
            { required: true, message: '当前状态不能为空', trigger: 'blur' }
          ],
          occNature: [
            { required: true, message: '工作性质不能为空', trigger: 'blur' }
          ],
          occSalaryRange: [
            { required: true, message: '月薪范围不能为空', trigger: 'blur' }
          ],
          occWorkAddress: [
            { required: true, message: '工作地点不能为空', trigger: 'blur' }
          ],
          occKeyworks: [
            { required: true, message: '搜索关键字不能为空', trigger: 'blur' }
          ],
          occCompany: [
            { required: true, message: '公司名称不能为空', trigger: 'blur' }
          ],
          occCompanydesc: [
            { required: true, message: '公司简介不能为空', trigger: 'blur' }
          ],
          occCount: [
            { required: true, message: '招聘人数不能为空', trigger: 'blur' }
          ],
          occWorkYear: [
            { required: true, message: '工作年限不能为空', trigger: 'blur' }
          ],
          occEducation: [
            { required: true, message: '学历不能为空', trigger: 'blur' }
          ],
          occBz1: [
            { required: true, message: '备注1不能为空', trigger: 'blur' }
          ],
          occBz2: [
            { required: true, message: '备注2不能为空', trigger: 'blur' }
          ]
        }
      }
    },
   
    methods: {
        inits(){
            this.visible = true
            this.$nextTick(()=> {
                this.$refs['dataForm'].resetFields()
            })
        },
      init (id) {
        this.dataForm.occId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.occId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/occupation/info/${this.dataForm.occId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.occName = data.occupation.occName
                this.dataForm.occCategoty = data.occupation.occCategoty
                this.dataForm.occCity = data.occupation.occCity
                this.dataForm.occTime = data.occupation.occTime
                this.dataForm.occHr = data.occupation.occHr
                this.dataForm.occDescription = data.occupation.occDescription
                this.dataForm.occState = data.occupation.occState
                this.dataForm.occNature = data.occupation.occNature
                this.dataForm.occSalaryRange = data.occupation.occSalaryRange
                this.dataForm.occWorkAddress = data.occupation.occWorkAddress
                this.dataForm.occKeyworks = data.occupation.occKeyworks
                this.dataForm.occCompany = data.occupation.occCompany
                this.dataForm.occCompanydesc = data.occupation.occCompanydesc
                this.dataForm.occCount = data.occupation.occCount
                this.dataForm.occWorkYear = data.occupation.occWorkYear
                this.dataForm.occEducation = data.occupation.occEducation
                this.dataForm.occBz1 = data.occupation.occBz1
                this.dataForm.occBz2 = data.occupation.occBz2
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
              url: this.$http.adornUrl(`/generator/occupation/${!this.dataForm.occId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'occId': this.dataForm.occId || undefined,
                'occName': this.dataForm.occName,
                'occCategoty': this.dataForm.occCategoty,
                'occCity': this.dataForm.occCity,
                'occTime': this.dataForm.occTime,
                'occHr': this.dataForm.occHr,
                'occDescription': this.dataForm.occDescription,
                'occState': this.dataForm.occState,
                'occNature': this.dataForm.occNature,
                'occSalaryRange': this.dataForm.occSalaryRange,
                'occWorkAddress': this.dataForm.occWorkAddress,
                'occKeyworks': this.dataForm.occKeyworks,
                'occCompany': this.dataForm.occCompany,
                'occCompanydesc': this.dataForm.occCompanydesc,
                'occCount': this.dataForm.occCount,
                'occWorkYear': this.dataForm.occWorkYear,
                'occEducation': this.dataForm.occEducation,
                'occBz1': this.dataForm.occBz1,
                'occBz2': this.dataForm.occBz2
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





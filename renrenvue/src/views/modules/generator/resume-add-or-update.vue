<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="姓名" prop="resName">
      <el-input v-model="dataForm.resName" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="resAge">
      <el-input v-model="dataForm.resAge" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="resGender">
      <el-input v-model="dataForm.resGender" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="婚姻" prop="resMarriage">
      <el-input v-model="dataForm.resMarriage" placeholder="婚姻"></el-input>
    </el-form-item>
    <el-form-item label="学历" prop="resEducation">
      <el-input v-model="dataForm.resEducation" placeholder="学历"></el-input>
    </el-form-item>
    <el-form-item label="毕业院校" prop="resCollege">
      <el-input v-model="dataForm.resCollege" placeholder="毕业院校"></el-input>
    </el-form-item>
    <el-form-item label="所学专业" prop="resMajor">
      <el-input v-model="dataForm.resMajor" placeholder="所学专业"></el-input>
    </el-form-item>
    <el-form-item label="英语水平" prop="resEnglish">
      <el-input v-model="dataForm.resEnglish" placeholder="英语水平"></el-input>
    </el-form-item>
    <el-form-item label="入学时间" prop="resInCollege">
      <el-input v-model="dataForm.resInCollege" placeholder="入学时间"></el-input>
    </el-form-item>
    <el-form-item label="毕业时间" prop="resOutCollege">
      <el-input v-model="dataForm.resOutCollege" placeholder="毕业时间"></el-input>
    </el-form-item>
    <el-form-item label="居住城市" prop="resCity">
      <el-input v-model="dataForm.resCity" placeholder="居住城市"></el-input>
    </el-form-item>
    <el-form-item label="工作年限" prop="resWorkYear">
      <el-input v-model="dataForm.resWorkYear" placeholder="工作年限"></el-input>
    </el-form-item>
    <el-form-item label="出生年月" prop="resBirthday">
      <el-input v-model="dataForm.resBirthday" placeholder="出生年月"></el-input>
    </el-form-item>
    <el-form-item label="户籍" prop="resHometown">
      <el-input v-model="dataForm.resHometown" placeholder="户籍"></el-input>
    </el-form-item>
    <el-form-item label="手机号码" prop="resMobile">
      <el-input v-model="dataForm.resMobile" placeholder="手机号码"></el-input>
    </el-form-item>
    <el-form-item label="邮箱" prop="resMail">
      <el-input v-model="dataForm.resMail" placeholder="邮箱"></el-input>
    </el-form-item>
    <el-form-item label="自我评价" prop="resEvaluate">
      <el-input v-model="dataForm.resEvaluate" placeholder="自我评价"></el-input>
    </el-form-item>
    <el-form-item label="期望工作地区" prop="resExpectedArea">
      <el-input v-model="dataForm.resExpectedArea" placeholder="期望工作地区"></el-input>
    </el-form-item>
    <el-form-item label="期望工作性质" prop="resExpectedWork">
      <el-input v-model="dataForm.resExpectedWork" placeholder="期望工作性质"></el-input>
    </el-form-item>
    <el-form-item label="期望工作职业" prop="resExpectedOccupation">
      <el-input v-model="dataForm.resExpectedOccupation" placeholder="期望工作职业"></el-input>
    </el-form-item>
    <el-form-item label="期望月薪" prop="resExpectedSalary">
      <el-input v-model="dataForm.resExpectedSalary" placeholder="期望月薪"></el-input>
    </el-form-item>
    <el-form-item label="目前状况" prop="resCurrentAtate">
      <el-input v-model="dataForm.resCurrentAtate" placeholder="目前状况"></el-input>
    </el-form-item>
    <el-form-item label="期望从事行业" prop="resExpectedIndustry">
      <el-input v-model="dataForm.resExpectedIndustry" placeholder="期望从事行业"></el-input>
    </el-form-item>
    <el-form-item label="工作经历" prop="resWorkExperience">
      <el-input v-model="dataForm.resWorkExperience" placeholder="工作经历"></el-input>
    </el-form-item>
    <el-form-item label="项目经验" prop="resProjectExperience">
      <el-input v-model="dataForm.resProjectExperience" placeholder="项目经验"></el-input>
    </el-form-item>
    <el-form-item label="专业技能" prop="resProfessionalSkill">
      <el-input v-model="dataForm.resProfessionalSkill" placeholder="专业技能"></el-input>
    </el-form-item>
    <el-form-item label="兴趣爱好" prop="resInterest">
      <el-input v-model="dataForm.resInterest" placeholder="兴趣爱好"></el-input>
    </el-form-item>
    <el-form-item label="录入时间" prop="resTime">
      <el-input v-model="dataForm.resTime" placeholder="录入时间"></el-input>
    </el-form-item>
    <el-form-item label="录入人" prop="resHrId">
      <el-input v-model="dataForm.resHrId" placeholder="录入人"></el-input>
    </el-form-item>
    <el-form-item label="来源" prop="resFrom">
      <el-input v-model="dataForm.resFrom" placeholder="来源"></el-input>
    </el-form-item>
    <el-form-item label="备注1" prop="resBz1">
      <el-input v-model="dataForm.resBz1" placeholder="备注1"></el-input>
    </el-form-item>
    <el-form-item label="备注2" prop="resBz2">
      <el-input v-model="dataForm.resBz2" placeholder="备注2"></el-input>
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
          resId: 0,
          resName: '',
          resAge: '',
          resGender: '',
          resMarriage: '',
          resEducation: '',
          resCollege: '',
          resMajor: '',
          resEnglish: '',
          resInCollege: '',
          resOutCollege: '',
          resCity: '',
          resWorkYear: '',
          resBirthday: '',
          resHometown: '',
          resMobile: '',
          resMail: '',
          resEvaluate: '',
          resExpectedArea: '',
          resExpectedWork: '',
          resExpectedOccupation: '',
          resExpectedSalary: '',
          resCurrentAtate: '',
          resExpectedIndustry: '',
          resWorkExperience: '',
          resProjectExperience: '',
          resProfessionalSkill: '',
          resInterest: '',
          resTime: '',
          resHrId: '',
          resFrom: '',
          resBz1: '',
          resBz2: ''
        },
        dataRule: {
          resName: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          resAge: [
            { required: true, message: '年龄不能为空', trigger: 'blur' }
          ],
          resGender: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          resMarriage: [
            { required: true, message: '婚姻不能为空', trigger: 'blur' }
          ],
          resEducation: [
            { required: true, message: '学历不能为空', trigger: 'blur' }
          ],
          resCollege: [
            { required: true, message: '毕业院校不能为空', trigger: 'blur' }
          ],
          resMajor: [
            { required: true, message: '所学专业不能为空', trigger: 'blur' }
          ],
          resEnglish: [
            { required: true, message: '英语水平不能为空', trigger: 'blur' }
          ],
          resInCollege: [
            { required: true, message: '入学时间不能为空', trigger: 'blur' }
          ],
          resOutCollege: [
            { required: true, message: '毕业时间不能为空', trigger: 'blur' }
          ],
          resCity: [
            { required: true, message: '居住城市不能为空', trigger: 'blur' }
          ],
          resWorkYear: [
            { required: true, message: '工作年限不能为空', trigger: 'blur' }
          ],
          resBirthday: [
            { required: true, message: '出生年月不能为空', trigger: 'blur' }
          ],
          resHometown: [
            { required: true, message: '户籍不能为空', trigger: 'blur' }
          ],
          resMobile: [
            { required: true, message: '手机号码不能为空', trigger: 'blur' }
          ],
          resMail: [
            { required: true, message: '邮箱不能为空', trigger: 'blur' }
          ],
          resEvaluate: [
            { required: true, message: '自我评价不能为空', trigger: 'blur' }
          ],
          resExpectedArea: [
            { required: true, message: '期望工作地区不能为空', trigger: 'blur' }
          ],
          resExpectedWork: [
            { required: true, message: '期望工作性质不能为空', trigger: 'blur' }
          ],
          resExpectedOccupation: [
            { required: true, message: '期望工作职业不能为空', trigger: 'blur' }
          ],
          resExpectedSalary: [
            { required: true, message: '期望月薪不能为空', trigger: 'blur' }
          ],
          resCurrentAtate: [
            { required: true, message: '目前状况不能为空', trigger: 'blur' }
          ],
          resExpectedIndustry: [
            { required: true, message: '期望从事行业不能为空', trigger: 'blur' }
          ],
          resWorkExperience: [
            { required: true, message: '工作经历不能为空', trigger: 'blur' }
          ],
          resProjectExperience: [
            { required: true, message: '项目经验不能为空', trigger: 'blur' }
          ],
          resProfessionalSkill: [
            { required: true, message: '专业技能不能为空', trigger: 'blur' }
          ],
          resInterest: [
            { required: true, message: '兴趣爱好不能为空', trigger: 'blur' }
          ],
          resTime: [
            { required: true, message: '录入时间不能为空', trigger: 'blur' }
          ],
          resHrId: [
            { required: true, message: '录入人不能为空', trigger: 'blur' }
          ],
          resFrom: [
            { required: true, message: '来源不能为空', trigger: 'blur' }
          ],
          resBz1: [
            { required: true, message: '备注1不能为空', trigger: 'blur' }
          ],
          resBz2: [
            { required: true, message: '备注2不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.resId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.resId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/resume/info/${this.dataForm.resId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.resName = data.resume.resName
                this.dataForm.resAge = data.resume.resAge
                this.dataForm.resGender = data.resume.resGender
                this.dataForm.resMarriage = data.resume.resMarriage
                this.dataForm.resEducation = data.resume.resEducation
                this.dataForm.resCollege = data.resume.resCollege
                this.dataForm.resMajor = data.resume.resMajor
                this.dataForm.resEnglish = data.resume.resEnglish
                this.dataForm.resInCollege = data.resume.resInCollege
                this.dataForm.resOutCollege = data.resume.resOutCollege
                this.dataForm.resCity = data.resume.resCity
                this.dataForm.resWorkYear = data.resume.resWorkYear
                this.dataForm.resBirthday = data.resume.resBirthday
                this.dataForm.resHometown = data.resume.resHometown
                this.dataForm.resMobile = data.resume.resMobile
                this.dataForm.resMail = data.resume.resMail
                this.dataForm.resEvaluate = data.resume.resEvaluate
                this.dataForm.resExpectedArea = data.resume.resExpectedArea
                this.dataForm.resExpectedWork = data.resume.resExpectedWork
                this.dataForm.resExpectedOccupation = data.resume.resExpectedOccupation
                this.dataForm.resExpectedSalary = data.resume.resExpectedSalary
                this.dataForm.resCurrentAtate = data.resume.resCurrentAtate
                this.dataForm.resExpectedIndustry = data.resume.resExpectedIndustry
                this.dataForm.resWorkExperience = data.resume.resWorkExperience
                this.dataForm.resProjectExperience = data.resume.resProjectExperience
                this.dataForm.resProfessionalSkill = data.resume.resProfessionalSkill
                this.dataForm.resInterest = data.resume.resInterest
                this.dataForm.resTime = data.resume.resTime
                this.dataForm.resHrId = data.resume.resHrId
                this.dataForm.resFrom = data.resume.resFrom
                this.dataForm.resBz1 = data.resume.resBz1
                this.dataForm.resBz2 = data.resume.resBz2
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
              url: this.$http.adornUrl(`/generator/resume/${!this.dataForm.resId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'resId': this.dataForm.resId || undefined,
                'resName': this.dataForm.resName,
                'resAge': this.dataForm.resAge,
                'resGender': this.dataForm.resGender,
                'resMarriage': this.dataForm.resMarriage,
                'resEducation': this.dataForm.resEducation,
                'resCollege': this.dataForm.resCollege,
                'resMajor': this.dataForm.resMajor,
                'resEnglish': this.dataForm.resEnglish,
                'resInCollege': this.dataForm.resInCollege,
                'resOutCollege': this.dataForm.resOutCollege,
                'resCity': this.dataForm.resCity,
                'resWorkYear': this.dataForm.resWorkYear,
                'resBirthday': this.dataForm.resBirthday,
                'resHometown': this.dataForm.resHometown,
                'resMobile': this.dataForm.resMobile,
                'resMail': this.dataForm.resMail,
                'resEvaluate': this.dataForm.resEvaluate,
                'resExpectedArea': this.dataForm.resExpectedArea,
                'resExpectedWork': this.dataForm.resExpectedWork,
                'resExpectedOccupation': this.dataForm.resExpectedOccupation,
                'resExpectedSalary': this.dataForm.resExpectedSalary,
                'resCurrentAtate': this.dataForm.resCurrentAtate,
                'resExpectedIndustry': this.dataForm.resExpectedIndustry,
                'resWorkExperience': this.dataForm.resWorkExperience,
                'resProjectExperience': this.dataForm.resProjectExperience,
                'resProfessionalSkill': this.dataForm.resProfessionalSkill,
                'resInterest': this.dataForm.resInterest,
                'resTime': this.dataForm.resTime,
                'resHrId': this.dataForm.resHrId,
                'resFrom': this.dataForm.resFrom,
                'resBz1': this.dataForm.resBz1,
                'resBz2': this.dataForm.resBz2
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

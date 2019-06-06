<template>
  <el-dialog
    title="详情"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
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
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.resId = id
        this.visible = true
        this.$nextTick(() => {
        this.$refs['dataForm'].resetFields()
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
        })
      },
    }
  }
</script>

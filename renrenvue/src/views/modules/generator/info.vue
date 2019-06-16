<template>
  <el-dialog
  title="简历详情"
  :close-on-click-modal="false"
  :visible.sync="visible">
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">年龄{{resAge}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">性别{{resGender}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">婚姻{{resMarriage}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">学历{{resEducation}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">毕业院校{{resCollege}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">所学专业{{resMajor}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">英语水平{{resEnglish}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">入学时间{{resInCollege}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">毕业时间{{resOutCollege}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">居住城市{{resCity}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">工作年限{{resWorkYear}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">出生年月{{resBirthday}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">户籍{{resHometown}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">手机号码{{resMobile}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">邮箱{{resMail}}</div></el-col>
</el-row>
<el-row >
  <el-col :span="24"><div class="grid-content bg-purple-dark">自我评价{{resEvaluate}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="8"><div class="grid-content bg-purple">期望工作地区{{resExpectedArea}}</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple-light">期望工作性质{{resExpectedWork}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">期望工作职业{{resExpectedOccupation}}</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple-light">期望月薪{{resExpectedSalary}}</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple">目前状况{{resCurrentAtate}}</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple-light">期望从事行业{{resExpectedIndustry}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="24"><div class="grid-content bg-purple">工作经历{{resWorkExperience}}</div></el-col>
  <el-col :span="24"><div class="grid-content bg-purple-light">项目经验{{resProjectExperience}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="24"><div class="grid-content bg-purple">专业技能{{resProfessionalSkill}}</div></el-col>
  <el-col :span="24"><div class="grid-content bg-purple-light">兴趣爱好{{resInterest}}</div></el-col>
  <el-col :span="10"><div class="grid-content bg-purple">录入时间{{resTime}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">录入人{{resHrId}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="8"><div class="grid-content bg-purple">来源{{resFrom}}</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple-light">备注1{{resBz1}}</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple">备注2{{resBz2}}</div></el-col>
</el-row>
<hr/><hr/>
历史面试记录：
<el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList(id)">
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
        prop="recId"
        header-align="center"
        align="center"
        label="面试记录ID">
      </el-table-column>
      <el-table-column
        prop="recRId"
        header-align="center"
        align="center"
        label="简历ID">
      </el-table-column>
      <el-table-column
        prop="recHrId"
        header-align="center"
        align="center"
        label="HR_ID">
      </el-table-column>
      <el-table-column
        prop="recCommunicate"
        header-align="center"
        align="center"
        label="沟通能力">
      </el-table-column>
      <el-table-column
        prop="recSkill"
        header-align="center"
        align="center"
        label="技能水平">
      </el-table-column>
      <el-table-column
        prop="recStudy"
        header-align="center"
        align="center"
        label="学习能力">
      </el-table-column>
      <el-table-column
        prop="recEq"
        header-align="center"
        align="center"
        label="情商">
      </el-table-column>
      <el-table-column
        prop="recImpression"
        header-align="center"
        align="center"
        label="面试印象">
      </el-table-column>

    </el-table>


<hr/><hr/>
<!-- 新增面试记录：
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="沟通能力" prop="say">
        <el-select v-model="dataForm.say" placeholder="请选择">
            <el-option v-for="item in options1" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="技能水平" prop="skill">
        <el-select v-model="dataForm.skill" placeholder="请选择">
            <el-option v-for="item in options2" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="面试印象" prop="see">
        <el-select v-model="dataForm.see" placeholder="请选择">
            <el-option v-for="item in options3" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="情商" prop="eq">
        <el-select v-model="dataForm.eq" placeholder="请选择">
            <el-option v-for="item in options4" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>
     <el-form-item label="学习能力" prop="study">
        <el-select v-model="dataForm.study" placeholder="请选择">
            <el-option v-for="item in options5" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>   
    </el-form>
        <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">点击预约</el-button>
    </span> -->
  </el-dialog>
</template>
<script>
import Editor from './MyUediter'
import cities from './cities.json'
export default {
      components:{
      Editor
    },
    data () {
      return {
        dataForm: {          
        },
        visible: false,
          resId: 0,        
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
          resBz2: '',

          dataList: [],
          dataListLoading: false,
          dataListSelections: [],
        
        // options1:[{
        //     value:'优秀',
        //     label:'优秀'
        // },{
        //     value:'良好',
        //     label:'良好'
        // },
        // {
        //     value:'较差',
        //     label:'较差'
        // }], 
        // options2:[{
        //     value:'优秀',
        //     label:'优秀'
        // },{
        //     value:'良好',
        //     label:'良好'
        // },
        // {
        //     value:'较差',
        //     label:'较差'
        // }],
        // options3:[{
        //     value:'优秀',
        //     label:'优秀'
        // },{
        //     value:'良好',
        //     label:'良好'
        // },
        // {
        //     value:'较差',
        //     label:'较差'
        // }],
        // options4:[{
        //     value:'优秀',
        //     label:'优秀'
        // },{
        //     value:'良好',
        //     label:'良好'
        // },
        // {
        //     value:'较差',
        //     label:'较差'
        // }],  
        //  options5:[{
        //     value:'优秀',
        //     label:'优秀'
        // },{
        //     value:'良好',
        //     label:'良好'
        // },
        // {
        //     value:'较差',
        //     label:'较差'
        // }],                             

        // dataRule: {
        // // resName: [
        //   //   { required: true, message: '姓名不能为空', trigger: 'blur' }
        //   // ],
        // }
        
        }
    },

    // activated () {
    //     this.getDataLists(id)
    // },
 
  methods:{
    init (id) {
    this.resId = id
    console.log("2.sdasdasd="+id)

    this.visible = true
        this.$nextTick(() => {             
            this.$http({
              url: this.$http.adornUrl(`/generator/resume/info/${this.resId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.resAge = data.resume.resAge
                this.resGender = data.resume.resGender
                this.resMarriage = data.resume.resMarriage
                this.resEducation = data.resume.resEducation
                this.resCollege = data.resume.resCollege
                this.resMajor = data.resume.resMajor
                this.resEnglish = data.resume.resEnglish
                this.resInCollege = data.resume.resInCollege
                this.resOutCollege = data.resume.resOutCollege
                this.resCity = data.resume.resCity
                this.resWorkYear = data.resume.resWorkYear
                this.resBirthday = data.resume.resBirthday
                this.resHometown = data.resume.resHometown
                this.resMobile = data.resume.resMobile
                this.resMail = data.resume.resMail
                this.resEvaluate = data.resume.resEvaluate
                this.resExpectedArea = data.resume.resExpectedArea
                this.resExpectedWork = data.resume.resExpectedWork
                this.resExpectedOccupation = data.resume.resExpectedOccupation
                this.resExpectedSalary = data.resume.resExpectedSalary
                this.resCurrentAtate = data.resume.resCurrentAtate
                this.resExpectedIndustry = data.resume.resExpectedIndustry
                this.resWorkExperience = data.resume.resWorkExperience
                this.resProjectExperience = data.resume.resProjectExperience
                this.resProfessionalSkill = data.resume.resProfessionalSkill
                this.resInterest = data.resume.resInterest
                this.resTime = data.resume.resTime
                this.resHrId = data.resume.resHrId
                this.resFrom = data.resume.resFrom
                this.resBz1 = data.resume.resBz1
                this.resBz2 = data.resume.resBz2
                

              }
            })
        })
      },


        getDataList (id) {
        this.dataListLoading = true
        this.resRId = id
        console.log("面试简历ID="+this.resRId)
        this.$http({
          url: this.$http.adornUrl(`/generator/record/listRecord/${this.resRId}`),
          method: 'get',
          // params: this.$http.adornParams({
          //   'page': this.pageIndex,
          //   'limit': this.pageSize,
          
          // })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page
          } else {
            this.dataList = []           
          }
          this.dataListLoading = false
        })
      },

      // 当前页
      // currentChangeHandle (val) {
      //   this.pageIndex = val
      //   this.getDataLists()
      // },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // //获取工作经验
      // getWorkExp(val){
      //   this.dataForm.resWorkExperience = val;
      // },
      // //获取项目经验
      // getProExp (val){
      //   this.dataForm.resProjectExperience = val;
      // },
      //重置ueditor
      // reSetUeditor(){
      //   this.$nextTick(()=>{
      //     this.$refs.reSetWorkExp.init();
      //     this.$refs.reSetProExp.init()
      //   })
      // },
      
      //表单提交
      // dataFormSubmit () {
      //   console.log(this.dataForm.resCity[1]);
      //   this.$refs['dataForm'].validate((valid) => {
      //     if (valid) {
      //       this.$http({
      //         url: this.$http.adornUrl(`/generator/interview/saveRes`),              
      //         method: 'post',
      //         data: this.$http.adornData({
      //           'resName': this.dataForm.resName,
      //           'resAge': this.dataForm.resAge,
      //           'say': this.dataForm.say,
      //           'resMarriage': this.dataForm.resMarriage,
      //           'resEducation': this.dataForm.resEducation,
      //           'resCollege': this.dataForm.resCollege,
      //           'resMajor': this.dataForm.resMajor,
      //           'resEnglish': this.dataForm.resEnglish,
      //           'resInCollege': this.dataForm.resInCollege,
      //           'resOutCollege': this.dataForm.resOutCollege,
      //           'resCity': this.dataForm.resCity[1],
      //           'resWorkYear': this.dataForm.resWorkYear,
      //           'resBirthday': this.dataForm.resBirthday,
      //           'resHometown': this.dataForm.resHometown[1],
      //           'resMobile': this.dataForm.resMobile,
      //           'resMail': this.dataForm.resMail,
      //           'resEvaluate': this.dataForm.resEvaluate,
      //           'resExpectedArea': this.dataForm.resExpectedArea[1],
      //           'resExpectedWork': this.dataForm.resExpectedWork,
      //           'resExpectedOccupation': this.dataForm.resExpectedOccupation,
      //           'resExpectedSalary': this.dataForm.resExpectedSalary,
      //           'resCurrentAtate': this.dataForm.resCurrentAtate,
      //           'resExpectedIndustry': this.dataForm.resExpectedIndustry,
      //           'resWorkExperience': this.dataForm.resWorkExperience,
      //           'resProjectExperience': this.dataForm.resProjectExperience,
      //           'resProfessionalSkill': this.dataForm.resProfessionalSkill,
      //           'resInterest': this.dataForm.resInterest,
      //           'resFrom': this.dataForm.resFrom,
      //           'intwBookTime': this.dataForm.intwBookTime
      //         })
      //       }).then(({data}) => {
      //         if (data && data.code === 0) {
      //           this.$message({
      //             message: '操作成功',
      //             type: 'success',
      //             duration: 1500,
      //             onClose: () => {
      //               this.visible = false
      //               this.$emit('refreshDataList')
      //             }
      //           })
      //         } else {
      //           this.$message.error(data.msg)
      //         }
      //       })
      //     }
      //   })
      // }
       }
}
</script>

<style>
</style>
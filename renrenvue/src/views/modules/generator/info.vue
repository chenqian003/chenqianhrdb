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
  <el-col :span="6"><div class="grid-content bg-purple">毕业院校</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">所学专业</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">英语水平</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">入学时间</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">毕业时间</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">居住城市</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">工作年限</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">出生年月</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">户籍</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">手机号码</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">邮箱</div></el-col>
</el-row>
<el-row >
  <el-col :span="24"><div class="grid-content bg-purple-dark">自我评价</div></el-col>
</el-row>
<el-row>
  <el-col :span="8"><div class="grid-content bg-purple">期望工作地区</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple-light">期望工作性质</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">期望工作职业</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple-light">期望月薪</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple">目前状况</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple-light">期望从事行业</div></el-col>
</el-row>
<el-row>
  <el-col :span="24"><div class="grid-content bg-purple">工作经历</div></el-col>
  <el-col :span="24"><div class="grid-content bg-purple-light">项目经验</div></el-col>
</el-row>
<el-row>
  <el-col :span="24"><div class="grid-content bg-purple">专业技能</div></el-col>
  <el-col :span="24"><div class="grid-content bg-purple-light">兴趣爱好</div></el-col>
  <el-col :span="10"><div class="grid-content bg-purple">录入时间</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">录入人</div></el-col>
</el-row>
<el-row>
  <el-col :span="8"><div class="grid-content bg-purple">来源</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple-light">备注1</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple">备注2</div></el-col>
</el-row>
<hr/><hr/>
历史面试记录：
<el-row>
  <el-col :span="8">面试人<div class="grid-content bg-purple"></div></el-col>
  <el-col :span="8">沟通能力<div class="grid-content bg-purple-light"></div></el-col>
  <el-col :span="8">技能水平<div class="grid-content bg-purple"></div></el-col>
  <el-col :span="8">学习能力<div class="grid-content bg-purple"></div></el-col>
</el-row>
<el-row>
  <el-col :span="8">情商<div class="grid-content bg-purple"></div></el-col>
  <el-col :span="8">面试印象<div class="grid-content bg-purple-light"></div></el-col>
  <el-col :span="8">学习能力<div class="grid-content bg-purple"></div></el-col>
  <el-col :span="8">面试时间<div class="grid-content bg-purple"></div></el-col>
</el-row>

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
        visible: false,
          resId: 0,
         
          resAge: '',
          resGender: '',
          resMarriage: '',
          resEducation: '',
         
      
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

              }
            })
        })
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
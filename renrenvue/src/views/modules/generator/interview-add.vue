<template>
  <div>
  <el-dialog
    title="应聘者信息"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="姓名" prop="resName">
      <el-input v-model="dataForm.resName" placeholder="应聘者姓名"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="resMobile">
      <el-input v-model="dataForm.resMobile" placeholder="应聘者电话"></el-input>
    </el-form-item>
    <el-form-item label="年龄" prop="resAge">
      <el-input v-model="dataForm.resAge" placeholder="年龄"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="resGender">
        <el-select v-model="dataForm.resGender" placeholder="请选择">
            <el-option v-for="item in options1" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="婚姻" prop="resMarriage">
        <el-select v-model="dataForm.resMarriage" placeholder="请选择">
            <el-option v-for="item in options2" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="学历" prop="resEducation">
        <el-select v-model="dataForm.resEducation" placeholder="请选择">
            <el-option v-for="item in options3" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="毕业院校" prop="resCollege">
      <el-input v-model="dataForm.resCollege" placeholder="毕业院校"></el-input>
    </el-form-item>
    <el-form-item label="所学专业" prop="resMajor">
      <el-input v-model="dataForm.resMajor" placeholder="所学专业"></el-input>
    </el-form-item>
    <el-form-item label="英语水平" prop="resEnglish">
        <el-select v-model="dataForm.resEnglish" placeholder="请选择">
            <el-option v-for="item in options4" 
            :key="item.value" 
            :label="item.label" 
            :value="item.value">
            </el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="入学时间" prop="resInCollege">
      <el-date-picker
        v-model="dataForm.resInCollege"
        type="date"
        placeholder="选择日期">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="毕业时间" prop="resOutCollege">
      <el-date-picker
        v-model="dataForm.resOutCollege"
        type="date"
        placeholder="选择日期">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="居住城市" prop="resCity">
      <el-cascader
        :options="provinces"
        :show-all-levels="false"
        v-model="dataForm.resCity">
      </el-cascader>
      <!-- <el-input v-model="dataForm.resCity" placeholder="自我评价"></el-input> -->
    </el-form-item>
    <el-form-item label="工作年限" prop="resWorkYear">
      <el-input v-model="dataForm.resWorkYear" placeholder="工作年限"></el-input>
    </el-form-item>
    <el-form-item label="出生年月" prop="resBirthday">
      <el-date-picker
        v-model="dataForm.resBirthday"
        type="date"
        placeholder="选择日期">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="户籍" prop="resHometown">
      <el-cascader
        :options="provinces"
        :show-all-levels="false"
        v-model="dataForm.resHometown">
      </el-cascader>
      <!-- <el-input v-model="dataForm.resHometown" placeholder="自我评价"></el-input> -->
    </el-form-item>
    <el-form-item label="邮箱" prop="resMail">
      <el-input v-model="dataForm.resMail" placeholder="xxx@qq.com"></el-input>
    </el-form-item>
    <el-form-item label="自我评价" prop="resEvaluate">
      <el-input v-model="dataForm.resEvaluate" placeholder="自我评价"></el-input>
    </el-form-item>
    <el-form-item label="期望工作地区" prop="resExpectedArea">
      <el-cascader
        :options="provinces"
        :show-all-levels="false"
        v-model="dataForm.resExpectedArea">
      </el-cascader>
      <!-- <el-input v-model="dataForm.resExpectedArea" placeholder="期望工作地区"></el-input> -->
    </el-form-item>
    <el-form-item label="期望工作性质" prop="resExpectedWork">
      <el-select v-model="dataForm.resExpectedWork" placeholder="请选择">
          <el-option v-for="item in options6" 
          :key="item.value"
          :label="item.label"
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="期望工作职业" prop="resExpectedOccupation">
      <el-select v-model="dataForm.resExpectedOccupation" placeholder="请选择">
          <el-option v-for="item in options7" 
          :key="item.value" 
          :label="item.label" 
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="期望月薪" prop="resExpectedSalary">
      <el-select v-model="dataForm.resExpectedSalary" placeholder="请选择">
          <el-option v-for="item in options8" 
          :key="item.value" 
          :label="item.label" 
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="目前状态" prop="resCurrentAtate">
      <el-select v-model="dataForm.resCurrentAtate" placeholder="请选择">
          <el-option v-for="item in options9" 
          :key="item.value" 
          :label="item.label" 
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="期望从事行业" prop="resExpectedIndustry">
      <el-select v-model="dataForm.resExpectedIndustry" placeholder="请选择">
          <el-option v-for="item in options10" 
          :key="item.value" 
          :label="item.label" 
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="工作经历" prop="resWorkExperience">

      <editor  @getData="getWorkExp" ref="reSetWorkExp" v-model="dataForm.resWorkExperience"></editor>
    </el-form-item>
    <el-form-item label="项目经历" prop="resProjectExperience">
      <editor @getData="getProExp" ref="reSetProExp" v-model="dataForm.resProjectExperience"></editor>

    </el-form-item>
    <el-form-item label="专业技能" prop="resProfessionalSkill">
      <el-input v-model="dataForm.resProfessionalSkill" placeholder="专业技能"></el-input>
    </el-form-item>
    <el-form-item label="兴趣爱好" prop="resInterest">
      <el-input v-model="dataForm.resInterest" placeholder="兴趣爱好"></el-input>
    </el-form-item>
    <el-form-item label="来源" prop="resFrom">
      <el-select v-model="dataForm.resFrom" placeholder="请选择">
          <el-option v-for="item in options11" 
          :key="item.value" 
          :label="item.label" 
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="预约时间" prop="intwBookTime">
      <el-date-picker
        v-model="dataForm.intwBookTime"
        type="datetime"
        placeholder="选择日期">
      </el-date-picker>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">点击预约</el-button>
    </span>
  </el-dialog>
  
  </div>
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
        options1:[{
            value:'男',
            label:'男'
        },{
            value:'女',
            label:'女'
        }],
        options2:[{
            value:'已婚',
            label:'已婚'
        },{
            value:'未婚',
            label:'未婚'
        }],
        options3:[{
            value:'本科',
            label:'本科'
        },{
            value:'专科',
            label:'专科'
        }],
        options4:[{
            value:'四级',
            label:'四级'
        },{
            value:'六级',
            label:'六级'
        }],
        provinces:cities.ps,
        options6:[{
            value:'全职',
            label:'全职'
        },{
            value:'兼职',
            label:'兼职'
        }],
        options7:[{
            value:'前端',
            label:'前端'
        },{
            value:'后台',
            label:'后台'
        }],
        options8:[{
            value:'4000-6000',
            label:'4000-6000'
        },{
            value:'6000-8000',
            label:'6000-8000'
        },{
            value:'8000-10000',
            label:'8000-10000'
        }],
        options9:[{
            value:'在职',
            label:'在职'
        },{
            value:'离职',
            label:'离职'
        }],
        options10:[{
            value:'软件开发',
            label:'软件开发'
        },{
            value:'后台',
            label:'后台'
        }],
        options11:[{
            value:'2',
            label:'智联'
        },{
            value:'1',
            label:'前程无忧'
        }],
        dataForm: {
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
          resFrom: '',
          intwBookTime:''
        },
        dataRule: {
        // resName: [
          //   { required: true, message: '姓名不能为空', trigger: 'blur' }
          // ],
          // resAge: [
          //   { required: true, message: '年龄不能为空', trigger: 'blur' }
          // ],
          // resGender: [
          //   { required: true, message: '性别不能为空', trigger: 'blur' }
          // ],
          // resMarriage: [
          //   { required: true, message: '婚姻不能为空', trigger: 'blur' }
          // ],
          // resEducation: [
          //   { required: true, message: '学历不能为空', trigger: 'blur' }
          // ],
          // resCollege: [
          //   { required: true, message: '毕业院校不能为空', trigger: 'blur' }
          // ],
          // resMajor: [
          //   { required: true, message: '所学专业不能为空', trigger: 'blur' }
          // ],
          // resEnglish: [
          //   { required: true, message: '英语水平不能为空', trigger: 'blur' }
          // ],
          // resInCollege: [
          //   { required: true, message: '入学时间不能为空', trigger: 'blur' }
          // ],
          // resOutCollege: [
          //   { required: true, message: '毕业时间不能为空', trigger: 'blur' }
          // ],
          // resCity: [
          //   { required: true, message: '居住城市不能为空', trigger: 'blur' }
          // ],
          // resWorkYear: [
          //   { required: true, message: '工作年限不能为空', trigger: 'blur' }
          // ],
          // resBirthday: [
          //   { required: true, message: '出生年月不能为空', trigger: 'blur' }
          // ],
          // resHometown: [
          //   { required: true, message: '户籍不能为空', trigger: 'blur' }
          // ],
          // resMobile: [
          //   { required: true, message: '手机号码不能为空', trigger: 'blur' }
          // ],
          // resMail: [
          //   { required: true, message: '邮箱不能为空', trigger: 'blur' }
          // ],
          // resEvaluate: [
          //   { required: true, message: '自我评价不能为空', trigger: 'blur' }
          // ],
          // resExpectedArea: [
          //   { required: true, message: '期望工作地区不能为空', trigger: 'blur' }
          // ],
          // resExpectedWork: [
          //   { required: true, message: '期望工作性质不能为空', trigger: 'blur' }
          // ],
          // resExpectedOccupation: [
          //   { required: true, message: '期望工作职业不能为空', trigger: 'blur' }
          // ],
          // resExpectedSalary: [
          //   { required: true, message: '期望月薪不能为空', trigger: 'blur' }
          // ],
          // resCurrentAtate: [
          //   { required: true, message: '目前状况不能为空', trigger: 'blur' }
          // ],
          // resExpectedIndustry: [
          //   { required: true, message: '期望从事行业不能为空', trigger: 'blur' }
          // ],
          // resWorkExperience: [
          //   { required: true, message: '工作经历不能为空', trigger: 'blur' }
          // ],
          // resProjectExperience: [
          //   { required: true, message: '项目经验不能为空', trigger: 'blur' }
          // ],
          // resProfessionalSkill: [
          //   { required: true, message: '专业技能不能为空', trigger: 'blur' }
          // ],
          // resInterest: [
          //   { required: true, message: '兴趣爱好不能为空', trigger: 'blur' }
          // ],
          // resFrom: [
          //   { required: true, message: '来源不能为空', trigger: 'blur' }
          // ]
        }
      }
    },
    
    // created (){
    //   this.reSetUeditor();
    // },

    methods: {
      init () {
        this.visible = true
         this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          })
      },
      //获取工作经验
      getWorkExp(val){
        this.dataForm.resWorkExperience = val;
      },
      //获取项目经验
      getProExp (val){
        this.dataForm.resProjectExperience = val;
      },
      //重置ueditor
      // reSetUeditor(){
      //   this.$nextTick(()=>{
      //     this.$refs.reSetWorkExp.init();
      //     this.$refs.reSetProExp.init()
      //   })
      // },
      
      //表单提交
      dataFormSubmit () {
        console.log(this.dataForm.resCity[1]);
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/interview/saveRes`),              
              method: 'post',
              data: this.$http.adornData({
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
                'resCity': this.dataForm.resCity[1],
                'resWorkYear': this.dataForm.resWorkYear,
                'resBirthday': this.dataForm.resBirthday,
                'resHometown': this.dataForm.resHometown[1],
                'resMobile': this.dataForm.resMobile,
                'resMail': this.dataForm.resMail,
                'resEvaluate': this.dataForm.resEvaluate,
                'resExpectedArea': this.dataForm.resExpectedArea[1],
                'resExpectedWork': this.dataForm.resExpectedWork,
                'resExpectedOccupation': this.dataForm.resExpectedOccupation,
                'resExpectedSalary': this.dataForm.resExpectedSalary,
                'resCurrentAtate': this.dataForm.resCurrentAtate,
                'resExpectedIndustry': this.dataForm.resExpectedIndustry,
                'resWorkExperience': this.dataForm.resWorkExperience,
                'resProjectExperience': this.dataForm.resProjectExperience,
                'resProfessionalSkill': this.dataForm.resProfessionalSkill,
                'resInterest': this.dataForm.resInterest,
                'resFrom': this.dataForm.resFrom,
                'intwBookTime': this.dataForm.intwBookTime
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

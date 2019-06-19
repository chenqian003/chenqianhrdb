<template>
  <el-dialog
  title="简历详情"
  :close-on-click-modal="false"
  :visible.sync="visible">
<el-row>
    <el-col :span="24"><div class="grid-content bg-purple">姓名:{{resName}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">年龄:{{resAge}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">性别:{{resGender}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">婚姻:{{resMarriage}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">学历:{{resEducation}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">毕业院校:{{resCollege}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">所学专业:{{resMajor}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">英语水平:{{resEnglish}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">入学时间:{{resInCollege}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">毕业时间:{{resOutCollege}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">居住城市:{{resCity}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">工作年限:{{resWorkYear}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">出生年月:{{resBirthday}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="6"><div class="grid-content bg-purple">户籍:{{resHometown}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">手机号码:{{resMobile}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">邮箱:{{resMail}}</div></el-col>
</el-row>
<el-row >
  <el-col :span="24"><div class="grid-content bg-purple-dark">自我评价:{{resEvaluate}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="8"><div class="grid-content bg-purple">期望工作地区:{{resExpectedArea}}</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple-light">期望工作性质:{{resExpectedWork}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple">期望工作职业:{{resExpectedOccupation}}</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple-light">期望月薪:{{resExpectedSalary}}</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple">目前状况:{{resCurrentAtate}}</div></el-col>
  <el-col :span="20"><div class="grid-content bg-purple-light">期望从事行业:{{resExpectedIndustry}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="24"><div class="grid-content bg-purple">工作经历:{{resWorkExperience}}</div></el-col>
  <el-col :span="24"><div class="grid-content bg-purple-light">项目经验:{{resProjectExperience}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="24"><div class="grid-content bg-purple">专业技能:{{resProfessionalSkill}}</div></el-col>
  <el-col :span="24"><div class="grid-content bg-purple-light">兴趣爱好:{{resInterest}}</div></el-col>
  <el-col :span="10"><div class="grid-content bg-purple">录入时间:{{resTime}}</div></el-col>
  <el-col :span="6"><div class="grid-content bg-purple-light">录入人:{{resHrId}}</div></el-col>
</el-row>
<el-row>
  <el-col :span="8"><div class="grid-content bg-purple">来源:{{resFrom}}</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple-light">备注1{{resBz1}}</div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple">备注2{{resBz2}}</div></el-col>
</el-row>



<!--历史面试记录-->
<div style="margin-top:10px;">
<el-collapse accordion>
  <el-collapse-item v-for="d in dataList" :key="d.recId">
    <template slot="title">
    <el-row>
      <el-col :span="4">沟通能力：{{d.recCommunicate}}</el-col>
      <el-col :span="4">技能水平：{{d.recSkill}}</el-col>
      <el-col :span="4">学习能力：{{d.recStudy}}</el-col>
      <el-col :span="4">情商：{{d.recEq}}</el-col>
    </el-row>
    <!-- <i class="header-icon el-icon-info"></i> -->
    </template>
    <div>面试印象：</div>
    <div>{{d.recImpression}}</div>
  </el-collapse-item>
</el-collapse>
</div>



    <el-form :model="dataForm" :rules="dataRule"  ref="dataForm" @keyup.enter.native="saveRecord()" label-width="80px" style="margin-top:20px;">
        <el-row>   
              <el-form-item label="简历ID" prop="recordRId" v-show='false'>
                  <el-input v-model="dataForm.recordRId" placeholder="简历ID"></el-input>
              </el-form-item>
          <el-col :span="12">
              <el-form-item label="沟通能力" prop="recCommunicate">
                  <el-select v-model="dataForm.recCommunicate" placeholder="请选择">
                      <el-option v-for="item in options1" 
                      :key="item.value" 
                      :label="item.label" 
                      :value="item.value">
                      </el-option>
                  </el-select>
              </el-form-item>
          </el-col>
          <el-col :span="12">
              <el-form-item label="技能水平" prop="recSkill">
                  <el-select v-model="dataForm.recSkill" placeholder="请选择">
                      <el-option v-for="item in options2" 
                      :key="item.value" 
                      :label="item.label" 
                      :value="item.value">
                      </el-option>
                  </el-select>
              </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="学习能力" prop="recStudy">
            <el-select v-model="dataForm.recStudy" placeholder="请选择">
                <el-option v-for="item in options3" 
                :key="item.value" 
                :label="item.label" 
                :value="item.value">
                </el-option>
            </el-select>
        </el-form-item>   
          </el-col>
          <el-col :span="12">
            <el-form-item label="情商" prop="recEq">
            <el-select v-model="dataForm.recEq" placeholder="请选择">
                <el-option v-for="item in options4" 
                :key="item.value" 
                :label="item.label" 
                :value="item.value">
                </el-option>
            </el-select>
        </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="面试印象" prop="recImpression">
              <el-input type="textarea" v-model="dataForm.recImpression"></el-input>
            </el-form-item>
          </el-col>
        </el-row>    
    </el-form> 

    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="saveRecord()">面试提交</el-button>
    </span>
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
          recordRId:'', //?
          recSkill:'',
          recStudy:'', 
          recCommunicate:'',
          recEq:'',
          recImpression:''         
        },
        visible: false,
          resId: 0,    
          resName:'',    
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
          recordRId: '',

          dataList: [],
          dataListLoading: false,
          dataListSelections: [],
       
        options1:[{
            value:1,
            label:'优秀'
        },{
            value:2,
            label:'良好'
        },
        {
            value:3,
            label:'较差'
        }], 
        options2:[{
            value:1,
            label:'优秀'
        },{
            value:2,
            label:'良好'
        },
        {
            value:3,
            label:'较差'
        }],
        options3:[{
            value:'优秀',
            label:'优秀'
        },{
            value:'良好',
            label:'良好'
        },
        {
            value:'较差',
            label:'较差'
        }],
        options4:[{
            value:'优秀',
            label:'优秀'
        },{
            value:'良好',
            label:'良好'
        },
        {
            value:'较差',
            label:'较差'
        }],                              

        dataRule: {
          recordRId: [
            { required: true, message: '简历ID不能为空', trigger: 'blur' }
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
       },
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
                this.resName = data.resume.resName               
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
    //添加面试记录
    saveRecord () {
        this.$nextTick(() => {  
          console.log("imp="+this.dataForm.recImpression);  
                    console.log("recRId="+this.recordRId);      
    
          this.$http({
              url: this.$http.adornUrl(`/generator/record/save`),
              method: 'get',
              params: this.$http.adornParams({
                'recRId':this.dataForm.recordRId,
                'recCommunicate':this.dataForm.recCommunicate,
                'recSkill':this.dataForm.recSkill,
                'recStudy':this.dataForm.recStudy,
                'recEq':this.dataForm.recEq,
                'recImpression':this.dataForm.recImpression,
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                //清空表单,
                // this.$refs['dataForm'].resetFields()
                    this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              }else {
                this.$message.error(data.msg)
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
            this.dataForm.recordRId = this.resRId          
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
       }
}
</script>
<style>
</style>
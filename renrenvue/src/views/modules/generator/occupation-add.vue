<template>
    <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="职位名称" prop="occName">
      <el-input v-model="dataForm.occName" placeholder="职位名称"></el-input>
    </el-form-item>
    <el-form-item label="所属类别" prop="occCategoty">
        <el-cascader
        :props="optionProps"
        :options="options5"
        v-model="dataForm.occCategoty">
        </el-cascader>
    </el-form-item>
    <el-form-item label="所属城市" prop="occCity">
      <el-cascader
        :options="provinces"
        v-model="dataForm.occCity">
        </el-cascader>
    </el-form-item>
    <el-form-item label="当前时间" prop="occTime">
        <el-date-picker
           v-model="dataForm.occTime"
           type="datetime"
           placeholder="选择日期时间">
        </el-date-picker>
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
      <el-select v-model="dataForm.occSalaryRange" placeholder="请选择">
          <el-option
            v-for="item in options4"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="工作地点" prop="occWorkAddress">
      <el-select v-model="dataForm.occWorkAddress" placeholder="请选择">
          <el-option
            v-for="item in options3"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
      </el-select>
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
      <el-select v-model="dataForm.occWorkYear" placeholder="请选择">
          <el-option
            v-for="item in options2"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="学历" prop="occEducation">
      <el-select v-model="dataForm.occEducation" placeholder="请选择">
          <el-option
            v-for="item in options1"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    </el-form>

    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
import ps from './cities.json';
export default {
   data() {
        return {
          optionProps:{
            value:'catId',
            label:'catName',
            children:'children'
          },

            visible: false,
        options1: [{
          value: '大专',
          label: '大专'
        }, 
        {
          value: '本科',
          label: '本科'
        },
         {
          value: '研究生',
          label: '研究生'
        },
         {
          value: '博士',
          label: '博士'
        },
          {
          value: '博士后',
          label: '博士后'
        }],
        
        options2: [{
          value: '1-3年',
          label: '1-3年'
        }, {
          value: '3-5年',
          label: '3-5年'
        }, {
          value: '5年以上',
          label: '5年以上'
        }], 

       options3: [{
          value: '北京',
          label: '北京'
        }, {
          value: '上海',
          label: '上海'
        }, {
          value: '深圳',
          label: '深圳'
        }], 

        options4: [{
          value: '5000-6000',
          label: '5000-6000'
        }, {
          value: '8000-10000',
          label: '8000-10000'
        }, {
          value: '15000-20000',
          label: '15000-20000'
        }], 

       options5: [],

       provinces:ps.ps,
       
        dataForm: {
          occId: 0,
          occName: '',
          occCategoty: '',
          occCity: '',
          occTime: '',
          occDescription: '',
          occState: '',
          occNature: '',
          occSalaryRange: '',
          occWorkAddress: '',
          occCompany: '',
          occCompanydesc: '',
          occCount: '',
          occWorkYear: '',
          occEducation: '',
          
          resetFields:''
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
          ]
        }
      }
    }
   ,
   created(){
     //
     this.getCategory();
   },
   
    methods: {

       parseList(list){
    //创建一个对象命名为map
    var map={};
    //通过遍历把list中的元素放到map对象中
    list.forEach(function(item){
        if(!map[item.catId]){
	    //核心步骤1：map中的'item.id'属性指向list数组中的对象元素
            map[item.catId]=item;
        }
    });
    //再次遍历为了对map属性所指的对象进行处理
    list.forEach(function(item){
        //过滤父级id不是null的元素
        if(item.catParentId!=0){
            //map[item.pid]为该元素的父级元素
            map[item.catParentId].children ? map[item.catParentId].children.push(item):map[item.catParentId].children=[item];
        }
    });
    //过滤后仅剩下根节点
    return list.filter(function(item){
        if(item.catParentId===0){
            return item;
        } 
    });
},
      getCategory(){
        console.log("getCategory...");
          //发送http请求找url要数据，get获取数据
          this.$http({
          url: this.$http.adornUrl('/generator/category/getTree'),
          method: 'get',
         
        }).then(({data}) => {
          console.log("test...");
          console.log(data)
          
          if (data && data.code === 0) {
            console.log(this.parseList(data.list));
            this.options5 = this.parseList(data.list);
            
          } 
          
        })
      },
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
                this.dataForm.occDescription = data.occupation.occDescription
                this.dataForm.occState = data.occupation.occState
                this.dataForm.occNature = data.occupation.occNature
                this.dataForm.occSalaryRange = data.occupation.occSalaryRange
                this.dataForm.occWorkAddress = data.occupation.occWorkAddress
                this.dataForm.occCompany = data.occupation.occCompany
                this.dataForm.occCompanydesc = data.occupation.occCompanydesc
                this.dataForm.occCount = data.occupation.occCount
                this.dataForm.occWorkYear = data.occupation.occWorkYear
                this.dataForm.occEducation = data.occupation.occEducation
                
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
                'occDescription': this.dataForm.occDescription,
                'occState': this.dataForm.occState,
                'occNature': this.dataForm.occNature,
                'occSalaryRange': this.dataForm.occSalaryRange,
                'occWorkAddress': this.dataForm.occWorkAddress,
                'occCompany': this.dataForm.occCompany,
                'occCompanydesc': this.dataForm.occCompanydesc,
                'occCount': this.dataForm.occCount,
                'occWorkYear': this.dataForm.occWorkYear,
                'occEducation': this.dataForm.occEducation
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





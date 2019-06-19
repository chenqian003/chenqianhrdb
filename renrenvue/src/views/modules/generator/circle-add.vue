<template>
    <div> 
    <el-dialog
    title="朋友圈信息"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :inline="true" :model="dataForm" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable style="width：30px" ></el-input>
    </el-form-item>
    <el-form-item>
       <el-button @click="getInformation(dataForm.key)">查询</el-button> 
    </el-form-item>
    
    
    <!-- <el-form : label-width="80px">
    </el-form> -->
    
    <el-form-item>
    <div>{{name}}:{{telephone}}</div>
    </el-form-item>
   </el-form>
    
    <el-input
      type="textarea"
      :rows="4"
       placeholder="请输入内容"
       v-model="textarea" 
       >
    </el-input>
    

    <el-button @click="add(textarea,telephone)" style="margin-top:20px">添加</el-button> 

    
    </el-dialog>
    
    </div>
</template>
<script>
import { connect } from 'net';
import { constants } from 'fs';
export default {
    data (){
        return{

            //user_id:'',
            keywords:'',
            name:'xufuli',
            telephone:'15527892357',
            textarea:'',
            //frisenderlist:[],
            visible: false,
            show:false,
            dataForm:{
               key:''
            }
           
        }
    },

    methods:{
        init () {
        this.visible = true
     },
        getInformation (val){
       // this.dataListLoading = true;
        console.log(val+"info");
        
       
        this.$http({
          url: this.$http.adornUrl('/generator/friends/getInformation'),
          method: 'get',
          params: this.$http.adornParams({
            // 'page': this.pageIndex,
            // 'limit': this.pageSize,
            'keywords': val
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.name = data.user.username,
            this.telephone=data.user.mobile
            //this.user_id=data.user.userId;
            //console.log(user_id+"dengluid")
            // this.totalPage = data.page.totalCount
          } else {
            this.name = '',
            this.telephone='';

            // this.totalPage = 0
          }
          
        //  this.dataListLoading = false
        })
      },
       
        add (f1,f2){
       
           this.$http({
           url: this.$http.adornUrl('/generator/friends/add'),
           method: 'get',   
           params: this.$http.adornParams({
            // 'page': this.pageIndex,
            // 'limit': this.pageSize,
                 'mobile':f2,
                 'msg':f1,
                 })
          }).then(({data}) => {
          if (data && data.code === 0) {
            this.result = data.result , 
            console.log(this.result)    
            this.visible = false,
            this.$emit('refreshDataList')
            }
            if(this.result===1){
            this.$message('已经添加过');
            console.log("111111")
            }else if(this.result ===0){
             this.$message('添加成功');
            }else{
              this.$message('登陆者id为发送者id')
            }
          
          
        //  this.dataListLoading = false
        })
        
        
        
      }
    }
}
</script>




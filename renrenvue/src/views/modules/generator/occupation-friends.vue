<template>
<div>   
<el-row>
  <el-col :span="8" v-for="occupation in dataList" :key="occupation.occId" >
    <el-card :body-style="{ padding: '0px' }">
        <div style="padding: 20px;"> 
          <span>{{occupation.occName}}</span>
          <span>|</span>
          <span>{{occupation.occWorkYear}}</span>
          <span>|</span>
          <span>{{occupation.occSalaryRange}}</span>
          <span>|</span>
          <span>{{occupation.occEducation}}</span>
          <span>|</span>
          <span>{{occupation.occWorkAddress}}</span>
          
          <hr/>
          <p>工作要求：<br/>
          1 xxxxxx<br/>
          2 xxxxx<br/>
          3 xxxxx<br/>
          </p>        
          
        <!-- <el-form label-position="left" inline class="demo-table-expand">
          <el-form-item label="">
          <span>{{occupation.occName}}</span>
          </el-form-item>
          <el-form-item label="">
            <span>{{occupation.occWorkYear}}</span>
          </el-form-item>
          <el-form-item label="">
            <span>{{occupation.occSalaryRange}}</span>
          </el-form-item>
          <el-form-item label="">
            <span>{{occupation.occEducation}}</span>
          </el-form-item>
          <el-form-item label="">
            <span>{{occupation.occWorkAddress}}</span>
          </el-form-item>
          
        
        </el-form> -->
             
        <div class="bottom clearfix">
          <el-button type="text" class="button" @click="getShare(occupation.occHr)">分享</el-button>
          <el-button type="text" class="button" @click="getDetail(occupation.occId)">详情</el-button>
        </div>
      </div>
    </el-card>
  </el-col>
</el-row>
<o-d  v-if="detailVisible"  ref="xiang" ></o-d>
<share  v-if="shareVisible"  ref="nong" :dataFromFather="resumeList" :recieverId="recieverId"></share>

</div>
</template>

<script>
import OD from './occupation-detail'
import share from './occupation-share'
export default {
    props:['list'],
  data() {
    return {
      key: '', 
      currentDate: new Date(),
      dataList: [],
      resumeList: [],
      pageIndex: 1,
      pageSize: 10,
      detailVisible: false,
      shareVisible: false,
      recieverId:''
    };
  },
  components:{
      OD,
      share
  },

  created () {
    this.getDataList()
  },
  
  methods:{
     getShare (occHr) {
        //console.log('路径------')


        this.$http({
          url: this.$http.adornUrl('/generator/resume/resId'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.key
          })
        }).then(({data}) => {
          //console.log('路径---data---'+data);
          if (data && data.code === 0) {

            this.resumeList = data.list;
            this.shareVisible=true;
            this.recieverId=occHr;
            console.log("aaaa");
           // console.log('size='+this.resumeList.length)
            
          } else {
            this.resumeList = []
            
          }
          
        })
      },

      getDataList () {
        
        this.$http({
          url: this.$http.adornUrl('/generator/occupation/list2'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.list
            
          } else {
            this.dataList = []
            
          }
          
        })
      },
      getDetail (id) {
          this.detailVisible = true
          this.$nextTick(() => {
                this.$refs.xiang.init(id)
          })
      }
    //   getShare(resId){
    //       this.shareVisible = true
    //       this.$nextTick(() =>{
    //           this.$refs.nong.in(resId)
    //       })
          
    // }
  }
}
</script>

<style>
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }

  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>

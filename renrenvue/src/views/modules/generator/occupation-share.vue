<template>
<div>
<el-dialog
    :title="'分享'"
    :close-on-click-modal="false"
    :visible.sync="visible">
  <el-table
    ref="multipleTable"
    :data="dataFromFather"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column
    prop="resId"
      type="selection"
      width="55">
    </el-table-column>
    <el-table-column
      prop="resName"
      label="姓名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="resMobile"
      label="电话"
      width="120">
    </el-table-column>
  </el-table>


  <span slot="footer" class="dialog-footer">
      <el-button @click="visible=false">取消</el-button>
      <el-button type="primary" @click="toggleSelection()">确定</el-button>
      <!-- <el-button type="primary" @click="shareRes()">上传</el-button> -->
    </span>
  </el-dialog>
</div>
</template>

<script>
  export default {
    props:['dataFromFather','recieverId'],
    data() {
      return {
        visible:true,
        resId:'',
        multipleSelection: []
      }
    },

    methods: {
         in(){
            this.visible = true
            this.$nextTick(()=> {
                this.$refs['dataForm'].resetFields()
            })
        },


      toggleSelection(rows) {
        //获取选中的求职者ID，数组
        if (rows) {
          rows.forEach(row => {
            this.$refs.multipleTable.toggleRowSelection(row);
          });
        } else {
          this.$refs.multipleTable.clearSelection();
        }
        //将求职者数组的id和recieverId 传递到后台控制其中
        this.visible = false;
      },
      // 向后台发送数据
      shareRes(){
        console.log("shareRes....");
        this.$http({
              url: this.$http.adornUrl('/generator/friends/save2'),
              method: 'post',
              data: this.$http.adornData({
                'resIdList': JSON.stringify(this.multipleSelection),
                'reciverId': 'recieverId',
                
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
      },

      handleSelectionChange(val) {
        this.multipleSelection = val;
        console.log(this.multipleSelection);
      }
    }
  }
</script>
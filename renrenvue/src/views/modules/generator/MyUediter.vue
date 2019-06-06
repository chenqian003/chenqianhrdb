<template>
  <div>
    <div class="mod-demo-ueditor">
        <script :id="ueId" class="ueditor-box" type="text/plain" style="width: 100%; height: 260px;"></script>
        <p><el-button @click="getContent()">获得内容</el-button></p>
    </div>
  </div>
</template>
<script>
import ueditor from 'ueditor'
import { log } from 'util';
export default {
    data(){
        return{
            ue: null,
            ueId: `J_ueditorBox_${new Date().getTime()}`,
            ueContent: '',
        }
    },
    mounted () {
      this.ue = ueditor.getEditor(this.ueId, {
        // serverUrl: '', // 服务器统一请求接口路径
        zIndex: 3000
      })
    },
    methods: {
      getContent () {
        this.ue.ready(() => {
          this.ueContent = this.ue.getContent()
        })
        this.$emit("getData",this.ueContent)
      },
      
      init(){
        this.ueContent = this.ue.setContent('',false);
      }
    }
  }
</script>

<style lang="scss">
  .mod-demo-ueditor {
    position: relative;
    z-index: 510;
    > .el-alert {
      margin-bottom: 10px;
    }
  }
</style>
<template>
  <el-dialog
    title="面试过程"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="简历ID" prop="intwResumeId" >
      <el-input v-model="dataForm.intwResumeId" placeholder="简历ID" readonly="true"></el-input>
    </el-form-item>
    <el-form-item label="应聘者姓名" prop="intwName">
      <el-input v-model="dataForm.intwName" placeholder="应聘者姓名" readonly="true"></el-input>
    </el-form-item>
    <el-form-item label="应聘者电话" prop="intwMobile">
      <el-input v-model="dataForm.intwMobile" placeholder="应聘者电话" readonly="true"></el-input>
    </el-form-item>
    <el-form-item label="预约人" prop="intwHrId">
      <el-input v-model="dataForm.intwHrId" placeholder="预约人" readonly="true"></el-input>
    </el-form-item>
    <el-form-item label="沟通能力" prop="recCommunicate">
      <el-select v-model="dataForm.recCommunicate" placeholder="请选择">
          <el-option v-for="item in options1" 
          :key="item.value"
          :label="item.label"
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="技能水平" prop="recSkill">
      <el-select v-model="dataForm.recSkill" placeholder="请选择">
          <el-option v-for="item in options2" 
          :key="item.value"
          :label="item.label"
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="学习能力" prop="recStudy">
      <el-select v-model="dataForm.recStudy" placeholder="请选择">
          <el-option v-for="item in options3" 
          :key="item.value"
          :label="item.label"
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="情商" prop="recEq">
      <el-select v-model="dataForm.recEq" placeholder="请选择">
          <el-option v-for="item in options4" 
          :key="item.value"
          :label="item.label"
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="面试印象" prop="recImpression">
      <el-select v-model="dataForm.recImpression" placeholder="请选择">
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
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          intwId: '',
          intwResumeId: '',
          intwName: '',
          intwMobile: '',
          recCommunicate: '',
          recSkill: '',
          recStudy: '',
          recEq: '',
          recImpression: '',
        },
        options1:[{
          value:'1',
          label:'一般'
        },{
          value:'2',
          label:'好'
        }],
        options2:[{
          value: '1',
          label: '差'
        },{
          value: '2',
          label: '好'
        }],
        options3:[{
          value: '一般',
          label: '一般'
        },{
          value: '好',
          label: '好'
        }],
        options4:[{
          value: '低',
          label: '低'
        },{
          value: '高',
          label: '高'
        }],
        options5:[{
          value: '一般',
          label: '一般'
        },{
          value: '很好',
          label: '很好'
        }],
        dataRule: {
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
        }
      }
    },
    methods: {
      init (id) {
        this.intwId = id
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
            this.$http({
              url: this.$http.adornUrl(`/generator/interview/info/${this.intwId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.intwResumeId = data.interview.intwResumeId
                this.dataForm.intwName = data.interview.intwName
                this.dataForm.intwMobile = data.interview.intwMobile
                this.dataForm.intwBookTime = data.interview.intwBookTime
                this.dataForm.intwHrId = data.interview.intwHrId
                this.dataForm.intwState = data.interview.intwState
                this.dataForm.intwTime = data.interview.intwTime
              }
            })          
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/generator/interview/saveRec`), 
              method: 'post',
              data: this.$http.adornData({
                'recRId': this.dataForm.intwResumeId,
                'recCommunicate': this.dataForm.recCommunicate,
                'recSkill': this.dataForm.recSkill,
                'recStudy': this.dataForm.recStudy,
                'recEq': this.dataForm.recEq,
                'recImpression': this.dataForm.recImpression,
                'intwId': this.intwId
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

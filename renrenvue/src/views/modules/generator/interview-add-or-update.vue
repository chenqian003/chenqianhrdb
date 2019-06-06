<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="简历ID" prop="intwResumeId">
      <el-input v-model="dataForm.intwResumeId" placeholder="简历ID"></el-input>
    </el-form-item>
    <el-form-item label="应聘者姓名" prop="intwName">
      <el-input v-model="dataForm.intwName" placeholder="应聘者姓名"></el-input>
    </el-form-item>
    <el-form-item label="应聘者电话" prop="intwMobile">
      <el-input v-model="dataForm.intwMobile" placeholder="应聘者电话"></el-input>
    </el-form-item>
    <el-form-item label="预约时间" prop="intwBookTime">
      <el-date-picker
        v-model="dataForm.intwBookTime"
        type="datetime"
        placeholder="选择日期">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="预约人" prop="intwHrId">
      <el-input v-model="dataForm.intwHrId" placeholder="预约人"></el-input>
    </el-form-item>
    <el-form-item label="当前状态" prop="intwState">
      <el-select v-model="dataForm.intwState" placeholder="请选择">
          <el-option v-for="item in options1" 
          :key="item.value"
          :label="item.label"
          :value="item.value">
          </el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="操作时间" prop="intwTime">
      <el-date-picker
        v-model="dataForm.intwTime"
        type="date"
        placeholder="选择日期">
      </el-date-picker>
    </el-form-item>
    <el-form-item label="备注1" prop="intwBz1">
      <el-input v-model="dataForm.intwBz1" placeholder="备注1"></el-input>
    </el-form-item>
    <el-form-item label="备注2" prop="intwBz2">
      <el-input v-model="dataForm.intwBz2" placeholder="备注2"></el-input>
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
          intwId: 0,
          intwResumeId: '',
          intwName: '',
          intwMobile: '',
          intwBookTime: '',
          intwHrId: '',
          intwState: '',
          intwTime: '',
          intwBz1: '',
          intwBz2: ''
        },
        options1:[{
          value:'1',
          label:'未面试'
        },{
          value:'2',
          label:'已面试'
        }],
        dataRule: {
          intwResumeId: [
            { required: true, message: '简历ID不能为空', trigger: 'blur' }
          ],
          intwName: [
            { required: true, message: '应聘者姓名不能为空', trigger: 'blur' }
          ],
          intwMobile: [
            { required: true, message: '应聘者电话不能为空', trigger: 'blur' }
          ],
          intwBookTime: [
            { required: true, message: '预约时间不能为空', trigger: 'blur' }
          ],
          intwHrId: [
            { required: true, message: '预约人不能为空', trigger: 'blur' }
          ],
          intwState: [
            { required: true, message: '当前状态不能为空', trigger: 'blur' }
          ],
          intwTime: [
            { required: true, message: '操作时间不能为空', trigger: 'blur' }
          ],
          intwBz1: [
            { required: true, message: '备注1不能为空', trigger: 'blur' }
          ],
          intwBz2: [
            { required: true, message: '备注2不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.intwId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.intwId) {
            this.$http({
              url: this.$http.adornUrl(`/generator/interview/info/${this.dataForm.intwId}`),
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
                this.dataForm.intwBz1 = data.interview.intwBz1
                this.dataForm.intwBz2 = data.interview.intwBz2
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
              url: this.$http.adornUrl(`/generator/interview/${!this.dataForm.intwId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'intwId': this.dataForm.intwId || undefined,
                'intwResumeId': this.dataForm.intwResumeId,
                'intwName': this.dataForm.intwName,
                'intwMobile': this.dataForm.intwMobile,
                'intwBookTime': this.dataForm.intwBookTime,
                'intwHrId': this.dataForm.intwHrId,
                'intwState': this.dataForm.intwState,
                'intwTime': this.dataForm.intwTime,
                'intwBz1': this.dataForm.intwBz1,
                'intwBz2': this.dataForm.intwBz2
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

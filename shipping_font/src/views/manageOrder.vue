<template>
  <el-container>
    <el-aside width="200px">
      <my_aside />
    </el-aside>
    <el-container>
      <!--      头部-->
      <el-header>
        <my_header />
      </el-header>
      <!--      主要内容-->
      <el-main>
        <div style="width: 100%;padding: 0px" >
          <!--          寄出信息表格-->
          <div style="height: 80vh;border-bottom: 3px dotted #eee">
            <div style="display: flex;height: 40px;margin-bottom: 10px">
              <span class="r-g-index r-g-index-1" style="margin-left: 20px">管</span>
              <span class="" style="margin-left: 10px;line-height: 30px;font-weight: bolder">订单管理</span>
            </div>
            <div style="">
              <el-table
                  :data="all_tableData.filter(data => !search || data.recname.toLowerCase().includes(search.toLowerCase()))"
                  style="width: 80%;margin-left: 3vw"
                  height="72vh"
                  :row-class-name="tableRowClassName">
                <el-table-column
                    prop="recname"
                    label="收件人"
                    width="100">
                </el-table-column>
                <el-table-column
                    prop="recphone"
                    label="联系方式"
                    width="150">
                </el-table-column>
                <el-table-column
                    prop="destination"
                    label="收货地址">
                </el-table-column>
                <el-table-column
                    prop="type"
                    label="运输方式">
                </el-table-column>
                <el-table-column
                    prop="esttime"
                    label="预计时间">
                </el-table-column>
                <el-table-column
                    prop="state"
                    label="当前状态"
                    width="100"
                    :filters="[{ text: '未发货', value: '未发货' }, { text: '运输中', value: '运输中' },
                    { text: '待签收', value: '待签收' },{ text: '已完成', value: '已完成' }
                    ]"
                    :filter-method="filterTag"
                    filter-placement="bottom-end">
                  <template slot-scope="scope">
                    <el-tag
                        v-if="scope.row.state === '未发货'"
                        :type="'info'"
                        disable-transitions>{{scope.row.state}}</el-tag>
                    <el-tag
                        v-if="scope.row.state === '运输中'"
                        :type="'primary'"
                        disable-transitions>{{scope.row.state}}</el-tag>
                    <el-tag
                        v-if="scope.row.state === '待签收'"
                        :type="'warning'"
                        disable-transitions>{{scope.row.state}}</el-tag>
                    <el-tag
                        v-if="scope.row.state === '已完成'"
                        :type="'success'"
                        disable-transitions>{{scope.row.state}}</el-tag>
                  </template>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot="header" slot-scope="scope">
                    <el-input
                        v-model="search"
                        size="mini"
                        placeholder="输入关键字搜索"/>
                  </template>
                  <template slot-scope="scope">
                    <el-button
                        v-if="scope.row.state === '运输中'"
                        size="mini"
                        type="primary"
                        @click="openProgress(scope.$index, scope.row)">更新状态</el-button>
                    <el-button
                        v-if="scope.row.state === '未发货'"
                        size="mini"
                        type="success"
                        @click="openDialog(scope.$index, scope.row)">发货分配</el-button>
                    <el-button
                        v-if="scope.row.state === '待签收'"
                        size="mini"
                        type="warning"
                        @click="recieve(scope.$index, scope.row)">签收</el-button>
                    <el-button
                        size="mini"
                        @click="handleEdit(scope.$index, scope.row)">详情</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </div>
        </div>

<!--        弹出框1-->
        <div>
          <el-dialog
              title="选择物流公司"
              :visible.sync="dialogVisible"
              :close-on-click-modal="false"
          >
            <div class="company-list">
              <el-card v-for="(company, index) in companies" :key="index" @click.native="selectCompany(index)">
                <div class="company-logo">
<!--                  <img src="company.logo" alt="公司logo" />-->
                  <img :src="company.logo"  alt="公司logo" style="height: 150px;object-fit: cover;" >
                </div>
                <div class="company-name">{{ company.name }}</div>
              </el-card>
            </div>
          </el-dialog>
        </div>

        <!--        弹出框3-->
        <div>
          <el-dialog
              title="选择运输单位"
              :visible.sync="UnitVisible"
              :close-on-click-modal="false"
          >
            <div class="company-list">
              <el-card v-for="(unit, index) in nowUnit" :key="index" @click.native="selectUnit(unit,index)">
                <div class="company-logo">
                  <!--                  <img src="company.logo" alt="公司logo" />-->
                  <img :src="unit.logo"  alt="公司logo" style="height: 150px;object-fit: cover;" >
                </div>
                <div class="company-name">{{ unit.name }}</div>
                <div class="company-name">可用运力{{ unit.rest }}/{{ unit.total }}</div>
                <el-progress :percentage="unit.percent" status="success">
                </el-progress>
              </el-card>
            </div>
          </el-dialog>
        </div>

<!--        弹出框2 展示进度-->
        <div>
          <el-dialog
              title="运输进度"
              :visible.sync="progressVisible"
              :close-on-click-modal="false"
          >
            <el-steps :active="activeStep" align-center >
              <el-step v-for="(step, index) in transportProgress" :key="index" :title="step.title" />
            </el-steps>
            <div>
              <div style="width: 100%;justify-content: start">
                <el-input v-model="newStep" style="margin: 3rem;width: 15rem" placeholder="请输入新的运输节点" />
                <el-button type="primary" @click="addStep">添加</el-button>
                <el-button type="success" @click="toDeli">确认到达</el-button>
              </div>
              <div>

              </div>
            </div>

          </el-dialog>
        </div>

      </el-main>
    </el-container>
  </el-container>
</template>
<script>

import my_aside from "@/components/my_aside";
import my_header from "@/components/my_header";
import { regionData,codeToText } from 'element-china-area-data';
import axios from "axios";
export default {
  name: "manageOrder",
  components:{
    my_aside,
    my_header
  },
  data(){
    return {
      UnitVisible:false,
      nowUnit:[],
      progressVisible: false,
      nowIndex:0,
      transportProgress: [
        { title: '发货' },
        { title: '装车' },
        { title: '运输中' },
        { title: '到达目的地' },
        { title: '卸货' },
        { title: '完成' },
      ],
      activeStep: 0,
      newStep: '',
      dialogVisible: false,
      companies: [],
      selectedCompany: null,
      state_options: [{
        value: '未发货',
        label: '未发货'
      }, {
        value: '运输中',
        label: '运输中'
      }, {
        value: '待签收',
        label: '待签收'
      }, {
        value: '已完成',
        label: '已完成'
      }, ],
      tempid:'',
      tempState: '',
      changeState:false,
      user:{},
      search: '',
      search_2: '',
      send_tableData: [
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'未发货',
        },
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'运输中',
        },
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'待签收',
        },
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'已完成',
        },
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'待签收',
        }
      ],
      all_tableData:[      {
        recname:'ZLG',
        recphone: "18224426057",
        destination:"北京市海淀区",
        type:'陆运',
        state:'未发货',
      },
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'运输中',
        },
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'待签收',
        },
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'已完成',
        },
        {
          recname:'ZLG',
          recphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'待签收',
        }],
      tranUnit:[],
      rec_tableData: [
        {
          sendname:'禹浩男喵',
          sendphone: "18224426057",
          setout:"北京市海淀区",
          type:'陆运',
          state:'未发货',
        },
        {
          sendname:'ZLG',
          sendphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'运输中',
        },
        {
          sendname:'ZLG',
          sendphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'待签收',
        },
        {
          sendname:'ZLG',
          sendphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'已完成',
        },
        {
          sendname:'ZLG',
          sendphone: "18224426057",
          destination:"北京市海淀区",
          type:'陆运',
          state:'待签收',
        }
      ],
      check:true,
      role:0,
      options: regionData,
      curpage:1,
      place_1:'',
      place_2:'',
      ruleForm: {
      },
      rules: {
        sendname: [
          { required: true, message: '请输入寄件人姓名', trigger: 'blur' },
        ],
        sendphone: [
          { required: true, message: '请选择寄件人联系方式', trigger: 'blur' }
        ],
        createtime: [
          { required: true, message: '请选择发货日期', trigger: 'blur' }
        ],
        setout: [
          {required: true, message: '请选择发货地', trigger: 'blur' }
        ],
        destination: [
          {required: true, message: '请选择收货地', trigger: 'blur' }
        ],
        address: [
          { required: true, message: '请填写发货地址', trigger: 'blur' }
        ],
        recaddress: [
          { required: true, message: '请填写收货地址', trigger: 'blur' }
        ],
        weight: [
          { required: true, message: '请填写货物重量', trigger: 'blur' }
        ],
        recname: [
          { required: true, message: '请填写收件人姓名', trigger: 'blur' }
        ],
        recphone: [
          { required: true, message: '请填写收件人手机', trigger: 'blur' }
        ],
      },
    }
  },
  created() {
    this.user = JSON.parse(window.localStorage.getItem("user"));
    this.token= JSON.parse(window.localStorage.getItem("token"));
    this.getAll();
  },
  methods: {
    selectUnit(unit,index){
      let id=this.all_tableData[this.nowIndex].id
      console.log("selectid: "+id)
      let transid=this.nowUnit[index].transunitid
      let _this=this
      axios
          .post("http://127.0.0.1:8710/order/allocation?&transunitid="+transid +"&orderid="+id+"&rest="+this.all_tableData[this.nowIndex].weight, {
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
          })
          .then(function (ressponse) {
            _this.$message({
              message: '分配成功！',
              type: 'success'
            });
            _this.$router.go(0)
          })
    },
    recieve(index,row){
      console.log(("recieved"+this.all_tableData[index].id))
     let  _this=this
      this.$alert('确认签收吗？', '签收', {
        confirmButtonText: '确定',
        callback: action => {
          axios
              .post("http://127.0.0.1:8710/order/receive?&orderid="+this.all_tableData[index].id, {
                headers: { "Content-Type": "application/x-www-form-urlencoded" },
              })
              .then(function (ressponse) {
                _this.$message({
                  message: '签收成功！',
                  type: 'success'
                });
              })
          _this.$router.go(0)
        }
      });

    },
    getSteps(orderid){
      let _this=this
      this.transportProgress=[]
      axios
          .get("http://127.0.0.1:8710/order/get_records?&orderid="+orderid, {
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
          })
          .then(function (ressponse) {
            for(let i=0;i<ressponse.data.length;i++){
              let temp={title:ressponse.data[i].content}
              _this.transportProgress.push(temp)
            }
          })
          this.activeStep = this.transportProgress.length;
    },
    toDeli(){
      console.log("deli"+this.all_tableData[this.nowIndex].id)
      let _this=this
      axios
          .post("http://127.0.0.1:8710/order/toDeli?&orderid="+this.all_tableData[this.nowIndex].id, {
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
          })
          .then(function (ressponse) {
            _this.$router.go(0)
          })

      this.progressVisible = false;
    },
    openProgress(index,row) {
      this.progressVisible = true;
      this.nowIndex=index;
      this.getSteps(this.all_tableData[index].id)

    },
    addStep() {
      if (this.newStep) {
        axios
            .post("http://127.0.0.1:8710/order/insertRecords?&orderid="+this.all_tableData[this.nowIndex].id+"&content="+this.newStep, {
              headers: { "Content-Type": "application/x-www-form-urlencoded" },
            })
            .then(function (ressponse) {
            })
        this.transportProgress.push({ title: this.newStep });
        this.newStep = '';
        this.activeStep = this.transportProgress.length;
      }
    },
    openDialog(index,row) {
      console.log("now:"+this.all_tableData[index].id)
      this.nowIndex=index
      // 从后端获取公司列表数据
      // 这里假设获取的数据格式为 [{ name: '公司1', logo: 'logo1.png' }, { name: '公司2', logo: 'logo2.png' }]
      let _this=this
      this.companies=[]
      axios
          .get("http://127.0.0.1:8710/tran/morethanrest?&rest="+this.all_tableData[index].weight, {
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
          })
          .then(function (ressponse) {
            for(let i=0;i<ressponse.data.length;i++){
              console.log(ressponse.data)
              _this.tranUnit=ressponse.data;
              let temp={name:ressponse.data[i].name,logo: 'https://636c-cloud1-8gc6ijvn24a36d79-1318402435.tcb.qcloud.la/appSource/bjtu.jpg?sign=80ef6386a463431bb89aedd32013970d&t=1687165095'}
              _this.companies.push(temp)
            }
          })
      this.dialogVisible = true;
    },
    selectCompany(index) {
      console.log(index)
      this.nowUnit=[]
      for(let i =0;i<this.tranUnit[index].list.length;i++){
        let temp=this.tranUnit[index].list[i]
        if(temp.name.search("冷链")!=-1){
          temp.logo="https://636c-cloud1-8gc6ijvn24a36d79-1318402435.tcb.qcloud.la/appSource/cold.png?sign=48851685684aee0682ff886589e65928&t=1687253649"
        }else{
          temp.logo="https://636c-cloud1-8gc6ijvn24a36d79-1318402435.tcb.qcloud.la/appSource/carat.png?sign=34045a010af4e49f5f9ae6068c711f22&t=1687253660"
        }
        temp.percent=parseInt(temp.rest)/parseInt(temp.total)*100
        this.nowUnit.push(temp)
      }
      this.dialogVisible = false;
      this.UnitVisible =true

    },
    ensureState(){
      if(this.tempState!=''){
        let _this=this;
        axios
            .get("http://localhost:8088/manage/state_change?&orderId="+ this.tempid+"&state="+this.tempState, {
              headers: { "Content-Type": "application/x-www-form-urlencoded" },
            })
            .then(function (ressponse) {
              if(ressponse.data==0){
                _this.$message.error({
                  message: "修改失败！请重试",
                });
              }else{
                _this.$message.success({
                  message: "修改成功！",
                });
                setTimeout(() => {
                  //设置延迟执行
                  _this.getAll();
                  _this.changeState=false;
                }, 1000);
              }
            })
      }
    },

    stateChange(){
    },
    handleState(index,row){
      this.changeState=true;
      this.tempid=row.id;
    },
    filterTag(value, row) {
      return row.state === value;
    },

    curpage_2(){
      this.curpage=2;
      this.getAll()

    },
    curpage_4(){
      this.curpage=4;
      this.getSend();
      this.getRec();
    },
    submitForm(){
      let _this = this;
      this.$refs.ruleForm.validate((valid)=>{
        if(valid){
          var format =new FormData();
          format.append("userid",this.user.id)
          format.append("createtime",this.ruleForm.createtime)
          format.append("setout",this.place_1)
          format.append("destination",this.place_2)
          format.append("type",this.ruleForm.type)
          format.append("state",'未发货')
          format.append("weight",this.ruleForm.weight)
          format.append("sendphone",this.ruleForm.sendphone)
          format.append("recphone",this.ruleForm.recphone)
          format.append("sendname",this.ruleForm.sendname)
          format.append("recname",this.ruleForm.recname)
          format.append("content",this.ruleForm.content)
          format.append("sendaddress",this.ruleForm.address)
          format.append("recaddress",this.ruleForm.recaddress)
          axios
              .post("http://localhost:8088/order/addOrder", format , {
                headers: { "Content-Type": "application/x-www-form-urlencoded",
                  "token":this.token
                },
              })
              .then(function (ressponse) {
                _this.resetForm();
                _this.$message.success({
                  message: "录入成功！",
                });
              })
        }else{
          _this.$message.error({
            message: "录入失败，请检查表单！",
          });
        }

      })

    },

    getSend(){
      var _this=this;
      this.send_tableData=[]
      console.log(this.user)
      axios
          .get("http://localhost:8088/order/selectBysp?&phone="+ this.user.phone, {
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
          })
          .then(function (ressponse) {
            _this.send_tableData=ressponse.data
          })
      // console.log(this.send_tableData)
    },
    getAll(){
      var _this=this;
      this.all_tableData=[]
      console.log(this.user)
      axios
          .get("http://127.0.0.1:8710/order/selectAll", {
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
          })
          .then(function (ressponse) {
            _this.all_tableData=ressponse.data
          })
      // console.log(this.send_tableData)
    },

    getRec(){
      var _this=this;
      this.rec_tableData=[]
      axios
          .get("http://localhost:8088/order/selectByrp?&phone="+ this.user.phone, {
            headers: { "Content-Type": "application/x-www-form-urlencoded" },
          })
          .then(function (ressponse) {
            _this.rec_tableData=ressponse.data;
          })
    },

    logout(){
      var _this = this;
      window.localStorage.removeItem("user");
      _this.$message({
        message: "注销成功",
        type: "success",
      });
      setTimeout(() => {
        location.reload();
      }, 1000);

    },

    tableRowClassName({row, rowIndex}) {
      if (rowIndex === 1) {
        return 'warning-row';
      } else if (rowIndex === 3) {
        return 'success-row';
      }
      return '';
    },
    handleChange (value) {
      this.ruleForm.selectedOptions=''
      this.place_1=''
      for(let i =0;i<value.length;i++){
        this.place_1=this.place_1+codeToText[value[i]]
      }
    },
    handleChange_2 (value) {
      this.ruleForm.selectedOptions2=''
      this.place_2=''
      for(let i =0;i<value.length;i++){
        this.place_2=this.place_2+codeToText[value[i]]
      }
    },
    resetForm(){
      this.ruleForm=[]
      this.place_1=''
      this.place_2=''
    },
    bodyScale() {
      let t = window.devicePixelRatio   // 获取下载的缩放 125% -> 1.25    150% -> 1.5
      if (!!window.ActiveXObject || "ActiveXObject" in window) {
        if (t != 1) {
          // 如果在笔记本中用IE浏览器打开 则弹出提示
          alert('您的设备对显示进行放大导致页面显示不完全,请调整后打开/或用其他浏览器')
        }
      } else {
        if (t != 1) {   // 如果进行了缩放，也就是不是1
          let c = document.querySelector('body')
          c.style.zoom = -0.62 * t + 1.55;   // 就去修改页面的缩放比例，这个公式我自己算的，不准确，勉强。
        }
      }
    },
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleStatus(index, row) {
      this.$prompt('请输入邮箱', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
        inputErrorMessage: '邮箱格式不正确'
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你的邮箱是: ' + value
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    }
  },
}
</script>

<style scoped>
.company-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.el-card {
  margin: 10px;
  width: 200px;
  height: auto;
  cursor: pointer;
}
.company-logo {
  height: 120px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.company-name {
  font-size: 16px;
  text-align: center;
  font-weight: bolder;
  margin-top: 15px;
}

.bock01 {
  border: 1px solid rgba(0,0,0,0.10);
  width: 50%;
  box-shadow: 0 0 10px 0 rgba(0,0,0,0.05);
  overflow: hidden;
  padding-top: 35px;
  padding-bottom: 27px;
  margin-left: 5px;
  margin-right: 5px;
}

.r-g-index {
  width: 30px;
  height: 30px;
  background: #cccccc;
  color: #fff;
  text-align: center;
  line-height: 30px;
  font-weight: bolder;
  border-radius: 10px;
}
.r-g-index.r-g-index-1 {
  background: black;
}
.r-g-index.r-g-index-2 {
  background: darkred;
}

.el-header{
  vertical-align: center;
  border-bottom: 3px solid #eee;
  margin: 5px;
  border-radius: 5px;
}
.el-menu{
  border-radius: 0px  25px 0px 0px;
  border-right: 0px;
  font-size: 30px;
}
.el-menu-item{
  text-align: start;
  font-size: 18px;
  font-weight: bold;
  height: 60px;
}

.el-main{
  /*border: 3px solid #eee;*/
  margin: 5px;
  border-radius: 5px;
  box-shadow: 0px 0px 2px black;
}
.el-menu-item{
}

body {
  display: block;
  margin: 0px;
}
</style>
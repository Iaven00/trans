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
<!--        首页-->
<!--        <div>-->
<!--          <div style="display:flex; flex-direction: row;justify-content:center">-->
<!--            <div class="bock01" name="Slider-1" style="margin-right: 3%;margin-left: 3%">-->
<!--              <i><img src="~@/assets/icon1.png" alt="个人政策"></i>-->
<!--              <h3>开发中。。</h3>-->
<!--              <p>-->
<!--              </p>-->
<!--            </div>-->
<!--            <div class="bock01" name="Slider-1"style="margin-right: 3%;margin-left: 3%">-->
<!--              <i><img src="~@/assets/icon2.png" alt="最新政策" ></i>-->
<!--              <h3>待发货：xxx</h3>-->
<!--              <p>-->
<!--              </p>-->
<!--            </div>-->
<!--            <div class="bock01" name="Slider-1"style="margin-right: 3%;margin-left: 3%">-->
<!--              <i><img src="~@/assets/icon3.png" alt="企业政策"></i>-->
<!--              <h3>运输中：xxx</h3>-->
<!--              <p>-->
<!--              </p>-->
<!--            </div>-->
<!--            <div class="bock01" name="Slider-1"style="margin-right: 3%;margin-left: 3%">-->
<!--              <i><img src="~@/assets/icon4.png" alt="热点政策"></i>-->
<!--              <h3>已完成：xxx</h3>-->
<!--              <p>-->
<!--              </p>-->
<!--            </div>-->
<!--        </div>-->
<!--        </div>-->
        <div>
          <h3 style="float: right" >欢迎您，{{ user.username }}</h3>
          <el-breadcrumb separator-class="el-icon-arrow-right">

          </el-breadcrumb>
          <el-carousel :interval="5000" style="margin-top: 5rem;margin-bottom: 5rem">
            <el-carousel-item v-for="item in carouselItems" :key="item.id">
              <img :src="item.imageUrl" alt="" style="width: 50%; height: auto;">
              <h3>{{ item.title }}</h3>
              <p>{{ item.content }}</p>
            </el-carousel-item>
          </el-carousel>
          <div class="card-container">
            <el-card class="card-item" @click="goToOrderPage('all')">
              <div slot="header" class="clearfix">
                <span>全部订单</span>
                <el-badge :value="allOrderCount" class="card-badge"></el-badge>
              </div>
            </el-card>
            <el-card class="card-item" @click="goToOrderPage('received')">
              <div slot="header" class="clearfix">
                <span>收到的订单</span>
                <el-badge :value="receivedOrderCount" class="card-badge"></el-badge>
              </div>
            </el-card>
            <el-card class="card-item" @click="goToOrderPage('sent')">
              <div slot="header" class="clearfix">
                <span>我发出的订单</span>
                <el-badge :value="sentOrderCount" class="card-badge"></el-badge>
              </div>
            </el-card>
            <el-card class="card-item" @click="goToOrderPage('toReceive')">
              <div slot="header" class="clearfix">
                <span>待签收的订单</span>
                <el-badge :value="toReceiveOrderCount" class="card-badge"></el-badge>
              </div>
            </el-card>
          </div>
        </div>

      </el-main>
    </el-container>
  </el-container>
</template>


<script>
import { regionData,codeToText } from 'element-china-area-data'
import my_aside from '../components/my_aside.vue'
import my_header from '../components/my_header.vue'
import axios from "axios";
export default {
  components:{
    my_aside,
    my_header
  },
  name: "center.vue",
  data(){
    return{
      carouselItems: [
        {
          id: 1,
          title: '轮播项1',
          content: '这是轮播项1的详细描述',
          imageUrl: 'https://636c-cloud1-8gc6ijvn24a36d79-1318402435.tcb.qcloud.la/appSource/transmin1.jpg?sign=6348d984e812917aa60800f49b6ddc0b&t=1687248364'
        },
        {
          id: 2,
          title: '轮播项2',
          content: '这是轮播项2的详细描述',
          imageUrl: 'https://636c-cloud1-8gc6ijvn24a36d79-1318402435.tcb.qcloud.la/appSource/transmin2.jpg?sign=1117bd5a34f87f1375c154a6317b24da&t=1687248381'
        },
        {
          id: 3,
          title: '轮播项3',
          content: '这是轮播项3的详细描述',
          imageUrl: 'https://636c-cloud1-8gc6ijvn24a36d79-1318402435.tcb.qcloud.la/appSource/transmin3.jpg?sign=e1fdac79d1d5b38db9ad95bc7bf89d9d&t=1687248389'
        }
      ],
      allOrderCount: 10,
      receivedOrderCount: 5,
      sentOrderCount: 3,
      toReceiveOrderCount: 2,
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
      all_tableData:[],
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
    // this.getSend();
    // this.getRec();
    // this.getAll();
    // this.bodyScale()
  },
  methods: {
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
          .get("http://127.0.0.1:8710/order/selectBysp?&phone="+ this.user.phone, {
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
          .get("http://localhost:8088/order/selectAll", {
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
      Change (value) {
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
    dEdit(index, row) {
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
.card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.card-item {
  width: 250px;
  margin: 20px;
}

.card-badge {
  margin-left: 10px;
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
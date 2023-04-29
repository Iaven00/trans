<template>
  <el-container>
    <el-aside width="200px">
      <el-menu
          style="height: 100vh"
          default-active="1"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b">
<!--        <h3 style="color: white;font-size: 30px;margin-top: 3vh;margin-bottom: 3vh">Title</h3>-->
        <div style="width: 200px; height: 100px;margin-top: 2vh" >
          <img class="img" src="~@/assets/shiptitle_white.png" draggable="false" style="display: block; width: 200px; height: 100px;">
        </div>
        <el-menu-item index="0" @click="curpage=0" style="margin-top: 3vh">
          <i class="el-icon-menu"></i>
          <span slot="title">首页</span>
        </el-menu-item>
        <el-menu-item index="1" @click="curpage=1">
          <i class="el-icon-s-promotion"></i>
          <span slot="title">新增订单</span>
        </el-menu-item>
        <el-menu-item index="2" @click="curpage=2">
          <i class="el-icon-s-check"></i>
          <span slot="title">订单管理</span>
        </el-menu-item>
        <el-menu-item index="3" @click="curpage=3">
          <i class="el-icon-menu"></i>
          <span slot="title">用户管理</span>
        </el-menu-item>
        <el-menu-item index="4" v-if="role==0" @click="curpage=4">
          <i class="el-icon-s-check"></i>
          <span slot="title">订单查询</span>
        </el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
<!--      头部-->
      <el-header>
        <el-popover
            placement="bottom"
            title="个人信息"
            width="300"
            trigger="click"
            content="将来放关于用户的信息。"
            style="float: right;align-content: center;margin-top: 1vh"
        >
          <el-button v-if="check" slot="reference"  icon="el-icon-user-solid" circle
                     style="background-color: #ffd04b">
          </el-button>

          <el-button v-if="!check" slot="reference"  icon="el-icon-user" circle
                     style="background-color: #ffd04b">
          </el-button>
          <!--用户信息 -->
          <div v-if="check">
            欢迎回来！<span style="color: #55ab41">{{
              user.username
            }}</span>
            <span id="logout" @click="logout">注销</span>
          </div>
          <div v-if="!check">
            <a
                style="
                    color: #55ab41;
                    margin-right: 148px;
                    text-decoration: none;
                  "
                href="/login"
            >对不起,请前往登录</a
            >
            <a
                style="color: #55ab41; text-decoration: none"
                href="/register"
            >注册</a
            >
          </div>
        </el-popover>
<!--        <div style="background-color: gray;height: 7vh"></div>-->
      </el-header>
<!--      主要内容-->
      <el-main>
<!--        首页-->
        <div v-if="curpage==0">
          <div style="display:flex; flex-direction: row;justify-content:center">
            <div class="bock01" name="Slider-1" style="margin-right: 3%;margin-left: 3%">
              <i><img src="~@/assets/icon1.png" alt="个人政策"></i>
              <h3>个人办事</h3>
              <p>
              </p>
            </div>
            <div class="bock01" name="Slider-1"style="margin-right: 3%;margin-left: 3%">
              <i><img src="~@/assets/icon2.png" alt="最新政策" ></i>
              <h3>最新政策</h3>
              <p>
              </p>
            </div>
            <div class="bock01" name="Slider-1"style="margin-right: 3%;margin-left: 3%">
              <i><img src="~@/assets/icon3.png" alt="企业政策"></i>
              <h3>企业政策</h3>
              <p>
              </p>
            </div>
            <div class="bock01" name="Slider-1"style="margin-right: 3%;margin-left: 3%">
              <i><img src="~@/assets/icon4.png" alt="热点政策"></i>
              <h3>热点政策</h3>
              <p>
              </p>
            </div>
        </div>
        </div>


<!--        下单-->
        <div v-if="curpage==1" style="width: 100%;padding: 0px" >
          <div >
            <div style="margin-top: 50px;">
              <el-col :span="10" style="border-right:2px solid #eee ">
                <div style="display: flex;height: 40px;margin-bottom: 10px">
                  <span class="r-g-index r-g-index-1" style="margin-left: 20px">寄</span>
                  <span class="" style="margin-left: 10px;line-height: 30px">寄方信息</span>
                </div>

                <el-form style="height: 80%;width: 500px;justify-content: start"  :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                  <el-form-item label="寄件人姓名" prop="send_name">
                    <el-input v-model="ruleForm.send_name" style="width: 200px;float: left"></el-input>
                  </el-form-item>
                  <el-form-item label="手机号"  prop="send_phone">
                    <el-input style="width: 200px;float: left" v-model="ruleForm.send_phone"></el-input>
                  </el-form-item>
                  <el-form-item label="寄出地区" prop="setout" >
                    <el-col :span="11">
                      <el-cascader
                          size="large"
                          :options="options"
                          v-model="ruleForm.setout"
                          style="width: 200px;"
                          @change="handleChange">
                      </el-cascader>
                    </el-col >
                    <el-col :span="11">
                      <el-form-item label="发货日期" required>
                        <el-form-item prop="create_time">
                          <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.create_time" style="width: 120px;"></el-date-picker>
                        </el-form-item>
                      </el-form-item>
                    </el-col>
                  </el-form-item>
                  <el-form-item label="详细始发地"  prop="address">
                    <el-input style="float: left" v-model="ruleForm.address"></el-input>
                  </el-form-item>
                  <el-form-item label="重量" prop="weight">
                    <el-input v-model="ruleForm.weight"></el-input>
                  </el-form-item>
                  <el-form-item label="期望方式" prop="type">
                    <el-radio-group v-model="ruleForm.type">
                      <el-radio label="陆运" ></el-radio>
                      <el-radio label="空运" ></el-radio>
                      <el-radio label="海运" ></el-radio>
                      <span></span>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="submitForm()">立即创建</el-button>
                    <el-button @click="resetForm()">重置</el-button>
                  </el-form-item>
                </el-form>
              </el-col >

              <el-col :span="10" style="margin-left: 5vh">
                <div style="display: flex;height: 40px;margin-bottom: 10px">
                  <span class="r-g-index r-g-index-2" style="margin-left: 20px">收</span>
                  <span class="" style="margin-left: 10px;line-height: 30px">收方信息</span>
                </div>
                <el-form style="height: 80%;width: 500px;justify-content: start"  :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                  <el-form-item label="收件人姓名" prop="rec_name">
                    <el-input v-model="ruleForm.rec_name" style="width: 200px;float: left"></el-input>
                  </el-form-item>
                  <el-form-item label="手机号"  prop="rec_phone">
                    <el-input style="width: 200px;float: left" v-model="ruleForm.rec_phone"></el-input>
                  </el-form-item>
                  <el-form-item label="收货地区" prop="destination" >
                    <el-col :span="11">
                      <el-cascader
                          size="large"
                          :options="options"
                          v-model="ruleForm.destination"
                          style="width: 200px;"
                          @change="handleChange_2">
                      </el-cascader>
                    </el-col >
                  </el-form-item>
                  <el-form-item label="详细收货地"  prop="rec_address">
                    <el-input style="float: left" v-model="ruleForm.rec_address"></el-input>
                  </el-form-item>
                  <el-form-item label="备注" prop="content">
                    <el-input type="textarea" :rows="6" resize='none' v-model="ruleForm.content"></el-input>
                  </el-form-item>
                </el-form>
              </el-col>
            </div>
          </div>
        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import { regionData,codeToText } from 'element-china-area-data'
export default {
  name: "center.vue",
  data(){
    return{
      check:false,
      role:0,
      options: regionData,
      curpage:1,

      ruleForm: {
      },
      rules: {
        send_name: [
          { required: true, message: '请输入寄件人姓名', trigger: 'blur' },
        ],
        send_phone: [
          { required: true, message: '请选择寄件人联系方式', trigger: 'blur' }
        ],
        create_time: [
          { type: 'date', required: true, message: '请选择发货日期', trigger: 'blur' }
        ],
        setout: [
          {required: true, message: '请选择发货地', trigger: 'change' }
        ],
        destination: [
          {required: true, message: '请选择收货地', trigger: 'change' }
        ],
        address: [
          { required: true, message: '请填写发货地址', trigger: 'blur' }
        ],
        rec_address: [
          { required: true, message: '请填写收货地址', trigger: 'blur' }
        ],
        weight: [
          { required: true, message: '请填写货物重量', trigger: 'blur' }
        ],
        rec_name: [
          { required: true, message: '请填写收件人姓名', trigger: 'blur' }
        ],
        rec_phone: [
          { required: true, message: '请填写收件人手机', trigger: 'blur' }
        ],
      },

    }
  },
  created() {
    // this.bodyScale()
  },
  methods: {
      handleChange (value) {
        this.ruleForm.selectedOptions=''
        let place=''
        for(let i =0;i<value.length;i++){
          place=place+codeToText[value[i]]
        }
      },
    handleChange_2 (value) {
      this.ruleForm.selectedOptions_2=''
      let place=''
      for(let i =0;i<value.length;i++){
        place=place+codeToText[value[i]]
      }
    },
      resetForm(){
      this.ruleForm.POLICY_TITLE= '';
      this.ruleForm.POLICY_GRADE= '';
      this.ruleForm. PUB_AGENCY= '';
      this.ruleForm.PUB_TIME= '';
      this.ruleForm. POLICY_TYPE= '';
      this.ruleForm.POLICY_BODY= '';
      this.ruleForm. PROVINCE= '';
      this.ruleForm.POLICY_SOURCE= '';
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
    handleDelete(index, row) {
      console.log(index, row);
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
<template>
  <div class="login-register">
    <div class="contain">
      <div class="big-box" :class="{active:isLogin}">
        <div class="big-contain" key="bigContainLogin" v-if="isLogin">
          <div class="btitle">账户登录</div>
          <div class="bform">
            <input type="email" placeholder="邮箱" v-model="form.email">
            <span class="errTips" v-if="emailError">* 邮箱填写错误 *</span>
            <input type="password" placeholder="密码" v-model="form.password">
            <span class="errTips" v-if="emailError">* 密码填写错误 *</span>
          </div>
          <button class="bbutton" @click="login">登录</button>
        </div>
        <div class="big-contain" key="bigContainRegister" v-else>
          <div class="btitle">创建账户</div>
          <div class="bform">
            <input type="text" placeholder="用户名" v-model="reg.username">
            <div style="display: flex">
              <input type="text" placeholder="邮箱" v-model="reg.email" style="float: left;width: 200px">
              <el-button size="small" style="width: 100px;margin-left: 20px" @click="codesend()">发送验证码</el-button>
            </div>

            <span class="errTips" v-if="existed">* 用户名已经存在！ *</span>
            <input type="email" placeholder="验证码" v-model="reg.code">
            <input type="password" placeholder="密码" v-model="reg.password">
          </div>
          <button class="bbutton" @click="register">注册</button>
        </div>
      </div>
      <div class="small-box" :class="{active:isLogin}">
        <div class="small-contain" key="smallContainRegister" v-if="isLogin">
          <div style="width: 200px; height: 100px;" >
            <img class="img" src="~@/assets/shiptitle_black.png" draggable="false" style="display: block; width: 200px; height: 100px;">
          </div>
          <div class="stitle">物流管理系统</div>
          <p class="scontent">没有账号？创建账户，立即下单！</p>
          <button class="sbutton" @click="changeType">注册</button>
        </div>
        <div class="small-contain" key="smallContainLogin" v-else>
          <div style="width: 200px; height: 100px;" >
            <img class="img" src="~@/assets/shiptitle_black.png" draggable="false" style="display: block; width: 200px; height: 100px;">
          </div>
          <div class="stitle">物流管理系统</div>
          <p class="scontent">已有账号？点击下方登录！</p>
          <button class="sbutton" @click="changeType">登录</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default{
  name:'login-register',
  data(){
    return {
      isLogin:false,
      emailError: false,
      passwordError: false,
      existed: false,
      reg:{
        username:'',
        email:'',
        password:'',
        phone:'',
        code:'',
      },
      form:{
        email:'',
        password:''
      }
    }
  },
  methods:{
    codesend(){
      var _this=this;
      if(this.reg.email!=''){
        _this.$message({
          message: "发送中请稍后",
          type: "primary",
        });
        axios
            .get("http://127.0.0.1:8710/account/user/sendcode?&email="+ this.reg.email, {
              headers: { "Content-Type": "application/x-www-form-urlencoded" },
            })
            .then(function (ressponse) {
              if (ressponse.data.code != 0) {
                _this.$message({
                  message: "发送成功",
                  type: "success",
                });
              }else{
                _this.$message({
                  message: "发送失败，请检查邮箱后重试",
                  type: "warning",
                });
              }
            })
      }else {
        _this.$message.error({
          message: "请输入邮箱！",
        });
      }
    },
    changeType() {
      this.isLogin = !this.isLogin
      // this.form.username = ''
      this.form.email = ''
      this.form.password = ''
    },
    login() {
      var format =new FormData();
      format.append("email",this.form.email)
      format.append("password",this.form.password)
      const self = this;
      if (self.form.email != "" && self.form.password != "") {
        let _this = this;
        axios
            .post("http://localhost:8710/auth/access/login", format , {
              headers: { "Content-Type": "application/x-www-form-urlencoded" },
            })
            .then(function (ressponse) {
              if (ressponse.data.code != "0") {
                localStorage.setItem("token", JSON.stringify(ressponse.data.code));
                localStorage.setItem("user", JSON.stringify(ressponse.data.object));
                _this.$message({
                  message: "登录成功",
                  type: "success",
                });
                setTimeout(() => {
                  //设置延迟执行
                  _this.$router.replace({ path: "/center" });
                }, 1000);
              } else {
                _this.$message.error({
                  message: "登录失败",
                });
              }
            })
      } else{
        this.$message({
          message: '填写不能为空',
          type: 'warning'
        });
      }
    },
    register(){
      const self = this;
      if(self.form.username != "" && self.form.email != "" && self.form.password != ""){
        self.$axios({
          method:'post',
          url: 'http://127.0.0.1:8710/account/user/register',
          data: {
            username: self.form.username,
            email: self.form.email,
            password: self.form.password
          }
        })
            .then( res => {
              switch(res.data){
                case 0:
                  alert("注册成功！");
                  this.login();
                  break;
                case -1:
                  this.existed = true;
                  break;
              }
            })
            .catch( err => {
              console.log(err);
            })
      } else {
        this.$message({
          message: '填写不能为空',
          type: 'warning'
        });
      }
    }
  }
}
</script>

<style scoped="scoped">
.login-register{
  width: 100vw;
  height: 100vh;
  box-sizing: border-box;
}
.contain{
  width: 60%;
  height: 60%;
  position: relative;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background-color: #fff;
  border-radius: 20px;
  box-shadow: 0 0 3px #f0f0f0,
  0 0 6px #f0f0f0;
}
.big-box{
  width: 70%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 30%;
  transform: translateX(0%);
  transition: all 1s;
}
.big-contain{
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.btitle{
  font-size: 1.5em;
  font-weight: bold;
  color: rgb(57,167,176);
}
.bform{
  width: 100%;
  height: 40%;
  padding: 2em 0;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}
.bform .errTips{
  display: block;
  width: 50%;
  text-align: left;
  color: red;
  font-size: 0.7em;
  margin-left: 1em;
}
.bform input{
  width: 50%;
  height: 30px;
  border: none;
  outline: none;
  border-radius: 10px;
  padding-left: 2em;
  background-color: #f0f0f0;
}
.bbutton{
  width: 20%;
  height: 40px;
  border-radius: 24px;
  border: none;
  outline: none;
  background-color: rgb(57,167,176);
  color: #fff;
  font-size: 0.9em;
  cursor: pointer;
}
.small-box{
  width: 30%;
  height: 100%;
  background: linear-gradient(135deg,rgb(57,167,176),rgb(56,183,145));
  position: absolute;
  top: 0;
  left: 0;
  transform: translateX(0%);
  transition: all 1s;
  border-top-left-radius: inherit;
  border-bottom-left-radius: inherit;
}
.small-contain{
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.stitle{
  font-size: 1.5em;
  font-weight: bold;
  color: #fff;
}
.scontent{
  font-size: 0.8em;
  color: #fff;
  text-align: center;
  padding: 2em 4em;
  line-height: 1.7em;
}
.sbutton{
  width: 60%;
  height: 40px;
  border-radius: 24px;
  border: 1px solid #fff;
  outline: none;
  background-color: transparent;
  color: #fff;
  font-size: 0.9em;
  cursor: pointer;
}

.big-box.active{
  left: 0;
  transition: all 0.5s;
}
.small-box.active{
  left: 100%;
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
  border-top-right-radius: inherit;
  border-bottom-right-radius: inherit;
  transform: translateX(-100%);
  transition: all 1s;
}
</style>
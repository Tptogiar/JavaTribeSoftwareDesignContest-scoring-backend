<template>
  <div class="login">
    <backgroundCom />
    <transition name="slide-fade">
      <div v-show="show" key="login" class="box">
        <Title text="LOGIN"></Title>
        <div>
          <div class="input-group gray">
            <label for="username"></label>
            <input
              id="username"
              v-model="username"
              placeholder="请输入真实姓名"
              label="姓名"
            />
          </div>
          <div class="input-group gray">
            <label for="password"></label>
            <input
              id="password"
              v-model="password"
              type="password"
              placeholder="请输入密码"
              label="密码"
            />
          </div>
          <div class="button-group">
            <router-link class="gray back" to="/">返回</router-link>
            <Button class="form-button" text="登录" @click.native="doLogin" />
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
import BackgroundCom from "@/components/BackgroundCom.vue";
import Title from "@/components/Title.vue";
import Button from "@/components/Button.vue";

export default {
  components: {
    BackgroundCom,
    Title,
    Button,
  },
  props: {},
  data() {
    return {
      username: "",
      password: "",
      show: false,
    };
  },
  methods: {
    doLogin: function () {
      let vue = this;
      if (this.username === "") {
        vue.$notify({ message: "姓名不能为空！", type: "danger" });

        return;
      }
      if (this.password === "") {
        vue.$notify({ message: "密码不能为空！", type: "danger" });
        return;
      }
      this.axios
        .post("/login/checkName", {
          judgeName: this.username,
          judgePassword: this.password,
        })
        .then(function (res) {
          if (res.data.status === 200) {
            window.localStorage.setItem("token", res.data.token);
            window.localStorage.setItem("judgeID", res.data.judge.id);
            window.localStorage.setItem("time", new Date().getTime());
            vue.$notify({ message: "登录成功！", type: "success" });
            vue.$router.replace("/judge");
          } else {
            vue.$notify({ message: "账号或密码错误！", type: "danger" });
          }
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
  mounted() {
    this.show = true;
  },
};
</script>

<style lang="scss" scoped>
.input-group {
  position: relative;
  width: 600px;
  margin: 0 auto 30px;
  label {
    position: absolute;
    top: 50%;
    left: 40px;
    width: 30px;
    height: 30px;
    transform: translate(0, -50%);
  }
  label[for="username"] {
    background: url(https://scoring-static-javatribe.oss-accelerate.aliyuncs.com/static/name.png) no-repeat;
    background-size: contain;
  }
  label[for="password"] {
    background: url(https://scoring-static-javatribe.oss-accelerate.aliyuncs.com/static/pwd.png) no-repeat;
    background-size: contain;
  }
  input {
    width: 400px;
    height: 90px;
    margin-left: 25px;
    letter-spacing: 2px;
    padding: 0;
    border: 0;
    background: rgba(240, 240, 240, 1);
    line-height: 90px;
  }
}
.gray {
  height: 90px;
  border-radius: 45px;
  background: rgba(240, 240, 240, 1);
  font-size: 28px;
  color: #2f195f;
}
input::-webkit-input-placeholder {
  /* placeholder颜色  */
  color: #2f195f;
  /* placeholder字体大小  */
  font-size: 28px;
  /* placeholder位置  */
  text-align: left;
}
.back {
  display: inline-block;
  width: 270px;
  line-height: 90px;
  vertical-align: top;
}

.button-group{
  width:600px;
  margin: 0 auto 30px;
  display: flex;
  justify-content: space-between;
}
.form-button {
  width: 270px;
}
</style>
<template>
  <div id="app">
    <router-view />
  </div>
</template>

<script>
import { sendWebsocket, closeWebsocket } from "./utils/websocket.js";
export default {
  data() {
    return {
      // 初始化当前加载出来的浏览器的宽度
      screenWidth: document.body.clientWidth,
      client: null,
      token: "",
    };
  },
  created() {},
  // 监听screenWidth值的改变
  watch: {
    screenWidth(val) {
      this.screenWidth = val;
      let self = this;
      if (this.screenWidth <= 750) {
        self.peen = false;
        self.seen = true;
      } else {
        self.peen = true;
        self.seen = false;
      }
    },
  },
  mounted() {
    const that = this;
    window.onresize = () => {
      return (() => {
        window.screenWidth = document.body.clientWidth;
        that.screenWidth = window.screenWidth;
      })();
    };
    this.axios.get("/ip/getIP").then((res) => {
      if (res.data.code == 200) {
        this.token = res.data.message;
        this.requstWs(this.token);
      }
    });
    // 每隔30s重连一次
    setInterval(() => {
      this.requstWs(this.token);
    }, 1000 * 30);
  },

  beforeDestroy() {
    // 页面销毁时关闭ws。因为有可能ws连接接收数据尚未完成，用户就跳转了页面
    // 在需要主动关闭ws的地方都可以调用该方法
    closeWebsocket();
  },
  methods: {
    // ws连接成功，后台返回的ws数据，组件要拿数据渲染页面等操作
    wsMessage(msg) {
      console.log(msg);
      if (msg === "update scores!") {
        this.$bus.$emit("updateScore"); // 发送到 rank 页面
      }
      // 这里写拿到数据后的业务代码
    },
    // ws连接失败，组件要执行的代码
    wsError(e) {
      console.log(e);
      // 比如取消页面的loading
      console.log("连接失败");
    },
    requstWs(token) {
      // 防止用户多次连续点击发起请求，所以要先关闭上次的ws请求。
      closeWebsocket();
      // 发起ws请求
      console.log("发送ws");
      sendWebsocket(
        "ws://120.76.177.221:8088/webSocket",
        token,
        this.wsMessage,
        this.wsError
      );
    },
  },
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>

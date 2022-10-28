import Vue from 'vue'
import App from './App.vue'
import router from './router'
import 'lib-flexible'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
// import timeLocalStorage from 'time-localstorage'

import {
  Button,
  Notify,
  Dialog,
  Tag
} from "vant";
Vue.use(Button);
Vue.use(ElementUI);
Vue.prototype.$notify = Notify;
Vue.prototype.$dialog = Dialog;
Vue.use(Tag);
Vue.use(VueAxios, axios);
Vue.prototype.$bus = new Vue(); // 事件总线


axios.defaults.baseURL = process.env.VUE_APP_BASE_API;

axios.interceptors.request.use(config => {
  // 浏览器终端问题 localstorage 的版本问题
  // 只有登录状态才加
    const token = window.localStorage.getItem('token');
    if(token){
      config.headers.Authorization =  window.localStorage.getItem('token')
    }
   return config
})

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

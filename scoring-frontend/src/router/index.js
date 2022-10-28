import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Rank from '../views/Rank.vue'
import Login from '../views/Login.vue'
import Judge from '../views/Judge.vue'
import Scoring from '../views/Scoring.vue'
import Admin from '../views/Admin.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {
      title: '首页'
    }
  },
  {
    path: '/rank',
    name: 'Rank',
    component: Rank,
    meta: {
      title: '排行榜'
    }
  },
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: {
      title: '评委登录'
    }
  },
  {
    path: '/judge',
    name: 'Judge',
    component: Judge,
    meta: {
      title: '评委首页'
    },
    beforeEnter: (to, from, next) => {
      if (window.localStorage.getItem("token")) {
        next();
      } else {
        next("/login");
      }
    }
  },
  {
    path: '/scoring',
    name: 'Scoring',
    component: Scoring,
    meta: {
      title: '评委评分'
    },
    beforeEnter: async function(to, from, next) {
      let isLogin = await judgeLogin();
      if(isLogin){
        next();
      }else{
        next("/login");
      }
    }
  },
  {
    path: '/admin',
    name: 'Admin',
    component: Admin,
    meta: {
      title: '管理员主页'
    },
    beforeEnter: async function(to, from, next){
      let isLogin = await judgeLogin();
      if(isLogin){
        next();
      }else{
        next("/login");
      }
    }
  },
]

/**
 * 判断是否登录
 * @returns 
 */
function judgeLogin() {
  return new Promise(resolve => {
    let time = window.localStorage.getItem("time");
    let endTime = Math.round(new Date().getTime() - time) / (1000 * 60 * 60);
    // 大于 2 小时清除登录记录
    if (endTime > 2) {
      window.localStorage.clear();
      resolve(false);
    } else {
      if (window.localStorage.getItem("token")) {
        window.localStorage.setItem("time", new Date().getTime()); // 更新在线时间
       resolve(true);
      } else {
        resolve(false);
      }
    }
  })
}

const router = new VueRouter({
  // mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 利用路由守卫完成 title 的修改
const defaultTitle = '爪哇部落'
router.beforeEach((to, from, next) => {
  document.title = to.meta.title ? to.meta.title : defaultTitle
  next()
})
export default router

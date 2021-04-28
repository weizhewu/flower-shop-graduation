import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import global_ from './config/global.js'
axios.defaults.baseURL = 'http://localhost:8080'

Vue.use(ElementUI);
Vue.use(VueAxios, axios)
Vue.prototype.GLOBAL = global_
// 路由导航守卫，当路由发生变化的时候，我们想要做的事情，这就是导航守卫的重点
// router.beforeEach((to, from, next) => {
//   if (to.path === '/auth') {
//     return next({ path: '/auth' })
//   }
//   let token = localStorage.getItem('token')
//   let isLogin
//   if (!token) {
//     isLogin = false
//   } else {
//     isLogin = true
//   }
//   if (!isLogin) {
//     if (to.path !== '/login') {
//       return next({ path: '/login' })
//     } else {
//       next()
//     }
//   } else {
//     if (to.path === '/login') {
//       return next({ path: '/' })
//     }
//     next()
//   }
// })

//全局请求拦截
axios.interceptors.request.use((config) => {
  //请求的接口不是登录和验证码接口
  if (['/sysAdmin/login', '/captcha'].indexOf(config.url) === -1) {
    const token = localStorage.getItem('token')
    if (token) {
      config.headers.Authorization = token
      config.headers.id = 'DE35D7CC05AF96A21D7ADFC8651E6614'
    }
  }
  return config
})

new Vue({
  router,
  store,
  render: (h) => h(App)
}).$mount('#app')

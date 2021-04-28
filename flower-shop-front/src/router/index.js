import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/index/Index.vue'
import FlowerDetail from '../views/flowerDetail/FlowerDetail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: Index
  },
  {
    path: '/detail',
    name: 'FlowerDetail',
    component: FlowerDetail
  }
]

const router = new VueRouter({
  routes
})

export default router

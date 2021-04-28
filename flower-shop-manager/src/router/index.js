import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/index/Index.vue'
import Flower from '../views/flower/Flower.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    component: Index,
	children:[
		{
			path: 'flower',
			name: 'Flower',
			component: Flower  
		}
	]
  },
  
]

const router = new VueRouter({
  routes
})

export default router

import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const store = new Vuex.Store({
  state: {
    token: localStorage.getItem('token'),
    name: '',
    avatar: '',
    menuList: null
  },
  mutations: {
    setToken(state, data) {
      state.token = data
    },
    setAdmin(state, data) {
      state.admin = data
    },
    setId(state, data) {
      state.id = data
    },
    setName(state, data) {
      state.name = data
    },
    setAvatar(state, data) {
      state.avatar = data
    },
    setMenuList(state, data) {
      state.menuList = data
    },
    refreshAdmin(state, data) {
      state.admin = data
    },
    refreshMenuList(state, data) {
      state.menuList = data
    }
  },
  actions: {}
})
export default store

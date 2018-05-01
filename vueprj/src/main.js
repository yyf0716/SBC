// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import 'normalize.css/normalize.css'// A modern alternative to CSS resets

import App from './App'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/en'

import '@/styles/index.scss' // global css

Vue.use(ElementUI, { locale })

import router from "./router/router_index"
import store from './store'

import '@/icons' // icon

Vue.prototype.HOME='/api'
Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})

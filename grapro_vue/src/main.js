import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
//import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import echarts from 'echarts'
import "normalize.css";

Vue.config.productionTip = false
Vue.use(ElementUI);
Vue.prototype.$ajax = axios
Vue.prototype.$echarts = echarts

new Vue({
  //store,
  router,
  render: h => h(App),
}).$mount('#app')

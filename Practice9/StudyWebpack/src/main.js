//测试模块化
import {add,cheng} from './js/mathUtil.js';
console.log(add(3, 2));
console.log(cheng(3, 2));

//导入css
import css from './css/normal.css'

//导入less
import less from './css/special.less';
document.writeln("<h3>我giao</h3>")

//webpack基本使用vue
//引入vue
/*import Vue from 'vue';
new Vue({
  el:'#app',
  data:{
    message:'万一'
  }
});*/

//vue终极方案
import Vue from 'vue';
import wanyi from './vue/wanyi.vue'
new Vue({
  el:'#app',
  template:'<wanyi/>',      //template中的内容会替换html页面中的div
  components:{              //这里是根组件的子组件，相当于wanyi:wanyi，使用es6的变量增强写法
    wanyi
  }
});
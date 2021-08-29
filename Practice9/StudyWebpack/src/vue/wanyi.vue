<template>
  <button @click="show" class="bt">{{message}}</button>

</template>

<script>
export default {
  name: 'wanyi',
  data(){
    return{
      message:'万一',
    }
  },
  methods:{
    show(){
      console.log('万一挑一，我是唯一');
    }
  }
};
</script>

<style scoped>
.bt{
  color: blue;
}
</style>
<template>
  <div>
      {{msg}}
      <p v-html="userName" />
      <span v-bind:class="vbclass">CSS</span>
    <br/>
      <span v-bind:title="vbtitle">TITLE</span>
    <br/>
      {{msg.split('').join(',')}}
    <br/>
    <p v-if="showflg">TRUE</p>
    <p v-else>FALSE</p>
  </div>
</template>

<script>
export default {
  data(){
      return{
          msg:'用户登录',
          userName : '用户名：',
          vbclass : 'c1',
          vbtitle : '动态',
          showflg : false
      }
  }
}
</script>

<style>
c1{
    color: red
}
</style>



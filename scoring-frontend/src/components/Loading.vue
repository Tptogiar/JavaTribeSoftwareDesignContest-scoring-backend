<template>
<div class="loading"></div>
</template>

<script>
export default {
  name: 'Loading' // 定义的组件名称 使用时写法：loading
}
</script>

<style scoped>
.loading {
  position: fixed;
  left: 0;
  top: 0;
  background: url('https://scoring-static-javatribe.oss-accelerate.aliyuncs.com/static/loading.gif') center center no-repeat #fff;
  width: 100vw;
  height: 100vh;
  z-index: 1000;
}
</style>

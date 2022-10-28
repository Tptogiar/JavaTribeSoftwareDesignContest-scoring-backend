<template>
  <div class="title">{{ text }}</div>
</template>

<script>
export default {
  name: "Title",
  props: { text: String },
};
</script>
<style scoped lang="scss">
.title {
  max-width: 503px;
  max-height: 149px;
  margin: 0 auto 88px;
  font-size: 71px;
  font-family: Adobe Heiti Std;
  font-weight: bold;
  letter-spacing:9px;
  color: rgba(47, 25, 95, 1);
  line-height: 79px;
}
</style>

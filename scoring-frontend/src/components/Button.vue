<template>
  <router-link v-if="routerLink" :to="url">
    <van-button class="Button" type="info">{{text}}</van-button>
  </router-link>
  <van-button class="Button" v-else type="info">{{text}}</van-button>
</template>

<script>

export default {
  name: "Button",
  props: {
    text: {
      type: String,
      required: true
    },
    url: {
      type: String,
      required: false,
      default: ""
    },
    routerLink: {
      type: Boolean,
      required: false,
      default: false
    }
  }
};
</script>

<style scoped lang="scss">
.Button {
  width:450px;
  height:90px;
  margin-bottom: 30px;
  background:rgba(47,25,95,1);
  font-size: 24px;
  text-align: center;
  border-radius:45px;
  letter-spacing: 6px;
  border:0;
}
</style>
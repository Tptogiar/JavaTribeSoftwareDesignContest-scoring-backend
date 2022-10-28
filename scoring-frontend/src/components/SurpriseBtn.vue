<template>
  <div class="about">
    <p @touchstart="start" @touchmove="move" @touchend="end">
    </p>
  </div>
</template>
<script>
export default {
    name:'SurpriseBtn',
  data() {
    return {
      longClick: 0,
      timeOutEvent: 0
    };
  },
  methods: {
    start() {
      var that = this;
      this.longClick = 0;
      this.timeOutEvent = setTimeout(function() {
        that.longClick = 1;
        // console.log("这是长按")
        that.$router.push("/admin")
      }, 3000);
    },
    move(e) {
      clearTimeout(this.timeOutEvent);
      this.timeOutEvent = 0;
      e.preventDefault();
      console.log("这是滑动")
    },
    end() {
      clearTimeout(this.timeOutEvent);
      if (this.timeOutEvent != 0 && this.longClick == 0) {
        //点击
        //此处为点击事件----在此处添加跳转详情页
        console.log("这是点击");
      }
      return false;
    }
  }
};
</script>
<style scoped>
.about{
    position: absolute;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  z-index: -100;
  overflow: hidden;
}
p{
    position: relative;
    top: 266px;
    left: 601px;

    width: 59px;
    height: 59px;
    margin: 0;
    /* background: red; */
    border-radius: 50%;

}
</style>
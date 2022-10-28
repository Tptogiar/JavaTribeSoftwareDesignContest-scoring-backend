<template>
  <div>
    <span class="c1 circle red"></span>
    <span class="c2 circle purple"></span>
    <span class="c3 circle yellow"></span>
    <span class="c4 circle yellow"></span>
    <span class="c5 circle purple"></span>
    <span class="c6 circle"></span>
  </div>
</template>

<script>
export default {
  name: "BackgroundCom",
};
</script>

<style lang="scss" scoped>
body {
  margin: 0;
  padding: 0;
}
div {
  position: absolute;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: #fff;
  z-index: -100;
  overflow: hidden;
}
.circle {
  position: absolute;
  display: inline-block;
  border-radius: 50%;
}
.red {
  background: rgba(245, 47, 87, 1);
  opacity: 0.9;
}
.purple {
  background: rgba(115, 83, 185, 1);
  opacity: 0.9;
}
.yellow {
  background: rgba(253, 227, 63, 1);
}
.c1 {
  top: -90px;
  left: -90px;
  width: 300px;
  height: 300px;
}
.c2 {
  top: 73px;
  left: 149px;
  width: 111px;
  height: 111px;
}
.c3 {
  top: 266px;
  left: 601px;
  width: 59px;
  height: 59px;
}
.c4 {
  left: 38px;
  top: 1155px;
  width: 112px;
  height: 112px;
}
.c5 {
  left: 290px;
  top: 931px;
  width: 44px;
  height: 44px;
}
.c6 {
  right: 79px;
  top: 1062px;
  width: 80px;
  height: 80px;
  border: 10px solid rgba(245, 47, 87, 1);
}
span.c3.circle.yellow::before {
  content: "";
  display: block;
  width: 40px;
  height: 40px;
  background: #fff;
  border-radius: 50%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>

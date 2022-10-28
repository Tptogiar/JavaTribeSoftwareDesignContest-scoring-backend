<template>
  <li class="t-row">
    <span  :class="[hasR4 ? 'r1' : 'r1Short']">{{ r1 }}</span>
    <span class="r2">{{ r2 }}</span>
    <span class="r3">{{ r3 }}</span>
    <span v-if="hasR4" class="r4">{{ r4 }}</span>
  </li>
</template>

<script>
export default {
  name: "TitleRow",
  props: {
    r1: {
      type: String,
    },
    r2: {
      type: String,
    },
    r3: {
      type: String,
    },
    r4: {
      type: String,
      default: "",
    },
  },
  computed: {
    hasR4() {
      return this.r4 != "";
    },
  }
};
</script>

<style lang="scss" scoped>
.t-row {
  display: flex;
  flex-wrap: nowrap;
  justify-content: space-between;
  width: 690px;
  margin: 0 auto 15px;
  padding: 0 48px 0 52px;
  box-sizing: border-box;
  font-size: 30px;
  font-family: Adobe Heiti Std;
  font-weight: bold;
  letter-spacing: 5px;
  color: rgba(47, 25, 95, 1);
}
.r1,
.r2 {
  display: inline-block;
  width: 170px;
  text-align: left;
}
.r1Short {
  width: 120px;
  display: inline-block;
  text-align: left;
}
.r3,
.r4 {
  display: inline-block;
  text-align: center;
  width: 84px;
}
</style>
<template>
  <DropDownRefresh :onRefresh="this.getTeamInfo">
    <div>
      <transition name="fade">
        <loading v-if="isLoading"></loading>
      </transition>
    </div>
    <div class="admin">
      <Title text="良哥专属主页" @click.native="refresh"></Title>
      <TitleRow r1="ID" r2="队伍名称" r3="操作"></TitleRow>

      <!-- <div>{{judgeId}}</div> -->
      <UpdateStatusRow
        v-for="item in teams"
        :key="item.id"
        :judgeId="judgeId"
        :teamName="item.teamName"
        :teamId="item.id"
        :teamStatus="item.teamStatus"
        :canMark="item.canMark"
      ></UpdateStatusRow>
    </div>
  </DropDownRefresh>
</template>

<script>
import Title from "@/components/Title.vue";
import TitleRow from "@/components/TitleRow.vue";
import UpdateStatusRow from "@/components/UpdateStatusRow.vue";
import DropDownRefresh from "@/components/DropDownRefresh.vue";
import Loading from "@/components/Loading.vue";
import timeLocalStorage from "time-localstorage";

export default {
  data() {
    return {
      teams: [],
      // judgeId:this.parse(window.localStorage.getItem("judgeID")),//引入timelocalstorage设置过期时间
      judgeId: this.parse(timeLocalStorage.get("judgeID")),
      isLoading: true,
    };
  },
  components: {
    Title,
    TitleRow,
    UpdateStatusRow,
    DropDownRefresh,
    Loading,
  },
  methods: {
    parse(val) {
      // val= JSON.parse(val)
      // val=val.value
      return parseInt(val) || 0;
    },
    parseFloat(val) {
      return parseFloat(val) || 0;
    },
    getTeamInfo() {
      let vue = this;
      this.axios.get("/judge/getAllTeams").then(function (res) {
        if (res.status === 200 && res.data instanceof Array) {
          vue.teams = res.data;
        } else {
          vue.$notify({ message: "登录过期！", type: "danger" });
          localStorage.clear();
          vue.$router.replace("/login");
        }
        vue.isLoading = false;
      });
    },
    // 更新数据
    refresh: function () {
      this.axios.get("/result/update").then((res) => {
        if (res.status == 200) {
          this.$notify({ message: "更新总排名成功！", type: "success" });
        }
      });
    },
  },
  mounted() {
    this.getTeamInfo();
  },
};
</script>

<style lang="scss">
.admin {
  margin-top: 67px;
}
.admin .title {
  margin-bottom: 52px;
  cursor: pointer;
}
.admin span.r1 {
  display: inline-block;
  // width: 343px;
  text-align: left;
}
.admin span.r2 {
  text-align: left;
}
.admin span.r3 {
  text-align: left;

  display: inline-block;
  // width: 80px;
}
.van-dialog {
  height: auto !important;
}
</style>

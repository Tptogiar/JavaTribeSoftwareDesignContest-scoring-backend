<template>
  <DropDownRefresh :onRefresh="this.getTeamInfo">
    <div>
      <transition name="fade">
        <loading v-if="isLoading"></loading>
      </transition>
    </div>
    <van-notice-bar style="font-size:.3rem" text="满分：100分，系统评分规则：去除最高分和最低分取平均值。" />
    <div class="scoring">
      <Title text="评分" @click.native="logout"></Title>
      <TitleRow class="titleRow" r1="队伍名" r2 ="项目名" r3="分数"  r4="操作"></TitleRow>
      <!-- <div>{{judgeId}}</div> -->
      <ScoringRow
        v-for="item in noScoreTeam"
        :key="item.id"
        :judgeId="judgeId"
        :teamName="item.teamName"
        :projectName="item.projectName"
        :teamId="item.id"
        :teamStatus="item.teamStatus"
        :canMark="item.canMark"
        :value="parse(0)"
      ></ScoringRow>
      <ScoringRow
        v-for="item in hasScoreTeam"
        :key="item.teamName"
        class="isJudge"
        :judgeId="judgeId"
        :teamName="item.teamName"
        :projectName="item.projectName"
        :teamStatus="item.teamStatus"
        :teamId="item.teamId"
        :value="parseFloat(item.mark)"
      ></ScoringRow>
    </div>
  </DropDownRefresh>
</template>

<script>
import Title from "@/components/Title.vue";
import TitleRow from "@/components/TitleRow.vue";
import ScoringRow from "@/components/ScoringRow.vue";
import DropDownRefresh from "@/components/DropDownRefresh.vue";
import Loading from "@/components/Loading.vue";
import timeLocalStorage from "time-localstorage";
import Vue from 'vue';
import { NoticeBar } from 'vant';

Vue.use(NoticeBar);
export default {
  data() {
    return {
      hasScoreTeam: [],
      noScoreTeam: [],
      // judgeId:this.parse(window.localStorage.getItem("judgeID")),//引入timelocalstorage设置过期时间
      judgeId: this.parse(timeLocalStorage.get("judgeID")),
      isLoading: true,
    };
  },
  components: {
    Title,
    TitleRow,
    ScoringRow,
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
      // 两组都没有数组时，是身份验证出现了错误了，应该跳转到登录页
      const hasScore = new Promise((resolve, reject) => {
        this.axios
          .post("/judge/getHasScoreTeam", {
            id: this.judgeId,
          })
          .then((res) => {
            if (res.status == 200 &&  (res.data instanceof Array)) {
              resolve(res.data);
            } else {
              reject(res.data);
            }
          });
      });
      const noScore = new Promise((resolve, reject) => {
        this.axios
          .post("/judge/getNoScoreTeam", {
            id: this.judgeId,
          })
          .then((res) => {
            if (res.status == 200 && (res.data instanceof Array)) {
              resolve(res.data);
            } else {
              reject(res.data);
            }
          });
      });

     
      Promise.all([hasScore, noScore])
        .then(([r1, r2])=> {
          this.hasScoreTeam = r1;
          this.noScoreTeam  = r2;
        },err => {
          this.$notify({ message: "登录过期！", type: "danger" });
           localStorage.clear();
          this.$router.replace("/login")
          console.log(err);
        })
        .catch((e) => {
          console.log(e);
        })
        .finally(() => {
          this.isLoading = false;
        });
    },
    logout() {
      if (timeLocalStorage.get("token")) {
        this.$dialog
          .confirm({
            message: "确定要退出登录吗? \n此操作不可逆，是否继续?",
            title: "注意！",
          })
          .then(() => {
            localStorage.clear();
            this.$router.push("/login");
          })
          .catch(() => {});
      } else {
        this.$notify({ message:"登录超时！", type:"danger"})
        this.$router.push("/login");
      }
    },
  },
  mounted() {
   
    this.getTeamInfo();
  },
};
</script>

<style lang="scss">
.scoring {
  margin-top: 67px;
}
.scoring .title {
  margin-bottom: 52px;
  cursor: pointer;
}

.van-dialog {
  height: auto !important;
}
</style>

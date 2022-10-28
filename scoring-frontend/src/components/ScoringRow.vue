<template>
  <li class="s-row">
    <span v-show="teamStatus == 0" class="play"
      ><img alt="playing" class="playing" src="https://scoring-static-javatribe.oss-accelerate.aliyuncs.com/static/playing-3.gif"
    /></span>
    <span class="s-teamName">{{ teamName }}</span>
    <span class="s-projectName">{{projectName}}</span>
    <div class="s-scoring">
      <!-- 有值 -->
      <input
        v-if="value"
        :disabled="ifChange"
        type="number"
        class="score-input"
        v-model="score"
      />
      <!-- 无值 -->
      <input v-else type="number" class="score-input" v-model="score" />
    </div>
    <div class="s-confirm">
      <van-button
        class="option btn"
        v-if="value"
        size="normal"
        hairline
        plain
        @click="changeBtn"
        :text="change"
      ></van-button>
      <van-button
        class="option btn"
        v-else
        :disabled="disable"
        size="normal"
        hairline
        plain
        @click="subimtScore"
        >确认</van-button
      >
    </div>
  </li>
</template>

<script>
export default {
  name: "ScoringRow",
  props: {
    judgeId: {
      type: Number,
    },
    teamId: {
      required: false,
      type: Number,
    },
    teamName: {
      required: true,
    },
    projectName: {
      required: true
    },
    teamStatus: {
      // required: true,
      type: Number,
    },
    value: {
      type: Number,
      default: 0,
    },
    canMark: {
      type: Number,
      default: 1,
    },
  },
  data: function () {
    return {
      score: 0,
      // newScore:0
      ifChange: true,
      change: "修改",
    };
  },
  computed: {
    disable() {
      return !(this.score > 0 && this.score <= 100);
    },
    waitMark() {
      return this.value == 0 && this.canMark == 0 && this.teamStatus != 0;
    },
  },
  methods: {
    subimtScore: function () {
      if (!(this.score > 0 && this.score <= 100)) {
        this.$notify({ message: "分数必须大于0！", type: "warning" });
        return;
      }
      var vue = this;
      this.$dialog
        .confirm({
          message: `给队伍"${this.teamName}"评分为 ${this.score} \n此操作可逆，是否继续?`,
          title: "注意！",
        })
        .then(() => {
          // vue.submitScorePost();
          vue.throttle(vue.submitScorePost, 3000)();
        })
        .catch(() => {});
    },
    changeBtn: function () {
      if (this.ifChange !== false) {
        this.ifChange = !this.ifChange;
        this.change = "提交";
        //   console.log(this.ifChange)
      } else {
        //   一秒只发一次
        // this.changeScore();
        this.throttle(this.changeScore, 3000)();
      }
    },
    changeScore: function () {
      if (!(this.score > 0 && this.score <= 100)) {
        this.$notify({ message: "分数必须大于0！", type: "warning" });
        return;
      }
      var vue = this;
      this.$dialog
        .confirm({
          message: `是否要将队伍"${this.teamName}"的分数修改为 ${this.score} \n此操作可逆，是否继续?`,
          title: "注意！",
        })
        .then(() => {
          vue.throttle(vue.updateScore, 3000)();
        })
        .catch(() => {});
    },
    // 节流函数
    throttle: function (fn, gapTime) {
      let _lastTime = null;

      return function () {
        let _nowTime = +new Date();
        if (_nowTime - _lastTime > gapTime || !_lastTime) {
          fn();
          _lastTime = _nowTime;
        }
      };
    },
    // 提交更新分数请求
    updateScore: function () {
      var vue = this;
      this.axios({
        url: "/judge/updateScore",
        method: "post",
        data: {
          judgeId: vue.judgeId,
          teamId: vue.teamId,
          marks: vue.score,
        },
      }).then(function (res) {
        console.log(res);
        if (res.status === 200 && res.data.code == 200) {
          vue.$notify({ message: "修改成功！", type: "success" });
          // vue.$router.go(0); // 不兼容 ios 系统
          vue.$router.go(0);
          location.reload(); // js原生
        } else {
          vue.$notify({ message: "该队伍暂时禁止修改评分！", type: "danger" });
        }
      });
    },
    submitScorePost: function () {
      var vue = this;
      this.axios({
        url: "/judge/insertScore",
        method: "post",
        data: {
          judgeId: vue.judgeId,
          teamId: vue.teamId,
          marks: vue.score,
        },
      }).then(function (res) {
        if (res.status === 200 && res.data.code == 200) {
          vue.$notify({ message: "评分成功！", type: "success" });
          // console.log("reload");
          vue.$router.go(0);
          location.reload(); // js原生
        } else {
          vue.$notify({
            message: "该队伍还没上场展示，暂时不能评分！",
            type: "danger",
          });
        }
      });
    },
  },
  watch: {
    score: function (newValue) {
      const num = Number.parseFloat(newValue);
      if (num > 100) {
        this.score = 100;
      } else if (num < 0) {
        this.score = 0;
      } else {
        this.score = num;
      }
    },
  },
  created() {
    this.score = this.value;
  },
};
</script>

<style lang="scss" scoped>
.s-row {
  position: relative;
  display: flex;
  flex-wrap: nowrap;
  justify-content: space-between;
  align-items: center;
  width: 690px;
  height: 125px;
  margin: 0 auto 30px;
  padding: 0 48px 0 52px;
  background: rgba(240, 240, 240, 0.9);
  border-radius: 56px;
  box-sizing: border-box;
}
span.play {
  position: absolute;
  left: 15px;
  top: 50%;
  transform: translate(0, -50%);
}
img.playing {
  width: 32px;
  height: 32px;
  overflow: hidden;
  transform: scale(2.2);
  margin: 0;
}
.s-name {
  width: 343px;
  position: relative;
  text-align: left;
}

.s-name .info{
  position: absolute;
  top:50%;
  transform: (0,-50%);
}

.wait-tag {
  position: absolute;
  right: 0;
  top: 50%;
  transform: translate(0, -50%);
}
.score-input {
  display: inline-block;
  width: 84px;
  height: 43px;
  border-radius: 6px;
  border: 0;
  outline: 0;
  text-align: center;
  background: rgba(255, 255, 255, 0.4);
}
.s-teamName,
.s-projectName{
  width:170px;
  text-align: left;
  overflow: hidden;
   text-overflow:ellipsis;
}
.s-teamName,
.s-projectName,
.score-input {
  font-size: 24px;
  font-family: Adobe Heiti Std;
  font-weight: bold;
  color: rgba(47, 25, 95, 1);
}
.isJudge {
  background-color: rgba(47, 25, 95, 1);
  .s-teamName,
  .s-projectName,
  .score-input {
    color: rgba(255, 255, 255, 1);
  }
  .score-input:disabled {
    background: rgba(47, 25, 95, 1);
  }
}

.s-name .team{
  font-size:16px;
  font-weight: normal;
}
.option {
  width: 80px;
  font-size: 24px;
  font-family: Adobe Heiti Std;
  font-weight: bold;
  color: rgba(255, 255, 255, 1);
  line-height: 80px;
}
.option.btn {
  width: 84px;
  height: 43px;
  background: rgba(47, 25, 95, 1);
  border-radius: 22px;
}
.option:disabled {
  background: rgba(47, 25, 95, 0.3);
}
.van-dialog {
  height: auto !important;
}
</style>

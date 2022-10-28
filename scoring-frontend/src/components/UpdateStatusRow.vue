<template>
  <li class="s-row">
    <span class="r-rank">{{ teamId }}</span>
    <span class="s-teamName">{{ teamName }}</span>
    <div class="s-canMark">
      <el-switch
        v-model="markStatus"
        active-text="可评"
        inactive-text="禁评"
        active-color="#13ce66"
        inactive-color="#ff4949"
        @change="updateMark"
      >
      </el-switch>
    </div>
    <div class="s-update">
      <el-switch
        v-model="speaking"
        active-text="上场"
        inactive-text="下场"
        active-color="#13ce66"
        inactive-color="#ff4949"
        @change="update"
      >
      </el-switch>
    </div>
  </li>
</template>

<script>
export default {
  name: "UpdateStatusRow",
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
    teamStatus: {
      required: true,
      type: Number,
    },
    canMark: {
      type: Number,
      require:true
    }
  },
  data: function () {
    return {
      ifChange: true,
      change: "修改",
      speaking: false,
      markStatus:false,
      newStatus: 0,
      newMarkStatus:0,
    };
  },
  methods: {
    update: function () {
      // 打开开关后，状态变为true
      if (this.speaking === true) {
        // 上场
        this.newStatus = 0;
      } else {
        // 下场
        this.newStatus = 1;
      }
      let vue = this;
      vue
        .axios({
          url: "/judge/updateStatus",
          method: "post",
          data: {
            id: vue.teamId,
            teamStatus: vue.newStatus,
          },
        })
        .then(function (res) {
          console.log(res);
          if (res.status === 200 && res.data.code == 200) {
            vue.$notify({ message: "修改成功！", type: "success" });
          } else {
            vue.$notify({ message: "修改失败", type: "danger" });
          }
        });
    },
    updateMark: function () {
      // 打开开关后，状态变为true
      if (this.markStatus === true) {
        // 可评
        this.newMarkStatus = 0;
      } else {
        // 禁评
        this.newMarkStatus = 1;
      }
      let vue = this;
      vue
        .axios({
          url: "/judge/updateCanMark",
          method: "post",
          data: {
            id: vue.teamId,
            canMark: vue.newMarkStatus,
          },
        })
        .then(function (res) {
          console.log(res);
          if (res.status === 200 && res.data.code == 200) {
            vue.$notify({ message: "修改成功！", type: "success" });
          } else {
            vue.$notify({ message: "修改失败", type: "danger" });
          }
        });
    },
  },
  
  created() {
    // 0：上场
    // 1：下场/候场
    if (this.teamStatus === 0) {
      this.speaking = true;
    } else {
      this.speaking = false;
    }

    // 0 可评分
    // 1 禁评分
    if(this.canMark === 0){
      this.markStatus = true;
    }else{
      this.markStatus = false;
    }
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
  height: 114px;
  margin: 0 auto 30px;
  padding: 0 48px 0 52px;
  background: rgba(240, 240, 240, 0.9);
  border-radius: 56px;
  box-sizing: border-box;
}

.s-teamName {
  width: 200px;
  text-align: left;
}

.s-teamName,
.score-input {
  font-size: 24px;
  font-family: Adobe Heiti Std;
  font-weight: bold;
  color: rgba(47, 25, 95, 1);
  // line-height:80px;
}


.van-dialog {
  height: auto !important;
}
</style>

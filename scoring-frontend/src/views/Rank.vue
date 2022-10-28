<template>

<DropDownRefresh :onRefresh="this.getInfo">
  <div>
    <transition name="fade">
      <loading v-if="isLoading"></loading>
    </transition>
  </div>
  <div class="rank">
    <Title text="排行榜"></Title>
    <TitleRow r1="排名" r2="队伍名称" r3="评分"></TitleRow>
    <RankRow
      v-for="(item, index) in teamInfo"
      :key="index"
      :class="addColor(index + 1)"
      :rank="index + 1"
      :name="item.teamName"
      :score="item.mark"
    ></RankRow>
  <div class="tip" v-show="isblank">
    评委还未进行评分,请耐心等待...
  </div>
    <img alt="Rank" src="https://scoring-static-javatribe.oss-accelerate.aliyuncs.com/static/rank.png" />
  </div>
</DropDownRefresh>  
</template>

<script>
import Title from "@/components/Title.vue";
import TitleRow from "@/components/TitleRow.vue";
import RankRow from "@/components/RankRow.vue";
import axios from "axios";
import DropDownRefresh from "@/components/DropDownRefresh.vue"
import Loading from '@/components/Loading.vue'

export default {
  data() {
    return {
      teamInfo: [],
      isblank:false,
      isLoading: true
    };
  },
  components: {
    Title,
    TitleRow,
    RankRow,
    DropDownRefresh,
    Loading
  },
  methods: {
    /**添加不同类名 */
    addColor(index) {
      if (index < 7) return "rank-" + index;
      else return "rank-0";
    },
    /**获取队伍信息 */
    getInfo() {
      axios
        .post("/result/getResult")
        .then((res) => {
          this.teamInfo = res.data
          if(this.teamInfo.length===0) this.isblank=true
          this.isLoading = false
        })
        .catch((err) => {
          this.$notify({ message: err, type: 'danger' })

        });
    }
    
  },
  mounted() {
    this.getInfo();   
    this.$bus.$on("updateScore", () => {
      this.getInfo();
    })
  }
};
</script>

<style scope>
.rank {
  margin-top: 67px;
}
.rank .title {
  margin-bottom: 52px;
}
.tip{
    height: 660px;
    text-align: center;
    line-height: 320px;
}
img {
  width: 653px;
  height: 333px;
  margin-bottom: 29px;
}
</style>

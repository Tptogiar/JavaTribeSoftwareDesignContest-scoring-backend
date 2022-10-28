<template>
  <div class="home">
    <BackgroundCom/>
    <transition name="slide-fade">
      <div v-if="show" key='box' class='box'>
        <Title text='软件设计大赛评分系统'></title>
        <Button routerLink url="/rank" text='我是游客'></Button>
        <Button routerLink url="/judge" text='我是评委'></Button>
      </div>
    </transition>
  </div>
</template>

<script>
// @ is an alias to /src
import BackgroundCom from '@/components/BackgroundCom.vue'
import Title from '@/components/Title.vue'
import Button from '@/components/Button.vue'


export default {
  data(){
    return{
      show:false
    }
  },
  components: {
    BackgroundCom,
    Title,
    Button
  },
  methods: {
    
  },
  mounted(){
    this.show=true

  }
  
}
  
</script>

<style>
@import "../css/style.css";
.box{
  margin-top: 385px;
}
.van-dialog{
  width: 500px;
  height: 270px;
}
.van-dialog__header{
  font-size: 32px;
  font-weight: 800;
  line-height: 38px;
  margin-top: 5px;
}
.van-dialog__message {
  margin: 17px 0;
  font-size:24px;
  line-height: 35px;
  letter-spacing: 1.5px;
}
.van-button {
  height: 65px;
  font-size: 23px;
  font-weight: 700;
}
</style>
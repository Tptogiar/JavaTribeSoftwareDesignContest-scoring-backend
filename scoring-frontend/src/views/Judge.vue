<template>
  <div class="judge">
    <BackgroundCom/>
    <SurpriseBtn/>
    <transition name="slide-fade">
      <div v-if="show" key='judge' class='box'>
        <Title text='软件设计大赛评分系统'></title>
        <Button routerLink url="/rank" text='查看排行'></Button>
        <Button routerLink url="/scoring" text='我来评分'></Button>
      </div>
    </transition>
  </div>
</template>

<script>
// @ is an alias to /src
import BackgroundCom from '@/components/BackgroundCom.vue'
import Title from '@/components/Title.vue'
import Button from '@/components/Button.vue'
import SurpriseBtn from '@/components/SurpriseBtn'

export default {
  data(){
    return{
      show:false
    }
  },
  components: {
    BackgroundCom,
    Title,
    Button,
    SurpriseBtn
  },
  methods: {
  
  },
  mounted(){
    this.show=true
  }
}
</script>

<style>
.box{
  margin-top: 385px;
}
.slide-fade-enter-active {
  transition: all .3s ease;
}
.slide-fade-leave-active {
  transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);
}
.slide-fade-enter, .slide-fade-leave-to {
  transform: translateX(200px);
  opacity: 0;
}
</style>
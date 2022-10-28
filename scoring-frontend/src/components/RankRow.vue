<template>
    <li class='r-row'>
        <span class="r-rank">{{rank}}</span>
        <span class="r-name">{{name}}</span>
        <span class="r-score">{{score | toDecimal2}}</span>

    </li>
</template>

<script>
export default {
    name: "RankRow",
    props:["rank","name","score"],
    filters:{
        // 分数保留小数点后两位
        toDecimal2(x) {  
            let f = parseFloat(x);  
            if (isNaN(f)) {  
                return false;  
            }  
            f = Math.round(x*100)/100;  
            let s = f.toString();  
            let rs = s.indexOf('.');  
            if (rs < 0) {  
                rs = s.length;  
                s += '.';  
            }  
            while (s.length <= rs + 2) {  
                s += '0';  
            }  
            return s;  
        }
    }
    
    
}
</script>

<style lang="scss" scope>
.r-row {
    display: flex;
    flex-wrap: nowrap;
    justify-content: space-between;
    align-items:center;
    width:690px;
    height:114px;  
    margin: 0 auto 30px;
    padding:0 48px 0 52px;
    border-radius:56px;
    box-sizing: border-box;
}
.r-rank{
    width:64px;
    text-align: center;
    font-size:72px;
    font-family:Adobe Heiti Std;
    font-weight:bold;
    line-height:80px;
}
.r-name{
  width:170px;
  text-align: center;
}
.r-score{
  width:84px;
}
.r-name,
.r-score{
    font-size:24px;
    font-family:Adobe Heiti Std;
    font-weight:bold;
    color:rgba(47,25,95,1);
    line-height:80px;
}
.r-score{
    width: 66px;
}
.rank-1{
    background:rgba(255,133,133,0.07);
    .r-rank{
    color:rgba(255,133,133,1);
    }
}
.rank-2{
    background:rgba(255,198,117,0.1);
    .r-rank{
        color:rgba(255,198,117,1);
    }
}
.rank-3{
    background:rgba(254,228,64,0.1);
    .r-rank{
    color:rgba(254,228,64,1);
    }
}
.rank-4{
    background:rgba(86,216,147,0.1);
    .r-rank{
    color:rgba(86,216,147,1);
    }
}
.rank-5{
    background:rgba(123,209,208,0.1);
    .r-rank{
    color:rgba(123,209,208,1);
    }
}
.rank-6{
    background:rgba(128,169,201,0.1);
    .r-rank{
    color:rgba(126,180,221,1);
    }
}
.rank-0{
    background:rgba(129,100,193,0.1);
    .r-rank{
    color:rgba(129,100,193,1);
    }
}

</style>
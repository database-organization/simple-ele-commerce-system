<template>
  <div class="fgo-new-servant container clearfix">
    <!-- 英灵介绍 -->
    <div class="fgo-servant-hd">
      <h2 class="fl">新增从者
        <span>灵基再临</span>
      </h2>
      <a href="" class="fr">查看全部 </a>
    </div>
    <!-- 英灵列表 -->
    <ul class="fgo-servant-list ">
      <li v-for='index of 5' :key="index">
        <a href="">
          <div class="mask"></div>
          <div class="box">
            <img src="../assets/logo.png" alt="">
          </div>
          <i class="iconfont icon-favorites-fill"></i>
          <h3>伊什塔尔(Rider)</h3>
          <p>イシュタル</p>
        </a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "ShoppingExhibition",
}
</script>

<style scoped>

.fgo-new-servant{
  height: 914px;
  background-color: #f5f5f5;
}

.fgo-new-servant .fgo-servant-hd{
  height: 115px;
  /* background-color: rosybrown; */
  line-height: 115px;
}

.fgo-new-servant .fgo-servant-hd h2{
  height: 115px;
  font-size: 29px;
  font-weight: 600;
}

.fgo-new-servant .fgo-servant-hd h2 span{
  font-size: 20px;
  color: #999;
  padding-left: 5px;
}


.fgo-new-servant .fgo-servant-hd a{
  color: #999;
  /* padding-right: 8px; */
}

.fgo-new-servant .fgo-servant-hd a::after{
  /* right: 10px; */
  content: '';
  display: inline-block;
  width: 7px;
  height: 13px;
  padding-left: 20px;
  /* border-left: 10px; */
  /*background: url(../images/sprites.png) 0px -110px;*/
  vertical-align: middle;
}

/* .fgo-new-servant .fgo-servant-list{
    height: 799px;
    background-color: sandybrown;
} */

/* .fgo-new-servant .fgo-servant-list{
    position: relative;
} */


.fgo-new-servant .fgo-servant-list li{
  float: left;
  /* position: absolute; */
  position: relative;
  width: 215.8px;
  height: 390px;
  margin-right: 9px;
  margin-bottom: 9px;
  background-color: rgb(224, 236, 238);
  /* background-color: silver; */
  text-align: center;
  box-shadow: 2px 3px 6px 3px #999;
  overflow: hidden;
  transition: all .5s;
  /* border: 10px solid #000; */
}


.fgo-new-servant .fgo-servant-list li:nth-child(6n){
  margin-right: 0px;
}

.fgo-new-servant .fgo-servant-list li i{
  position: absolute;
  /* width: 10px; */
  left: 185px;
  top: -3px;
  /* scale: 5; */
  font-size: 25px;
  color: rgba(255, 10, 10, 0.8);
}

/* .fgo-new-servant .fgo-servant-list li:nth-child(n+6){
    margin-bottom: 0px;
} */

.fgo-new-servant .fgo-servant-list li .mask{
  z-index: 1;
  position: absolute;
  width: 215.8px;
  height: 390px;
  top:0;
  left: 0;
  opacity: 0;
  transition: all 0.3s;
  background-image: linear-gradient(
      transparent,
      rgba(0,0,0,.45)
  )
}

.fgo-new-servant .fgo-servant-list li:hover{
  transform: scale(1.05);
  /* box-shadow: 4px 6px 8px 6px #999; */
}

.fgo-new-servant .fgo-servant-list li:hover .mask{
  opacity: 1;
}

.fgo-new-servant .fgo-servant-list li:hover h3{
  position: absolute;
  bottom: 35px;
  font-size: 20px;
  font-weight: bold;
  color:white;
  z-index: 2;
  text-align: center;
  /* border: 1px solid #000; */
  width: 100%;
}



.fgo-new-servant .fgo-servant-list img{
  transition: all 0.5s;
  width: 100%;
}

/* .fgo-new-servant .fgo-servant-list .box{
    overflow: hidden;
} */


.fgo-new-servant .fgo-servant-list li:hover img{
  margin-top: 41px;
  transform: scale(1.268);

}

/* .fgo-new-servant .fgo-servant-list li:hover  */


.fgo-new-servant .fgo-servant-list li h3{
  height: 26px;
  margin-top: 16px;
  font-size: 16px;
  font-weight: 400;
  transition: position 0.4s;
}

.fgo-new-servant .fgo-servant-list li p{
  font-size: 14px;
}
</style>
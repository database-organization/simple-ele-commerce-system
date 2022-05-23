<template>
  <el-header>
  <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
    <el-menu-item index="1">为您推荐</el-menu-item>
<!--    <el-submenu index="2">
      <template slot="title">我的工作台</template>
      <el-menu-item index="2-1">选项1</el-menu-item>
      <el-menu-item index="2-2">选项2</el-menu-item>
      <el-menu-item index="2-3">选项3</el-menu-item>
      <el-submenu index="2-4">
        <template slot="title">选项4</template>
        <el-menu-item index="2-4-1">选项1</el-menu-item>
        <el-menu-item index="2-4-2">选项2</el-menu-item>
        <el-menu-item index="2-4-3">选项3</el-menu-item>
      </el-submenu>
    </el-submenu>-->
    <el-menu-item index="2" @click="$store.state.drawer = true">购物车</el-menu-item>
    <el-menu-item index="3">订单管理</el-menu-item>
    <el-menu-item index="4">登陆 | 注册</el-menu-item>
    <ShoppingBody/>
<!--    侧边弹窗-->

  </el-menu>
  </el-header>
</template>

<script>
import ShoppingBody from "@/components/ShoppingBody";
export default {
  name: "ShoppingHeader",
  components:{
    ShoppingBody,
  },
  data() {
    return {
      drawer: false,
      activeIndex: '1',
      activeIndex2: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>

</style>
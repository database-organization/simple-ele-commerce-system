<template>
    <div id="app">
        <img alt="Vue logo" src="./assets/logo.png" />
        <router-link active-class="active" to="/about">About</router-link>
        <router-view></router-view>
        <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";

export default {
    name: "App",
    components: {
        HelloWorld,
    },
    methods:{
        haha(){

        }
    }
};
</script>  

<style lang="less">
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>

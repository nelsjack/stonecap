<template>
  <div id="app">
    <nav-bar></nav-bar>
    <router-view />
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue'
export default {
components: {
  NavBar
}
}
</script>

<style>
   body {
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
  }

  #app {
    width: 100%;
  }

  .nav {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    align-items: center;
    height: 3em;
    background-color: #0A6496;
  }
  .page-title {
  display: inline-flex;
  margin-left: 10px;
  margin-right: 10px;
}  
.container {
    width: 75%;
    margin-top: 1em;
  }
</style>
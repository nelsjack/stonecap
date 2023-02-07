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
    margin: 0px;
    background-color: #F4F4F4;
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
</style>
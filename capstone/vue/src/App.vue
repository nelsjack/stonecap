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
  margin-left:16px;
  margin-right: 10px;
  align-content: center;
 
}  
.container {
    width: 75%;
    margin-top: 1em;
    align-content: center
  }
  .search-button{
     display: flex;
     align-content: center
  }
  .search-bar{
     display: flex;
  }
  .search-combo{
    display: flex;
    flex-direction: row;
    
    align-content: center;
    margin-left:16px;
    margin-right:16px;
   
  }
  .break {
  flex-basis: 100%;
  height: 0.5em;
}
</style>
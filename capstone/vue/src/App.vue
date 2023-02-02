<template>
  <div id="app">
    <!-- <div class="nav">
            <router-link v-bind:to="{ name: 'home' }">
          <h3>Home</h3>
      </router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">
        <h3>Logout</h3>
      </router-link>
    </div> -->
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
<template>
  <div class="home">
    <h1>Welcome to Board Game Capstone!</h1>
    <router-link v-bind:to="{ name: 'login'}"> 
      <button>Login</button>
    </router-link>
    <router-link v-bind:to="{ name: 'register'}">
      <button>Register</button>
    </router-link>
    <trending-games></trending-games>
  </div>
</template>

<script>
import TrendingGames from '../components/TrendingGames.vue'
export default {
  name: "home",
  components:{
    TrendingGames
  }
};
</script>

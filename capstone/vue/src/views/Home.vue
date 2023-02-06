<template>
  <div class="home">
    <h1>Welcome to Stone Cap!</h1>
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

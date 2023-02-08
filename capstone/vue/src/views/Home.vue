<template>
  <div class="home">
    <h4 class="home-heading display-5">Discover newly released tabletop games <br>Explore other users' collections<br>Track your own!</h4>
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

<style>
  .home-heading {
    text-align: center;
    color: rgb(124, 124, 124);
    font-size: 2em !important;
  }
</style>

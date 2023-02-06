<template>
  <div class="wishlist-game-card">
      <b-card class="game-card" :id='`${game.id}`' v-for="game in games" v-bind:key="game.id">
      <img class="game-thumbnail"  :src="game.thumb_url" />
      <h3 class="game-title">{{ game.handle }}</h3>
      <p class="game-description">{{ game.description }}</p>
      <p class="game-price">${{ game.price }}</p>
    </b-card>
  </div>
</template>

<script>
export default {
    name: 'wishlist-game-card',
    props: ['games']
};
</script>

<style>
    .wishlist-game-card {
       width: 75%;
       margin-top: 1em; 
    }

    .game-description {
      font-size: 80%;
      margin-left: 10px;
    }

    .game-price {
      margin-left: 10px;
      margin-right: 10px;
    }

    .game-thumbnail {
      margin-left: 10px;
      margin-right: 10px; 
    }

    .game-title {
      margin-left: 10px;
      margin-right: 10px; 
    }
</style>
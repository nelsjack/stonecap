<template>
  <div class="wishlist-game-card">
      <div class="game-card" :id='`${game.id}`' v-for="game in games" v-bind:key="game.id">
      <img class="game-thumbnail"  :src="game.thumb_url" />
      <h3 class="game-title">{{ game.handle }}</h3>
      <p class="game-plays">N/A</p>
      <p class="game-description">{{ game.description }}</p>
      <p class="game-price">${{ game.price }}</p>
    </div>
  </div>
</template>

<script>
export default {
    name: 'wishlist-game-card',
    props: ['games']
};
</script>

<style>
</style>
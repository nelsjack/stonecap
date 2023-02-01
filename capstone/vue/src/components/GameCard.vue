<template>
  <div>
    <div class="game-card" v-for="game in games" v-bind:key="game.id" v-on:mouseover="displayCurrentUsers(game.id)">
      <img class="game-thumbnail" :src="game.thumb_url" />
      <h3 class="game-title">{{ game.handle }}</h3>
      <p class="game-description">{{ game.description }}</p>
    </div>
  </div>
</template>

<script>
import userService from '../services/UserService';

export default {
    name: 'game-card',
    props: ['games'],
    data() {
      return {
        hover: false
      }
    },
      methods: {
        displayCurrentUsers(boardGameId) {
          userService.getUsersByBoardGameId(boardGameId).then(response => {
            console.log(response.data);
          })
        }
      }
};
</script>

<style>
  .game-thumbnail {
    height: 5em;
    width: 5em;
    margin-left: 5px;
  }

  .trending-games-container {
    width: 75%;
    margin-top: 1em;
  }

  .game-card {
    display: flex;
    flex-direction: row;
    align-items: center;
    border: solid 1px;
    border-radius: 10px;
    margin-top: 10px;
    background-color: #FFFF;
  }

  .game-title {
    margin-left: 10px;
    margin-right: 10px;
  }

  .game-description {
    margin-right: 5px;
  }
</style>
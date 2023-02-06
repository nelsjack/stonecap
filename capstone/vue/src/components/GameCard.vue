<template>
  <div>
    <b-card class="game-card shadow" :id='`${game.id}`' v-for="game in games" v-bind:key="game.id" v-on:mouseover="displayCurrentUsers(game.id)">
      <img class="game-thumbnail"  :src="game.thumb_url" />
      <h3 class="game-title">{{ game.handle }}</h3>
      <p class="game-description">{{ game.description }}</p>
      <!-- Possibly make this its own CurrentPlayers component, add router link to span that directs to user profile page -->
      <b-popover class="popover" :target='`${game.id}`' triggers="hover" placement="right" title="Current Players">
        <div class="player-name" v-for="player in currentPlayers" v-bind:key="player" v-on:click="routeToUserProfile(player)">
          {{ player }}<br/> </div>
      </b-popover>

    </b-card>
  </div>
</template>

<script>
import userService from '../services/UserService';

export default {
    name: 'game-card',
    props: ['games'],
    data() {
      return {
        hover: false,
        currentPlayers: [],
      }
    },
      methods: {
        displayCurrentUsers(boardGameId) {
          userService.getUsersByBoardGameId(boardGameId).then(response => {
            this.currentPlayers = response.data;
          })
        },
        routeToUserProfile(user) {
          this.$router.push({name:'Profile', params: {username: user}})
          this.$router.go()
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
    font-size: 90%;
  }

  .game-title {
    margin-left: 10px;
    margin-right: 10px;
  }

  .game-description {
    margin-right: 5px;
  }

  .popover {
    margin-left: 10px;
  }

  .player-name {
    cursor: pointer;
  }
</style>
<template>
  <div>
    <b-card class="game-card shadow" :id='`${game.id}`' v-for="game in games" v-bind:key="game.id" v-on:mouseover="displayCurrentUsers(game.id)">
      <img class="game-thumbnail"  :src="game.thumb_url" />
      <h3 class="game-title">{{ game.handle }}</h3>
      <p class="game-description" v-html="game.description"></p>
      <game-card-buttons :gameId="game.id"/>
      <b-popover class="popover" :target='`${game.id}`' triggers="hover" placement="right" title="Current Players">
        <div class="player-name" v-for="player in currentPlayers" v-bind:key="player" v-on:click="routeToUserProfile(player)">
          {{ player }}<br/> </div>
      </b-popover>

    </b-card>
  </div>
</template>

<script>
import userService from '../services/UserService';
import boardGameService from '../services/BoardGameService';
import GameCardButtons from './GameCardButtons.vue';

export default {
    name: 'game-card',
    props: ['games'],
    components: { GameCardButtons },
    data() {
      return {
        hover: false,
        currentPlayers: [],
      }
    },
      methods: {
        displayCurrentUsers(boardGameId) {
          userService.getUsersByBoardGameId(boardGameId).then(response => {
            let responseArray = response.data;
            const result = responseArray.filter( function( item, index, inputArray ) {
              return inputArray.indexOf(item) == index;
          });
            this.currentPlayers = result;
          })
        },
        routeToUserProfile(user) {
          this.$router.push({name:'Profile', params: {username: user}})
          this.$router.go()
        },
        addGameToWishlist(boardGameId) {
          const boardGame= {
            user_id: this.$store.state.user.id,
            board_game_id: boardGameId, 
            save_type: "wishlist"
          }
          boardGameService.saveGameForUser(boardGame);
        },
        checkIfGameIsOnWishlist(boardGameId) {
          boardGameService.getWishlistBoardGamesByUsername(this.$store.state.user.username)
          .then(response => {
            response.data.forEach((element) => {
              if(element.board_game_id == boardGameId) {
                return true;
              }
            })
          })
        },
        checkIfGameIsOwned() {

        },
        checkIfGameIsPlayed() {

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
    align-items: flex-start;
    border: solid 1px;
    border-radius: 10px;
    margin-top: 10px;
    margin-bottom: 10px;
    background-color: rgb(187, 179, 179);
    font-size: 95%;
  }

  .game-title {
    margin-top: 15px;
    margin-left: 10px;
    margin-right: 10px;
  }

  .game-description {
    margin-top: 20px;
    margin-left: 5px;
    margin-right: 5px;
  }

  .popover {
    margin-left: 10px;
  }

  .player-name {
    cursor: pointer;
  }

  .game-card-button {
    margin: 5px;
    width: 10em;
  }

  .btn-primary {
    background-color: #0A6496 !important;
  }
</style>
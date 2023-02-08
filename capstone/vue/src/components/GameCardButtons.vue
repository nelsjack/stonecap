<template>
    <div class="game-card-button-container" >
        <b-button class="game-card-button" variant="primary" v-on:click="addGameToOwned(gameId)" v-bind:disabled="ownedDisabled" v-if="!isOwned">
          <b-icon icon="archive"></b-icon>
          Add to Owned
        </b-button>
        <b-button v-else class="disabled-game-card-button" variant="success" disabled>Owned<b-icon icon="check"/></b-button>
        <b-button class="game-card-button" variant="primary" v-on:click="addGameToPlayed(gameId)" v-bind:disabled="playedDisabled" v-if="!isPlayed">
          <b-icon icon="bookmark-check"></b-icon>
          Add to Played
        </b-button>
        <b-button v-else class="disabled-game-card-button" variant="success" disabled>Played<b-icon icon="check"/></b-button>
        <b-button class="game-card-button" variant="primary" v-on:click="addGameToWishlist(gameId)" v-bind:disabled="wishlistDisabled" v-if="!isOnWishlist">
          <b-icon icon="cart-plus"></b-icon>
          Add to Wishlist
        </b-button>
        <b-button v-else class="disabled-game-card-button" variant="success" disabled>On Wishlist<b-icon icon="check"/></b-button>
    </div>
</template>

<script>
import boardGameService from '../services/BoardGameService';

export default {
    name: "game-card-buttons",
    props: ['gameId'],
    data() {
        return {
            isOnWishlist: false,
            wishlistDisabled: false,
            isOwned: false,
            ownedDisabled: false,
            isPlayed: false,
            playedDisabled: false,
        }
    },
    created() {
        this.checkIfGameIsOnWishlist(this.gameId);
        this.checkIfGameIsPlayed(this.gameId);
        this.checkIfGameIsOwned(this.gameId);
    },
    methods: {
        addGameToWishlist(boardGameId) {
          const boardGame= {
            user_id: this.$store.state.user.id,
            board_game_id: boardGameId, 
            save_type: "wishlist"
          }
          boardGameService.saveGameForUser(boardGame);
          this.wishlistDisabled = true;
        },
        checkIfGameIsOnWishlist(boardGameId) {
          boardGameService.getWishlistBoardGamesByUsername(this.$store.state.user.username)
          .then(response => {
            response.data.forEach((element) => {
              if(element.board_game_id == boardGameId) {
                this.isOnWishlist = true;
              }
            })
          })
        },
        addGameToOwned(boardGameId) {
          const boardGame= {
            user_id: this.$store.state.user.id,
            board_game_id: boardGameId, 
            save_type: "owned"
          }
          boardGameService.saveGameForUser(boardGame);
          this.ownedDisabled = true;
        },
        checkIfGameIsOwned(boardGameId) {
          boardGameService.getOwnedBoardGamesByUsername(this.$store.state.user.username)
          .then(response => {
            response.data.forEach((element) => {
              if(element.board_game_id == boardGameId) {
                this.isOwned = true;
              }
            })
          })
        },
        addGameToPlayed(boardGameId) {
          const boardGame= {
            user_id: this.$store.state.user.id,
            board_game_id: boardGameId, 
            save_type: "played"
          }
          boardGameService.saveGameForUser(boardGame);
          this.playedDisabled = true;
        },
        checkIfGameIsPlayed(boardGameId) {
          boardGameService.getPlayedBoardGames(this.$store.state.user.username)
          .then(response => {
            response.data.forEach((element) => {
              if(element.board_game_id == boardGameId) {
                this.isPlayed = true;
              }
            })
          })
        },
    }
}
</script>

<style>
  .disabled-game-card-button {
    margin: 5px;
  }
</style>
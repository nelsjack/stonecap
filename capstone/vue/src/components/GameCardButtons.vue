<template>
    <div class="game-card-button-container" >
        <b-button class="game-card-button" variant="primary">
          <b-icon icon="archive"></b-icon>
          Add to Owned
        </b-button>
        <b-button class="game-card-button" variant="primary">
          <b-icon icon="bookmark-check"></b-icon>
          Add to Played
        </b-button>
        <b-button class="game-card-button" variant="primary" v-on:click="addGameToWishlist(gameId)" v-bind:disabled="wishlistDisabled" v-if="!isOnWishlist">
          <b-icon icon="cart-plus"></b-icon>
          Add to Wishlist
        </b-button>
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
            wishlistDisabled: false
        }
    },
    created() {
        this.checkIfGameIsOnWishlist(this.gameId);
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
        }
    }
}
</script>

<style>

</style>
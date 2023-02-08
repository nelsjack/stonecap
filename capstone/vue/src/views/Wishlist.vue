<template>
<div class="wishlist-container">
  <div class="wishlist">
    <h3>
      Your Wishlist
      <b-icon icon="book"></b-icon>
    </h3>
    <game-card :games="this.wishlistGames"/>
  </div>
</div>
</template>

<script>
import GameCard from "../components/GameCard.vue";
import boardGameService from "../services/BoardGameService";

export default {
  name: "Wishlist",
  components: { GameCard },
  data() {
    return {
      wishlistGames: [],
    };
  },
  created() {
      this.getWishlistBoardGames();
  },
  methods: {
    getWishlistBoardGames() {
      boardGameService.getWishlistBoardGamesByUsername(this.$route.params.username)
        .then((response) => {
          response.data.forEach((element) => {
            boardGameService.getBoardGamesById(element.board_game_id)
              .then((data) => {
                this.wishlistGames.push(data.data.games[0]);
              });
          });
        });
    },
  },
};
</script>

<style>
.wishlist {
  margin-top: 3em;
  width: 75%;
}

.wishlist-container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.headings {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  width: 100%;
  margin-top: 2em;
}
</style>
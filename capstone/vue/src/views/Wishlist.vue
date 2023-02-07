<template>
  <div class="wishlist">
    <h3>Your Wishlist</h3>
    <wishlist-game-card :games="this.wishlistGames" />
  </div>
</template>

<script>
import WishlistGameCard from "../components/WishlistGameCard.vue";
import boardGameService from "../services/BoardGameService";

export default {
  name: "Wishlist",
  components: { WishlistGameCard },
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
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 3em;
}

.headings {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  width: 100%;
  margin-top: 2em;
}
</style>
<template>
  <div class="user-home">
    <h2>Welcome, {{ this.$route.params.username }}!</h2>
    <div class="game-collection">
    <h1>Your Game Collection</h1>
      <game-card :games="this.playedGames" />
    </div>
  </div>
</template>

<script>
import boardGameService from "../services/BoardGameService";
import GameCard from "../components/GameCard.vue";

export default {
  components: { GameCard },
  data() {
    return {
      playedGames: [],
    };
  },
  created() {
    this.getPlayedBoardGames();
  },
  methods: {
    getPlayedBoardGames() {
      boardGameService
        .getPlayedBoardGames(this.$route.params.username)
        .then((response) => {
          const playedGamesArray = [];
          response.data.forEach((element) => {
            boardGameService
              .getBoardGamesById(element.board_game_id)
              .then((data) => {
                playedGamesArray.push(data.data.games[0]);
              });
          });
          this.playedGames = playedGamesArray;
        });
    },
  },
};
</script>

<style>
.user-home {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.game-collection {
  width: 75%;
  margin-top: 1em;
}
</style>
<template>
  <div class="game-history">
    <div class="game-collection">
      <h4>
          Your Game History
          <b-icon icon="clock-history"></b-icon>
      </h4>
      <game-card :games="this.playedGames"></game-card>
    </div>
  </div>
</template>

<script>
import GameCard from "../components/GameCard.vue";
import boardGameService from "../services/BoardGameService";

export default {
  name: "history",
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
          response.data.forEach((element) => {
            boardGameService
              .getBoardGamesById(element.board_game_id)
              .then((data) => {
                this.playedGames.push(data.data.games[0]);
              });
          });
        });
    },
  },
};
</script>

<style>
    .game-history {
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
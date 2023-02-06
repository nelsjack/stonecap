<template>
  <div class="profile-page">
    <div class="game-collection">
      <h4>{{ this.$route.params.username }}'s Profile</h4>
      <game-card :games="this.playedGames"> </game-card>
      <!-- <post-card> </post-card> -->

    </div>
  </div>
</template>

<script>
import boardGameService from "../services/BoardGameService";
//import PostCard from "../components/PostCard.vue";
import GameCard from "../components/GameCard.vue";
export default {
  name: "Profile",
  components: {
    GameCard,
    //PostCard
  },
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
              .getBoardGamesById(element.boardGameId)
              .then((data) => {
                console.log(data.data);
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
.profile-page {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
</style>
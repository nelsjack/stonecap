<template>
  <div class="profile-page">
    <div class="game-collection">
      <h3>
        {{ this.$route.params.username }}'s Profile
        <b-icon icon="person"></b-icon>
      </h3>
      <br/>
      <h4>
        Owned Games
        <b-icon icon="archive"></b-icon>
      </h4>
      <game-card :games="this.ownedGames"> </game-card>
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
      ownedGames: [],
    };
  },
  created() {
    this.getOwnedBoardGames();
  },
  methods: {
    getOwnedBoardGames() {
      boardGameService
        .getOwnedBoardGamesByUsername(this.$route.params.username)
        .then((response) => {
          const ownedGamesArray = [];
          response.data.forEach((element) => {
            boardGameService
              .getBoardGamesById(element.board_game_id)
              .then((data) => {
                ownedGamesArray.push(data.data.games[0]);
              });
          });
          this.ownedGames = ownedGamesArray;
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
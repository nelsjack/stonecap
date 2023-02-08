<template>
  <div class="profile-page">
    <div class="game-collection">
      <!-- <b-avatar class="profile-picture" :src="this.$store.state.user.image" size="5em"/> -->
      <h3>
        {{ this.$route.params.username }}'s Profile
        <b-icon icon="person"></b-icon>
      </h3>
      <b-button class="add-friend-button" v-if="this.$store.state.user.username != this.$route.params.username">Add Friend</b-button>
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
      profilePicture: ""
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
    getUserProfilePicture() {

    },
    checkIfUserIsFriend() {
      
    }
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

.profile-picture {
  height: 5em;
  width: 5em;
}

.add-friend-button {
  background-color: #0a6496 !important;
}
</style>
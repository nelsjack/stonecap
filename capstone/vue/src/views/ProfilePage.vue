<template>
  <div class="profile-page">
    <div class="game-collection">
      <b-avatar class="profile-picture" :src="profilePicture" size="5em"/>
      <h3>{{ this.$route.params.username }}'s Profile</h3>
      <b-button
        class="add-friend-button"
        v-bind:disabled="addFriendButtonDisabled"
        v-if="
          !isFriend &&
          this.$store.state.user.username != this.$route.params.username"
        v-on:click="addFriend"
        ><b-icon icon="plus"/><b-icon icon="person"/> Add
        Friend</b-button>
      <br />
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
import userService from "../services/UserService";
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
      profilePicture: "",
      friends: [],
      isFriend: false,
      addFriendButtonDisabled: false
    };
  },
  created() {
    this.getOwnedBoardGames();
    this.checkIfUserIsFriend();
    this.getUserProfilePicture();
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
      userService.getUserIdByUsername(this.$route.params.username)
      .then((response) => {
        this.profilePicture = response.data.image;
      })
    },
    checkIfUserIsFriend() {
      userService.getAllFriends(this.$store.state.user.id).then((response) => {
        this.friends = response.data;
        userService.getUsers(this.friends).then((response) => {
          this.friends = response.data;
          this.friends.forEach((element) => {
            if (element.username == this.$route.params.username) {
              this.isFriend = true;
            }
          });
        });
      });
    },
    addFriend() {
      userService.getUserIdByUsername(this.$route.params.username)
      .then((response) => {
        const friendship = {
        user_id_one: this.$store.state.user.id,
        user_id_two: response.data.id
      }
        userService.createFriendship(friendship);
        this.addFriendButtonDisabled = true
      })
      
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
  padding: 5px !important;
  margin-bottom: 20px;
}
</style>
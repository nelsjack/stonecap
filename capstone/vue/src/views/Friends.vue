<template>
  <div class="container">
    <h1 class=page-title>{{user_name}}'s Friends Page</h1>
    <user-card v-for="user in users" :key="user.id" :user="user"></user-card>
<search-user></search-user>
   

  </div>
</template>

<script>
import SearchUser from '../components/SearchUser.vue';
import UserCard from "../components/UserCard.vue";

import UserService from "../services/UserService.js";
export default {
  components: { UserCard, SearchUser },
  data() {
    return {
      friends: [],
      user_id: this.$store.state.user.id,
      users: [],
      user_name: this.$store.state.user.username,
    };
  },
  created() {
    this.getFriends();
  },
  methods: {
    getFriends() {
      UserService.getAllFriends(this.$store.state.user.id).then((response) => {
        this.friends = response.data;
        UserService.getUsers(this.friends).then((response) => {
          this.users = response.data;
        });
      });
  
    },
  },
};
</script>

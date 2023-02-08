<template>
  <div>
    <h1>Friends Page Starter</h1>
    <user-card v-for="user in users" :key="user.id" :user="user"></user-card>

   

  </div>
</template>

<script>
import UserCard from "../components/UserCard.vue";

import UserService from "../services/UserService.js";
export default {
  components: { UserCard },
  data() {
    return {
      friends: [],
      user_id: this.$store.state.user.id,
      users: [],
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

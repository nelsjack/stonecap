<template>
  <div>
    
    <b-card class="user-card shadow" @click="routeToUserProfile" >
      <img class="user-icon" :src="user.image" />
      <h1 class="user-title">{{ user.username }}</h1>
    </b-card>
 
  </div>
</template>

<script>
import userService from "../services/UserService.js";

export default {
  name: "user-card",
  props: ["user"],
  data() {
    return {
      userId: -1,
    };
  },
  computed: {
    userContent() {
      return userService.getUsers(this.users);
    },
  },
  methods:{
      routeToUserProfile() {
      this.$router.push({
        name: "Profile",
        params: { username: this.user.username },
      });
    },
  }
};
</script>

<style>
.user-icon {
  height: 5em;
  width: 5em;
  margin-left: 5px;
}

.user-card {
  cursor: pointer;
  display: flex;
  flex-direction: row;
  align-items: center;
  border: solid 1px;
  border-radius: 10px;
  margin-top: 10px;
  background-color: #ffff;
  font-size: 90%;
}

.user-title {
  display: inline-flex;
  margin-left: 10px;
  margin-right: 10px;
}



.btn-primary {
  background-color: #0a6496 !important;
}
</style>

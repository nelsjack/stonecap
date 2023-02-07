<template>
  <div>
    <h1>Friends Page Starter</h1>
  <user-card :users="this.friends"></user-card>
  <!-- <li v-for="user in friends" :key="user.id">{{user}} test2</li> -->
  <h1>{{user_id}}</h1>
  <h1>{{friends}}</h1>
  </div>
</template>

<script>
import UserCard from '../components/UserCard.vue';

import UserService from '../services/UserService.js';
export default{
  components:{UserCard},
  data() {
      return {
        friends:[],
        user_id: this.$store.state.user.id
      }
    }, created(){
      this.getFriends();
    }, methods:{
        getFriends(){
            UserService.getAllFriends(this.$store.state.user.id).then(response => {
                this.friends =response.data;
            })
        }
    }
}



</script>
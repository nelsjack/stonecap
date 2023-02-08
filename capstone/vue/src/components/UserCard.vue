<template>
  <div>
    
    <b-card class="user-card shadow">
      <h1 class="user-title">{{user.username}}</h1>
      <h1>{{user}}</h1>
      <img :src="user.image"/>
    </b-card>
<!-- <h1>{{user.id}}</h1> -->
  </div>
</template>

<script>
import userService from '../services/UserService.js';

export default {
    name: 'user-card',
    props: ['user'],
    data() {
      return {
        userId: -1,
   
      }
    }
    , computed: {
userContent(){ 
  return userService.getUsers(this.users)
    }

    }
}
    
;
</script>

<style>
  .user-icon {
    height: 5em;
    width: 5em;
    margin-left: 5px;
  }


  .user-card {
    display: flex;
    flex-direction: row;
    align-items: center;
    border: solid 1px;
    border-radius: 10px;
    margin-top: 10px;
    background-color: #FFFF;
    font-size: 90%;
  }

  .user-title {
    margin-left: 10px;
    margin-right: 10px;
  }

  .game-description {
    margin-right: 5px;
  }

  

  .btn-primary {
    background-color: #0A6496 !important;
  }
</style>
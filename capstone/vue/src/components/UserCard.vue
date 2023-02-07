<template>
  <div>
    
    <b-card >
      <h1>{{user.id}}</h1>

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
  .game-thumbnail {
    height: 5em;
    width: 5em;
    margin-left: 5px;
  }

  .trending-games-container {
    width: 75%;
    margin-top: 1em;
  }

  .game-card {
    display: flex;
    flex-direction: row;
    align-items: center;
    border: solid 1px;
    border-radius: 10px;
    margin-top: 10px;
    background-color: #FFFF;
    font-size: 90%;
  }

  .game-title {
    margin-left: 10px;
    margin-right: 10px;
  }

  .game-description {
    margin-right: 5px;
  }

  .popover {
    margin-left: 10px;
  }

  .player-name {
    cursor: pointer;
  }

  .game-card-button {
    margin: 5px;
    width: 10em;
  }

  .btn-primary {
    background-color: #0A6496 !important;
  }
</style>
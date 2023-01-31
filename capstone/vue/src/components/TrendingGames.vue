<template>
  <div> 
      <div v-for="game in games" v-bind:key="game.id">{{game.handle}} </div>
  </div>
</template>

<script>
import boardGameService from '../services/BoardGameService'
export default {  
    name: 'trending-games', 
    data(){
        return{
            games: []
        }
    },
    created(){
        this.getTopTenBoardGames();
        console.log(this.games)
    },
    methods: {
    getTopTenBoardGames(){
      boardGameService.getTopTenBoardGames()
      .then(response => {
          this.games = response.data.games
      });
    }
  }

};
</script>

<style>

</style>
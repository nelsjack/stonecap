<template>
  <div class="trending-games-container">
      <h1>
        Trending Games
        <b-icon icon="chevron-double-up" scale="0.9"></b-icon>
      </h1> 
      <game-card :games="this.games"/>
  </div>
</template>

<script>
import boardGameService from '../services/BoardGameService'
import GameCard from './GameCard.vue';

export default {  
    name: 'trending-games', 
    components: { GameCard },
    data(){
        return{
            games: []
        }
    },
    created(){
        this.getTopTenBoardGames();
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
  body {
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
  }

  .home {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  .trending-games-container {
    width: 75%;
    margin-top: 10px;
  }
</style>
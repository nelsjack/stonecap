<template>
  <div class="container">
    
    <h1>
      Board Game Results
      <b-icon icon="search" scale="0.9"></b-icon>
    </h1>
   
   
    <game-card :games="this.games" />
  </div>
</template>

<script>
import boardGameService from "../services/BoardGameService";
import GameCard from "./GameCard.vue";

export default {
  name: "search-games",
  components: { GameCard },
  props: ['searchTerm'],
  data() {
    return {
      games: [],
    };
  },
  created() {
    this.getSearchBoardGames();
  },
  methods: {
    getSearchBoardGames() {
      boardGameService.getSearchBoardGames(this.searchTerm).then((response) => {
        this.games = response.data.games;
        
      });
    },
  },
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

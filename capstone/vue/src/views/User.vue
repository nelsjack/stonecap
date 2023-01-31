<template>
    <div>
        <h2>Name: {{ this.$route.params.username }}</h2>
        <div v-for="game in playedGames" v-bind:key="game.userGameId">
            {{ game.boardGameId }}
        </div>
    </div>
</template>

<script>
import boardGameService from '../services/BoardGameService'

export default {
    data() {
        return {
            playedGames: []
        }
    },
    created() {
        this.getPlayedBoardGames();
    },
    methods: {
        getPlayedBoardGames() {
            boardGameService.getPlayedBoardGames(this.$route.params.username)
            .then(response => {
                
                const playedGamesArray = [];
                response.data.forEach(element => {
                    const boardGameId = boardGameService.getBoardGamesById(element.boardGameId);
                    playedGamesArray.push(boardGameId)
                });
                this.playedGames = playedGamesArray;
                console.log(this.playedGames);
            })
        }
    }
}
</script>

<style>

</style>
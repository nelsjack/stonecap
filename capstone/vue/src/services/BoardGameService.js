import axios from 'axios';

export default {
    
    getTopTenBoardGames() {
        return axios.get('https://api.boardgameatlas.com/api/search?limit=10&order_by=rank&client_id=kYNboY2Iyu');
    },

    getPlayedBoardGames(username) {
        return axios.get(`http://localhost:9000/boardgame/${username}`);
    },

    getBoardGamesById(boardGameId) {
        return axios.get(`https://api.boardgameatlas.com/api/search?ids=${boardGameId}&client_id=kYNboY2Iyu`);
    }

  };
  
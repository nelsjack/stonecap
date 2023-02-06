import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

export default {
    
    getTopTenBoardGames() {
        return http.get('https://api.boardgameatlas.com/api/search?limit=10&order_by=rank&client_id=kYNboY2Iyu');
    },

    getPlayedBoardGames(username) {
        return http.get(`http://localhost:9000/boardgame/${username}/played`);
    },

    getBoardGamesById(boardGameId) {
        return http.get(`https://api.boardgameatlas.com/api/search?ids=${boardGameId}&client_id=kYNboY2Iyu`);
    },

    getWishlistBoardGamesByUsername(username) {
        return http.get(`http://localhost:9000/boardgame/${username}/wishlist`);
    },

    saveGameForUser(boardgame) {
        return http.post('http://localhost:9000/boardgame/save-game', boardgame);
    }

  };
  
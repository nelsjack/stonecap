import axios from 'axios';

export default {
    getTopTenBoardGames(){
        return axios.get('https://api.boardgameatlas.com/api/search?limit=10&order_by=rank&client_id=kYNboY2Iyu')
    }

  
  };
  
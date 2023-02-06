import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

export default {

    getUsersByBoardGameId(boardGameId) {
        return http.get(`http://localhost:9000/user/boardgame/${boardGameId}`);
    },
    getAllFriends(){
        return http.get(`http://localhost:9000/user/MyFriends`);
    }

}


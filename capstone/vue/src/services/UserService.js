import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

export default {

    getUsersByBoardGameId(boardGameId) {
        return http.get(`http://localhost:9000/user/boardgame/${boardGameId}`);
    },
    getAllFriends(userId){
        return http.get(`http://localhost:9000/user/${userId}/friends`);
    },
    getUser(userId){
        return http.get(`http://localhost:9000/user/${userId}`);
    }, getUsers(userList){
        return http.post(`http://localhost:9000/userList/`,userList);
    }, getUsersByContains(searchTerm){
        return http.get(`http://localhost:9000/user/search/contains/${searchTerm}`);
    }

}


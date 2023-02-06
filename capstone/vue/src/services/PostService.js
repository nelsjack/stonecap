import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
  });

export default {

    getPostByPostId(postId) {
        return http.get(`http://localhost:9000/post/${postId}`); 
    }, 

    // getAllByBoardGame(boardGameId){
    //     return http.get(`http://localhost:9000/post/${boardGameId}`); 
    // }, 

    getAllByUserId (userId) {
        return http.get(`http://localhost:9000/post/${userId}`); 
    }, 

    createNewPost(post) {
        return http.post(`http://localhost:9000/create-post`, post); 
    }

}
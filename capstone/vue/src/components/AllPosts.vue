<template>
  <div class="all-posts-container">
      <h1 class="title"> Feed </h1>
      <post-card :posts="this.posts"/>
     
  </div>
</template>

<script>
import postService from "../services/PostService";
import PostCard from "../components/PostCard.vue";
export default {
    name: "all-Posts", 
    components: {PostCard}, 
    data(){
        return {
            posts: [], 
        }; 
    }, 
    created(){
        postService.getAllPosts().then(response =>{
            this.posts = response.data; 
        })
    }

}
</script>

<style>
body {
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
 }

  .all-posts-container {
      justify-content: center;
    width: 75%;
    margin-top: 1em;
  }
  .title {
      justify-content: center;
  }
</style>
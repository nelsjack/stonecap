<template>
  <div class="all-posts-container">
      <h1 class="title"> Feed </h1>
        <b-button class="post-button" variant="primary" v-on:click="routeToCreatePost()">Add New Post</b-button>

      <post-card :posts="this.posts" class="all-posts"/>
     
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
    }, 
    methods: {
        routeToCreatePost(){
            this.$router.push({name: 'Post'})
            this.$router.go()
        }
    }

}
</script>

<style>

 .title {
      justify-content: center;
  }

  .all-posts{
   width: 75%
  }

  .all-posts-container {
      display: flex; 
      flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-top: 1em;
  }




</style>
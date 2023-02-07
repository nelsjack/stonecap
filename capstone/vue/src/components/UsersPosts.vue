<template>
  <div class="users-posts-container">
    <h2 class="title">Your Posts</h2>
    <post-card :posts="this.posts" />
  </div>
</template>

<script>
import postService from "../services/PostService";
import PostCard from "../components/PostCard.vue";
export default {
  name: "users-posts",
  components: { PostCard },
  data() {
    return {
      posts: [],
    };
  },
      created(){
      postService.getAllByUserId(this.$store.state.user.id).then((response) => {
          console.log(response.data); 
          this.posts = response.data; 
      })
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

  .users-posts-container {
    width: 30%;
    margin-top: 1em;
  }
  .title {
      justify-content: center;
  }
</style>
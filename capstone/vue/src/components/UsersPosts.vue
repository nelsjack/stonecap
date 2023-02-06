<template>
  <div class="users-posts-container">
    <h3>Feed</h3>
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

  methods: {
      viewUsersPosts(postId){
          this.$router.push(`/post/${postId}`)
      }, 
      created(){
      postService.getAllByUserId().then((response) => {
          this.posts = response.data; 
      })
  }, 
      
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
    width: 50%;
    margin-top: 1em;
  }
</style>
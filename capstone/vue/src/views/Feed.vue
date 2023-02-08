<template>
  <div class="feed-page">
    
    <all-post class="all-posts" :posts="this.allPosts"></all-post>
  </div>
</template>

<script>

import postService from "../services/PostService"
export default {
  name: "all-Posts",

  data() {
    return {
      allPosts: [],
    };
  },
  created(){
      postService.getAllPosts().then((response) => {
          this.allposts = response.data; 
      })
  }, 

};
</script>

<style>
.feed-page{
  display: flex;
  justify-content: center;
  align-items: center;
  width: 75%; 
}
.all-posts{
   margin: 5em;
  justify-content: center;
}


</style>
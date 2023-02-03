<template>
  <div class="post-home">
      <add-post class="add-post"></add-post>
      <post-card></post-card>
  </div>
</template>

<script>
import AddPost from "../components/AddPost.vue"
import PostCard from "../components/PostCard.vue"

export default {
    name: "Post", 
    components: {AddPost, PostCard}, 
    data(){ 
        return { 
            Post: []
        }; 
    }
    }
</script>

<style>
.post-home {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.add-post {
    justify-content: left;
}
</style>
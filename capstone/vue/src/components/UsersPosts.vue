<template>
  <div class="users-posts-container">
    <h2 class="title">Your Posts</h2>
    <post-card class="users-posts" :posts="this.posts" />
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
  created() {
    postService.getAllByUserId(this.$store.state.user.id).then((response) => {
      console.log(response.data);
      this.posts = response.data;
    });
  },
};
</script>


<style>
.title {
  justify-content: center;
}

.users-posts-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 50%
}



</style>
<template>
  <div class="post-home">
    <add-post class="add-post"></add-post>
    <users-posts class="users-post"></users-posts>
  </div>
</template>

<script>
import AddPost from "../components/AddPost.vue";
import UsersPosts from "../components/UsersPosts.vue";

export default {
  name: "Post",
  components: { AddPost, UsersPosts },
  data() {
    return {
      Post: [],
    };
  },
};
</script>

<style>
.post-home {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
.add-post {
  margin: 5em;
  justify-content: left;
}
.users-posts {
  margin: 5em;
  justify-content: right;
}
</style>
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
  justify-content: center;
 
}
.add-post {
  margin: 5em; 
  height: 10em; 

}
.users-posts{
  width: 100%
}
</style>
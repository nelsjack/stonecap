<template>
  <div>
    <b-card
      class="post-card shadow"
      :id="`${post.id}`"
      v-for="post in posts"
      v-bind:key="post.id"
    >
      <img class="post-image" :src="post.image" />
      <h4 class="post-title">{{ post.title }}</h4>
      
      <!-- <img src='../assets/star.png' class='star-rating'
      v-bind:title="post.rating + 'rating'" v-for='rating in posts' v-bind:key='rating' /> -->
<!-- v-for='rating in ratings' v-bind:key='rating' -->

      
      <p class="post-comments">{{ post.comments }}</p>

  <post-username :post="post"></post-username>
    </b-card>
  </div>
</template>

<script>
// import postService from "../services/PostService";
import PostUsername from "./PostUsername.vue"
export default {
  name: "post-card",
  props: ["posts"],
  components: {PostUsername}, 
  data() {
    return {
      username: "",
      // rating: 0
    };
  },
  
    // getStarReviews(rating){
    //   postService.rating(rating).then((response) => {
    //     this.rating = response.data
    //   })

    // }

};
</script>

<style>
.post-image {
  height: 5em;
  width: 5em;
  margin-left: 5px;
}

.user-post-container {
  width: 30%;
  margin: 1em;
}

.post-card {
  display: flex;
  flex-direction: column;
  align-items: left;
  border: solid 1px;
  border-radius: 10px;
  margin-top: 10px;
  background-color: #ffff;
}

.post-title {
  margin-left: 10px;
  margin-right: 10px;
}

.post-comments {
  margin-right: 5px;
}

.star-rating{
  justify-content: right;
  width: 2em; 
}
</style>
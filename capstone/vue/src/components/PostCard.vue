<template>
  <div>
    <div class="post-card" v-for="post in posts" v-bind:key="post.id">
      <h3>{{ post.title }}</h3>
      <img src="imageUrl" />
      <p >{{ post.comments }}</p>
      <img src="../assets/star.png"/>
    <p>{{post.tags}}</p>
    </div>
  </div>
</template>

<script>
import postService from '../services/PostService'; 

export default {
    name: 'post-card', 
    data(){
      return {
        post: []
      }; 
    },
    methods: {
        getPost(postId) {
            postService.getPostByPostId(postId).then ((response) => {
                return this.post = response.data;
            })
        }
    }


};
</script>

<style>

</style>
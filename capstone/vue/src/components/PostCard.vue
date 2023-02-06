<template>
  <div>
    <div class="post-card" :id='`${post.id}`' v-for="post in posts" v-bind:key="post.id" >
<h3>Feed</h3>
<img class="post-image" :src="post.image" />
<h4 class = "post-title">{{post.title}}</h4>
<p class="post-comments">{{post.comments}}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'post-card', 
  props: ['posts'], 

}; 
</script>

<style>
.post-image {
    height: 5em;
    width: 5em;
    margin-left: 5px;
  }

  .post-card {
    display: flex;
    flex-direction: row;
    align-items: center;
    border: solid 1px;
    border-radius: 10px;
    margin-top: 10px;
    background-color: #FFFF;
  }

  .post-title {
    margin-left: 10px;
    margin-right: 10px;
  }

  .post-comments {
    margin-right: 5px;
  }


</style>
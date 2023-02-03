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



</style>
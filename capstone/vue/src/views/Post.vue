<template>
  <div class="post-home">
      <h2>{{post.title}}</h2>
      <post-card :post="this.getPost" />
  </div>
</template>

<script>
import postService from "../services/PostService"; 
import PostCard from "../components/PostCard.vue"; 

export default {
    components: {PostCard}, 
    data(){ 
        return { 
            getPost: [], 

        }; 
    }, 
    created(){ 
        this.getPost(); 
    }, 
    methods: { 
        getPostByPostId(){ 
            postService.getPostByPostId(this.$route.params.postId).then((response) => {
                const post = []; 
                response.data.forEach((element) =>{
                    postService.getPostByPostId(element.postId).then((data) => {
                        console.log(data.data); 
                        post.push(data.data.post[0]); 
                    }); 
            
            }); 
            this.getPost = post; 
            })
        }
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
</style>
<template>

  <div class="posted-user" >
         {{ username }}
  </div>
</template>

<script>
import postService from "../services/PostService";
export default {
    name: "post-username", 
props: ["post"], 
data(){
    return {
    username: ""
    }
}, 
created(){
    this.getUsername(this.post.user_id)
  },
  methods: {
    getUsername(userId) {
      postService.findUsernameByPost(userId).then((response) => {
        console.log(response.data)
        this.username = response.data;
      });
    },
}
}
</script>

<style>

</style>
<template>
  <button type="submit" v-on:click="savePost">Submit</button>
</template>

<script>
import postService from '../services/PostService';

export default {
savePost() {
    postService.savePost(this.post).then((response)=>{
        if(response.status === 201) {
            this.$router.push("/")
        }
    })
}
}
</script>

<style>

</style>
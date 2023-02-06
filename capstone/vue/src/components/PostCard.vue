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
      <p class="post-comments">{{ post.comments }}</p>
      <p class="posted-user">{{ post.userid }}</p>
    </b-card>
  </div>
</template>

<script>
export default {
  name: "post-card",
  props: ["posts"],
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
</style>
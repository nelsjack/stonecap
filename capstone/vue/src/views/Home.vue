<template>
  <div class="home">
    <h1>Home</h1>
    <p>Token: {{ this.$store.state.token }} </p>
    <router-link v-bind:to="{ name: 'login'}"> 
      <button>Login</button>
    </router-link>
    <router-link v-bind:to="{ name: 'register'}">
      <button>Register</button>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

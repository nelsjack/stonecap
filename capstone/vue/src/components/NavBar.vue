<template>
  <b-navbar class="navbar justify-content-between sticky-top shadow p-3 mb-5">
    <b-nav-item-dropdown id="home-dropdown" class="list-unstyled">
      <template slot="button-content">
        <b-icon icon="list" scale="2"></b-icon>
      </template>
      <b-dropdown-item to="/">Home</b-dropdown-item>
      <b-dropdown-item v-on:click.prevent="routeToAllPosts"
        >Feed</b-dropdown-item
      >
      <b-dropdown-item v-on:click.prevent="routeToUserWishlist"
        >Wishlist</b-dropdown-item
      >
      <b-dropdown-item>Friends</b-dropdown-item>
      <b-dropdown-item>Game history</b-dropdown-item>
    </b-nav-item-dropdown>
    <b-navbar-brand class="nav-title" to="/"> Stone Cap </b-navbar-brand>
    <!-- todo: conditionally display profile-dropdown if user is logged in, else, display login button -->
    <b-nav-item-dropdown id="profile-dropdown" class="list-unstyled">
      <b-dropdown-item v-on:click.prevent="routeToUserProfile"
        >Profile</b-dropdown-item
      >
      <b-dropdown-item>Settings</b-dropdown-item>
      <b-dropdown-item to="/logout" v-if="$store.state.token != ''"
        >Logout</b-dropdown-item
      >
      <b-dropdown-item to="/logout" v-if="$store.state.token == ''"
        >Login</b-dropdown-item
      >
    </b-nav-item-dropdown>
  </b-navbar>
</template>

<script>
export default {
  name: "nav-bar",
  methods: {
    routeToUserWishlist() {
      this.$router.push({
        name: "Wishlist",
        params: { username: this.$store.state.user.username },
      });
    },
    routeToAllPosts() {
      this.$router.push({ name: "AllPosts" });
    },

    routeToUserProfile() {
      this.$router.push({
        name: "Profile",
        params: { username: this.$store.state.user.username },
      });
    },
  },
};
</script>

<style>
.navbar {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  background-color: #0a6496;
}

#home-dropdown {
  width: 10em;
  text-align: start;
  margin-left: 1em;
}

#profile-dropdown {
  width: 10em;
  text-align: end;
  margin-right: 1em;
}

.nav-title {
  color: white !important;
  font-size: 2em !important;
  font-weight: bold;
}
</style>
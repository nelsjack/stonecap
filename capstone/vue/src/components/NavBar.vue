<template>
  <b-navbar class="navbar justify-content-between sticky-top shadow p-3 mb-5">
    <b-nav-item-dropdown id="home-dropdown" class="list-unstyled" no-caret>
      <template slot="button-content">
        <b-icon icon="list" style="color: white" scale="2"></b-icon>
      </template>
      <b-dropdown-item to="/">Home</b-dropdown-item>
      <b-dropdown-item v-on:click.prevent="routeToAllPosts"
        >Feed</b-dropdown-item
      >
      <b-dropdown-item v-on:click.prevent="routeToUserWishlist"
        >Wishlist</b-dropdown-item
      >
      <b-dropdown-item to="/friends">Friends</b-dropdown-item>
      <b-dropdown-item v-on:click.prevent="routeToUserProfile"
        >Game History</b-dropdown-item
      >
    </b-nav-item-dropdown>
    <b-navbar-brand class="nav-title" to="/"> Stone Cap Games </b-navbar-brand>
    <!-- todo: conditionally display profile-dropdown if user is logged in, else, display login button -->
    <b-nav-item-dropdown
      id="profile-dropdown"
      class="list-unstyled"
      :text="this.$store.state.user.username"
    >
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

    routeToUserHistory() {
      this.$router.push({
        name: "history",
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
  width: 240px;
  text-align: start;
  margin-left: 16px;
}

#profile-dropdown {
  width: 240px;
  text-align: end;
  margin-right: 16px;
  font-size: 1.3em;
  color: white;
}

.nav-title {
  color: white !important;
  font-size: 2em !important;
  font-weight: bold;
  margin: 0px !important;
}
</style>
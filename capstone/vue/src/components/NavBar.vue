<template>
  <b-navbar class="navbar justify-content-between sticky-top">
      <b-nav-item-dropdown id="home-dropdown" class="list-unstyled">
          <b-dropdown-item to="/">home</b-dropdown-item>
          <b-dropdown-item >feed</b-dropdown-item>
          <b-dropdown-item >wishlist</b-dropdown-item>
          <b-dropdown-item >friends</b-dropdown-item>
          <b-dropdown-item >game history</b-dropdown-item>
      </b-nav-item-dropdown>
      <b-navbar-brand to="/">
        stone cap
      </b-navbar-brand>
      <b-nav-item-dropdown id="profile-dropdown" class="list-unstyled">
          <b-dropdown-item >profile</b-dropdown-item>
          <b-dropdown-item >settings</b-dropdown-item>
          <b-dropdown-item to="/logout">logout</b-dropdown-item>
      </b-nav-item-dropdown>
  </b-navbar>
</template>

<script>
export default {
name: 'nav-bar'
}
</script>

<style>
.navbar {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  background-color: #0A6496;
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
</style>
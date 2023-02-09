<template>
  <div class="container">
    <h1 class=page-title>Search Page</h1>
<b-form-input :v-bind="searchTerm"  v-model="searchTerm" placeholder="Enter Board Game Name Here"></b-form-input>
<b-button type="submit"  >Search</b-button>
<h2>{{searchTerm}}</h2>
<search-games></search-games>
   

  </div>
</template>

<script>
import SearchGames from '../components/SearchGames.vue';

export default {
  components: { SearchGames },
  data() {
    return {
     searchTerm:"",
    };
  },
  created() {
   
  },
  methods: {
    
  },
};
</script>

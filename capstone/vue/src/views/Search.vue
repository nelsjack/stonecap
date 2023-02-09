<template>
  <div class="container">
    <h1 class=page-title>Search</h1>
    
    <div class="break"></div>
    <div class="search-combo">
<b-form-input :v-bind="searchTerm"  v-model="searchTerm" placeholder="Enter Board Game Name Here"></b-form-input>
<b-button  class="search-button" @click="sendSearch" >Search</b-button>

    </div>
<search-games :searchTerm="sentSearch" :key="sentSearch"></search-games>
   

  </div>
</template>

<script>
import SearchGames from '../components/SearchGames.vue';

export default {
  components: { SearchGames },
  data() {
    return {
     searchTerm:"",
     sentSearch:"",

    };
  },
  created() {
   
  },
  methods: {
    sendSearch(){
        this.sentSearch=this.searchTerm;
        
    }
  },
};
</script>

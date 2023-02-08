.<template>
  <div class="container">
      <!-- <h1>test search term {{searchTerm}} users {{users}}</h1> -->
       <b-form-input v-on:keyup="searchUser"  v-model="searchTerm" placeholder="Enter username here"></b-form-input>
        <user-card v-for="user in users" :key="user.id" :user="user"></user-card>
  </div>
</template>

<script>
import UserService from '../services/UserService';
import UserCard from '../components/UserCard.vue';
export default {
  components: { UserCard },
name: "search-user",
data(){
    return{
    searchTerm: "",
    users: []
    };
}, created(){
},  methods:{
    searchUser(){
        return UserService.getUsersByContains(this.searchTerm).then((response) =>{
            console.log(response.data)
            this.users = response.data

        } );
    }
}
}
</script>

<style>

</style>
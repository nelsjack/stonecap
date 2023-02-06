<template>
  <div class="form-card">
    <b-form class="form-buttons"   v-on:submit.prevent="onSubmit" @reset="onReset">
      <b-form-group
        class="form-title"
        id="input-group-1"
        label="Board Game Title:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="form.title"
          type="text"
          placeholder="Enter board game title"
          required
        ></b-form-input>
      </b-form-group>
      <div class="form-rating">
      <p>Rating:</p>
      <b-form-rating
        class="mb-2"
        id="rating"
        label="Rating:"
        v-model="form.rating"
        variant="warning"
      >
       <b-form-input
          v-model="form.rating"
          type="int"
          required
        ></b-form-input></b-form-rating>
</div>


      <b-form-group
        class="form-comments"
        id="input-group-2"
        label="Comments:"
        label-for="input-2"
      >
        <b-form-input
          id="input-2"
          v-model="form.comments"
          placeholder="My Comments"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group 
      class="form-image" id="input-group-2" label="Image URL:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.image"
          placeholder="Image URL"
          required
        ></b-form-input>
        
      </b-form-group>

  <b-form-group 
      class="form-tags" id="input-group-3" label="Tags:" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="form.tags"
          placeholder="Tags"
          required
        ></b-form-input>
        
      </b-form-group>

<!-- <div class="form-tags">
      <label for="tags-separators">Tags: </label>
      <b-form-tags
      
        input-id="tags-pills"
        v-model="form.tags"
        separator=" ,;"
        placeholder="Enter new tags separated by space, comma or semicolon"
        no-add-on-enter
      ></b-form-tags>
</div> -->

      <b-form-group id="input-group-4" v-slot="{ ariaDescribedby }">
        <b-form-checkbox-group
        class="form-public"
          v-model="form.checked"
          id="checkboxes-4"
          :aria-describedby="ariaDescribedby"
        >
          <b-form-checkbox value="me"> Make Public</b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
  </div>
</template>

<script>
import postService from "../services/PostService";

export default {
  name: "add-post",
  data() {
    return {
      form: {
       //user: this.$store.user.id, 
        title: "",
        rating: 0,
        comments: "",
        image: "",
        tags: "",
        checked: [],
        publicPrivate: ""
      },
    };
  },
  methods: {
    onSubmit() {
      console.log("post"); 
      postService
        .createNewPost(this.form)
        .then((response) => {
          if (response.status === 201) {
            // this.$router.push("/");
          }
        })
    },
    onReset(event) {
      event.preventDefault();
      this.form.title = "";
      this.form.rating = 0;
      this.form.comments = ""; 
      this.form.image = "";
      this.tags = "";
      this.form.checked = [];
      this.show = false;
      this.$nextTick(() => {
        this.show = true;
      });
    },
  },
};
</script>

<style>
.form-card {
  display: flex;
  flex-direction: row;
  align-items: center;
  border: solid 1px;
  border-radius: 10px;
  margin-top: 10px;
  background-color: #ffff;
}

  .form-title {
   margin: 10px}

    .form-rating{
    margin: 10px}

    .form-comments{margin: 10px}

    .form-image{margin: 10px}

    .form-tags{margin: 10px}

    .form-public{margin: 10px}

    .form-buttons{margin:10px}
</style>
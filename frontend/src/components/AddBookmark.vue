<template>
  <div>
    <h1>ブックマーク追加</h1>
    <form @submit.prevent="addBookmark">
      <div>
        <label>タイトル:</label>
        <input type="text" v-model="bookmark.title" required />
      </div>
      <div>
        <label>URL:</label>
        <input type="text" v-model="bookmark.url" required />
      </div>
      <div>
        <label>説明:</label>
        <textarea v-model="bookmark.description"></textarea>
      </div>
      <div>
        <button type="submit">追加</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      bookmark: {
        title: "",
        url: "",
        description: "",
      },
    };
  },
  methods: {
    async addBookmark() {
      try {
        await axios.post("/bookmarks/add", this.bookmark);
        this.$router.push("/");
      } catch (error) {
        console.error(error);
      }
    },
  },
};
</script>

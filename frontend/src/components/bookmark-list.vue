<template>
  <div>
    <h1>ブックマーク一覧</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>URL</th>
          <th>タイトル</th>
          <th>説明</th>
          <th></th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="bookmark in bookmarks" :key="bookmark.id">
          <td>{{ bookmark.id }}</td>
          <td>{{ bookmark.url }}</td>
          <td>{{ bookmark.title }}</td>
          <td>{{ bookmark.description }}</td>
          <td><button @click="editBookmark(bookmark.id)">編集</button></td>
          <td><button @click="deleteBookmark(bookmark.id)">削除</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      bookmarks: [],
    };
  },
  methods: {
    fetchBookmarks() {
      axios.get('http://localhost:8080/bookmarks')
        .then((response) => {
          this.bookmarks = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
    },
    editBookmark(id) {
      // 編集画面へ遷移する処理を実装する
      this.$router.push({ name: 'edit', params: { id } });
    },
    deleteBookmark(id) {
      axios.delete(`http://localhost:8080/bookmarks/${id}`)
        .then(() => {
          this.fetchBookmarks();
        })
        .catch((error) => {
          console.error(error);
        });
    },
  },
  mounted() {
    this.fetchBookmarks();
  },
};
</script>

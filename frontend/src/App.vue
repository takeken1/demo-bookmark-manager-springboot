<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <bookmark-list />
  </div>
</template>

<script>
import BookmarkList from "./components/bookmark-list.vue";

export default {
  name: "App",
  components: {
    BookmarkList,
  },
};
</script>

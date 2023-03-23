import { createRouter, createWebHistory } from "vue-router";
import BookmarkList from "@/components/BookmarkList.vue";
import AddBookmark from "@/components/AddBookmark.vue";

const routes = [
  {
    path: "/",
    name: "BookmarkList",
    component: BookmarkList
  },
  {
    path: "/add-bookmark",
    name: "AddBookmark",
    component: AddBookmark
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;

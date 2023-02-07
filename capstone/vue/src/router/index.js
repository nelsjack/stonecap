import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import User from '../views/User.vue'
import ProfilePage from '../views/ProfilePage.vue'
import Wishlist from '../views/Wishlist.vue'
import store from '../store/index'
import Post from '../views/Post.vue'
import Friends from '../views/Friends.vue'
import AllPosts from '../components/AllPosts.vue'

Vue.use(Router)



/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/user/:username",
      name: "User",
      component: User,
      meta: {
        requiresAuth: true
      }
    },
    // {
    //   path: "/post/:postId", 
    //   name: "Post", 
    //   component: Post
    // }, 
    {
      path: "/create-post",
      name: "Post",
      component: Post,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/profile/:username",
      name: "Profile",
      component: ProfilePage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/boardgame/:username/wishlist",
      name: "Wishlist",
      component: Wishlist,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/post/all-posts",
      name: "AllPosts",
      component: AllPosts,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/friends",
      name: "Friends",
      component: Friends,
      meta: {
        requiresAuth: true
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;

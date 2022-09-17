import { createRouter, createWebHistory } from 'vue-router'
import User from '../views/UserRegisterView'
import Admin from '../views/AdminRegisterView.vue'
import Login from '../views/AdminLoginView.vue'
import fontello from '@/assets/icon/fontello-2d947b19/css/fontello.css'

const routes = [
  {
    path: '/user/register',
    name: 'UserRegisterView',
    components: {
      view1: User
    }
  },
  {
    path: '/admin/register',
    name: 'AdminRegisterView',
    components: {
      view2: Admin
    }

  },
  {
    path: '/admin/login',
    name: 'AdminLoginView',
    components: {
      view3: Login
    }
  },
  {
    path: '/admin/list',
    name: 'memberListView',
    component: () => import(/* webpackChunkName: "Test" */ '../views/memberList.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

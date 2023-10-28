// router.js
import { createRouter, createWebHistory } from 'vue-router';
import LoginForm from './components/LoginForm.vue';
import TheatreCreate from './components/TheatreCreate.vue';
import TheatreSearch from './components/TheatreSearch.vue';
import TheatreEdit from './components/TheatreEdit.vue';
import ShowCreate from './components/ShowCreate.vue';
import ShowEdit from './components/ShowEdit.vue';
import ShowSearch from './components/ShowSearch.vue';
import DashboardView from './components/DashboardView.vue';
import ExportTheatres from './components/ExportTheatres.vue';

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginForm
  },
  {
    path: '/theatre',
    name: 'theatre',
    component: TheatreCreate
  },
  {
    path: '/theatre/search',
    name: 'theatre-search',
    component: TheatreSearch
  },
  {
    path: '/theatre/:id/edit',
    name: 'theatre-edit',
    component: TheatreEdit,
  },
  {
    path: '/show',
    name: 'show',
    component: ShowCreate,
  },
  {
    path: '/show/search',
    name: 'show-search',
    component: ShowSearch
  },
  {
    path: '/show/:id/edit',
    name: 'show-edit',
    component: ShowEdit,
  },
  {
    path: '/dashboard',
    name: 'dashboard',
    component: DashboardView,
  },
  {
    path: '/export',
    name: 'export',
    component: ExportTheatres,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

const only_admin_pages = ['theatre', 'theatre-search', 'theatre-edit', 
                          'show', 'show-search', 'show-edit', 'export'
                        ]

router.beforeEach((to, from, next) => {
  if (only_admin_pages.indexOf(to.name) > -1) { // admin only page
    if (!JSON.parse(localStorage.getItem('role'))) {
      next(false); // Redirect to the login page if the user is not logged in, else stay put.
    }
    else {
      next();
    }
  } else {
    next()
  }
});

export default router;

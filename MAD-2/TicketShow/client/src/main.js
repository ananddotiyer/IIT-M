import { createApp } from 'vue'
import store from './store.js'
import App from './App.vue'
import router from './router'
import './styles.css'
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.js';

const app = createApp(App);

app.use(store);
app.use(router);

app.mount('#app');

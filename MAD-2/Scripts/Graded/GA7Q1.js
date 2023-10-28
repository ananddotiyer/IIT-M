const home = {
    template: `<h1>Home</h1>`
}

const profile = {
    template: `<h1>Hello {{name}}</h1>`,
    props: ['name']
}

const routes = [
    {path: '/', name: 'home', component: home},
    {path: '/profile/:name', name: 'profile', props: true, component: profile}
]

const router = new VueRouter({
    routes,
    base: '/'    
})

const app = new Vue({
    el: '#app',
    router
})
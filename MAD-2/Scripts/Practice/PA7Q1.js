const home = {
    template: `
        <h2>Home</h2>
    `
}

const profile = {
    template: `
        <h2>Welcome to {{this.$route.params.name}}</h2>
    `
}

const routes = [
    {path: '/', component: home},
    {path: '/profile/:name', component: profile}
]

const router = new VueRouter({
    routes,
})

new Vue({
    el: '#app',
    router,
})
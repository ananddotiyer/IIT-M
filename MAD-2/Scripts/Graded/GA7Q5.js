const profile = {
    template: `<div><p>Profile Page </p></div>`
}

const post = {
    template: `<div><p>Users post </p></div>`
}

const routes = [
    {path: '/profile', component: profile},
    {path: '/post', component: post},
    {path: '*', component: post}
]

const router = new VueRouter({
    routes, 
    base: '/'
})

const app = new Vue({
    el: "#app",
    router
})
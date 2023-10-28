const home = {
    template: `<div>Welcome to the home page</div>`
}

const user = {
    template: `<div><div>User ID: {{this.$route.params.id}}</div>
        <router-view></router-view></div>`,            
}

const profile = {
    template: '<div>Name: Rohit Sharma</div>'
}

const error = {
    template: `<div>404: Profile not found </div>`
}

const routes = [
    {path: '/', component: home},
    {
        path: '/user/:id',
        component: user,
        children: [
            {path: '', component: profile},
            {path: 'profile', component: error},
            {path: '*', component: profile}
        ]
    }
]

const router = new VueRouter({
    routes,
    base: '/'
})

const app = new Vue({
    el: "#app",
    router
})
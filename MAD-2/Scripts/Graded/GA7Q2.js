const player = {
    template: `
    <div>
        <h1>name: {{name}}</h1>
        <router-view></router-view>
    </div>    
    `,
    props: ['name']
}

const test = {
    template: `<div><h1>Test runs: {{runs}}</h1></div>`,
    data() {
        return {
            runs: 5000
        }
    }
}

const oneDay = {
    template: `<div><h1>Oneday runs: {{runs}}</h1></div>`,
    data() {
        return {
            runs: 10000
        }
    }
}

const routes = [
    {
        path: '/player/:name',
        component: player,
        children: [
            {path: '', component: oneDay},
            {path: 'test', component: test},
            {path: 'oneday', component: oneDay},
        ],
        props: true
    },
    {path: '*', component: oneDay}
]

const router = new VueRouter({
    routes,
    base: '/'
})

const app = new Vue({
    el: "#app",
    router
})
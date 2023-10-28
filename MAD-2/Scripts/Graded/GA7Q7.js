const store = new Vuex.Store({
    state: {
        count: 0,
        discount: 10,
        products: [
            {
                name: 'apple',
                price: 120
            },
            {
                name: 'banana',
                price: 60
            },
        ]
    },
    mutations: {
        reducePrice: state => {
            state.products.forEach(product => {
                product.price -= (state.discount)/100*product.price;})
        }
    }
})

new Vue({
    el: "#app",
    store: store,
    computed: {
        products() {
            console.log(store.state.products)
            return store.state.products
        }
    },
    methods: {
        applyDiscount() {
            this.$store.commit('reducePrice')
        }
    }
})
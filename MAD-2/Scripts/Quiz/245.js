Vue.component('custom-comp', {
    data() {
        return { name: 'Rohit Sharma'}
    },
    template: `<div>Welcome {{name}}</div>`
})

new Vue({
    el: "#app",
    mounted() {
        this.$refs.custom.name = 'Virat Kohli'
    }
})
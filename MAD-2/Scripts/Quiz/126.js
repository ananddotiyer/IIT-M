const app = new Vue({
    el: "#app",
    data: {
        x: 0,
        y: 0
    },
    methods: {
        increment_x() {
            console.log(this.x)
            for (let i = 20; i > 0; i--) {
                this.x += 1
            }            
            console.log(this.x)
        }
    },
    watch: {
        x(p, q) {
            console.log("watching")
            if (p < q && p > 10) {
                this.y = 1
            }
        }
    }
})

for (let i = 20; i > 0; i--) {
    app.x++
}
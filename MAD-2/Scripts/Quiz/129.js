styleObj = {
    height: '50px',
    width: '50px',
    margin: '10px'
}

const app = new Vue({
    el: "#app",
    data: {
        style1: {
            backgroundColor: 'green', ...styleObj
        },
        style2: {
            ...styleObj, backgroundColor: 'red',
        },
        condition: false,
        run: 0
    },
    methods: {
        changeRun(r) {
            this.run = r
        }
    },
    watch: {
        run(p, q) {
            if (p > q) {
                this.condition = !this.condition
            }
        }
    }
})
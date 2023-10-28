const comp1 = {
    template: `
    <div>
        <p>Total Score: {{totalRun}}</p>
        <p>Current Over: {{runs}}</p>
    </div>
    `,
    props: {
        run: Number,
    },
    data() {
        return {
            totalRun: 0,
            runs: []
        }
    },
    watch: {
        run() {
            this.totalRun += this.run
            this.runs.push(this.run -10)
        }
    }
}

const app = new Vue({
    el: "#app",
    data: {
        run: 0,
    },
    methods: {
        changeRun(s) {
            this.run = s + 10
        }
    },
    components: {
        'component-1': comp1
    }
})
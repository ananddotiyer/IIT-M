const total = {
    template: '<div>Total Score: {{total_score}}</div>',
    props: ['total_score']
}

const over = {
    template: `<div style="margin:10px 0px;">Current Over: 
        <span v-for="run in over"> {{run}} | </span>
        </div>`,
    props: ['over']
}

const editScore = {
    template: `<div><button @click="$emit('add-run-event')">Add Run</button></div>`
}

const app = new Vue({
    el: "#app",
    data: {
        over: [100],
        count: true
    },
    components: {
        over: over,
        total:total,
        'edit-score': editScore
    },
    computed: {
        total_score() {
            let total = this.over.reduce((a, b) => a + b, 0)
            return total
        }
    },
    methods: {
        addRun() {
            this.count ? this.over.push(6) : this.over.push(4)
            this.count = ! this.count
        }
    }
})
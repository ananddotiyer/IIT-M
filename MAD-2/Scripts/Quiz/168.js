const vm = new Vue({
    el: "#app",
    data: {
        rollArray: [
            {result: 'snake', init: 0, final: 10},
            {result: 'ladder', init: 0, final: 10},
            {result: null, point: 10}
        ],
        position: 0,
    },
    methods: {
        move() {
            obj = this.rollArray.pop()
            if (obj.result == 'ladder') {
                this.position = obj.final
            }
            if (obj.result == 'snake') {
                this.position = obj.init
            }
        }
    },
})
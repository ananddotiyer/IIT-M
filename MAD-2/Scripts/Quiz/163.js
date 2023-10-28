const vm = new Vue({
    el: "#app",
    data: {
        isDanger: false,
    },
    methods: {
        changeStyle() {
            console.log("Changing style")
            this.isDanger = !this.isDanger
        },
    },
})
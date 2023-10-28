const vm = new Vue({
    el: "#app",
    data: {
        isRed: false,
        peopleCount: 0
    },
    watch: {
        peopleCount(newValue, oldValue) {
            if (newValue > oldValue && newValue > 2) {
                this.isRed = true
            }
        }
    }
})
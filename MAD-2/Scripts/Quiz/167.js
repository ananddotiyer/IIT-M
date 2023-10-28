const vm = new Vue({
    el: '#app',
    data: {
        isDark: true
    },
    methods: {
        changeRadio(event) {
            if (event.target.value == "dark") {
                this.isDark = false
            } else {
                this.isDark = true
            }
        }
    }
})
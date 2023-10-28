const app = new Vue({
    el: "#app",
    data: {
        number: '',
        newNumber: ''
    },
    mounted() {
        if (localStorage.number) {
            this.number = localStorage.number
        }
    },
    methods: {
        addNumber() {
            localStorage.number = this.number;
        }
    },
})
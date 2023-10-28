const app = new Vue({
    el: "#app",
    data: {
        name: "",
        isError: true
    },
    mounted() {
        if (localStorage.name) {
            this.name = localStorage.name;
            this.isError = localStorage.isError
        }
    },
    methods: {
        check: function() {
            if (this.name.length > 3)
                this.isError = false;
            else
                this.isError = true
            localStorage.name = this.name
            localStorage.isError = this.isError
        }
    }
})
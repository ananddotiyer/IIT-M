new Vue({
    el: "#app",
    data: {
        subject: "AppDev",
        marks: 50
    },
    mounted() {
        this.subject = "AppDev";
        this.marks = 50;

        if (localStorage.marks) {
            this.subject += "2"
            this.marks = localStorage.marks + 20
        }
        else {
            this.subject += "1"
            this.marks += 20
        }
    },
    methods: {
        compute_marks() {
            localStorage.setItem("subject", this.subject)
            localStorage.setItem("marks", this.marks + 10)
        }
    }
})

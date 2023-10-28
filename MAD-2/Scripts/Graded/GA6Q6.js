const app = new Vue({
    el: "#app",
    data: {
        dark: {
            backgroundColor: 'black',
            color: 'white'
        },
        normal: {
            backgroundColor: 'red',
            color: 'white'
        },
        mode: 'dark'
    },
    created() {
        websiteMode = localStorage.getItem('mode')
        if (websiteMode) {
            this.mode = localStorage.getItem('mode')
        }
    },
    methods: {
        changeMode(mode) {
            localStorage.setItem('mode', mode)
            this.mode = mode
        },
    }
})
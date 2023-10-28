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
        mode: null
    },
    created() {
        websiteMode = sessionStorage.getItem('mode')
        console.log(websiteMode)
        this.mode = websiteMode ? websiteMode : 'dark'
    },
    methods: {
        changeMode(mode) {
            sessionStorage.setItem('mode', mode)
            this.mode = mode
        },
    }
})
new Vue({
    el: "#app",
    data() {
        return {
            weather: 0
        }
    },
    async created() {
        return fetch("https://fcc-weather-api.glitch.me/api/current?lat=12.97&lon=77.59")
        .then(response => response.json())
        .then(responseJson => {
            this.weather = responseJson
            console.log(this.weather)
        })
        .catch(error => {
            console.log(error)
        })
    }
})

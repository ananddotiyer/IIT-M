const players = [
    {name: 'Rohit', role: 'Batsman'}, 
    {name: 'Virat', role: 'Batsman'}, 
    {name: 'Bumbum', role: 'Bowler'}, 
]

const app = new Vue({
    el: '#app',
    data: {
        players: players
    }
})
const app = new Vue({
    el: "#app",
    data: {
        principal: 0,
        annuualInterestRate: 0,
        duration: 0,
        totalPayableAmount: 0,
    },
    computed: {
        simpleInterest() {
            return (this.principal * this.annuualInterestRate * this.duration) / 100
        }
    }
})

appData = [
    [2000, 10, 2],
    [3000, 20, 3],
    [5000, 30, 4]
]

let handler = setInterval(() => {
    data = appData.pop()
    app.principal = data[0]
    app.annuualInterestRate = data[1]
    app.duration = data[2]
    app.totalPayableAmount += app.simpleInterest
}, 1000)
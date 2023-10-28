function Player(name, run) {
    this.name = name
    this.run = run
}

Player.prototype.changeRun = function (run) {
    this.run = this.run + run
}

player1 = new Player('Rohit', 5000)
player1.changeRun(400)
console.log(player1.run)
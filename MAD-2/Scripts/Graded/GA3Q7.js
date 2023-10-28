const dataObj = {
    count: 10000
}

const optObject = {
    el: "#app",
    data: dataObj
}

const app = new Vue(optObject)

setInterval(() => {
    app.count -= 1
}, 1000)
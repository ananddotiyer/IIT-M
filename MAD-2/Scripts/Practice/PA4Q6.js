const comp1 = {
    template: `<h4>This is {{name}}</h4>`,
    //Wrong way of defining component data
    data: {
        name: 'component1'
    },
    // //Right way of defining component data
    // data() {
    //     return {
    //         name: 'component1'
    //     }
    // }
}

const app = new Vue({
    el: "#app",
    components: {
        comp1: comp1
    }
})
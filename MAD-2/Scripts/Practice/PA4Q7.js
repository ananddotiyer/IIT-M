const comp = {
    template: `<li>{{msg.message}}</li>`,
    props: ['msg']
}

const app = new Vue({
    el: "#app",
    data: {
        messages: [
            {message: 'This is message 1'},
            {message: 'This is message 2'},
            {message: 'This is message 3'}
        ]
    },
    components: {
        comp,
    }
})
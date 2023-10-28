Vue.component('comp12', {
    template: '<p>{{message}}</p>',
    data: function() {
        return {message: 'This is component 12'}
    }
}
)

//THis won't work without explictly registering the component, unlike comp12.
const comp11 = {
    template: '<p>{{message}}</p>',
    data: function() {
        return {message: 'This is component 11'}
    }
}

const comp1 = {
    template: `
        <div>
            <h3>Component1</h3>
            <comp11></comp11>
            <comp12></comp12>
        </div>
    `,
    // if the registration is removed, comp11 will fail to work
    // components: {
    //     comp11:comp11
    // }
}

const app = new Vue({
    el: "#app",
    components: {
        comp1: comp1
    }
})
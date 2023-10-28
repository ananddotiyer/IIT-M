Vue.component('some', {
    template: `<div>
        <slot></slot>
        <h1>Component Data</h1>
    </div>`
})

new Vue({
    el: "#app"
})
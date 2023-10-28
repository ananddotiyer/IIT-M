Vue.component('custom-input', {
    // props: ['value'],
    template: `
        <input
            v-bind:value='value'
            v-on:input="$emit('input', $event.target.value)"
        >
    `,
})

new Vue({
    el: "#app",
    data: {searchText: 'type something...'}
})
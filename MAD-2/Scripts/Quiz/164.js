const runComp = {
    template: `<div id="total-run"> {{run}}
    <div>
        <button @click="$emit('increaserun')"> click me </button>
    </div
    <div>
    `,
    props: {
        run: Number
    }
}

const vm = new Vue({
    el: "#app",
    data: {
        run: 10
    },
    components: {
        'run-comp': runComp
    }
})
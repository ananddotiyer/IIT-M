const player = {
    template: `
    <div>
        <slot>Second</slot>
        <slot name="test">Not available</slot>
        <slot name="oneday">Not available</slot>
    </div>
    `
}

const app = new Vue({
    el:"#app",
    data: {
        test: 'This is test data',
        oneday: 'This is oneday data',
        profile: 'This is players profile'
    },
    components: {
        player: player,
    }
})
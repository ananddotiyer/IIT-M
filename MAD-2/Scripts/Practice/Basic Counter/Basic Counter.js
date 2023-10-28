
// Problem 1: Basic Counter
// Create a Vue component that displays a counter value. 
// Include two buttons: one to increment the counter and another to decrement it. 
// Display the current counter value on the page.

const app = Vue.createApp({
    data() {
        return {
            counter: 0,
            win_lose: 'lose'
        }
    },
    methods: {
        increment_counter() {
            this.counter += 1
        },
        decrement_counter() {
            this.counter -= 1
        }
    },
    computed: {
        square_counter() {
            return this.counter ** 2
        },
        class_name() {
            return {
                win: this.counter > 10,
                lose: this.counter <= 0
            }
        }
    },
    watch: {
        counter(value) {
            this.win_lose = value > 10 ? 'win' : 'lose'
        }
    }

}).mount("#app")
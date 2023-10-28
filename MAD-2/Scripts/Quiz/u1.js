const buttoncomp = {
    template: `<button @click="addItem()">Add {{item_name}}</button>`,
    props: ['item_name', 'count'],
    methods: {
        addItem() {
            const item = this.$parent.items.filter(
                (item) => item.item_name != this.item_name
            )
            console.log(item[0].item_name, this.item_name)
            item[0].count += Number(this.count)
        }
    }
}

const vm = new Vue({
    el: '#app',
    data: {
        items: [
            {
                count: 10,
                item_name: 'item1',
            },
            {
                count: 0,
                item_name: 'item2'
            }
        ]
    },
    components: {
        'button-comp': buttoncomp,
    },
})
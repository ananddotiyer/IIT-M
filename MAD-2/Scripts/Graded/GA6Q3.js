const namedSlot= {
    template: `
    <div>
        <slot name='header' :user='currentUser'></slot>
    </div>
    `,
    data() {
        return {
            users: [
                {
                    user_id: 1,
                    name: 'Anand',
                    dist: 'Trivadrum'
                },
                {
                    user_id: 2,
                    name: 'Aravind',
                    dist: 'Palakkad'
                }
            ],
            currentUser: null
        }
    },
    // props: ['current_user_id'],
    created() {
        current_user = sessionStorage.getItem('userId')
        current_user_id = current_user ? current_user : 2
        console.log(current_user_id)
        this.currentUser = this.users.find((user) => user.user_id == current_user_id)
        sessionStorage.setItem('userId', current_user == 1 ? 2 : 1)
    }
}

const app = new Vue({
    el: "#app",
    components: {
        'named-slot': namedSlot
    }
})
import Vuex from 'vuex';

const store = new Vuex.Store({
    state: {
        date: ''
    },
    mutations: {
        setDate(state, date) {
            state.date = date;
        },
    }
})

export default store;
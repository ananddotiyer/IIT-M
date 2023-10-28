new Vue({
    el: "#app",
    data: {
        title: "To do list", 
        newData: '',
        todoList: new Array()
    },
    methods: {
        addTodoList() {
            this.todoList.push(this.newData)
            console.log(this.todoList)
            localStorage.setItem("todolist", JSON.stringify(this.todoList))
        }
    }
})
let app = new Vue({
	el:"#app",
	data: {
		msg: "",
		messages: [],
	},
	methods: {
		addMsg: function(){
			this.messages.push(this.msg);
            // console.log(this.messages)
			// this.msg="";
		}
	},
	computed: {
		count: function(){
            console.log(this.messages)
			return this.messages.length;
		}
	}
})
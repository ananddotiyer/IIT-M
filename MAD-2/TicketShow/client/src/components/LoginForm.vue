<!-- <template>
  <div>
    <h2>{{title}}</h2>
    <form @submit.prevent="login">
      <div>
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="username" required>
      </div>
      <div>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" required>
      </div>
      <button type="submit" class="button" @click="login">Sign in</button>
      <button type="submit" class="button" @click="signup">Sign up</button>
    </form>
  </div>
</template> -->

<template>
  <div>
    <h3 class="mb-6">{{ title }}</h3>
    <form ref="loginForm" @submit.prevent="submitForm" @keyup.enter="submitForm" class="needs-validation" novalidate>
      <div class="mb-3">
        <label for="username" class="form-label">Username:</label>
        <input type="text" id="username" v-model="username" class="form-control" required>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Password:</label>
        <input type="password" id="password" v-model="password" class="form-control" required>
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">Email:</label>
        <input type="text" id="email" v-model="email" class="form-control" :disabled="email_disabled" required>
      </div>
      <div class="mb-3">
        <button type="button" class="btn btn-primary" @click="setLastClickedButton('signin')">Sign in</button>
        <button type="button" class="btn btn-primary" @click="setLastClickedButton('signup')">Sign up</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      email: '',
      email_disabled: true,
      title: 'Login',
      lastClickedButton: 'signin'
    };
  },
  mounted() {
    this.base_server_url = this.$root.base_server_url
    this.base_client_url = this.$root.base_client_url
  },
  methods: {
    submitForm(event) {
      event.preventDefault();

      if (this.lastClickedButton == 'signin') {
        this.login()
      } else if (this.lastClickedButton == 'signup') {
        this.signup()
      }
    },
    setLastClickedButton(buttonName) {
      this.lastClickedButton = buttonName;
      if (this.lastClickedButton == 'signin') {
        this.title = "Login"
        this.email_disabled = true
      } else if (this.lastClickedButton == 'signup') {
        this.title = "Sign up"
        this.email_disabled = false
      }
    },
    login() {
      if (this.username.trim() !== "" && this.password.trim() !== "") {
        fetch(`${this.base_server_url}/api/login/`, {
          method: "POST",
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            "username": this.username,
            "password": this.password
          })
        }).then(resp => resp.json())
          .then(data => {
            if (data.access_token != -1) {
              localStorage.access_token = data.access_token;
              localStorage.username = data.username;
              localStorage.role = data.role;
              localStorage.login = true;
              this.$root.loggedInUser = this.username;
              this.$router.push({ name: 'dashboard' })

              if (data.username == 'admin')
                this.$root.isAdmin = true
              else
                this.$root.isAdmin = false
            } else {
              window.alert("Login failed!")
            }
          })
      }

      this.username = '';
      this.password = '';
    },

    signup() {
      if (this.username.trim() !== "" && this.password.trim() !== "") {
        fetch(`${this.base_server_url}/api/signup/`, {
          method: "POST",
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            "username": this.username,
            "password": this.password,
            'email': this.email
          })
        }).then(resp => resp.json())
          .then(data => {
            if (data.result != -1) {
              window.alert(`User "${data.username}" signed up!`)
            } else {
              window.alert("Signup failed!")
            }
          })
      }

      this.$root.signedUpUser = this.username;

      this.username = '';
      this.password = '';
      this.email = '';
    },
  },
};
</script>
<style>
.button {
  margin: 5px;
}
</style>
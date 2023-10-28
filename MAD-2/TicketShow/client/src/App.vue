<template>
  <div>
    <header class="bg-black py-2">
      <nav class="navbar navbar-expand-lg navbar-dark bg-black">
        <div class="container">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item dropdown" v-if="isAdmin">
                <a class="nav-link dropdown-toggle" href="#" id="theatreDropdown" role="button" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  Theatre
                </a>
                <ul class="dropdown-menu" aria-labelledby="theatreDropdown">
                  <li><a class="dropdown-item" href="/theatre">Add</a></li>
                  <li><a class="dropdown-item" href="/theatre/search">Search(edit/delete)</a></li>
                </ul>
              </li>
              <li class="nav-item dropdown" v-if="isAdmin">
                <a class="nav-link dropdown-toggle" href="#" id="showDropdown" role="button" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  Show
                </a>
                <ul class="dropdown-menu" aria-labelledby="showDropdown">
                  <li><a class="dropdown-item" href="/show">Add</a></li>
                  <li><a class="dropdown-item" href="/show/search">Search(edit/delete)</a></li>
                </ul>
              </li>
              <li class="nav-item" v-if="isAdmin">
                <a class="nav-link" href="/export">Export</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/dashboard" v-if="loggedInUser != ''">Dashboard</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#" @click="handleLogout" v-if="loggedInUser != ''">Logout</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <a class="nav-link" href="/">
        <h4>Welcome, {{ loggedInUser }}</h4>
      </a>
    </header>
    <main>
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
export default {
  data() {
    return {
      base_server_url: 'http://localhost:5000',
      base_client_url: 'http://localhost:8080',
      loggedInUser: '', // Initialize with empty user
      signedUpUser: '', // No Signed up user
      isAdmin: Boolean(localStorage.username == 'admin'),
    };
  },
  methods: {
    handleLogout() {
      // Perform the logout action or call the logout function in Login.vue
      this.$router.push({ name: 'login' });
      localStorage.access_token = '';
      localStorage.username = '';
      localStorage.role = '';
      localStorage.login = false;
      this.loggedInUser = '';
      this.isAdmin = false;
    }    
  },
};

</script>

<style>
header {
  background-color: #333;
  color: #fff;
  padding: 20px;
}
</style>
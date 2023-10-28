<!-- <template>
    <div>
        <h2>Theatre Search</h2>
        <form @submit.prevent="searchTheatres">
            <div>
                <label>Name:</label>
                <input type="text" v-model="searchParams.name" />
            </div>
            <div>
                <label>Place:</label>
                <input type="text" v-model="searchParams.place" />
            </div>
            <div>
                <label>Capacity:</label>
                <input type="number" v-model="searchParams.capacity" />
            </div>
            <button type="submit">Search</button>
        </form>

        <div v-if="theatres.length > 0">
            <h3>Search Results</h3>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Place</th>
                        <th>Capacity</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="theatre in theatres" :key="theatre.t_id">
                        <td>{{ theatre.t_id }}</td>
                        <td><a :href="getTheatreUrl(theatre.t_id)">{{ theatre.name }}</a></td>
                        <td>{{ theatre.place }}</td>
                        <td>{{ theatre.capacity }}</td>
                        <td><button @click="deleteTheatre(theatre.t_id)">Delete</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template> -->

<template>
    <div>
        <h2>Theatre Search</h2>
        <form @submit.prevent="searchTheatres" class="mb-3">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" id="name" class="form-control" v-model="searchParams.name" />
            </div>
            <div class="mb-3">
                <label for="place" class="form-label">Place:</label>
                <input type="text" id="place" class="form-control" v-model="searchParams.place" />
            </div>
            <div class="mb-3">
                <label for="capacity" class="form-label">Capacity:</label>
                <input type="number" id="capacity" class="form-control" v-model="searchParams.capacity" />
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>

        <div v-if="theatres.length > 0">
            <h3>Search Results</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Place</th>
                        <th>Capacity</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="theatre in theatres" :key="theatre.t_id">
                        <td>{{ theatre.t_id }}</td>
                        <td><a :href="getTheatreUrl(theatre.t_id)">{{ theatre.name }}</a></td>
                        <td>{{ theatre.place }}</td>
                        <td>{{ theatre.capacity }}</td>
                        <td>
                            <button @click="deleteTheatre(theatre.t_id)" class="btn btn-danger">Delete</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
  
<script>
export default {
    data() {
        return {
            searchParams: {
                name: '',
                place: '',
                capacity: ''
            },
            theatres: []
        };
    },
    mounted() {
        this.base_server_url = this.$root.base_server_url
        this.base_client_url = this.$root.base_client_url
        this.$root.loggedInUser = localStorage.username;
    },
    methods: {
        async searchTheatres() {
            const searchData = {}
            if (this.searchParams.name != "")
                searchData.name = this.searchParams.name
            if (this.searchParams.place != "")
                searchData.place = this.searchParams.place
            if (this.searchParams.capacity != "")
                searchData.capacity = this.searchParams.capacity

            fetch(`${this.base_server_url}/api/theatres/search/`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'Authorization': `Bearer ${localStorage.access_token}`
                },
                body: JSON.stringify(searchData),
            }).then(async resp => {
                if (resp.ok) {
                    return resp.json();
                } else {
                    const errorMessage = await resp.text();
                    throw new Error(`Failed to find theatres.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                }
            }).then(data => {
                this.theatres = data.theatres
            }).catch(error => {
                alert(error.message);
                if (error.message.includes("Token has expired"))
                    this.$router.push({ name: 'login' })
            });
        },
        getTheatreUrl(theatreId) {
            return `${this.base_client_url}/theatre/${theatreId}/edit`;
        },
        async deleteTheatre(theatreId) {
            let errorMessage;
            if (confirm(`Are you sure you want to delete theatre id ${theatreId}?`)) {
                await fetch(`${this.base_server_url}/api/theatre/${theatreId}/delete/`, {
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                        'Authorization': `Bearer ${localStorage.access_token}`
                    }
                }).then(async resp => {
                    if (resp.ok) {
                        alert(`Theatre ${theatreId} deleted successfully!`);
                        return resp.json();
                    } else {
                        errorMessage = await resp.text();
                        throw new Error(`Failed to delete theatre with id ${this.theatre.id}.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                    }
                }).then(data => {
                    console.log(data)
                }).catch(error => {
                    alert(errorMessage);
                    if (error.message.includes("Token has expired"))
                        this.$router.push({ name: 'login' })
                });
                this.searchTheatres() //Refresh
            }
        },
    }
}
</script>
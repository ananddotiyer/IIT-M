<!-- <template>
    <div>
        <h2>Show Search</h2>
        <form @submit.prevent="searchShows">
            <div>
                <label>Name:</label>
                <input type="text" v-model="searchParams.name" />
            </div>
            <div>
                <label>Current:</label>
                <input type="checkbox" v-model="searchParams.current" />
            </div>
            <div>
                <label>Rating:</label>
                <input type="number" v-model="searchParams.rating" min="0" max="5" />
            </div>
            <div>
                <label>Tag1:</label>
                <input type="text" v-model="searchParams.tag1" />
            </div>
            <div>
                <label>Tag2:</label>
                <input type="text" v-model="searchParams.tag2" />
            </div>
            <div>
                <label>Tag3:</label>
                <input type="text" v-model="searchParams.tag3" />
            </div>
            <button type="submit">Search</button>
        </form>

        <div v-if="shows.length > 0">
            <h3>Search Results</h3>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Current</th>
                        <th>Rating</th>
                        <th>Tag1</th>
                        <th>Tag2</th>
                        <th>Tag3</th>
                        <th>Availability</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="show in shows" :key="show.s_id">
                        <td>{{ show.s_id }}</td>
                        <td><a :href="getShowUrl(show.s_id)">{{ show.name }}</a></td>
                        <td>{{ show.current }}</td>
                        <td>{{ show.rating }}</td>
                        <td>{{ show.tag1 }}</td>
                        <td>{{ show.tag2 }}</td>
                        <td>{{ show.tag3 }}</td>
                        <td>{{ show.availability }}</td>
                        <td><button @click="deleteTheatre(show.s_id)">Delete</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template> -->

<template>
    <div>
        <h2>Show Search</h2>
        <form @submit.prevent="searchShows" class="mb-3">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" id="name" class="form-control" v-model="searchParams.name" />
            </div>
            <div class="mb-3">
                <label for="current" class="form-check-label">Current:&nbsp;</label>
                <input type="checkbox" id="current" class="form-check-input" v-model="searchParams.current" />
            </div>
            <div class="mb-3">
                <label for="rating" class="form-label">Rating:</label>
                <input type="number" id="rating" class="form-control" v-model="searchParams.rating" min="0" max="5" />
            </div>
            <div class="mb-3">
                <label for="tag1" class="form-label">Tag1:</label>
                <input type="text" id="tag1" class="form-control" v-model="searchParams.tag1" />
            </div>
            <div class="mb-3">
                <label for="tag2" class="form-label">Tag2:</label>
                <input type="text" id="tag2" class="form-control" v-model="searchParams.tag2" />
            </div>
            <div class="mb-3">
                <label for="tag3" class="form-label">Tag3:</label>
                <input type="text" id="tag3" class="form-control" v-model="searchParams.tag3" />
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>

        <div v-if="shows.length > 0">
            <h3>Search Results</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Current</th>
                        <th>Rating</th>
                        <th>Tag1</th>
                        <th>Tag2</th>
                        <th>Tag3</th>
                        <th>Availability</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="show in shows" :key="show.s_id">
                        <td>{{ show.s_id }}</td>
                        <td><a :href="getShowUrl(show.s_id)">{{ show.name }}</a></td>
                        <td>{{ show.current }}</td>
                        <td>{{ show.rating }}</td>
                        <td>{{ show.tag1 }}</td>
                        <td>{{ show.tag2 }}</td>
                        <td>{{ show.tag3 }}</td>
                        <td>{{ show.availability }}</td>
                        <td>
                            <button @click="deleteShow(show.s_id)" class="btn btn-danger">Delete</button>
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
                current: true,
                rating: '',
                tag1: '',
                tag2: '',
                tag3: '',
            },
            shows: []
        };
    },
    mounted() {
        this.base_server_url = this.$root.base_server_url
        this.base_client_url = this.$root.base_client_url
        this.$root.loggedInUser = localStorage.username;
    },
    methods: {
        async searchShows() {
            const searchData = {}
            if (this.searchParams.name != "")
                searchData.name = this.searchParams.name
            if (this.searchParams.current != false)
                searchData.current = this.searchParams.current
            if (this.searchParams.rating != "")
                searchData.rating = this.searchParams.rating
            if (this.searchParams.tag1 != "")
                searchData.tag1 = this.searchParams.tag1
            if (this.searchParams.tag2 != "")
                searchData.tag2 = this.searchParams.tag2
            if (this.searchParams.tag3 != "")
                searchData.tag3 = this.searchParams.tag3

            fetch(`${this.base_server_url}/api/shows/search/`, {
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
                    throw new Error(`Failed to find shows.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                }
            }).then(data => {
                this.shows = data.shows
            }).catch(error => {
                alert(error.message);
                if (error.message.includes("Token has expired"))
                    this.$router.push({ name: 'login' })
            });
        },
        getShowUrl(showId) {
            return `${this.base_client_url}/show/${showId}/edit`;
        },
        async deleteShow(showId) {
            let errorMessage;
            if (confirm(`Are you sure you want to delete show id ${showId}?`)) {
                await fetch(`${this.base_server_url}/api/show/${showId}/delete/`, {
                    method: "DELETE",
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                        'Authorization': `Bearer ${localStorage.access_token}`
                    }
                }).then(async resp => {
                    if (resp.ok) {
                        alert(`Show ${showId} deleted successfully!`);
                        return resp.json();
                    } else {
                        errorMessage = await resp.text();
                        throw new Error(`Failed to delete show with id ${showId}.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                    }
                }).then(data => {
                    console.log(data)
                }).catch(error => {
                    alert(errorMessage);
                    if (error.message.includes("Token has expired"))
                        this.$router.push({ name: 'login' })
                });
                this.searchShows() //Refresh
            }
        },
    }
}
</script>
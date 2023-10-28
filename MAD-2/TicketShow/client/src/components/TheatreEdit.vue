<!-- <template>
    <div>
        <form @submit="submitForm">
            <img v-if="image_url" :src="image_url" alt="Theatre Image">
            <div>
                <label for="name">Name:</label>
                <input type="text" id="name" v-model="theatre.name" required>
            </div>
            <div>
                <label for="place">Location:</label>
                <input type="text" id="place" v-model="theatre.place" required>
            </div>
            <div>
                <label for="capacity">Capacity:</label>
                <input type="number" id="capacity" v-model="theatre.capacity" required>
            </div>
            <div>
                <label for="image">Image</label>
                <input type="file" id="image" accept="image/*" @change="handleImageUpload">
            </div>

            <button type="submit">Save</button>
        </form>

        <div v-if="theatre_shows.length > 0">
            <h3>List of current shows:</h3>
            <table>
                <thead>
                    <tr>
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
                    <tr v-for="show in theatre_shows" :key="show.s_id">
                        <td><a :href="getShowUrl(show.s_id)">{{ show.name }}</a></td>
                        <td>{{ show.current }}</td>
                        <td>{{ show.rating }}</td>
                        <td>{{ show.tag1 }}</td>
                        <td>{{ show.tag2 }}</td>
                        <td>{{ show.tag3 }}</td>
                        <td>{{ show.availability }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template> -->

<template>
    <div>
        <form @submit="submitForm">
            <div class="mb-3">
                <img v-if="image_url" :src="image_url" alt="Theatre Image" class="img-fluid">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" id="name" class="form-control" v-model="theatre.name" required>
            </div>
            <div class="mb-3">
                <label for="place" class="form-label">Location:</label>
                <input type="text" id="place" class="form-control" v-model="theatre.place" required>
            </div>
            <div class="mb-3">
                <label for="capacity" class="form-label">Capacity:</label>
                <input type="number" id="capacity" class="form-control" v-model="theatre.capacity" required>
            </div>
            <div class="mb-3">
                <label for="image" class="form-label">Image:</label>
                <input type="file" id="image" class="form-control" accept="image/*" @change="handleImageUpload">
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form>

        <div v-if="theatre_shows.length > 0">
            <h3>List of current shows:</h3>
            <table class="table">
                <thead>
                    <tr>
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
                    <tr v-for="show in theatre_shows" :key="show.s_id">
                        <td><a :href="getShowUrl(show.s_id)">{{ show.name }}</a></td>
                        <td>{{ show.current }}</td>
                        <td>{{ show.rating }}</td>
                        <td>{{ show.tag1 }}</td>
                        <td>{{ show.tag2 }}</td>
                        <td>{{ show.tag3 }}</td>
                        <td>{{ show.availability }}</td>
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
            theatre: {
                name: '',
                place: '',
                capacity: 0,
                image: null,
                image_url: ''
            },
            theatre_shows: []
        };
    },
    mounted() {
        this.base_server_url = this.$root.base_server_url
        this.base_client_url = this.$root.base_client_url
        this.$root.loggedInUser = localStorage.username;

        this.theatre.id = this.$route.params.id;
        this.fetchTheatre(this.theatre.id);

        this.searchTheatreShows() // Populate current shows for this theatre

    },
    methods: {
        handleImageUpload(event) {
            const file = event.target.files[0];
            this.theatre.image = file
            console.log("handleImageUpload", this.theatre.image)
        },
        async fetchTheatre(theatreId) {
            await fetch(`${this.base_server_url}/api/theatre/${theatreId}/get/`, {
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Authorization': `Bearer ${localStorage.access_token}`
                },
            }).then(async resp => {
                if (resp.ok) {
                    return resp.json();
                } else {
                    const errorMessage = await resp.text();
                    throw new Error(`Failed to find theatre with id ${this.theatre.id}.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                }
            }).then(data => {
                this.theatre = data.result
            }).catch(error => {
                alert(error.message);
                if (error.message.includes("Token has expired"))
                    this.$router.push({ name: 'login' })
            });
        },

        async searchTheatreShows() {
            //Reuses "/api/dashboard".
            //<date> is passed as None, so it searches shows in specified theatre on all dates.
            const payload = {
                t_id: this.theatre.id,
                date: null,
                user: null
            }
            fetch(`${this.base_server_url}/api/dashboard/`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'Authorization': `Bearer ${localStorage.access_token}`
                },
                body: JSON.stringify(payload),
            }).then(async resp => {
                if (resp.ok) {
                    return resp.json();
                } else {
                    const errorMessage = await resp.text();
                    throw new Error(`Failed to find shows in theatre with id ${this.theatre.id}.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                }
            }).then(data => {
                this.theatre_shows = data.shows
            }).catch(error => {
                alert(error.message);
                if (error.message.includes("Token has expired"))
                    this.$router.push({ name: 'login' })
            });
        },
        getShowUrl(showId) {
            return `${this.base_client_url}/show/${showId}/edit`;
        },

        async submitForm() {
            try {
                if (this.theatre.image) {
                    const file = this.theatre.image
                    const formData = new FormData();
                    formData.append('image', file, file.name);

                    console.log(this.base_url)
                    const response = await fetch(`${this.base_server_url}/upload/image`, {
                        method: 'POST',
                        body: formData,
                    });

                    const image = await response.json();
                    this.theatre.image_url = image['imageUrl']
                }

                const theatreData = {
                    t_id: this.theatre.t_id,
                    name: this.theatre.name,
                    place: this.theatre.place,
                    capacity: this.theatre.capacity,
                    image_url: this.theatre.image_url
                };

                console.log("Before edit API call")
                console.log(theatreData)

                console.log(`${this.base_server_url}/api/theatre/${theatreData.t_id}/edit/`)
                await fetch(`${this.base_server_url}/api/theatre/${theatreData.t_id}/edit/`, {
                    method: 'PATCH',
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                        'Authorization': `Bearer ${localStorage.access_token}`
                    },
                    body: JSON.stringify(theatreData),
                }).then(async resp => {
                    if (resp.ok) {
                        alert('Theatre details updated successfully!');
                        return resp.json();
                    } else {
                        const errorMessage = await resp.text();
                        throw new Error(`Failed to edit theatre.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                    }
                }).then(data => {
                    console.log(data)
                }).catch(error => {
                    alert(error);
                });
            } catch (error) {
                alert(error.message);
                if (error.message.includes("Token has expired"))
                    this.$router.push({ name: 'login' })
            }
        },
    },
    computed: {
        image_url() {
            return `${this.base_server_url}/${this.theatre.image_url}`;
        },
    }
};
</script>
  
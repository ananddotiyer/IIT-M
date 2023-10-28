<!-- <template>
    <div>
        <h2>Add Theatre</h2>
        <form @submit.prevent="addTheatre">
            <img v-if="image_url" :src="image_url" alt="Theatre Image">
            <div v-else>No Image Available</div>
            <div>
                <label for="name">Name</label>
                <input type="text" id="name" v-model="theatre.name" required>
            </div>
            <div>
                <label for="place">Place</label>
                <input type="text" id="place" v-model="theatre.place" required>
            </div>
            <div>
                <label for="capacity">Capacity</label>
                <input type="number" id="capacity" v-model="theatre.capacity" required>
            </div>
            <div>
                <label for="image">Image</label>
                <input type="file" id="image" accept="image/*" @change="handleImageUpload" required>
            </div>
            <button type="submit">Add Theatre</button>
        </form>
    </div>
</template> -->

<template>
    <div>
        <h2 class="mb-4">Add Theatre</h2>
        <form @submit.prevent="addTheatre" class="needs-validation" novalidate>
            <!-- <div class="mb-3">
                <img v-if="image_url" :src="image_url" alt="Theatre Image" class="mb-3">
                <div v-else>No Image Available</div>
            </div> -->
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input type="text" id="name" v-model="theatre.name" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="place" class="form-label">Place</label>
                <input type="text" id="place" v-model="theatre.place" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="capacity" class="form-label">Capacity</label>
                <input type="number" id="capacity" v-model="theatre.capacity" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="image" class="form-label">Image</label>
                <input type="file" id="image" accept="image/*" @change="handleImageUpload" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Theatre</button>
        </form>
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
                url: ''
            },
        };
    },
    mounted() {
        this.base_server_url = this.$root.base_server_url
        this.base_client_url = this.$root.base_client_url
        this.$root.loggedInUser = localStorage.username;
        console.log(this.$root.isAdmin)
    },
    methods: {
        handleImageUpload(event) {
            const file = event.target.files[0];
            // this.theatre.image = URL.createObjectURL(file);
            this.theatre.image = file
        },
        async addTheatre() {
            const file = this.theatre.image
            const formData = new FormData();
            formData.append('image', file, file.name);

            try {
                const response = await fetch(`${this.base_server_url}/upload/image`, {
                    method: 'POST',
                    // mode: "no-cors",
                    body: formData,
                });

                const image = await response.json();
                this.theatre.url = image['imageUrl']

                const theatreData = {
                    name: this.theatre.name,
                    place: this.theatre.place,
                    capacity: this.theatre.capacity,
                    image_url: this.theatre.url,
                };

                // const createResponse = await fetch(`${this.base_server_url}/api/theatre/create/`, {
                fetch(`${this.base_server_url}/api/theatre/create/`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                        'Authorization': `Bearer ${localStorage.access_token}`
                    },
                    body: JSON.stringify(theatreData),
                }).then(async resp => {
                    if (resp.ok) {
                        alert('Theatre added successfully!');

                        this.theatre.name = '';
                        this.theatre.place = '';
                        this.theatre.capacity = null;
                        this.theatre.image = null;
                        return resp.json();
                    } else {
                        const errorMessage = await resp.text();
                        throw new Error(`Failed to add theatre.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                    }
                }).then(data => {
                    this.theatres = data.theatres
                    this.$forceUpdate(); // without this, theatre names aren't appearing in the dropdown.
                    console.log(this.theatres)
                }).catch(error => {
                    alert(error);
                });
            } catch (error) {
                alert(error.message);
                if (error.message.includes("Token has expired"))
                    this.$router.push({ name: 'login' })
            }
        },
        computed: {
            image_url() {
                return `${this.base_server_url}/${this.theatre.url}`;
            },
        }
    }
}
</script>

<style>
img {
    width: 150px;
    height: 150px;
}
</style>
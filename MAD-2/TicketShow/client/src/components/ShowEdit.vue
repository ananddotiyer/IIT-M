<!-- <template>
    <div>
        <h2>Edit Show</h2>
        <form @submit.prevent="submitForm">
            <img v-if="image_url" :src="image_url" alt="Show Image">
            <div v-else>No Image Available</div>
            <div>
                <label>Theatre:</label>
                <input type="text" id="name" v-model="show.t_name" disabled="True">
            </div>
            <div>
                <label for="current">Current</label>
                <input type="checkbox" id="current" v-model="show.current">
            </div>
            <div>
                <label for="name">Name</label>
                <input type="text" id="name" v-model="show.name" required>
            </div>
            <div>
                <label for="rating">Rating</label>
                <input type="number" id="rating" v-model="show.rating" min="0" max="5" disabled="True">
            </div>
            <div>
                <label for="tag1">Tag 1</label>
                <input type="text" id="tag1" v-model="show.tag1" disabled="True">
            </div>
            <div>
                <label for="tag2">Tag 2</label>
                <input type="text" id="tag2" v-model="show.tag2" disabled="True">
            </div>
            <div>
                <label for="tag3">Tag 3</label>
                <input type="text" id="tag3" v-model="show.tag3" disabled="True">
            </div>
            <div>
                <label for="price">Price</label>
                <input type="number" id="price" v-model="show.price" min="0" disabled="True">
            </div>
            <div>
                <label for="start">Start</label>
                <input type="time" id="start" v-model="show.start" disabled="True">
            </div>
            <div>
                <label for="duration">Duration</label>
                <input type="number" id="duration" v-model="show.duration" min="0" disabled="True">
            </div>
            <div>
                <label for="image">Image</label>
                <input type="file" id="image" accept="image/*" @change="handleImageUpload">
            </div>
            <button type="submit">Edit Show</button>
        </form>
    </div>
</template> -->

<template>
    <div>
        <h2>Edit Show</h2>
        <form @submit.prevent="submitForm">
            <div class="mb-3">
                <img v-if="image_url" :src="image_url" alt="Show Image" class="img-fluid">
                <div v-else>No Image Available</div>
            </div>
            <div class="mb-3">
                <label class="form-label">Theatre:</label>
                <input type="text" class="form-control" v-model="show.t_name" disabled>
            </div>
            <div class="mb-3">
                <label for="current" class="form-check-label">Current:&nbsp;</label>
                <input type="checkbox" id="current" class="form-check-input" v-model="show.current">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" id="name" class="form-control" v-model="show.name" required>
            </div>
            <div class="mb-3">
                <label for="rating" class="form-label">Rating:</label>
                <input type="number" id="rating" class="form-control" v-model="show.rating" min="0" max="5" disabled>
            </div>
            <div class="mb-3">
                <label for="tag1" class="form-label">Tag 1:</label>
                <input type="text" id="tag1" class="form-control" v-model="show.tag1" disabled>
            </div>
            <div class="mb-3">
                <label for="tag2" class="form-label">Tag 2:</label>
                <input type="text" id="tag2" class="form-control" v-model="show.tag2" disabled>
            </div>
            <div class="mb-3">
                <label for="tag3" class="form-label">Tag 3:</label>
                <input type="text" id="tag3" class="form-control" v-model="show.tag3" disabled>
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Price:</label>
                <input type="number" id="price" class="form-control" v-model="show.price" min="0" disabled>
            </div>
            <div class="mb-3">
                <label for="start" class="form-label">Start:</label>
                <input type="time" id="start" class="form-control" v-model="show.start" disabled>
            </div>
            <div class="mb-3">
                <label for="duration" class="form-label">Duration:</label>
                <input type="number" id="duration" class="form-control" v-model="show.duration" min="0" disabled>
            </div>
            <div class="mb-3">
                <label for="image" class="form-label">Image:</label>
                <input type="file" id="image" class="form-control" accept="image/*" @change="handleImageUpload">
            </div>
            <button type="submit" class="btn btn-primary">Edit Show</button>
        </form>
    </div>
</template>
  
<script>
export default {
    data() {
        return {
            show: {
                t_id: null,
                t_name: '',
                current: false,
                name: '',
                rating: 0,
                tag1: '',
                tag2: '',
                tag3: '',
                price: 100,
                start: "00:00",
                duration: 100,
                availability: false,
                image: null,
                image_url: '',
                theatres: []
            },
        };
    },
    mounted() {
        this.base_server_url = this.$root.base_server_url
        this.base_client_url = this.$root.base_client_url
        this.$root.loggedInUser = localStorage.username;

        this.show.id = this.$route.params.id;
        this.fetchShow(this.show.id);
    },
    methods: {
        handleImageUpload(event) {
            const file = event.target.files[0];
            this.show.image = file
        },
        async fetchShow(showId) {
            await fetch(`${this.base_server_url}/api/show/${showId}/get/`, {
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Authorization': `Bearer ${localStorage.access_token}`
                },
            }).then(async resp => {
                if (resp.ok) {
                    return resp.json();
                } else {
                    const errorMessage = await resp.text();
                    throw new Error(`Failed to find show.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                }
            }).then(data => {
                this.show = data.result
            }).catch(error => {
                console.log(error);
            });
        },
        async submitForm() {
            try {
                if (this.show.image) {
                    const file = this.show.image
                    const formData = new FormData();
                    formData.append('image', file, file.name);

                    console.log(this.base_url)
                    const response = await fetch(`${this.base_server_url}/upload/image`, {
                        method: 'POST',
                        body: formData,
                    });

                    const image = await response.json();
                    this.show.image_url = image['imageUrl']
                }

                const showData = {
                    s_id: this.show.s_id,
                    name: this.show.name,
                    current: this.show.current,
                    image_url: this.show.image_url,
                };

                await fetch(`${this.base_server_url}/api/show/${showData.s_id}/edit/`, {
                    method: 'PATCH',
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                        'Authorization': `Bearer ${localStorage.access_token}`
                    },
                    body: JSON.stringify(showData),
                }).then(async resp => {
                    if (resp.ok) {
                        alert('Show details updated successfully!');
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
            return `${this.base_server_url}/${this.show.image_url}`;
        },
    }
}
</script>

<style>
img {
    width: 150px;
    height: 150px;
}
</style>
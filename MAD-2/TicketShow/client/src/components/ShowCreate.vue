<!-- <template>
    <div>
        <h2>Add Show</h2>
        <form @submit.prevent="addShow">
            <img v-if="image_url" :src="image_url" alt="Show Image">
            <div v-else>No Image Available</div>
            <div>
                <label>Theatre:</label>
                <select v-model="show.selectedTheatreId" @change="showSelectedTheatre">
                    <option value="">Select Theatre</option>
                    <option v-for="theatre in theatres" :key="theatre.t_id" :value="theatre.t_id">{{ theatre.name }}({{
                        theatre.place }})</option>
                </select>
            </div>
            <div>
                <label for="current">Current</label>
                <input type="checkbox" id="current" v-model="show.current" required>
            </div>
            <div>
                <label for="name">Name</label>
                <input type="text" id="name" v-model="show.name" required>
            </div>
            <div>
                <label for="rating">Rating</label>
                <input type="number" id="rating" v-model="show.rating" min="0" max="5" required>
            </div>
            <div>
                <label for="tag1">Tag 1</label>
                <input type="text" id="tag1" v-model="show.tag1" required>
            </div>
            <div>
                <label for="tag2">Tag 2</label>
                <input type="text" id="tag2" v-model="show.tag2" required>
            </div>
            <div>
                <label for="tag3">Tag 3</label>
                <input type="text" id="tag3" v-model="show.tag3" required>
            </div>
            <div>
                <label for="price">Price</label>
                <input type="number" id="price" v-model="show.price" min="0" required>
            </div>
            <div>
                <label for="start">Start</label>
                <input type="time" id="start" v-model="show.start" required>
            </div>
            <div>
                <label for="duration">Duration</label>
                <input type="number" id="duration" v-model="show.duration" min="0" required>
            </div>
            <div>
                <label for="availability">Availability</label>
                <input type="number" id="availability" v-model="show.availability" disabled="True">
            </div>
            <div>
                <label for="image">Image</label>
                <input type="file" id="image" accept="image/*" @change="handleImageUpload">
            </div>
            <button type="submit">Add Show</button>
        </form>
    </div>
</template> -->

<template>
    <div>
        <h2>Add Show</h2>
        <form @submit.prevent="addShow">
            <div class="row">
                <div class="col-md-6">
                    <!-- <img v-if="image_url" :src="image_url" alt="Show Image" class="img-fluid">
                    <div v-else>No Image Available</div> -->

                    <div class="mb-3">
                        <label class="form-label">Theatre:</label>
                        <select class="form-select" v-model="show.selectedTheatreId" @change="showSelectedTheatre">
                            <option value="">Select Theatre</option>
                            <option v-for="theatre in theatres" :key="theatre.t_id" :value="theatre.t_id">
                                {{ theatre.name }}({{ theatre.place }})
                            </option>
                        </select>
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" class="form-check-input" id="current" v-model="show.current" required>
                        <label class="form-check-label" for="current">Current</label>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="name">Name</label>
                        <input type="text" id="name" class="form-control" v-model="show.name" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="rating">Rating</label>
                        <input type="number" id="rating" class="form-control" v-model="show.rating" min="0" max="5"
                            required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="tag1">Tag 1</label>
                        <input type="text" id="tag1" class="form-control" v-model="show.tag1" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="tag2">Tag 2</label>
                        <input type="text" id="tag2" class="form-control" v-model="show.tag2" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="tag3">Tag 3</label>
                        <input type="text" id="tag3" class="form-control" v-model="show.tag3" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="price">Price</label>
                        <input type="number" id="price" class="form-control" v-model="show.price" min="0" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="start">Start</label>
                        <input type="time" id="start" class="form-control" v-model="show.start" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="duration">Duration</label>
                        <input type="number" id="duration" class="form-control" v-model="show.duration" min="0" required>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="availability">Availability</label>
                        <input type="number" id="availability" class="form-control" v-model="show.availability" disabled>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="image">Image</label>
                        <input type="file" id="image" class="form-control" accept="image/*" @change="handleImageUpload">
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Add Show</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</template>

             
  
<script>
export default {
    data() {
        return {
            show: {
                selectedTheatreId: null,
                t_name: '',
                current: true,
                name: '',
                rating: 0,
                tag1: '',
                tag2: '',
                tag3: '',
                price: 100,
                start: "00:00",
                duration: 100,
                availability: 0,
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

        fetch(`${this.base_server_url}/api/theatres/search/`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Authorization': `Bearer ${localStorage.access_token}`
            },
            body: JSON.stringify({}),
        }).then(async resp => {
            if (resp.ok) {
                return resp.json();
            } else {
                const errorMessage = await resp.text();
                throw new Error(`Request failed with status ${resp.status}: ${errorMessage}`);
            }
        }).then(data => {
            this.theatres = data.theatres
            this.$forceUpdate(); // without this, theatre names aren't appearing in the dropdown.
        }).catch(error => {
            alert(error.message);
                if (error.message.includes("Token has expired"))
                    this.$router.push({ name: 'login' })
        });

    },
    methods: {
        handleImageUpload(event) {
            const file = event.target.files[0];
            this.show.image = file
        },
        async addShow() {
            const file = this.show.image
            const formData = new FormData();
            formData.append('image', file, file.name);

            try {
                const response = await fetch(`${this.base_server_url}/upload/image`, {
                    method: 'POST',
                    body: formData,
                });

                const image = await response.json();
                this.show.image_url = image['imageUrl']

                const showData = {
                    t_id: this.show.selectedTheatreId,
                    t_name: this.show.t_name,
                    current: this.show.current,
                    name: this.show.name,
                    rating: this.show.rating,
                    tag1: this.show.tag1,
                    tag2: this.show.tag2,
                    tag3: this.show.tag3,
                    price: this.show.price,
                    start: this.show.start,
                    duration: this.show.duration,
                    availability: this.show.availability,
                    image_url: this.show.image_url,
                };
                console.log(showData)
                await fetch(`${this.base_server_url}/api/show/create/`, {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                        'Authorization': `Bearer ${localStorage.access_token}`
                    },
                    body: JSON.stringify(showData),
                }).then(async resp => {
                    if (resp.ok) {
                        alert('Show added successfully!');

                        this.show.selectedTheatreId = null;
                        this.show.t_name = '';
                        this.show.current = false;
                        this.show.name = '';
                        this.show.rating = 0;
                        this.show.tag1 = '',
                        this.show.tag2 = '',
                        this.show.tag3 = '',
                        this.show.price = 100,
                        this.show.start = "00:00",
                        this.show.duration = 0,
                        this.show.availability = 0,
                        this.show.image = null,
                        this.show.image_url = ''
                        return resp.json();
                    } else {
                        const errorMessage = await resp.text();
                        throw new Error(`Failed to add show.\nRequest failed with status ${resp.status}: ${errorMessage}`);
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

        showSelectedTheatre() {
            if (this.show.selectedTheatreId == '') {
                console.log("Theatre doesn't exist!")
                return
            }
            const selectedTheatre = this.theatres.find(theatre => theatre.t_id === this.show.selectedTheatreId);
            console.log(this.show.selectedTheatreId)
            if (selectedTheatre) {
                const theatreName = selectedTheatre.name;
                const theatrePlace = selectedTheatre.place;
                const theatreCapacity = selectedTheatre.capacity;
                this.show.t_name = `${theatreName} (${theatrePlace})`
                this.show.availability = theatreCapacity
                console.log(this.show.t_name, "can seat ", this.show.availability, "people")
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
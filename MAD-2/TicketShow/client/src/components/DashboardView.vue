<!-- <template>
    <div>
        <div v-if="shows.length > 0">
            <div class="container">
                <p :class="{ 'highlighted': selectedElement === 'Today' }" @click="selectToday">Today</p>
                <p :class="{ 'highlighted': selectedElement === 'Tomorrow' }" @click="selectTomorrow">Tomorrow</p>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th></th>
                        <th>Tags</th>
                        <th>Rated</th>
                        <th></th>
                        <th>Starts at</th>
                        <th></th>
                        <th>Theatre</th>
                        <th></th>
                        <th>Available</th>
                        <th></th>
                        <th>#Seats</th>
                        <th>Price</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th>My Rating</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="show in shows" :key="show.s_id">
                        <td>
                            <img v-if="show.image_url" :src="getImageUrl(show.image_url)" alt="Show Image">
                            <div v-else>No Image Available</div>
                        </td>
                        <td>{{ show.name }}</td>
                        <td class="spacing-cell"></td>
                        <td>{{ alltags(show) }}</td>
                        <td>{{ show.rating }}/5</td>
                        <td class="spacing-cell"></td>
                        <td>{{ show.start }}</td>
                        <td class="spacing-cell"></td>
                        <td>{{ show.t_name }}</td>
                        <td class="spacing-cell"></td>
                        <td>{{ show.availability }}</td>
                        <td class="spacing-cell"></td>
                        <td contenteditable="true" @input="calculatePrice($event, show)" data-type="number">{{ show.seats }}
                        </td>
                        <td>{{ show.price }}</td>
                        <td><button @click="bookShow(show.s_id)">Book</button></td>
                        <td class="spacing-cell"></td>
                        <td class="spacing-cell"></td>
                        <td contenteditable="true" @input="rate_the_show($event, show)" data-type="number" min="1" max="5">{{ show.my_rating}}</td>
                        <td><button @click="rateShow(show.s_id)">Rate</button></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template> -->

<template>
    <div>
        <div v-if="shows.length > 0">
            <div class="row justify-content-center">
                <div class="col-6 text-center">
                    <p :class="{ 'highlighted': selectedElement === 'Today' }" @click="selectToday" class="fw-bold">Today
                    </p>
                </div>
                <div class="col-6 text-center">
                    <p :class="{ 'highlighted': selectedElement === 'Tomorrow' }" @click="selectTomorrow" class="fw-bold">
                        Tomorrow</p>
                </div>
            </div>
        </div>
        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Tags</th>
                    <th>Rated</th>
                    <th>Starts at</th>
                    <th>Theatre</th>
                    <th>Available</th>
                    <th>#Seats</th>
                    <th>Price</th>
                    <th></th>
                    <th></th>
                    <th>Your Rating</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="show in shows" :key="show.s_id">
                    <td>
                        <img v-if="show.image_url" :src="getImageUrl(show.image_url)" alt="Show Image">
                        <div v-else>No Image Available</div>
                    </td>
                    <td>{{ show.name }}</td>
                    <td>{{ alltags(show) }}</td>
                    <td>{{ show.rating }} / 5</td>
                    <td>{{ show.start }}</td>
                    <td>{{ show.t_name }}</td>
                    <td>{{ show.availability }}</td>
                    <td>
                        <div contenteditable="true" @input="calculatePrice($event, show)" data-type="number"
                            class="editable-cell">{{ show.seats }}</div>
                    </td>
                    <td>{{ show.price }}</td>
                    <td><button @click="bookShow(show.s_id)" class="btn btn-primary">Book</button></td>
                    <td>
                        <div contenteditable="true" @input="rate_the_show($event, show)" data-type="number" min="1" max="5"
                            class="editable-cell">{{ show.my_rating }}</div>
                    </td>
                    <td><button @click="rateShow(show.s_id)" class="btn btn-primary">Rate</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
  
<script>
import store from '../store';
export default {
    data() {
        return {
            shows: [],
            seats: 1,
            rating_show: null,
            rating: 0,
            date: new Date().toISOString(),
            selected_element: 'today'
        };
    },
    mounted() {
        this.base_server_url = this.$root.base_server_url
        this.base_client_url = this.$root.base_client_url
        this.$root.loggedInUser = localStorage.username;

        this.searchAllShows()
    },
    methods: {
        async searchAllShows() {
            const date = `${this.date.split('T')[0]} 00:00:00.000000`
            const payload = {
                t_id: null,
                date: date,
                user: localStorage.username
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
                    throw new Error(`Failed to find shows.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                }
            }).then(data => {
                this.shows = data.shows
                this.shows.forEach((show) => {
                    show.basePrice = show.price;
                });
                console.log(data.shows)
            }).catch(error => {
                alert(error.message);
                if (error.message.includes("Token has expired"))
                    this.$router.push({ name: 'login' })
            });
        },
        getImageUrl(image_url) {
            console.log(`${this.base_server_url}/${image_url}`)
            return `${this.base_server_url}/${image_url}`;
        },
        selectToday() {
            this.selectedElement = 'Today';
            this.date = new Date().toISOString()
            store.commit('setDate', this.date);
            this.searchAllShows()
        },
        selectTomorrow() {
            this.selectedElement = 'Tomorrow';
            const tomorrow = new Date();
            tomorrow.setDate(tomorrow.getDate() + 1);
            this.date = tomorrow.toISOString()
            store.commit('setDate', this.date);
            this.searchAllShows()
        },
        calculatePrice(event, show) {
            this.seats = parseInt(event.target.innerText);
            console.log(this.seats)
            if (Number.isInteger(this.seats) && this.seats >= 1)
                show.price = show.basePrice * this.seats;
            else
                event.target.innerText = ''
        },
        rate_the_show(event, show) {
            this.rating = parseInt(event.target.innerText)
            this.rating_show = show
        },
        async bookShow(showId) {
            const booking_date = store.state.date.split('T')[0]
            const booking_timestamp = store.state.date
            const booking_month = new Date(store.state.date).getMonth() + 1
            console.log("Store date", store.state.date)
            if (booking_timestamp === '') {
                alert("Please select booking date from top of this screen, before you proceed!")
                return
            }

            const show = this.shows.find((show) => show.s_id === showId);

            if (!window.confirm(`You're booking ${this.seats} seats for "${show.name}" on ${booking_date} at ${show.start} hrs.  ` +
                `Are you sure?\n\nIMPORTANT: Please make sure you refresh the screen before you initiate booking!`))
                return

            // Don't proceed, if there aren't enough seats avaialble.
            if (show.availability - this.seats < 0) {
                alert("Not enough seats available for this show!")
                return
            }

            if (show) {
                const showData = {
                    u_id: localStorage.username,
                    s_id: show.s_id,
                    t_id: show.t_id,
                    date: booking_timestamp,
                    month: booking_month,
                    availability: show.availability,
                    seats: this.seats,
                    cost: show.price
                }

                const availabilityData = {
                    s_id: show.s_id,
                    t_id: show.t_id,
                    s_date: booking_date,
                    availability: show.availability - this.seats,
                }

                try {
                    const response = await fetch(`${this.base_server_url}/api/show/book/`, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                            'Access-Control-Allow-Origin': '*',
                            'Authorization': `Bearer ${localStorage.access_token}`
                        },
                        body: JSON.stringify(showData),
                    });

                    if (response.ok) {
                        const message = `${this.seats} seats booked for "${show.name}" on ${booking_date} at ${show.start} hrs`;

                        //Reduce availability for the corresponding show.  If the record is not present, add it.
                        const response = await fetch(`${this.base_server_url}/api/showdate/`, {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json',
                                'Access-Control-Allow-Origin': '*',
                                'Authorization': `Bearer ${localStorage.access_token}`
                            },
                            body: JSON.stringify(availabilityData),
                        });

                        if (response.ok) {
                            alert(`${message}.`);
                            show.availability = show.availability - this.seats
                        } else {
                            alert(`${message}.\n\nFailed to update show availability!`);
                        }
                    } else {
                        alert('Failed to book for the show!');
                    }
                } catch (error) {
                    alert(`${error}`);
                }
            }
        },
        async rateShow(showId) {
            console.log(showId)
            const show = this.shows.find((show) => show.s_id === showId);
            const booking_date = store.state.date.split('T')[0]
            let rating = show.rating

            if (show === this.rating_show) //if the current show is matching with the show which is rated.
                rating = this.rating

            const ratingData = {
                u_id: localStorage.username,
                s_id: show.s_id,
                t_id: show.t_id,
                s_date: booking_date,
                rating: rating
            }

            const response = await fetch(`${this.base_server_url}/api/rating/`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'Authorization': `Bearer ${localStorage.access_token}`
                },
                body: JSON.stringify(ratingData),
            });

            if (response.ok) {
                alert(`User rating for ${show.name} updated successfully!`);
            } else {
                alert(`Failed to update user rating!`);
            }
        }
    },
    computed: {
        alltags() {
            return (show) => {
                let tags = ''
                if (show.tag1 != '')
                    tags += show.tag1
                if (show.tag2 != '')
                    tags += ", " + show.tag2
                if (show.tag3 != '')
                    tags += ", " + show.tag3
                return tags
            }
        }
    }
}
</script>

<style>
.container {
    display: flex;
}

.container p {
    margin: 10px;
}

.highlighted {
    background-color: red;
}

td.spacing-cell {
    width: 20px;
}
</style>
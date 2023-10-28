<template>
    <div>
        <div v-if="theatres.length > 0">
            <table class="table">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Place</th>
                        <th>Capacity</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="theatre in theatres" :key="theatre.t_id">
                        <td>
                            <img v-if="theatre.image_url" :src="getImageUrl(theatre.image_url)" alt="Show Image"
                                class="img-fluid">
                            <div v-else>No Image Available</div>
                        </td>
                        <td>{{ theatre.name }}</td>
                        <td>{{ theatre.place }}</td>
                        <td>{{ theatre.capacity }}</td>
                        <td>
                            <button @click="exportTheatre(theatre.t_id)" class="btn btn-primary"
                                :disabled="shouldDisableButton(theatre.t_id)">
                                {{ export_button_text[theatre.t_id] }}
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
  
  <!-- <template>
    <div>
        <div v-if="theatres.length > 0">
            <table>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th></th>
                        <th>Name</th>
                        <th></th>
                        <th>Place</th>
                        <th></th>
                        <th>Capacity</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="theatre in theatres" :key="theatre.t_id">
                        <td>
                            <img v-if="theatre.image_url" :src="getImageUrl(theatre.image_url)" alt="Show Image">
                            <div v-else>No Image Available</div>
                        </td>
                        <td class="spacing-cell"></td>
                        <td>{{ theatre.name }}</td>
                        <td class="spacing-cell"></td>
                        <td>{{ theatre.place }}</td>
                        <td class="spacing-cell"></td>
                        <td>{{ theatre.capacity }}</td>
                        <td class="spacing-cell"></td>
                        <td><button @click="exportTheatre(theatre.t_id)">{{ export_button_text[theatre.t_id] }}</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template> -->

<script>
export default {
    data() {
        return {
            export_button_text: [],
            export_button_disabled: [],
            task_status: [],
            task_result: [],
            theatres: [],
        };
    },
    mounted() {
        this.base_server_url = this.$root.base_server_url
        this.base_client_url = this.$root.base_client_url
        this.$root.loggedInUser = localStorage.username;

        this.searchAllTheatres()
    },
    methods: {
        async searchAllTheatres() {
            const payload = {
            }
            fetch(`${this.base_server_url}/api/theatres/search/`, {
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
                    throw new Error(`Failed to find theatres.\nRequest failed with status ${resp.status}: ${errorMessage}`);
                }
            }).then(data => {
                this.theatres = data.theatres

                this.theatres.forEach((theatre) => {
                    this.export_button_text[theatre.t_id] = "Export"
                    this.theatres.forEach((theatre) => {
                        this.export_button_disabled[theatre.t_id] = false
                    });
                });
                // console.log(data.theatres)
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
        exportTheatre(t_id) {
            fetch(`${this.base_server_url}/export/${t_id}/`, {
                method: "GET",
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'Authorization': `Bearer ${localStorage.access_token}`
                }
            }).then(resp => {
                return resp.json()
            }).then(data => {
                const taskId = data['taskId'];
                this.pollTaskStatus(taskId, t_id);
            }),
                setTimeout(() => this.task_status[t_id] = null, 20000)
            setTimeout(() => { }, 20000)
        },
        pollTaskStatus(taskId, t_id) {
            fetch(`${this.base_server_url}/task_status/${taskId}/${t_id}/`, {
                method: "GET",
                headers: {
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': '*',
                    'Authorization': `Bearer ${localStorage.access_token}`
                }
            }).then(resp => {
                return resp.json()
            }).then(data => {
                const status = data.status
                if (status === 'SUCCESS') {
                    this.export_button_text[t_id] = "Completed"
                    this.export_button_disabled[t_id] = true
                } else if (status === 'PENDING' || status === 'STARTED') {
                    this.export_button_text[t_id] = "In progress"
                    this.export_button_disabled[t_id] = true
                    setTimeout(() => {
                        this.pollTaskStatus(taskId, t_id);
                    }, 2000); // Poll every 2 seconds
                }
            })
        },
        shouldDisableButton(t_id) {
            return this.export_button_disabled[t_id]
        }
    },
}
</script>

<style>
td.spacing-cell {
    width: 20px;
}
</style>
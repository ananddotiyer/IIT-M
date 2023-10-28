<template>
    <div>
        <h1>{{ message }}</h1>
        <child />
    </div>
</template>
  
<script>
import Child from './Child.vue';

export default {
    components: {
        Child
    },
    data() {
        return {
            message: 'Hello from parent component'
        }
    }
}
</script>

<template>
    <div>
        <button @click="updateParentMessage">Update parent message</button>
    </div>
</template>
  
<script>
export default {
    methods: {
        updateParentMessage() {
            this.$parent.message = 'New message from child component';
        }
    }
}
</script>

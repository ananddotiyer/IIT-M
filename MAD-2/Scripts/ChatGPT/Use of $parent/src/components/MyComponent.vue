<template>
    <div>
        <p>{{ message }}</p>
    </div>
</template>
  
<script>
export default {
    name: 'MyComponent',
    data() {
        return {
            message: 'Welcome to my Vue.js app!'
        };
    }
};
</script>

<!-- In the above example, MyComponent.vue contains a simple template that displays a message. 
The JavaScript code defines a data method that returns an object with the message property. -->
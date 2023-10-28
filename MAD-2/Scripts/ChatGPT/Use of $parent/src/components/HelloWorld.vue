<template>
    <div>
        <h1>{{ greeting }}</h1>
    </div>
</template>
  
<script>
export default {
    name: 'HelloWorld',
    data() {
        return {
            greeting: 'Hello, world!'
        };
    }
};
</script>

<!-- In the above example, HelloWorld.vue contains a simple template that displays a greeting. 
The JavaScript code defines a data method that returns an object with the greeting property. -->
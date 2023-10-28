<template>
    <div class="app">
        <img alt="Vue logo" src="./assets/logo.png">
        <!-- <hello-world />
        <my-component /> -->
        <parent />
    </div>
</template>
  
<script>
import HelloWorld from './components/HelloWorld.vue';
import MyComponent from './components/MyComponent.vue';
import Parent from './components/Parent.vue';

export default {
    name: 'App',
    components: {
        HelloWorld,
        MyComponent,
        Parent
    }
};
</script>
  
<style>
.app {
    font-family: Arial, Helvetica, sans-serif;
    text-align: center;
}
</style>
  
<!-- In the above example, App.vue contains the main template for the application, 
which includes an image and two child components (HelloWorld and MyComponent). 
The JavaScript code imports these child components and registers them with the 
root component using the components option. The name option specifies the 
name of the component, which is used in the template. -->
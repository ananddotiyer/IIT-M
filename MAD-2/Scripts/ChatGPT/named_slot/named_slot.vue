<template>
  <div>
    <h1>{{ title }}</h1>
    <slot name="content"></slot>
  </div>
</template>

<script>
export default {
  name: 'MyNamedSlot',
  props: {
    title: String
  }
}
</script>
  
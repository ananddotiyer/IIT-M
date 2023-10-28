<template>
    <div>
        <MyNamedSlot title="Hello">
            <p>This is some content that will be inserted into the named slot.</p>
        </MyNamedSlot>
    </div>
</template>
  
<script>
import MyNamedSlot from 'named_slot.vue'

export default {
    components: {
        MyNamedSlot
    }
}
</script>
  
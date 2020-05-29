<template>
    <div>
        <Top></Top>
        <Menu></Menu>
    </div>
</template>

<script>
    import Top from '../top/Top'
    import Menu from '../menu/AdminMenu'
    export default {
        name: "AdminMain",
        components:{
            Top,
            Menu
        }
    }
</script>

<style scoped>

</style>
<template>
    <div>
        <Top></Top>
        <Menu></Menu>
    </div>

</template>

<script>
    import Top from '../top/Top'
    import Menu from '../menu/StudentMenu'
    export default {
        name: "StudentMain",
        components:{
            Top,
            Menu
        }
    }
</script>

<style scoped>

</style>
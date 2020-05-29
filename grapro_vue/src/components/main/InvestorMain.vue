<template>
    <div>
        <Top></Top>
        <Menu></Menu>
    </div>
</template>

<script>
    import Top from '../top/Top'
    import Menu from '../menu/InvestorMenu'
    export default {
        name: "InvestorMain",
        components:{
            Top,
            Menu
        }
    }
</script>

<style scoped>

</style>
<template>
    <div>
        <Head :index="activeIndex"></Head>
        首页
    </div>
</template>

<script>
    import Head from '../head/Head'
    export default {
        name: "index",
        data(){
            return{
                activeIndex: '3'
            }
        },
        components: {
            Head
        }
    }
</script>

<style scoped>

</style>
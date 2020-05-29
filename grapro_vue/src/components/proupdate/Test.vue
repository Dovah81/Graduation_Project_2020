<template>
    <div>
        <ProUpdate></ProUpdate>
        <el-button type="primary" @click="ret" >返回</el-button>
    </div>
</template>

<script>
    import ProUpdate from "@/components/proupdate/ProUpdate";
    export default {
        name: "Test",
        components:{
            ProUpdate
        },
        methods:{
            ret(){
                this.$router.push("/investor/investedpro")
            }
        }
    }
</script>

<style scoped>

</style>
<template>
    <div>
        <el-radio-group v-model="radio">
            <el-radio :label="0">学生</el-radio>
            <el-radio :label="1">融资人</el-radio>
        </el-radio-group>
    </div>
</template>

<script>
    export default {
        name: "Register",
        data(){
            return{
                radio:0
            }
        }
    }
</script>

<style scoped>

</style>
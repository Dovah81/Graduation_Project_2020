<template>
    <div>
        <el-row class="tac">
            <el-col :span="3">
                <h3>项目管理</h3>
                <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo menu"
                        @open="handleOpen"
                        @close="handleClose" >
                    <el-menu-item index="1">
                        <i class="el-icon-setting"></i>
                        <span slot="title" @click="checkpro">项目申请审核</span>
                    </el-menu-item>
                    <el-menu-item index="2">
                        <i class="el-icon-setting"></i>
                        <span slot="title" @click="studentpro">学生项目管理</span>
                    </el-menu-item>
                    <el-menu-item index="3">
                        <i class="el-icon-setting"></i>
                        <span slot="title" @click="studentmes">学生信息查看</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                        <i class="el-icon-setting"></i>
                        <span slot="title" @click="data">数据统计查看</span>
                    </el-menu-item>
                    <el-menu-item index="5">
                        <i class="el-icon-setting"></i>
                        <span slot="title" @click="logout">退出</span>
                    </el-menu-item>

                </el-menu>
            </el-col>
            <el-col :span="21">
                <router-view></router-view>
            </el-col>
        </el-row>
    </div>
</template>

<script>
    export default {
        name: "AdminMenu",
        methods:{
            checkpro(){
                this.$router.push("/admin/checkpro")
            },
            studentpro(){
                this.$router.push("/admin/studentpro")
            },
            studentmes(){
                this.$router.push("/admin/studentmes")
            },
            data(){
                this.$router.push("/admin/data")
            },
            logout(){
                this.$router.push("/login")
            }
        }
    }
</script>

<style scoped>

</style>
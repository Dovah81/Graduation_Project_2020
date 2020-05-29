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
                        <span slot="title" @click="investreq">我的融资申请</span>
                    </el-menu-item>
                    <el-menu-item index="2">
                        <i class="el-icon-setting"></i>
                        <span slot="title" @click="investpro">融资项目管理</span>
                    </el-menu-item>
                    <el-menu-item index="3">
                        <i class="el-icon-setting"></i>
                        <span slot="title" @click="allpro">发现项目</span>
                    </el-menu-item>
                    <el-menu-item index="4">
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
        name: "InvestorMenu",
        methods:{
            investreq(){
                this.$router.push("/investor/investreq")
            },
            investpro(){
                this.$router.push("/investor/investedpro")
            },
            allpro(){
                this.$router.push("/investor/allpro")
            },
            logout(){
                this.$router.push("/login")
            }
        }
    }
</script>

<style scoped>

</style>
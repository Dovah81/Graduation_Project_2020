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
                        <i class="el-icon-location"></i>
                        <span slot="title" @click="crepro">创建项目</span>
                    </el-menu-item>
                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>我的项目</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="1-1" @click="checkedpro">已审核项目</el-menu-item>
                            <el-menu-item index="1-2" @click="uncheckedpro">未审核项目</el-menu-item>
                            <el-menu-item index="1-3" @click="joinedpro">加入的项目</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>申请审核</span>
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="2-1" @click="promember">项目加入申请</el-menu-item>
                            <el-menu-item index="2-2" @click="proinvestment">项目融资申请</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-menu-item index="4">
                        <i class="el-icon-setting"></i>
                        <span slot="title" @click="allpro">发现项目</span>
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
        name: "menu",
        methods: {
            crepro(){
                this.$router.push("/student/createpro")
            },
            checkedpro(){
                this.$router.push("/student/checkedpro")
            },
            uncheckedpro(){
                this.$router.push("/student/uncheckedpro")
            },
            joinedpro(){
                this.$router.push("/student/joinedpro")
            },
            promember(){
                this.$router.push("/student/promember")
            },
            proinvestment(){
                this.$router.push("/student/proinvestment")
            },
            allpro(){
                this.$router.push("/student/allpro")
            },
            logout(){
                this.$router.push("/login")
            }
        }
    }
</script>

<style scoped>
    .menu {
        min-height: 500px;
    }
</style>
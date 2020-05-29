<template>
    <div class="home">
            <header>
                <div class="logo">
                    <div class="adv"></div>
                    <div class="title">大学生创业系统</div>
                </div>
                <div class="info" id="test">
                    <div class="child current">
                        <div class="date"></div>
                        <div class="time">
                            <div class="user">
                                欢迎！{{user.name}}
                            </div>
                        </div>
                    </div>
                </div>
            </header>
    </div>
</template>

<script>
    import {getUser} from "../../common/js/cache";

    '../../common/js/cache'
    export default {
        name: "top",
        data(){
            return{
                user: {

                }
            }
        },
        created(){
            this.user = getUser()
        }
    }
</script>

<style scoped>
    *{
        margin: 0;
        padding: 0;
    }
    header{
        height: 90px;
        display: flex;
        justify-content: space-between;
        background: url("header.jpg") 0 0 no-repeat;
        background-size: 100% 100%;

    }
    header .logo{
        display: flex;
        margin-left: 30px;
        width: 40%;
        height: 90px;
        line-height: 90px;
        font-size: 26px;
        font-weight: bolder;
        color: rgb(255, 255, 255);

    }

    header .logo .title {
        margin-left: 5px;
    }

    header .logo .adv {
        width: 40px;
        height: 90px;
        /*background: url('../../assets/logo.png') no-repeat center center;*/
    }

    header .info {
        width: 20%;
        display: flex;
        flex-wrap: wrap;
        justify-content: flex-end;
        align-items: center;
    }
    header .info .child{
        width: 60%;
        text-align: right;
    }
    .child.user{
        font-size: 24px;
        font-weight: 400;
    }

    .time {
        display: flex;
        height: 90px;
        line-height: 90px;
    }

    .time .user {
        padding: 5px 0 0 5px;
    }

    .time .userinfo-inner {
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        color: #fff;
    }

</style>
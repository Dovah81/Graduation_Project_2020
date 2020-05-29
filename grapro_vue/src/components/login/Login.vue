<template>
    <div>
        <Head :index="activeIndex"></Head>
        <div class="wrap">
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="用户名">
                    <el-input v-model="form.id"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input  type= password v-model="form.password"></el-input >
                </el-form-item>
                <el-radio-group v-model="radio" style="margin: 10px auto;">
                    <el-radio :label="0">学生</el-radio>
                    <el-radio :label="1">融资人</el-radio>
                    <el-radio :label="2">学校</el-radio>
                </el-radio-group>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit" >登录</el-button>
                </el-form-item>
            </el-form>

        </div>
    </div>
</template>

<script>
    import {HOST} from '../../common/js/config'
    import {saveUser} from '../../common/js/cache'
    import Head from '../head/Head'
    export default {
        name: "login",
        data(){
            return{
                activeIndex: '3',
                form: {
                    id: '',
                    password: ''
                },
                radio:0
            }
        },
        components: {
            Head
        },
        methods:{
            onSubmit(){
                let url = "";
                switch(this.radio){
                    case 0:
                        url = `${HOST}/student/login`;
                        break;
                    case 1:
                        url = `${HOST}/investor/login`;
                        break;
                    case 2:
                        url = `${HOST}/admin/login`;
                }
                console.log(url);
                this.$ajax.post(url,this.form).then((res)=>{
                    let result = res.data
                    switch (result.code){
                        case 0: //成功
                            console.log(result.object)
                            saveUser(result.object)
                            switch(this.radio){
                                case 0:
                                    this.$router.push("/student")
                                    break;
                                case 1:
                                    this.$router.push("/investor")
                                    break;
                                case 2:
                                    this.$router.push("/admin")
                            }
                            break;
                        default: //失败
                            this.$message(result.msg)
                    }
                })
            },
            Register(){
                this.$router.push("/register")
            }
        }
    }
</script>

<style scoped>
    .wrap {
        width: 500px;
        height: 1000px;
        margin: 10px auto;
    }
</style>
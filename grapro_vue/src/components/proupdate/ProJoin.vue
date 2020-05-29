<template>
    <div>
        <div class="wrap">
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="项目名称" prop="name">
                    <el-col :span="12">
                        <el-input v-model="form.name" ></el-input>
                    </el-col>
                </el-form-item>
                <el-form-item label="项目类型" prop="type">
                    <el-input  v-model="form.type" ></el-input >
                </el-form-item>
                <el-form-item label="项目简介" prop="intro">
                    <el-input type="textarea" rows="10"  v-model="form.intro" ></el-input >
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit" :disabled="this.user.ifchecked==0">申请加入</el-button>
                    <el-button  @click="ret" >返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    import {HOST} from "@/common/js/config";
    import {getUser} from "../../common/js/cache";

    '../../common/js/cache'

    export default {
        name: "ProJoin",
        data(){
            return{
                user:{

                },
                form: {
                    name: '',
                    type: '',
                    intro:'',
                    studentId:''
                },
                rules:{
                    name: [
                        { required: true, message: '请输入项目名', trigger: 'blur' },
                    ],
                    type: [
                        { required: true, message: '请输入项目类型', trigger: 'blur' },
                    ],
                    intro: [
                        { required: true, message: '请输入项目介绍', trigger: 'blur' },
                    ]
                },
                req:{
                    projectId:'',
                    studentId:''
                }

            }
        },
        created(){
            this.user = getUser()
            this.form.id = this.$route.params.id
            this.req.projectId=this.$route.params.id
            this.req.studentId=this.user.id
            this.getData()
        },
        methods: {
            //根据ID获取数据
            getData() {
                let url = `${HOST}/project/sel/${this.form.id}`;
                this.$ajax.get(url).then((res) => {
                    this.form = res.data
                })
            },
            onSubmit() {
                let url = `${HOST}/projectMember/joinProject`;
                this.$ajax.post(url, this.req).then((res) => {
                    let result = res.data
                    switch (result.code) {
                        case 0: //成功
                            this.$message(result.msg);
                            break;
                        case -1:
                            this.$message(result.msg);
                            break;
                        default: //成功
                            this.$message(result.msg);
                            this.$router.push("/student")
                    }

                })
            },
            ret(){
                this.$router.push("/student/allpro")
            }
        }
    }
</script>
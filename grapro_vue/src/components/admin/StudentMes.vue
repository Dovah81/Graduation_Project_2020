<template>
    <div class="wrap">
        <el-table
                @row-click="ShowMes"
                :data="pageInfo.list"
                border
                style="width: 100%">
            <el-table-column
                    type="index"
                    label="编号"
                    width="50">
            </el-table-column>
            <el-table-column
                    prop="id"
                    label="学生编号"
                    width="50">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="学生姓名"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="intro"
                    label="学生信息"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="age"
                    label="年龄"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="phone"
                    label="联系电话"
                    width="120">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.row.id)">查看详情</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import {HOST} from '../../common/js/config'
    import {getUser} from "@/common/js/cache";

    '../../common/js/cache'
    export default {

        name: "StudentMes",
        data(){
            return{
                user:{

                },
                path: '',
                currPage: 1,   //当前页,
                pageInfo: {}  //查询的数据
            }
        },
        created(){
            this.user = getUser()
            this.path = HOST
            this.getData()
        },
        methods: {
            getData() {
                let url = `${HOST}/admin/list/studentMes/${this.currPage}`
                this.$ajax.post(url,this.user).then(res => {
                    this.pageInfo = res.data
                })
            },
            ShowMes(val){
                let thisRowData=this;
                thisRowData=val;
                console.log(thisRowData);
            },
            handleEdit(id){
                let url = `/student/sel/${id}`
                this.$router.push(url)
            }
        },
    }
</script>

<style scoped>

</style>
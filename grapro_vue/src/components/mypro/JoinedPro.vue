<template>
    <div class="wrap">
        <el-table
                :data="pageInfo.list"
                border
                style="width: 100%">
            <el-table-column
                    type="index"
                    label="编号"
                    width="50">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="项目名称"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="type"
                    label="项目类型"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="cretime"
                    label="创建时间"
                    width="120"
                    :formatter="dateFormatter">
            </el-table-column>
            <el-table-column
                    prop="ifchecked"
                    label="是否通过审核"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="message"
                    label="审核信息"
                    width="120">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.row.id)">编辑</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
    import {HOST} from '../../common/js/config'
    import {makeSimpleDate} from '../../common/js/dateformat'
    import {getUser} from "@/common/js/cache";

    '../../common/js/cache'

    export default {
        name: "JoinedPro",
        data(){
            return {
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
                let url = `${HOST}/project/list/joined/${this.currPage}`
                this.$ajax.post(url,this.user).then(res => {
                    this.pageInfo = res.data
                    console.log(this.pageInfo)
                })
            },
            dateFormatter(row, column, cellValue){
                return makeSimpleDate(cellValue)
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
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
                            @click="agreee(scope.row.id)">查看</el-button>
                    <el-button
                            size="mini"
                            @click="agree(scope.row.id)">同意</el-button>
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
        name: "CheckPro",
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
                let url = `${HOST}/project/list/tocheck/${this.currPage}`
                this.$ajax.post(url,this.user).then(res => {
                    this.pageInfo = res.data
                    console.log(this.pageInfo)
                })
            },
            dateFormatter(row, column, cellValue){
                console.log(cellValue)
                return makeSimpleDate(cellValue)
            },
            agree(id){
                let url = `${HOST}/project/agree/${id}`;
                this.$ajax.get(url).then((res) => {
                    let result = res.data
                    this.$message(result.msg)
                })
            }
        },

    }
</script>

<style scoped>

</style>
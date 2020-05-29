<template>
    <div class="wrap">
        <div>融资申请管理</div>
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
                    prop="projectId"
                    label="项目编号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="investorId"
                    label="申请人编号"
                    width="120">
            </el-table-column>
            <el-table-column
                    prop="amount"
                    label="金额"
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
                    label="审核状态"
                    width="120">
            </el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="agree(scope.row.id)"
                            :disabled="scope.row.ifchecked!=0">同意</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            @click="disagree(scope.row.id)"
                            :disabled="scope.row.ifchecked!=0">拒绝</el-button>
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
        name: "ProInvestment",
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
                let url = `${HOST}/projectInvestment/list/checkS/${this.currPage}`
                this.$ajax.post(url,this.user).then(res => {
                    this.pageInfo = res.data
                })
                console.log(this.pageInfo.list)
            },
            dateFormatter(row, column, cellValue){
                return makeSimpleDate(cellValue)
            },
            agree(id){
                let url = `${HOST}/projectInvestment/agree/${id}`;
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
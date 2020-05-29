<template>
    <div class="wrap" >
        <div id="myChart" class="bar"></div>
    </div>
</template>

<script>
    import {HOST} from '../../common/js/config'
    import {getUser} from '../../common/js/cache'
    //import {echarts} from 'echarts'
    export default {
        data() {
            return {
                records: [],
                months: [],
                nums: [],
                formInline: {
                    year: '2020',
                    userId: ''
                }
            }
        },
        mounted(){
            this.formInline.userId = getUser().id
            this.drawLine();
        },
        methods:{
            drawLine(){
                // 基于准备好的dom，初始化echarts实例
                let myChart = this.$echarts.init(document.getElementById('myChart'))
                this.drawChart(myChart);
                myChart.showLoading();// 加载动画
                 let path = `${HOST}/project/monthNum`
                 this.$ajax.post(path,this.formInline).then((res)=> {
                     this.records = res.data
                     this.records.forEach((item) => {
                         this.months.push(item.month + '月') //构造x轴数据
                         this.nums.push(item.num) //构造y轴数据
                     })
                     myChart.hideLoading();
                     // 填入数据
                     myChart.setOption({
                         xAxis: {
                             data: this.months
                         },
                         series: [{
                             name: '数量',
                             data: this.nums
                         }]
                     });
                 })

            },
            drawChart(myChart){

                //指定图表配置项和数据
                var option = {
                    //标题
                    title : {
                        text : `2020年新建项目数`,
                        left : 150,//距离左边的像素值
                        borderColor : '#ff4b2d',
                        borderWidth : 1

                    },
                    color: ['#ed0c1b'],
                    tooltip : {
                        trigger: 'axis',
                        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    //工具箱
                    toolbox:{
                        show:true,
                        feature:{
                            saveAsImage:{
                                show:true
                            },
                            dataView:{
                                show:true
                            },
                            restore:{
                                show:true
                            },
                            dataZoom:{
                                show:true
                            },
                            magicType:{
                                type:['bar','line']
                            }
                        }
                    },
                    //图例
                    legend:{
                        data:['数量']
                    },
                    //x轴
                    xAxis : {
                        type : 'category',
                        data : [],
                        axisLabel:{
                            interval:0,//全部显示x轴
                            rotate:-30//-30度倾斜显示
                        },
                        axisTick: {
                            alignWithLabel: true
                        }
                    },
                    //y轴
                    yAxis : {
                        type : 'value'
                    },
                    //数据
                    series : {
                        name : '数量',
                        type : 'bar',//柱状图
                        data : []
                    },
                };
                myChart.setOption(option);

            }
        }

    }
</script>

<style scoped>
    .wrap {
        margin: 10px 0 0 10px;
        padding: 10px;
    }

    .wrap .bar{
        margin-top: 30px;
        width:800px;
        height:500px;
    }
</style>
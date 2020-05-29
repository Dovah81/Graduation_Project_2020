import Vue from 'vue'
import Router from 'vue-router'
import Index from '../components/index/Index'
import Login from '../components/login/Login'
import StudentMain from '../components/main/StudentMain'
import InvestorMain from '../components/main/InvestorMain'
import AdminMain from '../components/main/AdminMain'
import CreatePro from '../components/createpro/CreatePro'
import Register from '../components/register/Register'
import CheckedPro from '../components/mypro/CheckedPro'
import UncheckedPro from '../components/mypro/UncheckedPro'
import JoinedPro from '../components/mypro/JoinedPro'
import AllPro from '../components/allpro/AllPro'
import CheckPro from '../components/checkpro/CheckPro'
import ProMember from '../components/promanage/ProMember'
import ProInvestment from '../components/promanage/ProInvestment'
import ProUpdate from '../components/proupdate/ProUpdate'
import ProJoin from '../components/proupdate/ProJoin'
import Test from '../components/proupdate/Test'
import ProInvest from "../components/proupdate/ProInvest";
import InvestReq from "../components/investor/InvestReq";
import InvestedPro from "../components/investor/InvestedPro";
import StudentPro from "../components/admin/StudentPro";
import StudentMes from "../components/admin/StudentMes";
import Data from "../components/data/Data";

/*const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
    return originalPush.call(this, location).catch(err => err)
}*/
Vue.config.productionTip = false
Vue.use(Router)
//创建路由对象并配置路由
const router = new Router({
    routes: [
        {
            path: '/',
            component: Index
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '/register',
            component: Register
        },
        {
            path: '/student',
            component: StudentMain,
            children: [

                {
                    path: 'createpro',
                    component: CreatePro
                },
                {
                    path: 'checkedpro',
                    component: CheckedPro
                },
                {
                    path: 'uncheckedpro',
                    component: UncheckedPro
                },
                {
                    path: 'joinedpro',
                    component: JoinedPro
                },
                {
                    path: 'promember',
                    component: ProMember
                },
                {
                    path: 'proinvestment',
                    component: ProInvestment
                },
                {
                    path: 'allpro',
                    component: AllPro
                },
                {
                    path: 'checkpro',
                    component: CheckPro
                },
                {
                    path:'sel/:id',
                    component: ProUpdate
                },
                {
                    path:'join/:id',
                    component: ProJoin
                },
            ]
        },
        {
            path: '/investor',
            component: InvestorMain,
            children:[
                {
                    path: 'investreq',
                    component: InvestReq
                },
                {
                    path: 'investedpro',
                    component: InvestedPro
                },
                {
                    path: 'allpro',
                    component: AllPro
                },
                {
                    path:'join/:id',
                    component: ProInvest
                },
                {
                    path:'sel/:id',
                    component: Test
                },
            ]
        },
        {
            path: '/admin',
            component: AdminMain,
            children:[
                {
                    path: 'checkpro',
                    component: CheckPro
                },
                {
                    path: 'studentpro',
                    component: StudentPro
                },
                {
                    path: 'studentmes',
                    component: StudentMes
                },
                {
                    path: 'data',
                    component: Data
                }
        ]
        }
    ]
})
//导出路由对象
export default  router
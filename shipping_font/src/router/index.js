import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)


const Login = () => import('../components/Login')
const Center= () =>import('../components/center')

const routes = [
    { path: '/', component: Login,meta:{requireAuth:false}},
    { path: '/login', component: Login,meta:{requireAuth:false} },
    { path: '/center', component: Center,meta:{requireAuth:false} },
    { path: '/*', redirect: '/' }  // 当匹配不上时重定向的到首页
]



const router = new Router({
    routes,
    mode: "history"
})

router.beforeEach((to, from, next) => {
    var _this = this;
    if(to.meta.requireAuth ){
        if(JSON.parse(window.localStorage.getItem("admin_access"))==null){
            console.log('没有登录')
            router.push({path: '/ad_login',query: {}})
            next()
        } else {
            // router.push({path: to.fullPath})
            next()
        }
    }
    else {
        next();
    }
})

export default router

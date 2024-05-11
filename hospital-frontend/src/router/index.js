import Vue from "vue";
import VueRouter from "vue-router";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import "@/assets/css/global.css";
import Login from "@/views/Login.vue";
import AdminHome from "@/views/admin/AdminHome.vue";
import AdminUser from "@/views/admin/AdminUser.vue";
import DoctorUser from "@/views/doctor/DoctorUser.vue";
import Patient from "@/views/patient/PatientUser.vue";
import PatientList from "@/views/patient/PatientList.vue";
import DoctorList from "@/views/doctor/DoctorList.vue";
import DoctorList2 from "@/views/doctor/DoctorList2.vue";
import OrderList from "@/views/order/OrderList.vue";
import {getToken} from "@/utils/storage.js";
import OrderOperate from "@/views/order/OrderOperate.vue";
import SectionMessage from "@/views/section/SectionMessage.vue";
import MyOrder from "@/views/patient/MyOrder.vue";
import OrderToday from "@/views/order/OrderToday.vue";
import DealOrder from "@/views/doctor/DealOrder.vue";
import DrugList from "@/views/drug/DrugList.vue";
import DrugList2 from "@/views/drug/DrugList2.vue";
import CheckList from "@/views/check/CheckList.vue";
import CheckList2 from "@/views/check/CheckList2.vue";
import DiseaseList from "@/views/disease/DiseaseList.vue";
import DiseaseList2 from "@/views/disease/DiseaseList2.vue";
import ProductList from "@/views/product/ProductList.vue";
import ProductList2 from "@/views/product/ProductList2.vue";
import DoctorOrder from "@/views/doctor/DoctorOrder.vue";
import InBed from "@/views/bed/InBed.vue";
import ArrangeIndex from "@/views/arrange/ArrangeIndex.vue";
import SectionList from "@/views/section/SectionList.vue";
import QaList from "@/views/qa/QaList.vue";
import QaList1 from "@/views/qa/QaList1.vue";
import QaList2 from "@/views/qa/QaList2.vue";
import Health from "@/views/health/Health.vue";
import HealthDataList from "@/views/health/HealthDataList.vue";
import HealthDataList2 from "@/views/health/HealthDataList2.vue";

import DoctorHome from "@/views/doctor/DoctorHome.vue";
import PatientHome from "@/views/patient/PatientHome.vue";
import MyBed from "@/views/patient/MyBed.vue";
import BedList from "@/views/bed/BedList.vue";
import DataExpore from "@/views/DataExpore.vue";
import echarts from 'echarts';//引入echarts
import DealOrderAgain from "@/views/doctor/DealOrderAgain.vue";
import DoctorCard from "@/views/doctor/DoctorCard.vue";
import PatientCard from "@/views/patient/PatientCard.vue"

Vue.prototype.$echarts = echarts;//引入echarts
Vue.use(ElementUI);
Vue.use(VueRouter);

const routes = [
  {
    path: "*",
    redirect:"/login"

  },
  {
    path: "/login",
    //redirect: "/login",//设置默认跳转路径
    component: Login
  },
  {
    path: "/admin",
    component: AdminUser,
    meta: {
      requireAuth: true,
    },
    children:[
      {
        path: "/adminLayout",
        component: AdminHome,
        meta: {
          requireAuth: true,
        },
      },
      {
      path: "/doctorList",
      component: DoctorList,
      meta: {
        requireAuth: true,
      },
    },
    {
      path: "/patientList",
      component: PatientList,
      meta: {
        requireAuth: true,
      },
    },
    {
      path: "/qaList",
      component: QaList,
      meta: {
        requireAuth: true,
      },
    },
    {
      path: "/orderList",
      component: OrderList,
      meta: {
        requireAuth: true,
      },
    },
    {
      path: "/drugList",
      component: DrugList,
      meta: {
        requireAuth: true,
      },
    },
    {
      path: "/checkList",
      component: CheckList,
      meta: {
        requireAuth: true,
      },

    },
    {
      path: "/diseaseList",
      component: DiseaseList,
      meta: {
        requireAuth: true,
      },

    },
    {
      path: "/productList",
      component: ProductList,
      meta: {
        requireAuth: true,
      },

    },
    {
      path: "/Health",
      component: Health,
      meta: {
        requireAuth: true,
      },

    },
    {
      path: "/HealthDataList",
      component: HealthDataList,
      meta: {
        requireAuth: true,
      },

    },
    {
      path: "/bedList",
      component: BedList,
      meta: {
        requireAuth: true,
      },

    },
    {
      path: "/dataExpore",
      component: DataExpore,
      meta: {
        requireAuth: true,
      },

    },
    {
      path: "/arrangeIndex",
      component: ArrangeIndex,
      meta: {
        requireAuth: true,
      },
    },
    {
      path: "/sectionList",
      component: SectionList,
      meta: {
        requireAuth: true,
      },
    },
  ]
  },
  {
    path: "/patient",
    component: Patient,
    meta: {
      requireAuth: true,
    },
    children:[
      {
        path: "/patientLayout",
        component: PatientHome,
        meta: {
          requireAuth: true,
        },
      },
      {
        path: "/orderOperate",
        component: OrderOperate
      },
      {
        path: "/checkList2",
        component: CheckList2
      },
      {
        path: "/drugList2",
        component: DrugList2
      },
      {
        path: "/doctorList2",
        component: DoctorList2
      },
      {
        path: "/diseaseList2",
        component: DiseaseList2
      },
      {
        path: "/productList2",
        component: ProductList2
      },
      {
        path: "/healthDataList2",
        component: HealthDataList2
      },
      {
        path: "/sectionMessage",
        component: SectionMessage
      },
      {
        path: "/myOrder",
        component: MyOrder
      },
      {
        path: "/myBed",
        component: MyBed
      },
      {
        path: "/patientCard",
        component: PatientCard,
      },
      {
        path: "/qaList2",
        component: QaList2,
      }
    ]
  },
  {
    path: "/doctor",
    component: DoctorUser,
    meta: {
      requireAuth: true,
    },
    children:[
    {
      path: "/doctorLayout",
      component: DoctorHome,
      meta: {
        requireAuth: true,
      },
    },
    {
      path: "/orderToday",
      component: OrderToday,
    },
    {
      path: "/dealOrder",
      component: DealOrder
    },
    {
      path: "/dealOrderAgain",
      component: DealOrderAgain
    },
    {
      path: "/doctorOrder",
      component: DoctorOrder,
  },
  {
      path: "/inBed",
      component: InBed,
  },
  {
    path: "/doctorCard",
    component: DoctorCard,
  },
  {
    path: "/qaList1",
    component: QaList1,
  }
  ],

  }
];

const router = new VueRouter({
  routes
});
//没登录的情况下，访问任何一个页面都会返回登录页面
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    const token = getToken();
    if (token !== null) {
      //直接放行
      next();
  } else {
      next("/login");
    }
  }
  else{
    next();
  }
  });
export default router;

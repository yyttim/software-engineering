<template>
  <div :style="{ backgroundColor: 'lightblue' }">
    <el-container>

      <!-- 头部 -->
      <el-header>
        <div class="font_words">
          <span @click="menuClick('adminLayout')">
            <img src="../../assets/logo.jpg" style="width: 35px;position: relative; top: 8px;right: 6px"/>
             <span style="color: rebeccapurple;font-size: 20px">医院管理系统</span>
          </span>
        </div>

        <div class="font_words">
          <span>欢迎您，<b>{{ userName }}</b>&nbsp;病人&nbsp;</span>
          <span><el-button type="danger" round size="mini" @click="logoutPatient">退出</el-button></span>
        </div>
      </el-header>
        <el-container>
            <!-- 侧边栏 -->
            <el-aside width="220px">
                <!-- 导航菜单 -->
                <el-menu  background-color="lightblue"
                    text-color="black"
                    active-text-color="black"
                    :default-active="activePath"
                >

                  <el-menu-item  index="patientLayout"  @click="menuClick('patientLayout')">
                    <i class="iconfont icon-homepage-menu" style="font-size: 18px;color: #2b5d88"> 首页</i>
                  </el-menu-item>

                  <el-submenu index="sub-menu1">
                    <template slot="title">
                      <span style="font-size: 18px;color: #2b5d88">线上医疗服务</span>
                    </template>
                    <el-menu-item index="qaList2" @click="menuClick('qaList2')">
                      <i class="iconfont icon-qa" style="font-size: 18px;"> 在线咨询</i>
                    </el-menu-item>
                  </el-submenu>

                  <el-submenu index="sub-menu2">
                    <template slot="title">
                      <span style="font-size: 18px;color: #2b5d88">线下医疗服务</span>
                    </template>
                    <el-menu-item index="doctorList2" @click="menuClick('doctorList2')">
                      <i class="iconfont icon-doctor-menu" style="font-size: 18px;"> 专家列表</i>
                    </el-menu-item>
                    <el-menu-item index="orderOperate" @click="menuClick('orderOperate')">
                      <i class="iconfont icon-arrange-menu" style="font-size: 18px"> 预约挂号</i>
                    </el-menu-item>
                  </el-submenu>

                  <el-submenu index="sub-menu3">
                    <template slot="title">
                      <span style="font-size: 18px;color: #2b5d88">个性化健康推荐</span>
                    </template>
                    <el-menu-item index="healthDataList2" @click="menuClick('HealthDataList2')">
                      <i class="iconfont icon-health-data-list" style="font-size: 18px;"> 每日健康数据</i>
                    </el-menu-item>
                  </el-submenu>

                  <el-submenu index="sub-menu4">
                    <template slot="title">
                      <span style="font-size: 18px;color: #2b5d88">医疗信息查询</span>
                    </template>

                    <el-menu-item index="diseaseList2" @click="menuClick('diseaseList2')">
                      <i class="iconfont icon-disease-list" style="font-size: 18px;"> 疾病症状查询</i>
                    </el-menu-item>
                    <el-menu-item index="productList2" @click="menuClick('productList2')">
                      <i class="iconfont icon-product-list" style="font-size: 18px;"> 医疗产品查询</i>
                    </el-menu-item>
                    <el-menu-item index="drugList2" @click="menuClick('drugList2')">
                      <i class="iconfont icon-drug-menu" style="font-size: 18px;"> 药品信息查询</i>
                    </el-menu-item>
                    <el-menu-item index="checkList2" @click="menuClick('checkList2')">
                      <i class="iconfont icon-checks-menu" style="font-size: 18px;"> 检查项目查询</i>
                    </el-menu-item>
                  </el-submenu>

                  <el-submenu index="sub-menu5">
                    <template slot="title">
                      <span style="font-size: 18px;color: #2b5d88">我的信息查询</span>
                    </template>

                    <el-menu-item index="myOrder" @click="menuClick('myOrder')">
                      <i class="iconfont icon-orders-menu" style="font-size: 18px"> 挂号信息</i>
                    </el-menu-item>
                    <el-menu-item index="myBed" @click="menuClick('myBed')">
                      <i class="iconfont icon-bed-menu" style="font-size: 18px"> 住院信息</i>
                    </el-menu-item>
                    <el-menu-item index="patientCard"@click="menuClick('patientCard')">
                      <i class="iconfont icon-doctor-menu" style="font-size: 18px"> 个人信息</i>
                    </el-menu-item>
                  </el-submenu>

                </el-menu>
            </el-aside>
            <el-main>
                <!-- 子路由入口 -->
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
  </div>
</template>
<script>
import jwtDecode from "jwt-decode";
import {
    getToken,
    clearToken,
    getActivePath,
    setActivePath,
} from "@/utils/storage.js";
export default {
    name: "Patient",
    data() {
        return {
            userName: "",
            activePath: "",
        };
    },
    methods: {
        //token解码
        tokenDecode(token) {
            if (token !== null) return jwtDecode(token);
        },
        //导航栏点击事件
        menuClick(path) {
            this.activePath = path;
            setActivePath(path);
            if (this.$route.path !== "/" + path) this.$router.push(path);
        },
        //退出登录
        logoutPatient() {
            this.$confirm("此操作将退出登录, 是否继续?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning",
            })
            .then(() => {
                clearToken();
                this.$message({
                    type: "success",
                    message: "退出登录成功!",
                });
                this.$router.push("login");
            })
            .catch(() => {
                this.$message({
                    type: "info",
                    message: "已取消",
                });
            });
        },
    },
    created() {
        //获取激活路径
        this.activePath = getActivePath();
        //解码token
        this.userName = this.tokenDecode(getToken()).pName;
    },
};
</script>
<style scoped lang="scss">
.title {
    cursor: pointer;
}
.el-header {
    background-color: rgba(52, 114, 166, 0.18);
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid lightgrey;
    .font_words {
        text-align: center;
        span {
            color: black;
        }
    }
}
.el-container {
    height: 100%;
}
.el-aside {
    background-color: lightblue;
    border-right: 1px solid lightgrey;
}
.el-menu {
    border: 0;
}
</style>

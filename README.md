# 基于SpringBoot的医疗管理系统

## 在线访问地址和登录方式
### IP地址
http://8.130.95.239/

### 域名
se.yuntianyang.com（备案中，待开放访问）

### 测试账号（初始密码123456）
患者：2000
医生：1000
管理员：202401

## 本地部署说明
## 数据库配置
### 数据库文件
DB_Hospital.sql

## 数据库用户名和密码需设置
用户名：root
密码：123456

## 后端部署
### 准备环境
JDK,IDEA,Maven,Mysql,Navicat
### 启动步骤
1.打开IDEA后，选择"open"打开"hospital-backend"项目
2.IDEA配置好"JDK1.8"和"Maven",刷新等待编译成功
3.使用Navicat导入数据库文件DB_Hospital.sql
4.在"aplication.yml"中配置好数据库配置
5.启动后端SpringBoot工程
6.在Run/Debug Configureations中选择Application
7.在Build and run 中选择Java1.8，com.shanzhu.hospital.BackendApplication

## 前端部署
### 准备环境
Node 16.13.2， 或者更高的版本（可能出现不兼容编译失败的情况）
### 启动步骤
1.用 idea打开 "hospital-frontend" 目录
2.在"终端"执行命令：
npm config set registry https://registry.npmmirror.com
4.在"终端"执行命令：npm run dev 
4.启动完成后显示相关登录地址

## 本地访问地址
http://localhost:9282/#/login

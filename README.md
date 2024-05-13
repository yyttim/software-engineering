# 数据库配置：
## 数据库文件
DB_Hospital.sql

## 数据库用户名和密码需设置为：
用户名：root
密码：123456

# 部署
## 后端：
准备环境：
JDK,IDEA,Maven,Mysql,Navicat
启动步骤：
1.打开IDEA后，选择"open"打开"hospital-backend"项目
2.IDEA配置好"JDK1.8"和"Maven",刷新等待编译成功
3.使用Navicat导入数据库文件DB_Hospital.sql
4.在"aplication.yml"中配置好数据库配置
5.启动后端SpringBoot工程

在Run/Debug Configureations中选择Application
在Build and run 中选择Java1.8，com.shanzhu.hospital.BackendApplication

# 访问地址：
http://8.130.95.239/

# 前端:
## 准备环境：
Node 16.13.2， 或者更高的版本（可能出现不兼容编译失败的情况）
## 启动步骤
1、用 idea打开 "hospital-frontend" 目录
2、在"终端"执行命令：
npm config set registry https://registry.npmmirror.com
3、在"终端"执行命令：
npm run dev 
启动完成后显示相关登录地址

# 账号：
患者：2000/123456
医生：1000/123456
管理员：202401/123456

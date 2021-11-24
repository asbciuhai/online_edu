# 简介

该项目为 **在线教育平台** ，采用前后端分离，基于WEB的B/S应用开发的，涵盖Nginx和MySQL与JAVA编程技术，数据缓存方面多使用Redis进行重要信息的缓存，针对B/S的架构，可大量减少安装客户端的繁琐，也节省大量的人力物力对于后期系统的维护与升级。 此项目为学生课设项目。主要技术参考于尚硅谷的在线平台教育项目

技术较为薄弱 **仅供学习研究**

## 系统架构

![image-20211124230932144](https://github.com/XU-JIANLIN/online_edu/blob/main/image/image-20211124230932144.png)

## 系统流程图

![image-20211124231056391](https://github.com/XU-JIANLIN/online_edu/blob/main/image/image-20211124231056391.png)
## 支付模块

![image-20211124231204971](https://github.com/XU-JIANLIN/online_edu/blob/main/image/image-20211124231204971.png)
## 单点登录模块

![image-20211124231226746](https://github.com/XU-JIANLIN/online_edu/blob/main/image/image-20211124231226746.png)



## 项目运行

### 所需组件

- IDEA
- MYSQL
- MAVEN
- REDIS
- SpringBoot + SpringCloud + Mybatis Plus +Swagger2.0 
- 阿里云OSS（需申请）
- 阿里云视频点播（需申请）
- 阿里云沙箱支付（需申请）

### 启动项目

- 通过IDEA打开，通过MAVEN下载依赖，并修改配置文件
  - online_edu_common     ——通用配置模块，无配置文件修改
  - online_edu_eureka         ——注册中心，可配置注册中心地址（默认不修改）
  - online_edu_gateway       ——网关，配置拦截的URL（默认不修改）
  - online_edu_gdpuxjl         ——主要业务模块 # TODO:需修改数据库账号密码
  - online_edu_payserive     ——支付模块，# TODO： 需修改支付宝账号信息，需修改数据库账号密码
  - online_edu_ucenterservice  —— # TODO: 需修改数据库账号密码，微信小程序或微博APPID信息
  - online_edu_vodservice     ——视频点播模块： # TODO: 需修改阿里云视频点播账号

- 先启动打开redis
- 项目启动顺序![image-20211124234656746](https://github.com/XU-JIANLIN/online_edu/blob/main/image/image-20211124234656746.png)

​	账号：数据库表 edu_member

​	密码：123456

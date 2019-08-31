# gmall
谷粒谷粒

# 技术栈
- redis
- Elastic search(kibana)
- SSO单点登录
- fastdfs分布式文件存储
- ActiveMQ
- 支付宝支付
- mysql
- Mybatis(通用mapper)
- Spring + SpringBoot
- Nginx
- apache web server
- idea
- maven
- dubbo(fastjson)  [如果是springcloud,用Gson]
- git
- docker + k8s云容器部署
- nodejs + vue.s + jquery + js + html
- thymeleaf


# 约定
- 基于springboot2.1.7
# - gmall-user(用户服务)port:8081 ==> ip: user.gmall.com [废弃] 
- gmall-user-service(用户服务service层)port:8082
- gmall-user-web(用户服务web层)port:8081 ==> ip: user.gmall.com 


- gmall-manage-service(后台界面系统服务service层)port:8084
- gmall-manage-web(后台界面系统服务web层)port:8083 ==> ip: manage.gmall.com 



# 注意点
## nginx 配置 80
[nginx 配置 80](https://github.com/nbchen/gmall/blob/assets/nginx配置80端口.md.md)

## 通用mapper
[通用mapper使用注意](https://github.com/nbchen/gmall/blob/assets/通用mapper使用注意.md)

## linux环境搭建
[linux-关闭防火墙](https://github.com/nbchen/gmall/blob/assets/linux-关闭防火墙.md);
[linux-安装dubbo-admin](https://github.com/nbchen/gmall/blob/assets/linux-安装dubbo-admin.md);
[linux-安装jdk](https://github.com/nbchen/gmall/blob/assets/linux-安装jdk.md);
[linux-安装tomcat](https://github.com/nbchen/gmall/blob/assets/linux-安装tomcat.md);
[linux-安装zookeeper](https://github.com/nbchen/gmall/blob/assets/linux-安装zookeeper.md);
[linux-安装文件上传插件](https://github.com/nbchen/gmall/blob/assets/linux-安装文件上传插件.md);




# 启动
window::
1. 配置hosts
2. 配置nginx并启动 
linux::192.168.17.146
0. 配置jdk (rz上传安装,防火墙关闭)
1. 配置redis (开机自启动)
2. 配置tomcat:dubbo-admin,启动服务监控中心 (开机自启动) 192.168.17.146:8080/dubbo,登录:root/root
3. 配置zookeeper服务注册中心 (开机自启动)  
4
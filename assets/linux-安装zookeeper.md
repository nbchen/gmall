前提:jdk
# 安装
- 解压：tar -zxf zookeeper-3.4.11.tar.gz
- 改名: mv zookeeper-3.4.11/ zookeeper
- 创建目录：mkdir data
- 进入conf目录下：cd conf
- 复制模板生成cfg配置文件: cp zoo_sample.cfg zoo.cfg
- 修改dataDir=/usr/local/apps/zookeeper/data

# zookeeper开机启动
`vim /etc/init.d/zookeeper`
- 脚本：
```markdown
#!/bin/bash
#chkconfig:2345 20 90
#description:zookeeper
#processname:zookeeper
ZK_PATH=/usr/local/apps/zookeeper
export JAVA_HOME=/usr/local/apps/jdk1.8.0_181
case $1 in
         start) sh  $ZK_PATH/bin/zkServer.sh start;;
         stop)  sh  $ZK_PATH/bin/zkServer.sh stop;;
         status) sh  $ZK_PATH/bin/zkServer.sh status;;
         restart) sh $ZK_PATH/bin/zkServer.sh restart;;
         *)  echo "require start|stop|status|restart"  ;;
esac
```

- 注册并配置开机启动文件的权限
```markdown
chkconfig --add zookeeper
chmod +x zookeeper
```

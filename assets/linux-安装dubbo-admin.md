
# dubbo-admin开机启动
`vim /erc/init.d/dubbo-admin`

- 脚本:
```markdown
#!/bin/bash
#chkconfig:2345 20 90
#description:dubbo-admin
#processname:dubbo-admin
CATALANA_HOME=/usr/local/apps/apache-tomcat-8.5.24
export JAVA_HOME=/usr/local/apps/jdk1.8.0_181
case $1 in
start)  
    echo "Starting Tomcat..."  
    $CATALANA_HOME/bin/startup.sh  
    ;;  
  
stop)  
    echo "Stopping Tomcat..."  
    $CATALANA_HOME/bin/shutdown.sh  
    ;;  
  
restart)  
    echo "Stopping Tomcat..."  
    $CATALANA_HOME/bin/shutdown.sh  
    sleep 2  
    echo  
    echo "Starting Tomcat..."  
    $CATALANA_HOME/bin/startup.sh  
    ;;  
*)  
    echo "Usage: tomcat {start|stop|restart}"  
    ;; esac
```

- 注册并配置开机启动文件的权限
```markdown
chkconfig --add dubbo-admin
chmod +x dubbo-admin
```
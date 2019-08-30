
- 解压：
```markdown
tar -zxvf apache-tomcat-8.5.24.tar.gz
```
- 启动：
```markdown
cd  /apache-tomcat-8.5.24/bin/
./startup.sh 或者 sh startup.sh
```
- 查看日志：
```markdown
tail -f tomcat/logs/catalina.out
```
- 启动+日志： 
```markdown
tomcat/bin/startup.sh & tailf tomcat/logs/catalina.out
```
- tomcat 部署dubbo-admin
```markdown
<Context path="/dubbo" docBase="/usr/local/apps/dubbo" debug="0" privileged="true" />
```


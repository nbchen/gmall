# 查询卸载openjdk
```markdown
    rpm -qa | grep java
    rpm -e --nodeps  tzdata-java-2013g-1.el6.noarch
    rpm -e --nodeps  java-1.7.0-openjdk-1.7.0.45-2.4.3.3.el6.x86_64
    rpm -e --nodeps  java-1.6.0-openjdk-1.6.0.0-1.66.1.13.0.el6.x86_64
```
# 安装sunjdk
- 安装目录：`/usr/local/apps/java`
- 解压: `tar -zxvf jdk-8u181-linux-x64.tar.gz`
- 配置环境变量: `vi /etc/profile`
```markdown
    export JAVA_HOME=/usr/local/apps/jdk1.8.0_181 # 当前解压jdk的路径
    export PATH=$PATH:$JAVA_HOME/bin
    export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
    export JAVA_HOME PATH CLASSPATH
```  
- 重新编译: `source /etc/profile`
- 测试: `java -version`
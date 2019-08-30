## 通用mapper
- 主键返回策略
```java
@Table(name = "ums_member") // 指定目标数据库表的表名
@Id
@KeySql(useGeneratedKeys = true) // 主键返回策略
```
- mapper路径扫描包选择
```java
import tk.mybatis.spring.annotation.MapperScan;
@MapperScan(basePackages = "com.nbchen.gmall.user.mapper") // mapper注入扫描,集成通用mapper注意引tk下的包
```


- 配置SQL输入到控制台
> 不配置的haulmybatis Log插件也没有不会显示SQL
```yaml
# 日志级别
logging:
  level:
    root: debug
```
这样log太多太细了,我们要针对mapper包debug
```yaml
# 日志级别
logging:
  level:
    com.nbchen.gmall.user.mapper.*: debug
```



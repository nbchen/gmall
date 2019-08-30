```markdown
1 spring的Service改为dubbo的service
2将autowired改为reference
3 dubbo在进行dubbo协议通讯时，需要实现序列化接口(封装的数据对象)
4 dubbo的consumer在三秒钟之内每间隔一秒进行一次重新访问，默认一秒钟超时，三次访问之后会直接抛超时异常，所以我们在开发阶段，可以将consumer设置的超时时间延长，方便断点调试
# 设置超时时间
spring.dubbo.consumer.timeout=600000
# 设置是否检查服务存在
spring.dubbo.consumer.check=false
```

## 服务者配置
```markdown
# jdbc配置
spring:
  # dubbo 配置
  dubbo:
    # dubbo 服务名称
    application: user-service
    # dubbo 服务扫描路径
    base-package: com.nbchen.gmall
    # dubbo 通讯协议的名称
    protocol:
      name: dubbo
    registry:
      # zookeeper 注册中心的名称
      address: 192.168.17.146:2181
      # zookeeper 通讯协议的名称
      protocol: zookeeper

```
## 消费者配置
```markdown
spring:
  # dubbo 配置
  dubbo:
    # dubbo 服务名称
    application: user-web
    # dubbo 服务扫描路径
    base-package: com.nbchen.gmall
    # dubbo 通讯协议的名称
    protocol:
      name: dubbo
    registry:
      # zookeeper 注册中心的名称
      address: 192.168.17.146:2181
      # zookeeper 通讯协议的名称
      protocol: zookeeper
    consumer:
      # 设置超时时间
      timeout: 600000
      # 设置是否检查服务存在
      check: false
```
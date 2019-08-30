## nginx 配置 80
- nginx.conf 导入 gmall.conf
```markdown

worker_processes  1;

events {
    worker_connections  1024;
}

http {
    include       mime.types;
    default_type  application/octet-stream;

    sendfile        on;
    #tcp_nopush     on;

    #keepalive_timeout  0;
    keepalive_timeout  65;

    #gzip  on;

    # 为了看起来清爽，我们先在nginx主配置文件`nginx.conf`中使用include指令引用我们的配置
    include vhost/*.conf;

    server {
        listen       80;
        server_name  localhost;

        location / {
            root   html;
            index  index.html index.htm;
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
}
```
- conf/vhost/gmall.conf
```markdown
upstream gmall-user{
	server	127.0.0.1:8081;
}
upstream gmall-cart{
	server	127.0.0.1:8082;
}
upstream gmall-manage{
	server	127.0.0.1:8083;
}

# 用户模块
server {
	listen       80;
	server_name  user.gmall.com;
	
	location / {
		proxy_pass http://gmall-user;
		proxy_connect_timeout 600;
		proxy_read_timeout 5000;
	}
}
# 购物车模块
server {
	listen       80;
	server_name  cart.gmall.com;
	
	location / {
		proxy_pass http://gmall-cart;
		proxy_connect_timeout 600;
		proxy_read_timeout 5000;
	}
}
# manage模块
server {
	listen       80;
	server_name  manage.gmall.com;
	
	location / {
		proxy_pass http://gmall-manage;
		proxy_connect_timeout 600;
		proxy_read_timeout 5000;
	}
}
```
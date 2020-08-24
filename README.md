# Project-Library
# 图书管理系统
![GitHub repo size](https://img.shields.io/github/repo-size/sxzyc/Project-Library)
![GitHub](https://img.shields.io/github/license/sxzyc/Project-Library)

### 功能
- 可以把借书信息导出为xls格式进行保存
- second
- third
- MD5加密

### 实现
基于JavaEE采用SSM框架实现的图书管理系统，图片采用异步上传，Java后端通过解析json进行接收

### 注意
tomcat需要为**8.5**版本，9.0会导致js文件在浏览器显示乱码

### 截图
![登录](https://tvax3.sinaimg.cn/large/005RH3Rxly1gi12t4i1qkj31hc0pt1ky.jpg)
![首页](https://tvax3.sinaimg.cn/large/005RH3Rxly1gi12wrj7qoj30qo09w3yt.jpg)
![管理](https://tvax4.sinaimg.cn/large/005RH3Rxly1gi12xa5m5lj30qo0bdab6.jpg)
![编辑](https://tvax3.sinaimg.cn/large/005RH3Rxly1gi12xo3zj8j315a0qfadv.jpg)
### 部署说明
- conf.xml是Mybatis核心配置文件，所有sql语句统一放在userMapper.xml。（sql语句不涉及多表查询）
- 优点：项目目录结构清晰，简单明了，容易查找修改。
![配置文件](http://wx3.sinaimg.cn/large/0061MTh9ly1gi1meqai33j317o0h20vn.jpg)

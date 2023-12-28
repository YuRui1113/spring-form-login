# Spring Boot中使用自定义Form Login

### 1、关于Spring Security Form Login

Spring Security支持通过HTML表单提供的用户名和密码来进行身份验证，称之为Form Login。

在Spring MVC应用中，我们可以通过Java配置来开启默认Form Login：
```
public SecurityFilterChain filterChain(HttpSecurity http) {
	http
		.formLogin(Customizer.withDefaults());
	// ...
}
```

大多数应用程序生产环境都需要自定义登录页面，本文将会展示如何提供自定义登录表单，并实现如下Spring Security功能：
- 启用和配置Spring Security
- 实现自定义Form Login
- 使用内存用户身份验证
- 配置白名单
- 授权匿名用户可以访问的公共资源
- 授权按角色访问的页面
- 未授权的用户被重定向到访问拒绝页面


### 2、开发环境

当前项目使用以下开发环境：
- 操作系统：Windows 11
- JDK 17
- 数据库：PostgreSQL 15.2
- IDE：VS Code（版本1.83.1），并安装插件：Extension Pack for Java、Spring Boot Extension Pack
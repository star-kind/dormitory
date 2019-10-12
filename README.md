# Dormitory Introduce Profile
A simple system of college dormitory manager

This system had three module:houseparent,student,visitor.

In system the houseparent can self reg,when houseparent logged in it,she can add/delete/modify/survey over all the students/visitors.


# technology structure
- engineering type: maven engineering
- development environment: linux ubuntu LTS 18.04
- database: mysql
- jdk: 10
- server: tomcat
- IDE: eclipse
- frame: springboot+bootstrap
- language: mysql+java+HTML+CSS+jquery+JavaScript+ajax
- spent time: 1 day.

-----------------------------------------------------------------------------------------------------------

## 二次重构

### 数据表

<br>

* 对宿管员之表新加了7列

------------------------------------------------------


### 宿管员模块

* 密码盐值加密机制

* 头像上传

* 修改资料

* 修改密码

* 新增高级宿管和超级宿管(仅限1名)两种角色,对全体宿管进行管理

* 高级宿管以上可注销/激活当值当班状态,而超级宿管则拥有全部权限(己身以外,注销/激活/删除/升级/降级)

* 登录前校验生成的验证码

* 新增正则校验,对注册时所填之数据进行了格式规范
------------------------------------------------------


### 住宿生模块和访客模块

* 修复了一些故障

* 新增正则校验,对登记时所填之数据进行了格式规范

* 皆新增了"将表格导出为Excel表文件"之功能.
------------------------------------------------------
### 其他方面

+ 后台

	* 将自定义业务异常统一封装于一个枚举类内,按键值对结构重载了构造器"(异常码,异常文)"

	* 在异常枚举类和工具类使用了单例模式,对其不再实例化
	
	* 新增了登录拦截器和拦截器配置类(白名单)
	
+ 前端
	
	* 引入并使用了bootstrap框架

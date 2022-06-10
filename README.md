# simple-ele-commerce-system

这个README.md想改的把改动一起附在PR里

## 概述

数据库大作业，一个简单的电商平台，采用前后端分离的设计。系统模块采用总-分式设计，以角色做区分，包括：

* 登录界面
* 用户登录
  * 商城首页
  * 购物车
  * 订单管理
* 商户登录
  * 商品管理
  * 供货商管理
* 供货商登录
  * 货物管理
  * 客户管理
* 平台登录
  * 总体管理

其中商户-供货商-平台登录采用相同前端界面设计

**数据库设计图**

![a](http://pic.netpunk.space/images/2022/05/27/20220527145741.png)

**UML类图**



**老师提的验收要点**

* 数据表符合规范
* 数据库设置
* 权限管理

## 技术选型

### 运行环境

* 硬件环境：单机云服务器

| 硬件 | 说明                                          |
| ---- | --------------------------------------------- |
| CPU  | Intel(R) Xeon(R) Platinum 8255C CPU @ 2.50GHz |
| 内存 | 4GiB System Memory                            |
| 磁盘 | normal 79GiB EXT4 volume                      |

* 系统：windows 10/11
* 语言：java、JavaScript-Vue
* 工具：IDEA、Navicat、Git
* 项目构建：Maven 3.5.2
* 数据库：MySQL 8.0

选择MySQL 8.0的**原因**：

开源、经典，资料多，构建方便，功能完备（支持角色权限管理），balabala

### 前端技术

* Vue生态

### 后端技术

* SpringBoot
* Mybatis

## 数据库设计

### 数据表设计

**中文**
|表名|属性|备注|
| ---- | ---- | ---- |
|客户|账号、密码、余额、地址|      |
|商品|ID、商品名称、图片url, 价格, 数量, 所有者|      |
|商家|账号、密码、店铺名|      |
|供应商|账号、密码、公司名|      |
|购物车|客户账号、商品ID、数量|      |
|订单|订单ID、客户账号、商家账号、商品ID、购买数量、是否支付、支付金额、成交时间|      |
|已发布商品|商品ID、商家账号、发布时间、商品数量|      |
|货单|货单ID、商家账号、供货商账号、商品ID、购买数量、支付金额、成交时间|      |
|管理员|账号、密码|不知道需不需要这个表|

**English**
|Name|Attribute|Note|
| ---- | ---- | ---- |
|costumers|account, password, balacnce, address|      |
|commodities|ID, name, url, price, amount, owner|      |
|shops|account, password, name|      |
|suppliers|account, password, name|      |
|shopping_car|co_account, com_ID, amount|      |
|orders|ID, co_account, sh_account, com_ID, amount, is_pay, total, time|      |
|online_commodity|com_ID, sh_account, time, amount|      |
|contracts|ID, sh_account, su_account, com_ID, amount, total, time|      |
|administrator|account, password|not for sure|

### 角色与用户设计

**中文**
|角色名|权限|备注|
| ---- | ---- | ---- |
|客户|查改(客户, {密码、余额、地址})</br>增删查改(购物车, {客户账号、商品ID、数量})</br>增查(订单, {订单ID、客户账号、商家账号、商品ID、购买数量、是否支付、支付金额、成交时间})</br>改(订单, {是否支付})</br>增删查(商品, {ID, 价格, 数量})|能够对客户表、购物车表有主动更改权限，对订单表、商品表有被动更改权限|
|商家|查改(商户, {密码、店铺名})</br>增删查(已发布商品, {商品ID、商家账号、发布时间、商品数量})</br>增查(货单, {货单ID、商家账号、供货商账号、商品ID、购买数量、支付金额、成交时间})</br>增删查改(商品, {商品名称, 图片url, 价格, 数量})|能够对商家表，已发布商品表有主动更改权限，对货单表、商品表有被动更改权限|
|供应商|查改(商户, {密码、店铺名}</br>增删查改(商品, {商品名称, 价格, 数量})|能够对供应商表，商品表有主动更改权限|
|管理员|全表增删查改||

**English**
|Name|Privilege|Note|
| ---- | ---- | ---- |
|costumer|SELECT,UPDATE(costumers, {password, balacnce, address})</br>INSERT,DELETE,SELECT,UPDATE(shopping_car, {co_account, com_ID, amount})</br>INSERT,SELECT(orders, {ID, co_account, sh_account, com_ID, amount, is_pay, total, time})</br>UPDATE(orders, {is_pay})</br>INSERT,DELETE,SELECT(commodities, {ID, name, url, price, amount, owner})|same as above|
|shop|SELECT,UPDATE(shops, {password, name})</br>INSERT,DELETE,SELECT(online_commodity, {com_ID, sh_account, time, amount})</br>INSERT,SELECT(contracts, {ID, sh_account, su_account, com_ID, amount, total, time})</br>INSERT,DELETE,SELECT,UPDATE(commodities, {name, url, price, amount})|same as above|
|supplier|SELECT,UPDATE(suppliers, {password, name})</br>INSERT,DELETE,SELECT,UPDATE(commodities, {name, price, amount})|same as above|
|administrator|root||

### 优化设计

#### 性能参数

在MySQL中使用`SHOW STATUS`能够查看MySQL数据库的性能参数，我们可以根据这些性能参数来了解MySQL数据库的状态，并制定合理的优化策略。一共有356个。



#### 查询优化(optional)

使用`EXPLAIN`可列举出查询语句的算子调用栈，查看查询性能瓶颈，对频繁调用的语句进行调优。



#### 建立索引

对常用数据表建立索引，虽然占内存，但是很提升性能



#### 数据库安全(optional)

一主一备，



## 开发周期

|时间|规划|备注|
| ---- | ---- | ---- |
|5/27, 5/28, 5/29, 5/30, 5/31, 6/1, 6/2, 6/5, 6/12|完成基础功能开发|共9天|
|6/13, 6/14, 6/15, 6/16|对接口＆debug|      |
|6/17, 6/18|写文档|      |

## TO DO LIST

- [ ] 登录系统接口定义和对接
- [ ] 客户添加购物车接口定义和对接
- [ ] 客户结算订单接口定义和对接
- [ ] 客户订单管理接口定义和对接
- [ ] 商户商品管理接口定义和对接
- [ ] 商户客户管理接口定义和对接
- [ ] 供应商商品管理接口定义和对接
- [ ] 供应商商户管理接口定义和对接

## 具体功能

* 登录
  * 用户登录、商户登录、供应商登录进入不同页面
* 用户
  * 更改账号、密码、地址
  * 添加商品到购物车
  * 购物车结算生成订单
  * 订单查看、订单支付
* 商户
  * 更改账号、密码、店铺名
  * 发布、删除商品
  * 从供应商进货（不一定）
  * 查看所有具有合作关系的供应商信息
* 供应商
  * 更改账号、密码、公司名
  * 向商户供货（不一定）
  * 查看所有具有合作关系的商户信息



## 操作指南

以下文章都是我们自己写的

* 关于Git和Github合作开发 [链接](http://blog.netpunk.space/2022/05/21/使用git与github合作开发/)

* 这是关于如何在后端实现代码修改的文章，可以方便大家之后合作开发 [链接](https://efficient-violin-63b.notion.site/6ca1a4da43974fcbab191f2fd6c7e574)

## 环境搭建

有用什么东西就些什么东西，这种用来报告灌水即好看又方便

### 前端环境



### 后端环境

数据库容器创建＆运行

~~~bash
docker run -d --name mysql_ex -v /home/shopping:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456  -p 3366:3306 mysql:8.0
~~~



## 集成测试

### 功能测试



### 性能测试(optional)



## 问题＆求解

这里也很好灌水

## 团队分工

根据报告书写要求，增加团队分工表格

| 姓名   | 负责模块 | 特点 |
| ------ | -------- | ---- |
| 廖温建 |          |      |
| 李一奔 |          |      |
| 林广兰 |          |      |
| 孙文祥 |          |      |
| 张哲   |          |      |


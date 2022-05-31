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

![a](http://pic.netpunk.space/images/2022/05/27/20220527145741.png)

### 老师提的验收要点

* 数据表符合规范
* 数据库设置（也就是数据库使用的内容）
* 权限管理

## 技术选型

### 运行环境

* 系统：windows 10/11
* 语言：java、JavaScript-Vue
* 工具：IDEA、Navicat、Git
* 项目构建：Maven 3.5.2
* 数据库：MySQL 5.7

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
|commodities|ID, name, url, price, amount， owner|      |
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
|costumer|SELECT,UPDATE(costumers, {password, balacnce, address})</br>INSERT,DELETE,SELECT,UPDATE(shopping_car, {co_account, com_ID, amount})</br>INSERT,SELECT(orders, {ID, co_account, sh_account, com_ID, amount, is_pay, total, time})</br>UPDATE(orders, {is_pay})</br>INSERT,DELETE,SELECT(commodities, {ID, price, amount})|same as above|
|shop|SELECT,UPDATE(shops, {password, name})</br>INSERT,DELETE,SELECT(online_commodity, {com_ID, sh_account, time, amount})</br>INSERT,SELECT(contracts, {ID, sh_account, su_account, com_ID, amount, total, time})</br>INSERT,DELETE,SELECT,UPDATE(commodities, {name, url, price, amount})|same as above|
|supplier|SELECT,UPDATE(suppliers, {password, name})</br>INSERT,DELETE,SELECT,UPDATE(commodities, {name, price, amount})|same as above|
|administrator|root||

## 开发周期

|时间|规划|备注|
| ---- | ---- | ---- |
|5/27, 5/28, 5/29, 5/30, 5/31, 6/1, 6/2, 6/5, 6/12|完成基础功能开发|共9天|
|6/13, 6/14, 6/15, 6/16|对接口＆debug|      |
|6/17, 6/18|写文档|      |

## 具体功能

- [ ] 建表语句和角色、权限定义
- [ ] 登录系统接口定义和对接
- [ ] 客户添加购物车接口定义和对接
- [ ] 客户结算订单接口定义和对接
- [ ] 客户订单管理接口定义和对接
- [ ] 商户商品管理接口定义和对接
- [ ] 商户客户管理接口定义和对接
- [ ] 供应商商品管理接口定义和对接
- [ ] 供应商商户管理接口定义和对接



## 后端代码操作指南

这是关于如何在后端实现代码修改的文章，可以方便大家之后合作开发

https://efficient-violin-63b.notion.site/6ca1a4da43974fcbab191f2fd6c7e574




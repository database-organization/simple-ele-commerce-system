# 接口说明

### 请求方法

所有接口只支持POST方法发起请求。

### 字符编码

HTTP通讯及报文BASE64编码均采用UTF-8字符集编码格式。

### 格式说明

请求格式

| 名称 | 描述                                         | 备注             |
| ---- | -------------------------------------------- | ---------------- |
| Body | 每个接口特有的参数，以JSON格式存放在Body属性 | 详见每个接口定义 |

相应格式

| 参数名称 | 类型   | 出现要求 | 描述                                 |
| -------- | ------ | -------- | ------------------------------------ |
| Data     | object | R        | 每个接口特有的参数，详见每个接口定义 |

元素出现要求说明：

| 符号 | 说明                                        |
| ---- | ------------------------------------------- |
| R    | 报文中该元素必须出现（Required）            |
| O    | 报文中该元素可选出现（Optional）            |
| C    | 报文中该元素在一定条件下出现（Conditional） |

在json中，值必须是以下数据类型之一：

| 类型              | type       | 实例                                     |
| ----------------- | ---------- | ---------------------------------------- |
| 字符串            | string     | "name":"Bill"                            |
| 数字              | int, float | "age":30, "age":3.5                      |
| 对象（JSON 对象） | object     | "Data":{name:"haha", age:"blabla"}       |
| 数组              | array      | "employees":[ "Bill", "Steve", "David" ] |
| 布尔              | bool       | "sale":true                              |
| Null              | Nan        | "middle_name":null                       |

# 接口定义

### 密码登录

- **接口说明：** 密码登录
- **接口地址：** /signin

**请求参数**

| 参数名称 | 类型   | 出现要求 | 描述       |
| -------- | ------ | -------- | ---------- |
| Body     |        | R        | 请求报文头 |
| account  | string | R        | 登录账户   |
| password | string | R        | 登录密码   |


请求示例：

```json
{
    "Body":{
        "account":"123456789",
        "password":"54321"
    }
}
```

**返回结果**

| 参数名称       | 类型   | 出现要求 | 描述                                             |
| -------------- | ------ | -------- | ------------------------------------------------ |
| Data           |        | R        | 响应报文头                                       |
| authentication | bool   | R        | 登录响应码，为1则账户密码正确，为0则账号密码错误 |
| userId         | string | R        | 用户ID                                           |
| msg            | string | R        | 用户角色                                         |

示例：

```json
{
    "Data":{
        "authentication":ture,
        "userId":"123456789",
        "msg":"costumer"
    }
}
```

## 客户

### 1.1更新客户信息

- **接口说明：** 更新客户密码、余额、地址
- **接口地址：** /costumer/updateMsg

**请求参数**

| 参数名称 | 类型   | 出现要求 | 描述       |
| -------- | ------ | -------- | ---------- |
| Body     |        | R        | 请求报文头 |
| name     | string | R        | 账户名     |
| newPwd   | string | R        | 新密码     |
| newBlc   | string | R        | 新余额     |
| newAdrs  | string | R        | 新地址     |


请求示例：

```json
{
    "Body":{
        "name":"123456789",
        "newPwd":"54321",
        "newBlc":"54321",
        "newAdrs":"54321"
    }
}
```

**返回结果**

| 参数名称 | 类型   | 出现要求 | 描述         |
| -------- | ------ | -------- | ------------ |
| Data     |        | R        | 响应报文头   |
| account  | string | R        | 账户名       |
| password | string | R        | 修改后的密码 |
| balance  | string | R        | 修改后的余额 |
| address  | string | R        | 修改后的地址 |

示例：

```json
{
    "Data":{
        "account":"123456789",
        "password":"54321",
        "balance":"54321",
        "address":"二里屯",
    }
}
```

### 1.2修改购物车中某商品的数量

- **接口说明：** 修改购物车中某商品的数量
- **接口地址：** /costumer/updateAmountInShoppingCar

**请求参数**

| 参数名称   | 类型   | 出现要求 | 描述                    |
| ---------- | ------ | -------- | ----------------------- |
| Body       |        | R        | 请求报文头              |
| co_account | string | R        | 账户名                  |
| com_ID     | string | R        | 商品ID                  |
| amount     | int    | R        | 商品数量                |
| operate    | bool   | R        | 为ture是增，为false是删 |


请求示例：

```json
{
    "Body":{
        "co_account":"123456789",
        "com_ID":"54321",
        "amount":10,
        "operate":true
    }
}
```

**返回结果**

| 参数名称 | 类型 | 出现要求 | 描述         |
| -------- | ---- | -------- | ------------ |
| Data     |      | R        | 响应报文头   |
| check    | bool | R        | 是否修改成功 |

示例：

```json
{
    "Data":{
        "check":ture
    }
}
```

### 1.3查询购物车

- **接口说明：** 查询购物车
- **接口地址：** /costumer/queryShopCar

**请求参数**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Body       |        | R        | 请求报文头 |
| co_account | string | R        | 账户名     |


请求示例：

```json
{
    "Body":{
        "co_account":"123456789"
    }
}
```

**返回结果**

| 参数名称 | 类型  | 出现要求 | 描述                   |
| -------- | ----- | -------- | ---------------------- |
| Data     |       | R        | 响应报文头             |
| com_ID   | array | R        | 账户对应的所有商品     |
| amount   | array | R        | 账户对应的所有商品数量 |

示例：

```json
{
    "Data":{
        "com_ID":["1", "2", "3"],
        "amount"[3, 1, 4]
    }
}
```


### 1.4把所有商品从购物车添加进订单

- **接口说明：** 把所有商品从购物车添加进订单
- **接口地址：** /costumer/addFromShoppingCarToOrders

**请求参数**

| 参数名称   | 类型         | 出现要求 | 描述               |
| ---------- | ------------ | -------- | ------------------ |
| Body       |              | R        | 请求报文头         |
| co_account | string       | R        | 客户账户名         |
| sh_account | array-string | R        | 商家账户名         |
| com_ID     | array-string | R        | 商品ID             |
| amount     | array-int    | R        | 商品数目           |
| is_pay     | string       | O        | 是否付款，默认为否 |
| total      | float        | R        | 商品总价           |


请求示例：

```json
{
    "Body":{
        "co_account":"123456789",
        "sh_account":["54321", "123456"],
        "com_ID":["1", "2"],
        "amount":[100, 200],
        "total":1000
    }
}
```

**返回结果**

| 参数名称 | 类型 | 出现要求 | 描述         |
| -------- | ---- | -------- | ------------ |
| Data     |      | R        | 响应报文头   |
| check    | bool | R        | 添加是否成功 |

示例：

```json
{
    "Data":{
		"check":true
    }
}
```

### 1.5查询订单

- **接口说明：** 查询该账户下所有订单情况
- **接口地址：** /costumer/updateAmountInShoppingCar

**请求参数**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Body       |        | R        | 请求报文头 |
| co_account | string | R        | 账户名     |


请求示例：

```json
{
    "Body":{
        "co_account":"123456789",
    }
}
```

**返回结果**

| 参数名称   | 类型         | 出现要求 | 描述       |
| ---------- | ------------ | -------- | ---------- |
| Data       |              | R        | 响应报文头 |
| ID         | array-object | R        | 分组订单ID |
| co_account | string       | O        | 客户账户名 |
| com_ID     | array-string | R        | 商品ID     |
| amount     | array-int    | R        | 商品数目   |
| is_pay     | string       | R        | 是否付款   |
| total      | float        | R        | 商品总价   |

注意：这里要特殊处理，因为一个订单ID

示例：

```json
{
    "Data":{
        "ID":[{"com_ID":["1", "2"], "amount":[100, 200], "is_pay": "是", "total": 1000}, {"com_ID":["1", "2"], "amount":[300, 400], "is_pay": "否", "total": 2000}],
		"co_account":"123456789"
    }
}
```

### 1.6修改订单状态

- **接口说明：** 修改订单的付款情况为‘是’
- **接口地址：** /costumer/updateAmountInShoppingCar

**请求参数**

| 参数名称   | 类型      | 出现要求 | 描述       |
| ---------- | --------- | -------- | ---------- |
| Body       |           | R        | 请求报文头 |
| co_account | string    | R        | 账户名     |
| comID      | string    | R        | 商品ID     |
| time       | timestamp | R        | 时间戳     |


请求示例：

```json
{
    "Body":{
        "co_account":"123456789",
        "comID":"54321",
        "time":"0000-00-00",
    }
}
```

**返回结果**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Data       |        | R        | 响应报文头 |
| co_account | string | R        | 客户账户名 |
| sh_account | string | R        | 商家账户名 |
| com_ID     | string | R        | 商品ID     |
| amount     | int    | R        | 商品数目   |
| is_pay     | string | R        | 是否付款   |
| total      | int    | R        | 商品总价   |


示例：

```json
{
    "Data":{
		"co_account":"123456789",
        "sh_account":"54321",
        "com_ID":"1",
        "amount":100,
        "is_pay":"是",
        "total":1000,
    }
}
```

### 1.7查询所有商品

- **接口说明：** 查询所有商品信息
- **接口地址：** /costumer/select_all_com

**请求参数**

| 参数名称 | 类型 | 出现要求 | 描述       |
| -------- | ---- | -------- | ---------- |
| Body     |      | R        | 请求报文头 |


请求示例：

```json
{
    "Body":{
    }
}
```

**返回结果**

| 参数名称 | 类型   | 出现要求 | 描述         |
| -------- | ------ | -------- | ------------ |
| Data     |        | R        | 响应报文头   |
| ID       | int    | R        | 商品ID       |
| name     | string | R        | 商品名       |
| url      | string | R        | 商品图片地址 |
| price    | int    | R        | 商品单价     |
| amount   | int    | R        | 商品数目     |
| owner    | string | R        | 商品所有者   |

示例：

```json
{
    "Data":{
        "ID":1,
        "name":"WIFI",
        "url":"C://pic.jpg",
        "price":100,
        "amount":100,
        "owner":"123456789@qq.com",
    }
}
```

## 商户

### 2.1更新商户信息

- **接口说明：** 更新商户密码、店铺名
- **接口地址：** /shops/UpdateMsg

**请求参数**

| 参数名称 | 类型   | 出现要求 | 描述       |
| -------- | ------ | -------- | ---------- |
| Body     |        | R        | 请求报文头 |
| account  | string | R        | 账户       |
| password | string | R        | 新密码     |
| name     | string | R        | 新店铺名   |


请求示例：

```json
{
    "Body":{
        "account":"123456789@qq.com",
        "password":"54321",
        "name":"GUET"
    }
}
```

**返回结果**

| 参数名称 | 类型 | 出现要求 | 描述                                  |
| -------- | ---- | -------- | ------------------------------------- |
| Data     |      | R        | 响应报文头                            |
| check    | bool | R        | 修改是否成功，成功为ture，失败为fasle |
|          |      |          |                                       |

示例：

```json
{
    "Data":{
        "check":ture,
        "userId":"123456789",
        "msg":"costumer"
    }
}
```

### 2.2查询商户信息

- **接口说明：** 更新商户密码、店铺名
- **接口地址：** /shops/QueryMsg

**请求参数**

| 参数名称 | 类型   | 出现要求 | 描述       |
| -------- | ------ | -------- | ---------- |
| Body     |        | R        | 请求报文头 |
| account  | string | R        | 商户账户   |


请求示例：

```json
{
    "Body":{
        "account":"123456789@qq.com",
    }
}
```

**返回结果**

| 参数名称 | 类型   | 出现要求 | 描述       |
| -------- | ------ | -------- | ---------- |
| Data     |        | R        | 响应报文头 |
| account  | string | R        | 账户       |
| password | string | R        | 密码       |
| name     | string | R        | 店铺名称   |

示例：

```json
{
    "Data":{
        "account":"123456789",
        "password":"12345",
        "name":"GUET"
    }
}
```

### 2.3查询已发布商品信息

- **接口说明：** 查询已发布商品信息
- **接口地址：** /shops/SelectOnlineComMsg

**请求参数**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Body       |        | R        | 请求报文头 |
| sh_account | string | R        | 账户       |


请求示例：

```json
{
    "Body":{
        "sh_account":"123456789@qq.com",
    }
}
```

**返回结果**

| 参数名称       | 类型      | 出现要求 | 描述                                  |
| -------------- | --------- | -------- | ------------------------------------- |
| Data           |           | R        | 响应报文头                            |
| authentication | bool      | R        | 修改是否成功，成功为ture，失败为fasle |
| com_ID         | string    | R        | 商品ID                                |
| sh_account     | string    | R        | 商户账号                              |
| time           | timestamp | R        | 时间戳                                |
| amount         | int       | R        | 商品数量                              |

示例：

```json
{
    "Data":{
        "authentication":ture,
        "com_ID":"1",
        "sh_account":"123456789",
        "time":"0000-00-00",
        "amount":"GUET"
    }
}
```

### 2.4修改已发布商品信息

- **接口说明：** 增加、删除已发布的商品信息
- **接口地址：** /shops/UpdateOnlineComMsg

**请求参数**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Body       |        | R        | 请求报文头 |
| comID      | string | R        | 账户       |
| sh_account | string | R        | 商户账号   |
| amount     | int    | R        | 商品新数目 |


请求示例：

```json
{
    "Body":{
        "comID":"1",
        "sh_account":"123456789@qq.com",
        "amount":100
    }
}
```

**返回结果**

| 参数名称       | 类型   | 出现要求 | 描述                                  |
| -------------- | ------ | -------- | ------------------------------------- |
| Data           |        | R        | 响应报文头                            |
| authentication | bool   | R        | 修改是否成功，成功为ture，失败为fasle |
| com_ID         | string | R        | 商品ID                                |
| sh_account     | string | R        | 商户账号                              |
| amount         | int    | R        | 商品数量                              |

示例：

```json
{
    "Data":{
        "authentication":ture,
        "com_ID":"1",
        "sh_account":"123456789",
        "time":"0000-00-00",
        "amount":"GUET"
    }
}
```

### 2.5新增货单条目

- **接口说明：** 新增货单条目
- **接口地址：** /shops/InsertContractsMsg

**请求参数**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Body       |        | R        | 请求报文头 |
| sh_account | string | R        | 商家账户   |
| su_account | string | R        | 供应商账号 |
| com_ID     | int    | R        | 商品ID     |
| amount     | int    | R        | 商品数目   |


请求示例：

```json
{
    "Body":{
        "sh_account":"197816279@qq.com",
        "su_account":"123456789@qq.com",
        "com_ID":1,
        "amount":100
    }
}
```

**返回结果**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Data       |        | R        | 响应报文头 |
| sh_account | string | R        | 商家账户   |
| su_account | string | R        | 供应商账号 |
| com_ID     | int    | R        | 商品ID     |
| amount     | int    | R        | 商品数目   |


示例：

```json
{
    "Data":{
        "authentication":ture,
        "com_ID":"1",
        "sh_account":"123456789",
        "time":"0000-00-00",
        "amount":"GUET"
    }
}
```

### 2.6查询相关供应商

- **接口说明：** 查询相关供应商
- **接口地址：** /shops/SelectContractsSuAccount

**请求参数**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Body       |        | R        | 请求报文头 |
| sh_account | string | R        | 商家账户   |


请求示例：

```json
{
    "Body":{
        "sh_account":"197816279@qq.com",
    }
}
```

**返回结果**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Data       |        | R        | 响应报文头 |
| su_account | string | R        | 供应商账号 |
| su_name    | string | R        | 供应商名称 |


示例：

```json
{
    "Data":{
        "su_account":["123456789@qq.com","987654321@qq.com","654654654@qq.com"],
        "su_name":["GUET","GURT","GUTT"]
    }
}
```

**商户相关信息不会只有这么点，之后再随便加一点什么交易总额，交易最多的商品什么的，放点随机数据上去就行了**

### 2.7查询名下所有商品

- **接口说明：** 查询名下所有商品
- **接口地址：** /shops/SelectAllComMsg

**请求参数**

| 参数名称   | 类型   | 出现要求 | 描述       |
| ---------- | ------ | -------- | ---------- |
| Body       |        | R        | 请求报文头 |
| sh_account | string | R        | 商家账户   |


请求示例：

```json
{
    "Body":{
        "sh_account":"197816279@qq.com",
    }
}
```

**返回结果**

| 参数名称 | 类型   | 出现要求 | 描述         |
| -------- | ------ | -------- | ------------ |
| Data     |        | R        | 响应报文头   |
| ID       | int    | R        | 商品ID       |
| name     | string | R        | 商品名       |
| url      | string | R        | 商品图片地址 |
| price    | string | R        | 商品单价     |
| amount   | int    | R        | 商品数目     |
| owner    | string | R        | 所有者账号   |


示例：

```json
{
    "Data":{
        "ID":[1,2,3],
        "name":["WIFI","PHONE","PC"],
        "url":["C://pic.jpg",null,null],
        "price":[100,200,300],
        "amount":[100,200,300],
        "owner":["GUET","GURT","GUTT"]
    }
}
```

### 2.8 修改名下商品

- **接口说明：** 查询名下所有商品
- **接口地址：** /shops/UpdateComMsg

**请求参数**

| 参数名称  | 类型   | 出现要求 | 描述       |
| --------- | ------ | -------- | ---------- |
| Body      |        | R        | 请求报文头 |
| owner     | string | R        | 所有者账户 |
| newName   | string | R        | 商品新名称 |
| newURL    | string | R        | 商品新图片 |
| newPrice  | int    | R        | 商品新价格 |
| newAmount | int    | R        | 商品新数目 |


请求示例：

```json
{
    "Body":{
        "owner":"197816279@qq.com",
        "newName":"WIFI",
        "newURL":"D//pic.png",
        "newPrice":200,
        "newAmount":100,
    }
}
```

**返回结果**

| 参数名称 | 类型 | 出现要求 | 描述                                  |
| -------- | ---- | -------- | ------------------------------------- |
| Data     |      | R        | 响应报文头                            |
| check    | bool | R        | 修改是否成功，成功为ture，失败为fasle |


示例：

```json
{
    "Data":{
        "check":ture,
    }
}
```

## 供应商

### 3.1更新供应商信息

- **接口说明：** 更新供应商密码、公司名
- **接口地址：** /suppliers/updateMsg

**请求参数**

| 参数名称 | 类型   | 出现要求 | 描述       |
| -------- | ------ | -------- | ---------- |
| Body     |        | R        | 请求报文头 |
| account  | string | R        | 账户名     |
| newPwd   | string | R        | 新密码     |
| newName  | string | R        | 新名称     |


请求示例：

```json
{
    "Body":{
        "account":"123456789@qq.com",
        "newPwd":"98765",
        "newName":"GURT"
    }
}
```

**返回结果**

| 参数名称 | 类型 | 出现要求 | 描述         |
| -------- | ---- | -------- | ------------ |
| Data     |      | R        | 响应报文头   |
| check    | bool | R        | 是否修改成功 |
|          |      |          |              |

示例：

```json
{
    "Data":{
        "check":ture,
    }
}
```

### 3.2查询名下所有商品

- **接口说明：** 查询名下所有商品
- **接口地址：** /suppliers/selectAllCom

**请求参数**

| 参数名称     | 类型   | 出现要求 | 描述       |
| ------------ | ------ | -------- | ---------- |
| Body         |        | R        | 请求报文头 |
| ownerAccount | string | R        | 账户名     |


请求示例：

```json
{
    "Body":{
        "ownerAccount":"123456789@qq.com",
    }
}
```

**返回结果**

| 参数名称 | 类型         | 出现要求 | 描述         |
| -------- | ------------ | -------- | ------------ |
| Data     |              | R        | 响应报文头   |
| ID       | array-int    | R        | 商品ID       |
| name     | array-string | R        | 商品名       |
| url      | array-string | R        | 商品图片地址 |
| price    | array-int    | R        | 商品单价     |
| amount   | array-int    | R        | 商品数目     |
| owner    | string       | R        | 商品所有者   |

示例：

```json
{
    "Data":{
        "ID":[1, 2, 3],
        "name":["WIFI", "labtop", "phone"],
        "url":["http://pic.jpg","http://pic.jpg","http://pic.jpg"],
        "price":[100,100,100],
        "amount":[100,100,100],
        "owner":"123456789@qq.com",
    }
}
```

### 3.3增加新商品

- **接口说明：** 增加新商品
- **接口地址：** /suppliers/insertNewCom

**请求参数**

| 参数名称     | 类型   | 出现要求 | 描述       |
| ------------ | ------ | -------- | ---------- |
| Body         |        | R        | 请求报文头 |
| name         | string | R        | 商品名     |
| price        | int    | R        | 商品单价   |
| amount       | int    | R        | 商品数目   |
| ownerAccount | string | R        | 商品所有者 |


请求示例：

```json
{
    "Body":{
        "name":"WIFI",
        "price":100,
        "amount":100,
        "ownerAccount":"123456789@qq.com",
    }
}
```

**返回结果**

| 参数名称 | 类型 | 出现要求 | 描述         |
| -------- | ---- | -------- | ------------ |
| Data     |      | R        | 响应报文头   |
| check    | bool | R        | 是否插入成功 |

示例：

```json
{
    "Data":{
        "check":true,
    }
}
```

### 3.4查询相关商户

- **接口说明：** 查询相关商户
- **接口地址：** /suppliers/selectContractsShop

**请求参数**

| 参数名称    | 类型   | 出现要求 | 描述           |
| ----------- | ------ | -------- | -------------- |
| Body        |        | R        | 请求报文头     |
| su_accounts | string | R        | 当前供应商账户 |


请求示例：

```json
{
    "Body":{
        "su_accounts":"123456789@qq.com",
    }
}
```

**返回结果**

| 参数名称 | 类型   | 出现要求 | 描述       |
| -------- | ------ | -------- | ---------- |
| Data     |        | R        | 响应报文头 |
| account  | string | R        | 账户名     |
| name     | string | R        | 商店名     |

示例：

```json
{
    "Data":{
        "account":["123456789@qq.com", "123456789@qq.com", "123456789@qq.com"],
        "name":"GUET",
    }
}
```

**商户相关信息不会只有这么点，之后再随便加一点什么交易总额，交易最多的商品什么的，放点随机数据上去就行了**


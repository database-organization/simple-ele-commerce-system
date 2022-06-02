#--------------------------建表与约束-------------------------------#

#建商品表
CREATE TABLE commodities (
ID INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(32) DEFAULT NULL,
url VARCHAR(256) DEFAULT NULL,
price VARCHAR(32) DEFAULT NULL,
amount INT DEFAULT NULL,
ownerAccount VARCHAR(32) DEFAULT NULL
);

#商品表样例
INSERT INTO commodities (ID, name, url, price, amount, ownerAccount) VALUES (1, '手机', 'http:#pic.netpunk.space/images/2022/06/02/20220602104655.png', '1024', 5, '123456789');
INSERT INTO commodities (ID, name, url, price, amount, ownerAccount) VALUES (2, '电脑', 'http:#pic.netpunk.space/images/2022/06/02/20220602104955.png', '2048', 5, '123456789@qq.com');
INSERT INTO commodities (ID, name, url, price, amount, ownerAccount) VALUES (3, '杯子', 'http:#pic.netpunk.space/images/2022/06/02/20220602105028.png', '5', 5, '123456789@gmail.com');

#建客户表
CREATE TABLE costumers (
account VARCHAR(32) PRIMARY KEY,
password VARCHAR(32) DEFAULT NULL,
balance DECIMAL DEFAULT NULL,
address VARCHAR(32) DEFAULT NULL,
CHECK(LENGTH(account)>=8 AND LENGTH(account)<=30)
);

#客户表样例
INSERT INTO costumers (account, password, balance, address) VALUES ('123456789', '54321', 5000, '沈阳大街');

#建商户表
CREATE TABLE shops (
account VARCHAR(32) PRIMARY KEY,
password VARCHAR(32) DEFAULT NULL,
name VARCHAR(32) DEFAULT NULL,
CHECK(LENGTH(account)>=8 AND LENGTH(account)<=30)
);

#商户表样例
INSERT INTO shops (account, password, name) VALUES ('123456789@qq.com', '54321', '老八汉堡店');

#建供应商表
CREATE TABLE suppliers (
account VARCHAR(32) PRIMARY KEY,
password VARCHAR(32) DEFAULT NULL,
name VARCHAR(32) DEFAULT NULL,
CHECK(LENGTH(account)>=8 AND LENGTH(account)<=30)
);

#供应商表样例
INSERT INTO suppliers (account, password, name) VALUES ('123456789@163.com', '54321', 'lwj无限无责任公司');

#建购物车表
CREATE TABLE shopping_car (
co_account VARCHAR(32),
com_ID INT,
amount INT DEFAULT NULL,
PRIMARY KEY (co_account , com_ID),
FOREIGN KEY(co_account) REFERENCES costumers(account),
FOREIGN KEY(com_ID) REFERENCES commodities(ID)
);

#购物车表样例
INSERT INTO shopping_car (co_account, com_ID, amount) VALUES ('123456789', 2, 3);

#建订单表
CREATE TABLE orders (
ID INT PRIMARY KEY AUTO_INCREMENT,
co_account VARCHAR(32),
sh_account VARCHAR(32),
com_ID INT,
amount INT DEFAULT NULL,
is_pay ENUM('是','否') NOT NULL,
total DECIMAL DEFAULT 0,
time TIMESTAMP DEFAULT NOW(),
# 不知道为什么这两个外键不能设置
# FOREIGN KEY(co_account) REFERENCES costumers(account)
# FOREIGN KEY(sh_account) REFERENCES shops(account)
FOREIGN KEY(com_ID) REFERENCES commodities(ID)
) engine=InnoDB default charset=utf8;

#订单表样例
INSERT INTO orders (ID, co_account, sh_account, com_ID, amount, is_pay, total, time) VALUES (1, '123456789', '123456789@qq.com', 1, 5, '是', 5120, '2022-6-2 11:23:55');

#建发布商品表
CREATE TABLE online_commodity (
com_ID INT,
sh_account VARCHAR(32),
time TIMESTAMP DEFAULT NOW(),
amount INT DEFAULT NULL,
PRIMARY KEY (com_ID , sh_account),
FOREIGN KEY(com_ID) REFERENCES commodities(ID),
FOREIGN KEY(sh_account) REFERENCES shops(account)
);

#发布商品表样例
INSERT INTO online_commodity (com_ID, sh_account, amount) VALUES (2, '123456789@qq.com', 5);

#建货单表
CREATE TABLE contracts (
ID INT PRIMARY KEY AUTO_INCREMENT,
sh_account VARCHAR(32),
su_account VARCHAR(32),
com_ID INT,
amount INT DEFAULT NULL,
total DECIMAL DEFAULT '0',
time TIMESTAMP DEFAULT NOW(),
FOREIGN KEY(sh_account) REFERENCES shops(account),
FOREIGN KEY(su_account) REFERENCES suppliers(account),
FOREIGN KEY(com_ID) REFERENCES commodities(ID)
);

#货单表样例
INSERT INTO contracts (sh_account, su_account, com_ID, amount, total) VALUES ('123456789@qq.com', '123456789@163.com', 2, 5, 10240);

#--------------------------角色与权限-------------------------------#

CREATE ROLE IF NOT EXISTS 'costumer', 'shop', 'supplier';

#客户角色权限
GRANT SELECT ON shopping.costumers TO costumer;

GRANT UPDATE(password, balance, address) ON shopping.costumers TO costumer;

GRANT ALL ON shopping.shopping_car TO costumer;

GRANT INSERT,SELECT ON shopping.orders TO costumer;

GRANT UPDATE(is_pay) ON shopping.orders TO costumer;

GRANT INSERT,SELECT ON shopping.commodities TO costumer;

#商户角色权限
GRANT SELECT ON shopping.shops TO shop;

GRANT UPDATE(password, name) ON shopping.shops TO shop;

GRANT INSERT,DELETE,SELECT ON shopping.online_commodity TO shop;

GRANT INSERT,SELECT ON shopping.contracts TO shop;

GRANT INSERT,DELETE,SELECT ON shopping.commodities TO shop;

GRANT UPDATE(name, url, price) ON shopping.commodities TO shop;

#供应商角色权限
GRANT SELECT ON shopping.suppliers TO supplier;

GRANT UPDATE(password, name) ON shopping.suppliers TO supplier;

GRANT INSERT,DELETE,SELECT ON shopping.commodities TO supplier;

GRANT UPDATE(name, url, price) ON shopping.commodities TO supplier;
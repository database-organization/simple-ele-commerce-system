CREATE TABLE commodities (
ID INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(32) DEFAULT NULL,
url VARCHAR(256) DEFAULT NULL,
price VARCHAR(32) DEFAULT NULL,
ownerAccount VARCHAR(32) DEFAULT NULL
);

CREATE TABLE costumers (
account VARCHAR(32) PRIMARY KEY,
password VARCHAR(32) DEFAULT NULL,
balance VARCHAR(32) DEFAULT NULL,
address VARCHAR(32) DEFAULT NULL,
CHECK(len(account)>=8 AND len(account)<=12)
);

CREATE TABLE shops (
account VARCHAR(32) PRIMARY KEY,
password VARCHAR(32) DEFAULT NULL,
name VARCHAR(32) DEFAULT NULL,
CHECK(len(account)>=8 AND len(account)<=12)
);

CREATE TABLE suppliers (
account VARCHAR(32) PRIMARY KEY,
password VARCHAR(32) DEFAULT NULL,
name VARCHAR(32) DEFAULT NULL,
CHECK(len(account)>=8 AND len(account)<=12)
);

CREATE TABLE shopping_car (
co_account VARCHAR(32),
com_ID INT,
number VARCHAR(32) DEFAULT NULL,
PRIMARY KEY (co_account , com_ID),
CONSTRAINT 1 FOREIGN KEY(co_account) REFERENCES costumers(account),
CONSTRAINT 2 FOREIGN KEY(com_ID) REFERENCES commodities(ID)
);

CREATE TABLE orders (
ID INT PRIMARY KEY AUTO_INCREMENT,
co_account VARCHAR(32),
sh_account VARCHAR(32),
com_ID INT,
number VARCHAR(32) DEFAULT '0',
is_pay VARCHAR(32) ENUM('是','否') NOT NULL DEFAULT '否',
total VARCHAR(32) DEFAULT '0',
time DATE DEFAULT '0000-00-00',
CONSTRAINT 3 FOREIGN KEY(co_account) REFERENCES costumers(account),
CONSTRAINT 4 FOREIGN KEY(sh_account) REFERENCES shops(account),
CONSTRAINT 5 FOREIGN KEY(com_ID) REFERENCES commodities(ID)
);

CREATE TABLE online_commodity (
com_ID INT,
sh_account VARCHAR(32),
time DATE DEFAULT '0000-00-00',
number VARCHAR(32) DEFAULT NULL,
PRIMARY KEY (com_ID , sh_account),
CONSTRAINT 6 FOREIGN KEY(com_ID) REFERENCES commodities(ID),
CONSTRAINT 7 FOREIGN KEY(sh_account) REFERENCES shops(account)
);

CREATE TABLE contracts (
ID INT PRIMARY KEY AUTO_INCREMENT,
sh_account VARCHAR(32),
su_account VARCHAR(32),
com_ID INT,
number VARCHAR(32) DEFAULT '0',
total VARCHAR(32) DEFAULT '0',
time DATE DEFAULT '0000-00-00',
CONSTRAINT 8 FOREIGN KEY(co_account) REFERENCES costumers(account),
CONSTRAINT 9 FOREIGN KEY(sh_account) REFERENCES shops(account),
CONSTRAINT 10 FOREIGN KEY(com_ID) REFERENCES commodities(ID)
);

CREATE ROLE IF NOT EXISTS 'costumer', 'shop', 'supplier';

#客户角色权限
GRANT SELECT ON shopping.costumers TO costumer;

GRANT UPDATE(password, balacnce, address) ON shopping.costumers TO costumer;

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



package com.starock.lizhishop.dao;

import com.starock.lizhishop.entity.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoftwareDao {
    //其实看函数名就能知道是什么作用的
    //这里的方法与resouces/mapper/SoftwareDao.xml里面的一一对应，涉及到MySQL。
    //这里同样留了getSoftwaresOnWindows和changeDetails两个方法
    List<Software> getSoftwaresOnWindows();
    boolean changeDetails(Integer price_id, Float price_value);

    //下面是lyb写的

    //************************客户相关操作语句******************************/

    //查询所有商品
    public boolean selectAllCom ();

    //更新客户密码
    public boolean updateCoPwd (@Param("name"),@Param("newPwd"));

    //更新客户余额
    public boolean updateCoBalacnce (@Param("name"),@Param("newBlc"));

    //更新客户地址
    public boolean updateCoAddress (@Param("name"),@Param("newAdrs"));

    //删除某客户
    public boolean deleteCo (@Param("name"));

    //将某商品增加至购物车中
    public boolean addToShoppingCar (@Param("co_account"),@Param("comID"),@Param("amount"));

    //将某商品从购物车中删除
    public boolean deleteFromShoppingCar (@Param("co_account"),@Param("comID"),@Param("amount"));

    //查询购物车中某商品的数量
    public boolean selectAmountInShoppingCar (@Param("co_account"),@Param("comID"));

    //修改购物车中某商品的数量
    public boolean updateAmountInShoppingCar (@Param("co_account"),@Param("comID"),@Param("amount"));

    //把所有商品从购物车添加进订单
    public boolean addFromShoppingCarToOrders (@Param("co_account"),@Param("comID"),@Param("owner"));

    //查询订单
    public boolean selectAllOrdersState(@Param("co_account"));

    //修改订单状态（isPay） 用户查某个具体商品的订单应该是用账号和商品ID去查的
    public boolean updateSingleOrders (@Param("co_account"),@Param("comID"),@Param("is_pay"),@Param(time));

    //************************商家相关操作语句******************************/

    //<!--商家查看信息-->
    public boolean selectAllShops (@Param("account"));

    //<!--商家修改密码和店铺名-->
    public boolean updatePwdAndName (@Param("account"),@Param("newPwd"),@Param("newName"));

    //<!--查询已发布商品-->
    public boolean selectOnlineCom (@Param("sh_account"));

    //<!--增加已发布商品-->
    public boolean insertOnlineCom (@Param("comID"),@Param("sh_account"),@Param("amount"));

    //<!--取消已发布商品-->
    public boolean deleteOnlineCom (@Param("comID"),@Param("sh_account"),@Param("amount"));

    //<!--增加货单，增加商品-->
    public boolean insertContracts (@Param("ID"),@Param("sh_account"),@Param("su_account"),,@Param("com_ID"),,@Param("amount"));

    public boolean insertCommodities (@Param("ID"),@Param("name"),@Param("url"),@Param("price"),@Param("amount"),@Param("owner"));

    //<!--查询相关供应商-->
    public boolean selectContracts (@Param("sh_account"));

    //<!--查询商品-->
    public boolean shopSelectAllCom (@Param("owner"));

    //<!--改动商品-->
    public boolean updatePwdAndName (@Param("owner"),@Param("newName"),@Param("newURL"),@Param("newPrice"),@Param("newAmount"));

    //************************供应商相关操作语句******************************/-->

    //<!--#供应商查询所有商品-->
    public boolean selectAllCom (@Param("ownerAccount"));

    //<!--#供应商增加新商品-->
    public boolean insertNewCom (@Param("name"),@Param("price"),@Param("amount"),@Param("ownerAccount"));

    //<!--#供应商查询有关商户-->
    public boolean selectContractShop (@Param("su_account"));

    //<!--#供应商修改密码和公司名-->
    public boolean updateSuoolierInfo (@Param("account"),@Param("newPwd") , @Param("newName"));



}

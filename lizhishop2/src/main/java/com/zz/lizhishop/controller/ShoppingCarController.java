package com.zz.lizhishop.controller;

import com.zz.lizhishop.dao.ShoppingcarDao;
import com.zz.lizhishop.service.CostumersService;
import com.zz.lizhishop.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
@RestController
public class ShoppingCarController {
    @Autowired
    ShoppingCarService shoppingCarService;

    //更新购物车货物数量
    @PostMapping("/costumer/updateAmountInShoppingCar")
    public Map<String,Object> ChangeShoppingCar(@RequestBody Map<String,Object> map){
        Map<String, Object> stringObjectMap = shoppingCarService.ChangeShoppingCar(map);
        return stringObjectMap;
    }

    //查询购物车
    @PostMapping("/costumer/queryShopCar")
    public Map<String,Object>QueryShopCar(@RequestBody Map<String,Object> map){
        Map<String,Object> stringObjectMap=shoppingCarService.QueryShopCar(map);
        return stringObjectMap;
    }

    //将购物车数据添加到订单
    @PostMapping("/costumer/addFromShoppingCarToOrders")
    public Map<String,Object> AddFromShoppingCarToOrders(@RequestBody Map<String,Object> map){
        Map<String,Object> stringObjectMap=shoppingCarService.AddFromShoppingCarToOrders(map);
        return stringObjectMap;
    }


}

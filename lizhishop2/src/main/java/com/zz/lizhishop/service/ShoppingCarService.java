package com.zz.lizhishop.service;

import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
public interface ShoppingCarService {
    Map<String,Object> ChangeShoppingCar(Map<String,Object> map);
    Map<String,Object> QueryShopCar(Map<String,Object > map);
    Map<String,Object> AddFromShoppingCarToOrders(Map<String,Object> map);
}

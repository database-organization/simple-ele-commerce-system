package com.zz.lizhishop.service;

import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
public interface OrdersService {
    Map<String,Object> selectAllOrdersState(Map<String,Object> map);
    Map<String,Object>updateOrder(Map<String,Object> map);
    Map<String,Object>deleteOrder(Map<String,Object> map);
}

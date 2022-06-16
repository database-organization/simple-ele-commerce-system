package com.zz.lizhishop.controller;

import com.zz.lizhishop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
@RestController
@RequestMapping("/costumer")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    //获取订单
    @PostMapping("selectAllOrdersState")
    public Map<String,Object> SelectAllOrdersState(@RequestBody Map<String,Object> map){
        Map<String,Object> stringObjectMap=ordersService.selectAllOrdersState(map);
        return stringObjectMap;
    }

    //更新订单信息
    @PostMapping("/updateOrder")
    public Map<String,Object> UpdateOrder(@RequestBody Map<String,Object>map){
        Map<String,Object> stringObjectMap=ordersService.updateOrder(map);
        return stringObjectMap;
    }

    //删除订单信息
    @PostMapping("/deleteOrder")
    public Map<String,Object> DeleteOrder(@RequestBody Map<String,Object>map){
        Map<String,Object> stringObjectMap=ordersService.deleteOrder(map);
        return stringObjectMap;
    }


}

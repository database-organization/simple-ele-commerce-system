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

    @PostMapping("selectAllOrdersState")
    public Map<String,Object> SelectAllOrdersState(@RequestBody Map<String,Object> map){
        Map<String,Object> stringObjectMap=ordersService.selectAllOrdersState(map);
        return stringObjectMap;
    }

    @PostMapping("/updateOrder")
    public Map<String,Object> UpdateOrder(@RequestBody Map<String,Object>map){
        Map<String,Object> stringObjectMap=ordersService.updateOrder(map);
        return stringObjectMap;
    }

    @PostMapping("/deleteOrder")
    public Map<String,Object> DeleteOrder(@RequestBody Map<String,Object>map){
        Map<String,Object> stringObjectMap=ordersService.deleteOrder(map);
        return stringObjectMap;
    }


}

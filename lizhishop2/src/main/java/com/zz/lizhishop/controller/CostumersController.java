package com.zz.lizhishop.controller;



import com.zz.lizhishop.service.CostumersService;
import com.zz.lizhishop.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
@RestController
public class CostumersController {
    @Autowired
    CostumersService costumersService;

    @PostMapping("/signin")
    public Map<String, Object> Login(@RequestBody Map<String, Object> map) {
        return costumersService.Login(map);
    }

    @PostMapping("/costumer/updateMsg")
    public Map<String,Object>Update(@RequestBody Map<String,Object> map){
        return costumersService.Update(map);
    }
}

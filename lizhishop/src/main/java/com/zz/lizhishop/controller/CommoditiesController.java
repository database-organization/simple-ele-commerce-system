package com.zz.lizhishop.controller;

import com.zz.lizhishop.service.CommoditiesService;
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
public class CommoditiesController {
    @Autowired
    CommoditiesService commoditiesService;

    @PostMapping("/costumer/select_all_com")
    public Map<String,Object> SelectAllCom(@RequestBody Map<String,Object> map){
        return commoditiesService.SelectAllCom(map);
    }
}

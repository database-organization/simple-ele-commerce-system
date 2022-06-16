package com.zz.lizhishop.controller;

import com.zz.lizhishop.service.ShopsService;
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
public class ShopsController {
    @Autowired
    ShopsService shopsService;

    @PostMapping("/costumer/addshops")
    public Map<String,Object> AddShops(@RequestBody Map<String,Object> map){
        Map<String,Object> stringObjectMap=shopsService.AddShops(map);
        return stringObjectMap;
    }

    @PostMapping("/costumer/SelectMsg")
    public Map<String,Object>SelectMsg(@RequestBody Map<String,Object> map){
        Map<String,Object> stringObjectMap=shopsService.SelectMsg(map);
        return stringObjectMap;
    }

    @PostMapping("/costumer/AddOnCommodities")
    public Map<String,Object>AddOnCommodities(@RequestBody Map<String,Object> map){
        Map<String,Object>stringObjectMap=shopsService.AddOnCommodities(map);
        return stringObjectMap;
    }

    @PostMapping("/costumer/DelOnCommodities")
    public Map<String,Object>DelOnCommodities(@RequestBody Map<String,Object> map){
        Map<String,Object>stringObjectMap=shopsService.DelOnCommodities(map);
        return stringObjectMap;
    }

    @PostMapping("/costumer/SelectOnCommodities")
    public Map<String,Object>SelectOnCommodities(@RequestBody Map<String,Object> map){
        Map<String,Object>stringObjectMap=shopsService.SelectOnCommodities(map);
        return stringObjectMap;
    }

    @PostMapping("/costumer/InsertContractsMsg")
    public Map<String,Object>InsertContractsMsg(@RequestBody Map<String,Object> map){
        Map<String,Object>stringObjectMap=shopsService.InsertContractsMsg(map);
        return stringObjectMap;
    }

    @PostMapping("/costumer/DeleteContractsMsg")
    public Map<String,Object>DeleteContractsMsg(@RequestBody Map<String,Object> map){
        Map<String,Object>stringObjectMap=shopsService.DeleteContractsMsg(map);
        return stringObjectMap;
    }

    @PostMapping("/costumer/SelectContractsMsg")
    public Map<String,Object>SelectContractsMsg(@RequestBody Map<String,Object> map){
        Map<String,Object>stringObjectMap=shopsService.SelectContractsMsg(map);
        return stringObjectMap;
    }


}

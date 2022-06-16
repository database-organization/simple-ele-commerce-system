package com.zz.lizhishop.controller;

import com.zz.lizhishop.entity.Suppliers;
import com.zz.lizhishop.service.SuppliersService;
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
public class SuppliersController {

    @Autowired
    SuppliersService suppliersService;

          @PostMapping("/costumer/AddSuppliers")
          public Map<String,Object> AddSuppliers(@RequestBody Map<String,Object> map){
          Map<String,Object> stringObjectMap=suppliersService.InsertSupplierMsg(map);
          return stringObjectMap;
          }

          @PostMapping("/costumer/SelectSuppliers")
          public Map<String,Object> SelectSuppliers(@RequestBody Map<String,Object> map) {
              Map<String, Object> stringObjectMap = suppliersService.SelectSupplierMsg(map);
              return stringObjectMap;
          }

}

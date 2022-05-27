package com.starock.lizhishop.controller;

import com.starock.lizhishop.entity.*;
import com.starock.lizhishop.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
//http://localhost:8080/getSoftwares
public class SoftwareController {
    @Autowired
    private SoftwareService softwareService;
    //这里我保留了两段代表性的代码，第一段是单纯的向前端发数据

//    @RequestMapping(value = "getHomePageSoftwares", method = RequestMethod.GET)
//    private Map<String, Object> getHomePageSoftwares() {
//        Map<String, Object> resultMap = new HashMap<>();
//        List<Software> discountList = softwareService.getDiscountSoftwares();
//        List<Software> recommendList = softwareService.getRecommendSoftwares();
//        List<Software> winList = softwareService.getSoftwaresOnWindows();
//        List<Software> macList = softwareService.getSoftwaresOnMac();
//
//        discountList = discountList.size() >= 6 ? discountList.subList(0, 6) : discountList;
//        recommendList = recommendList.size() >= 8 ? recommendList.subList(0, 8) : recommendList;
//        winList = winList.size() >= 4 ? winList.subList(0, 4) : winList;
//        macList = macList.size() >= 4 ? macList.subList(0, 4) : macList;
//
//        resultMap.put("code", "0");
//        resultMap.put("discountList", discountList);
//        resultMap.put("recommendList", recommendList);
//        resultMap.put("winList", winList);
//        resultMap.put("macList", macList);
//        return resultMap;
//    }

//    /**
//     * 注册
//     * @param map
//     * @return
//     */
//    @RequestMapping(value = "register", method = RequestMethod.POST)
//    private Map<String, Object> Register(@RequestBody Map<String, Object> map) {
//        Map<String, Object> resultMap = new HashMap<>();
//        if (softwareService.isRegister(map.get("email").toString(), map.get("password").toString()) != null){
//            resultMap.put("code", "-1");
//            return resultMap;
//        }
//        User user = new User();
//        user.setUsername(map.get("username").toString());
//        user.setPassword(map.get("password").toString());
//        user.setEmail(map.get("email").toString());
//
//        if (softwareService.addToUser(user))
//            resultMap.put("code", "1");
//        return resultMap;
//    }

}

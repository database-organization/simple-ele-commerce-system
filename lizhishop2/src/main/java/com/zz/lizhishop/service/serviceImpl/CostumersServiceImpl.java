package com.zz.lizhishop.service.serviceImpl;

import com.zz.lizhishop.dao.CostumersDao;
import com.zz.lizhishop.dao.ShoppingcarDao;
import com.zz.lizhishop.entity.Costumers;
import com.zz.lizhishop.service.CostumersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
@Service
public class CostumersServiceImpl implements CostumersService {

    @Autowired
    CostumersDao costumersDao;

    @Override
    public Map<String, Object> Login(Map<String, Object> map) {
        Map map2= (Map) map.get("Body");
        String account = map2.get("account").toString();
        String password = map2.get("password").toString();
        Costumers costumers = costumersDao.findCostumer(account, password);
        Map<String, Object> result = new HashMap<>();
        if (costumers != null) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("authentication", true);
            map1.put("msg", "costumer");
            result.put("Data", map1);
        }
        return result;
    }

    //登录的时候已经验证身份了，接下来直接修改就可以了
    @Override
    public Map<String,Object> Update(Map<String,Object> map){
        Map map2=(Map) map.get("Body");
        String name=map2.get("name").toString();
        String newPwd=map2.get("newPwd").toString();
        String newBlc=map2.get("newBlc").toString();
        String newAdrs=map2.get("newAdrs").toString();
        Map<String,Object> result=new HashMap<>();

        Map<String,Object> map1=new HashMap<>();
        map1.put("account",name);
        map1.put("password",newPwd);
        map1.put("balance",newBlc);
        map1.put("address",newAdrs);
        result.put("Data",map1);

        int reflect=costumersDao.changeMsg(name,newPwd,newBlc,newAdrs);
        System.out.println(reflect);
        return result;
    }
}

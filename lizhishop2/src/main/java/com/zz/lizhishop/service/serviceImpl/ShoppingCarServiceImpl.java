package com.zz.lizhishop.service.serviceImpl;

import com.zz.lizhishop.dao.ShoppingcarDao;
import com.zz.lizhishop.entity.ShoppingCar;
import com.zz.lizhishop.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {
    @Autowired
    ShoppingcarDao shoppingcarDao;
    @Override
    public Map<String, Object> ChangeShoppingCar(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String co_account=map2.get("co_account").toString();
        String com_ID=map2.get("com_ID").toString();
        int amount= Integer.parseInt(map2.get("amount").toString());
        Boolean operate= (Boolean) map2.get("operate");
        System.out.println(operate);
        if (operate==true){
            int reflect=shoppingcarDao.changecarmsg(co_account,com_ID,amount);
            System.out.println(reflect);
        }else{
            int reflect=shoppingcarDao.changecarmsg(co_account,com_ID,-amount);
            System.out.println(reflect);
        }

        Map<String,Object> result=new HashMap<>();
        Map<String,Object> map3=new HashMap<>();
        map3.put("check",operate);
        result.put("Data",map3);
        return result;
    }


    @Override
    public Map<String,Object> QueryShopCar(Map<String,Object> map){
        Map map2=(Map)map.get("Body");
        String co_account=map2.get("co_account").toString();

        List<ShoppingCar> car =shoppingcarDao.queryshopcar(co_account);
        List<Integer> com_ID=new ArrayList<>();
        List<Integer> amount=new ArrayList<>();
        for (int i=0;i<car.size();i++){
            com_ID.add(car.get(i).getCom_ID());
            amount.add(car.get(i).getCom_ID());
        }
        Map<String,Object> result=new HashMap<>();
        Map<String,Object> map3=new HashMap<>();
        map3.put("com_ID",com_ID);
        map3.put("amount",amount);
        result.put("Body",map3);
        return result;
    }

    @Override
    public Map<String, Object> AddFromShoppingCarToOrders(Map<String, Object> map) {
        Map map2=(Map) map.get("Body");
        String co_account=map2.get("co_account").toString();
        String sh_account=map2.get("sh_account").toString();
        int com_ID=Integer.parseInt(map2.get("com_ID").toString());

        int hang=shoppingcarDao.addFromShoppingCarToOrders(co_account,sh_account,com_ID);
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("check", true);
        result.put("Data", map1);
        return result;
    }


}

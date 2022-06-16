package com.zz.lizhishop.service.serviceImpl;

import com.zz.lizhishop.dao.SuppliersDao;
import com.zz.lizhishop.entity.Suppliers;
import com.zz.lizhishop.service.ShopsService;
import com.zz.lizhishop.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
@Service
public class SuppliersServiceImpl implements SuppliersService{

    @Autowired
    SuppliersDao suppliersDao;

    @Override
    public Map<String, Object> InsertSupplierMsg(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String account=map2.get("account").toString();
        String password=map2.get("password").toString();
        String name=map2.get("name").toString();

        int a=suppliersDao.InsertSupplierMsg(account,password,name);
        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg","1");
        result.put("Data",map3);
        return result;
    }

    @Override
    public Map<String, Object> SelectSupplierMsg(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String account=map2.get("account").toString();

        Suppliers suppliers=suppliersDao.SelectSupplierMsg(account);
        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg",suppliers);
        result.put("Data",map3);
        return result;
    }
}

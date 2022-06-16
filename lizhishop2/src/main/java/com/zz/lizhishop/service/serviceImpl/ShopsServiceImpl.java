package com.zz.lizhishop.service.serviceImpl;

import com.zz.lizhishop.dao.ShopsDao;
import com.zz.lizhishop.entity.OnlineCommodity;
import com.zz.lizhishop.entity.Shops;
import com.zz.lizhishop.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */

@Service
public class ShopsServiceImpl implements ShopsService {

    @Autowired
    ShopsDao shopsDao;

    //商家添加信息
    @Override
    public Map<String, Object> AddShops(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String account=map2.get("account").toString();
        String password=map2.get("password").toString();
        String name=map2.get("name").toString();

        int a= shopsDao.addshops(account,password,name);

        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg","1");
        result.put("Data",map3);
        return result;
    }

    //商家查看信息
    @Override
    public Map<String, Object> SelectMsg(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String account= map2.get("account").toString();

        Shops msg=shopsDao.SelectMsg(account);
        Map<String,Object> result=new HashMap<>();
        result.put("Data",msg);
        return result;
    }

    //增加已发布商品
    @Override
    public Map<String, Object> AddOnCommodities(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String com_ID=map2.get("com_ID").toString();
        String sh_account=map2.get("sh_account").toString();
        String amount=map2.get("amount").toString();

        int a= shopsDao.AddOnCommodities(com_ID,sh_account,amount);

        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg","1");
        result.put("Data",map3);
        return result;
    }

    //删除已发布商品
    @Override
    public Map<String, Object> DelOnCommodities(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String com_ID=map2.get("com_ID").toString();
        String sh_account=map2.get("sh_account").toString();

        int a= shopsDao.DelOnCommodities(com_ID,sh_account);
        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg","1");
        result.put("Data",map3);
        return result;
    }

    @Override
    public Map<String, Object> InsertContractsMsg(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        int ID=Integer.parseInt(map2.get("ID").toString());
        String sh_account=map2.get("sh_account").toString();
        String su_account=map2.get("su_account").toString();
        int com_ID=Integer.parseInt(map2.get("com_ID").toString());
        int amount=Integer.parseInt(map2.get("amount").toString());
        int total=Integer.parseInt(map2.get("total").toString());
        String time=map2.get("time").toString();

        int a=shopsDao.InsertContractsMsg(ID,sh_account,su_account,com_ID,amount,total,time);
        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg","1");
        result.put("Data",map3);
        return result;
    }

    @Override
    public Map<String, Object> SelectContractsMsg(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String sh_account=map2.get("sh_account").toString();
        String su_account=map2.get("su_account").toString();
        int com_ID=Integer.parseInt(map2.get("com_ID").toString());

        List a=shopsDao.SelectContractsMsg(sh_account,su_account,com_ID);
        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg",a);
        result.put("Data",map3);
        return result;
    }

    @Override
    public Map<String, Object> DeleteContractsMsg(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String sh_account=map2.get("sh_account").toString();
        String su_account=map2.get("su_account").toString();
        int com_ID=Integer.parseInt(map2.get("com_ID").toString());

        int a=shopsDao.DeleteContractsMsg(sh_account,su_account,com_ID);
        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg","1");
        result.put("Data",map3);
        return result;
    }

    //查询已发布商品
    @Override
    public Map<String, Object> SelectOnCommodities(Map<String, Object> map) {
        Map map2=(Map)map.get("Body");
        String sh_account=map2.get("sh_account").toString();

        List<OnlineCommodity> a=shopsDao.SelectOnCommodities(sh_account);
        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> result=new HashMap<>();
        map3.put("msg",a);
        result.put("Data",map3);
        return result;
    }


}

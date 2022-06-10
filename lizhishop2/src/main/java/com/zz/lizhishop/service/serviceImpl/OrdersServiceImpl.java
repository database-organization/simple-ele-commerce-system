package com.zz.lizhishop.service.serviceImpl;


import com.zz.lizhishop.dao.OrdersDao;
import com.zz.lizhishop.entity.Orders;
import com.zz.lizhishop.service.OrdersService;
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
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    OrdersDao ordersDao;

    @Override
    public Map<String, Object> selectAllOrdersState(Map<String, Object> map) {
        Map map2=(Map) map.get("Body");
        String co_account=map2.get("co_account").toString();

        List<Orders> comList=ordersDao.selectAllOrdersState(co_account);
        Map<String,Object> result=new HashMap<>();
        result.put("Data",comList);
        return result;
    }

    @Override
    public Map<String,Object> updateOrder(Map<String,Object> map){
        Map map2=(Map) map.get("Body");
        String co_account=map2.get("co_account").toString();
        String com_ID=map2.get("com_ID").toString();
        String time= map2.get("time").toString();

        int changenum=ordersDao.updateOrder(co_account,com_ID,time);
        Map<String,Object> result=new HashMap<>();
        Map<String,Object> map5=new HashMap<>();
        map5.put("is_pay","是");
        result.put("Data",map5);
        return result;
    }

    @Override
    public Map<String, Object> deleteOrder(Map<String, Object> map) {
        Map map2=(Map) map.get("Body");
        ArrayList<Integer> list = (ArrayList<Integer>) map2.get("ID");
        for (int i=0;i< list.size();i++){
            ordersDao.deleteOrdersState(list.get(i));
        }
        Map<String,Object> result=new HashMap<>();
        Map<String,Object> map5=new HashMap<>();
        map5.put("is_delete","succed");
        result.put("Data",map5);
        return result;
    }
}

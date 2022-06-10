package com.zz.lizhishop.service.serviceImpl;

import com.zz.lizhishop.dao.CommoditiesDao;
import com.zz.lizhishop.entity.Commodities;
import com.zz.lizhishop.service.CommoditiesService;
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
public class CommoditiesServiceImpl  implements CommoditiesService {

    @Autowired
    CommoditiesDao commoditiesDao;

    @Override
    public Map<String, Object> SelectAllCom(Map<String, Object> map) {
        Map map2=(Map) map.get("Date");

        List<Commodities> comList=commoditiesDao.selectAllCom();
        Map<String,Object> result=new HashMap<>();
        result.put("Data",comList);
        return result;
    }
}

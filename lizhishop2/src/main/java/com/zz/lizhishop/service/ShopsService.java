package com.zz.lizhishop.service;

import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
public interface ShopsService {
    //商家添加信息
    Map<String,Object>AddShops(Map<String,Object> map);
    //商家查看信息
    Map<String,Object>SelectMsg(Map<String,Object> map);
    //查询已发布商品
    Map<String,Object>SelectOnCommodities(Map<String,Object>map);
    //增加已发布商品
    Map<String,Object>AddOnCommodities(Map<String,Object>map);
    //删除已发布商品
    Map<String,Object>DelOnCommodities(Map<String,Object>map);
    //增加货单
    Map<String,Object>InsertContractsMsg(Map<String,Object> map);
    //查询货单
    Map<String,Object>SelectContractsMsg(Map<String,Object> map);
    //删除货单
    Map<String,Object>DeleteContractsMsg(Map<String,Object> map);
}

package com.zz.lizhishop.service;

import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
public interface SuppliersService {
    //添加供应商信息
    Map<String,Object> InsertSupplierMsg(Map<String,Object> map);
    //查询供应商信息
    Map<String,Object> SelectSupplierMsg(Map<String,Object> map);
}

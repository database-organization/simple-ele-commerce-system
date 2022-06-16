package com.zz.lizhishop.dao;

import com.zz.lizhishop.entity.Suppliers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Bamboo
 * @school GUET
 */
@Mapper
public interface SuppliersDao {

    @Insert("INSERT INTO suppliers(account,password,name) values (#{account},#{password},#{name})")
    int InsertSupplierMsg(String account,String password,String name);

    @Select("SELECT * FROM suppliers where account=#{account}")
    Suppliers SelectSupplierMsg(String account);

}

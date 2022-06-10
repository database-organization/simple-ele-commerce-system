package com.zz.lizhishop.dao;

import com.zz.lizhishop.entity.Costumers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Bamboo
 * @school GUET
 */
@Mapper
public interface CostumersDao {

    @Select("select * from costumers where account = #{account} and password = #{password}")
    Costumers findCostumer(String account, String password);

    @Update("update costumers set password=#{newPwd},balance=#{newBlc},address=#{newAdrs} where account=#{name}")
    int changeMsg(String name,String newPwd,String newBlc,String newAdrs);

}

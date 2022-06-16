package com.zz.lizhishop.dao;

import com.zz.lizhishop.entity.Commodities;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author Bamboo
 * @school GUET
 */
@Mapper
public interface CommoditiesDao {
    @Select("SELECT * FROM commodities")
    List<Commodities> selectAllCom ();
}

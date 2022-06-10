package com.zz.lizhishop.dao;

import com.zz.lizhishop.entity.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Bamboo
 * @school GUET
 */
@Mapper
public interface OrdersDao {

    @Select("SELECT * FROM orders WHERE co_account = #{co_account} ")
    List<Orders> selectAllOrdersState(String co_account);

    @Update("UPDATE orders set is_pay = '是' WHERE co_account = #{co_account} AND com_ID = #{com_ID} AND time = #{time}")
    int  updateOrder(String co_account, String com_ID,String time);

    @Delete("DELETE  FROM orders WHERE ID=#{ID}")
    void deleteOrdersState(int ID);

}

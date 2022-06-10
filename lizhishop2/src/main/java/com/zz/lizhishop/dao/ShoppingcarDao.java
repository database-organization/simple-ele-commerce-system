package com.zz.lizhishop.dao;

import com.zz.lizhishop.entity.ShoppingCar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Bamboo
 * @school GUET
 */
@Mapper
public interface ShoppingcarDao {

    @Update("update shopping_car set amount=amount+#{amount} where co_account=#{co_account} and com_ID=#{com_ID}")
    int changecarmsg(String co_account, String com_ID, int amount);

    @Select("select * from shopping_car where co_account=#{co_account}")
    List<ShoppingCar> queryshopcar(String co_account);

    @Insert("INSERT INTO orders(co_account, sh_account, com_ID, amount, is_pay, total) VALUES (#{co_account},#{sh_account},#{com_ID},null,'否',null)")
    int addFromShoppingCarToOrders(String co_account,String sh_account,int com_ID);
}


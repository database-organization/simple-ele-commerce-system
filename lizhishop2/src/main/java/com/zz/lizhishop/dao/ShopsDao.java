package com.zz.lizhishop.dao;

import com.zz.lizhishop.entity.Contracts;
import com.zz.lizhishop.entity.OnlineCommodity;
import com.zz.lizhishop.entity.Shops;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Bamboo
 * @school GUET
 */
@Mapper
public interface ShopsDao {

    @Insert("INSERT INTO shops(account,password,name) values (#{account},#{password},#{name})")
    int addshops(String account,String password,String name);

    //商家查看信息
    @Select("SELECT * FROM shops WHERE account = #{account}")
    Shops SelectMsg(String account);

    //增加已发布的商品
    @Insert("INSERT INTO online_commodity (com_ID, sh_account, amount) VALUES (#{com_ID}, #{sh_account}, #{amount})")
    int AddOnCommodities(String com_ID,String sh_account,String amount);

    //删除已发布商品
    @Delete("DELETE FROM online_commodity WHERE com_ID = #{com_ID} AND sh_account = #{sh_account}")
    int DelOnCommodities(String com_ID,String sh_account);

    @Select("SELECT * FROM online_commodity WHERE sh_account = #{sh_account}")
    List<OnlineCommodity> SelectOnCommodities(String sh_account);

    @Insert("INSERT INTO contracts (ID, sh_account, su_account, com_ID, amount, total,time) VALUES (#{ID},#{sh_account},#{su_account},#{com_ID},#{amount},#{total},#{time})")
    int InsertContractsMsg(int ID, String sh_account, String su_account,int com_ID, int amount, int total, String time);

    @Delete("Delete FROM contracts WHERE sh_account = #{sh_account} and su_account =#{su_account} and com_ID=#{com_ID}")
    int DeleteContractsMsg( String sh_account, String su_account,int com_ID);

    @Select("Select * FROM contracts WHERE sh_account = #{sh_account} and su_account =#{su_account} and com_ID=#{com_ID}")
    List<Contracts> SelectContractsMsg(String sh_account, String su_account, int com_ID);

}

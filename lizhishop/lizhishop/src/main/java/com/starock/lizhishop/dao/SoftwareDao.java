package com.starock.lizhishop.dao;

import com.starock.lizhishop.entity.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoftwareDao {
    //其实看函数名就能知道是什么作用的
    //这里的方法与resouces/mapper/SoftwareDao.xml里面的一一对应，涉及到MySQL。
    //这里同样留了getSoftwaresOnWindows和changeDetails两个方法
    List<Software> getSoftwaresOnWindows();
    boolean changeDetails(Integer price_id, Float price_value);
}

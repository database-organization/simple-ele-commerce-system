package com.starock.lizhishop.service;

import com.starock.lizhishop.entity.*;

import java.util.List;

public interface SoftwareService {
    //只是一个接口罢了，具体实现看SoftwareServiceImpl
    //这里留了两个方法做参考，一个是无参数的，一个是含参的
    List<Software> getSoftwaresOnWindows();
    boolean changeDetails(Integer price_id, Float price_value);
}

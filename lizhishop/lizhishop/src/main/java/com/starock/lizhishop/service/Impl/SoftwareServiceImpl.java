package com.starock.lizhishop.service.Impl;

import com.starock.lizhishop.dao.SoftwareDao;
import com.starock.lizhishop.entity.*;
import com.starock.lizhishop.service.SoftwareService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareServiceImpl implements SoftwareService {
    //这里我留了两个方法，和SoftwareService里面留的两个是一一对应的

    private final SoftwareDao softwareDao;

    public SoftwareServiceImpl(SoftwareDao softwareDao) {
        this.softwareDao = softwareDao;
    }

    @Override
    public List<Software> getSoftwaresOnWindows() {
        System.out.println(softwareDao.getSoftwaresOnWindows());
        return softwareDao.getSoftwaresOnWindows();
    }

    @Override
    public boolean changeDetails(Integer price_id, Float price_value){
        return softwareDao.changeDetails(price_id, price_value);
    }

}

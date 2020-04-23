package com.wj.service;

import java.util.List;

import com.wj.pojo.Real;



public interface Real_EstateService {
    List<Real> getAll(int currPage,int pageSize,String cardid,String name);
    int getCount(String cardid,String name);
}

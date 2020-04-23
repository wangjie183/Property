package com.wj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wj.pojo.Real;


public interface RealDao {
    List<Real> getAll(@Param("form") int currPage,@Param("pageSize") int pageSize,@Param("id") String cardid,@Param("name") String name);
    int getCount(@Param("id") String cardid,@Param("name") String name);
}

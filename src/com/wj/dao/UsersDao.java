package com.wj.dao;

import org.apache.ibatis.annotations.Param;

import com.wj.pojo.Users;


public interface UsersDao {
	   int isValidation(@Param("id") String cardid,@Param("psw") String password);
	   int addUsers(Users user);
	   Users getByCarId(@Param("id") String cardid);
}

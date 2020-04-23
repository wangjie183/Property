package com.wj.service;

import com.wj.pojo.Users;

public interface UsersService {
	   boolean isValidation(String cardid,String password);
	   boolean addUsers(Users user);
	   Users getByCarId(String cardid);
}

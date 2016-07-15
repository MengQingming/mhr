package com.boe.personnel.service;

import java.util.List;

import com.boe.personnel.entity.UserBase;

public interface IUserBaseService {
	
	public List<UserBase> selectUserLogin(UserBase userBase);
	
}

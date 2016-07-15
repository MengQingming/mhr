package com.boe.personnel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boe.personnel.entity.UserBase;
import com.boe.personnel.repository.UserBaseDao;
import com.boe.personnel.service.IUserBaseService;

@Service
public class UserBaseServiceImpl implements IUserBaseService {

	@Autowired
	private UserBaseDao userBaseDao;
	
	@Override
	public List<UserBase> selectUserLogin(UserBase userBase) {
		return userBaseDao.selectUserLogin(userBase);
	}

}

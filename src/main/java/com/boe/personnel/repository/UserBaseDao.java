package com.boe.personnel.repository;

import java.util.List;

import com.boe.personnel.entity.UserBase;

/**
 * 用户基础表Dao
 *
 */
@MyBatisRepository
public interface UserBaseDao {
	
	public List<UserBase> selectUserLogin(UserBase userBase);
	
}
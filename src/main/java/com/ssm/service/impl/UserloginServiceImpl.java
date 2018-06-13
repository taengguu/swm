package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserloginMapper;
import com.ssm.entity.Userlogin;
import com.ssm.service.UserloginService;

@Service
public class UserloginServiceImpl implements UserloginService{

	@Autowired
	private UserloginMapper userloginMapper;
	
	
	public Userlogin findByName(String name) {
		// TODO Auto-generated method stub
		return this.userloginMapper.selectByName(name);
	}

	public void save(Userlogin userlogin) {
		this.userloginMapper.insert(userlogin);
		
	}

	public void removeByName(String name) {
		this.userloginMapper.deleteByName(name);
		
	}

	public void updateByName(String name, Userlogin userlogin) {
		userlogin.setUserName(name);
		this.userloginMapper.updateByPrimaryKeySelective(userlogin);
		
	}

	public void removeById(Integer id) {
		this.userloginMapper.deleteByPrimaryKey(id);
		
	}

}

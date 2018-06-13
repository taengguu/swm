package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.dao.RoleMapper;
import com.ssm.entity.Role;
import com.ssm.service.RoleService;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;

	public Role findById(Integer id) {
		// TODO Auto-generated method stub
		return roleMapper.selectByPrimaryKey(id);
	}
	
	
	
}

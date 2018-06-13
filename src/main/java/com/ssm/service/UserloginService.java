package com.ssm.service;

import com.ssm.entity.Userlogin;

public interface UserloginService {
	
	//根据名字查找用户
	Userlogin findByName(String name);
	//保存用户登录信息
	void save(Userlogin userlogin);

	//根据姓名删除
	void removeByName(String name);
	//根据用户名更新
	void updateByName(String name,Userlogin userlogin);
	
	void removeById(Integer id);
}

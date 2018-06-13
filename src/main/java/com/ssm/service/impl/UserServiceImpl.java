package com.ssm.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.service.UserService;


/**
 * 缓存机制：所有的查询结果都放进了缓存，也就是把mysql查询的结果放到redis中去，
 * 然后第二次发起该条查询时就可以从redis中去读取查询的结果，从而不与mysql交互，从而达到优化效果，
 * redis和mysql查询速度相当于  内存读写和硬盘读写
 * @Cacheable("a")注解的意义就是把该方法的查询结果放到redis中去，下一次再发起查询就去redis中获取，存在redis中的数据的key就是a；
 * @CacheEvict(value={"a","b"},allEntries=true) 执行该方法后要清除redis中的key名称为a,b的数据
 * 
 * @author xjl
 *
 */
@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class UserServiceImpl implements UserService{

//	@Autowired
//	private UserMapper userMapper;
//	
//	@Cacheable("findUserById")
//	public User findUserById(Integer userId){
//		return this.userMapper.selectByPrimaryKey(userId);
//	}
//	
//	@Cacheable("getAllUser")
//	public List<User> findAll() {
//		// TODO Auto-generated method stub
//		return userMapper.selectAll();
//	}
//
//	@CacheEvict(value={"getAllUser","getUserById"},allEntries=true)//清空缓存
//	public void saveUser(User user){
//		 this.userMapper.insert(user);
//	}
//	@CacheEvict(value={"getAllUser","getUserById"},allEntries=true)//清空缓存
//	public void deleteUser(Integer userId){
//		this.userMapper.deleteByPrimaryKey(userId);
//	}
//	
//	@CacheEvict(value={"getAllUser","getUserById"},allEntries=true)//清空缓存
//	public void updateUser(User user){
//		this.userMapper.updateByPrimaryKeySelective(user);
//	}
//
//	public User findUserByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Set<String> getRoles(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Set<String> getPermissions(String username) {
//		// TODO Auto-generated method stub
//		return userMapper.;
//	}
	
}

package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
//
//	@RequestMapping("/index")
//	public String index(Model model){
//		System.out.println( list.get(0).getUserName());
//		model.addAttribute("username", list.get(0).getUserName());
//		return "index";
//	}
//
//	@ResponseBody
//	@RequestMapping(value="/getname",method=RequestMethod.GET)
//	public Map<String,Object> getname(){
//		System.out.println("*******showUsers******");
//		List<User> list = userService.findAll();
//		Map<String, Object> user=new HashMap<String, Object>();
//		user.put("user", list);
//		return user;
//	}
//	
//	@RequestMapping(value="/adduser",method=RequestMethod.GET)
//	@ResponseBody
//	public String addUser(Model model){
//		
//		System.out.println("******addUser*****");
//		User user=new User();
//		user.setUserId(2352);
//		user.setUserName("陈晨");
//		user.setAge(22);
//		user.setSex("男");
//		userService.saveUser(user);
//		System.out.println("添加成功");
//		return "添加成功";
//	}
//	
//	@RequestMapping(value="/deleteuser",method=RequestMethod.GET)
//	@ResponseBody
//	public String deleteUser(Model model){
//		System.out.println("******deleteUser********");
//		userService.deleteUser(2352);
//		System.out.println("*********删除成功****");
//		return "删除成功";
//	}

}

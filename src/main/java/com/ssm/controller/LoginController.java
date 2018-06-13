package com.ssm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.entity.Userlogin;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginUrl(){
		return "../../login";
	}

	
	@RequestMapping(value="/login1",method = RequestMethod.POST)
	public String login(Userlogin userlogin) throws Exception{
		UsernamePasswordToken token = new UsernamePasswordToken(userlogin.getUserName(),userlogin.getPassword());
		
		Subject subject = SecurityUtils.getSubject();
		//登录验证 ，失败会抛出异常
		try{
			subject.login(token);
		}catch(IncorrectCredentialsException e) {
			System.out.println("密码错误");
		}
		catch (Exception e) {
			System.out.println("登录失败："+e);
		}
		
		
		if(subject.hasRole("admin")){
			return "redirect:/admin/showStudent";
			
		}else if(subject.hasRole("teacher")){
			return "redirect:/teacher/showCourse";
		}else if(subject.hasRole("student")){
			return "redirect:/student/showCourse";
		}
		
		
		return "../../login";
	}
}

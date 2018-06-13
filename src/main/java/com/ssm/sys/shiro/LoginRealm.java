package com.ssm.sys.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssm.entity.Role;
import com.ssm.entity.Userlogin;
import com.ssm.service.RoleService;
import com.ssm.service.UserloginService;

@Component
public class LoginRealm extends AuthorizingRealm{

	@Autowired
	private UserloginService userloginService;
	
	@Autowired
	private RoleService roleService;
	
	
	/**
	 * 授权
	 * 从数据库获取该用户的权限和角色信息 进行权限验证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

		String username = (String) principalCollection.getPrimaryPrincipal();
		Role role = null;
		
		Userlogin userlogin = userloginService.findByName(username);
		role = roleService.findById(userlogin.getRole());
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		Set<String> r = new HashSet<String>();
		
		if(role!=null){
			r.add(role.getRolename());
			info.setRoles(r);
		}
		
		
		return info;
	}

	/**
	 * 认证
	 * 进行身份验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		//用户名
		String username = (String) token.getPrincipal();
		//密码
		String password = new String((char[])token.getCredentials());
		
		Userlogin userlogin = null;
		userlogin=userloginService.findByName(username);
		
		if(userlogin == null){
//			抛出没有改用户异常
			throw new UnknownAccountException();
			
		}else if(!password.equals(userlogin.getPassword())){
			//抛出密码错误异常
			throw new IncorrectCredentialsException();
		}
		//验证通过返回一个身份信息
		AuthenticationInfo aInfo = new SimpleAuthenticationInfo(username, password,getName());
		
		return aInfo;
	}

}

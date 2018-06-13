package com.ssm.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**
 * 
 * 实体类之间的复制（忽略null值）
 * 使用apache的BeanUtils
 * @author xjl
 *
 */
public class copyPropertiesUtils {
	
	/**
	 * 实体类之间的复制,调用getNullPropertyNames获取source中的null的key,null不复制到target中
	 * @param source 源实体对象
	 * @param target 目标实体对象
	 */
	public static void copyPropertiesInoreNull(Object source,Object target){
		BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
	}
	
	
	/**
	 * 获取source对象中的null值得属性key
	 * @param source
	 * @return source中的null值得key
	 */
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<String>();
		for(PropertyDescriptor pd : pds){
			Object srcValue = src.getPropertyValue(pd.getName());
			if(srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}
	
	

}

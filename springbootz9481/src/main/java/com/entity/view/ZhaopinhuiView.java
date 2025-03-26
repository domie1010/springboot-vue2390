package com.entity.view;

import com.entity.ZhaopinhuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 招聘会
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
@TableName("zhaopinhui")
public class ZhaopinhuiView  extends ZhaopinhuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhaopinhuiView(){
	}
 
 	public ZhaopinhuiView(ZhaopinhuiEntity zhaopinhuiEntity){
 	try {
			BeanUtils.copyProperties(this, zhaopinhuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

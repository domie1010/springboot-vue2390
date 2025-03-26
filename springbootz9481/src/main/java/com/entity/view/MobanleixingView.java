package com.entity.view;

import com.entity.MobanleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 模板类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
@TableName("mobanleixing")
public class MobanleixingView  extends MobanleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MobanleixingView(){
	}
 
 	public MobanleixingView(MobanleixingEntity mobanleixingEntity){
 	try {
			BeanUtils.copyProperties(this, mobanleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

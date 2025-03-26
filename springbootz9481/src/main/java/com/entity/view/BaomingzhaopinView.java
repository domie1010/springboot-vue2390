package com.entity.view;

import com.entity.BaomingzhaopinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 报名招聘
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
@TableName("baomingzhaopin")
public class BaomingzhaopinView  extends BaomingzhaopinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaomingzhaopinView(){
	}
 
 	public BaomingzhaopinView(BaomingzhaopinEntity baomingzhaopinEntity){
 	try {
			BeanUtils.copyProperties(this, baomingzhaopinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

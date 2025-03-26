package com.entity.model;

import com.entity.JianlishangchuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 简历上传
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public class JianlishangchuanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 简历
	 */
	
	private String jianli;
		
	/**
	 * 反馈
	 */
	
	private String fankui;
		
	/**
	 * 上传时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shangchuanshijian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：简历
	 */
	 
	public void setJianli(String jianli) {
		this.jianli = jianli;
	}
	
	/**
	 * 获取：简历
	 */
	public String getJianli() {
		return jianli;
	}
				
	
	/**
	 * 设置：反馈
	 */
	 
	public void setFankui(String fankui) {
		this.fankui = fankui;
	}
	
	/**
	 * 获取：反馈
	 */
	public String getFankui() {
		return fankui;
	}
				
	
	/**
	 * 设置：上传时间
	 */
	 
	public void setShangchuanshijian(Date shangchuanshijian) {
		this.shangchuanshijian = shangchuanshijian;
	}
	
	/**
	 * 获取：上传时间
	 */
	public Date getShangchuanshijian() {
		return shangchuanshijian;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}

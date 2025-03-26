package com.dao;

import com.entity.JianlishangchuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianlishangchuanVO;
import com.entity.view.JianlishangchuanView;


/**
 * 简历上传
 * 
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface JianlishangchuanDao extends BaseMapper<JianlishangchuanEntity> {
	
	List<JianlishangchuanVO> selectListVO(@Param("ew") Wrapper<JianlishangchuanEntity> wrapper);
	
	JianlishangchuanVO selectVO(@Param("ew") Wrapper<JianlishangchuanEntity> wrapper);
	
	List<JianlishangchuanView> selectListView(@Param("ew") Wrapper<JianlishangchuanEntity> wrapper);

	List<JianlishangchuanView> selectListView(Pagination page,@Param("ew") Wrapper<JianlishangchuanEntity> wrapper);
	
	JianlishangchuanView selectView(@Param("ew") Wrapper<JianlishangchuanEntity> wrapper);
	
}

package com.dao;

import com.entity.ZhaopinhuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhaopinhuiVO;
import com.entity.view.ZhaopinhuiView;


/**
 * 招聘会
 * 
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface ZhaopinhuiDao extends BaseMapper<ZhaopinhuiEntity> {
	
	List<ZhaopinhuiVO> selectListVO(@Param("ew") Wrapper<ZhaopinhuiEntity> wrapper);
	
	ZhaopinhuiVO selectVO(@Param("ew") Wrapper<ZhaopinhuiEntity> wrapper);
	
	List<ZhaopinhuiView> selectListView(@Param("ew") Wrapper<ZhaopinhuiEntity> wrapper);

	List<ZhaopinhuiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhaopinhuiEntity> wrapper);
	
	ZhaopinhuiView selectView(@Param("ew") Wrapper<ZhaopinhuiEntity> wrapper);
	
}

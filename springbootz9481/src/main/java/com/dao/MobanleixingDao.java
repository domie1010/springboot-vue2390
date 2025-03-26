package com.dao;

import com.entity.MobanleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MobanleixingVO;
import com.entity.view.MobanleixingView;


/**
 * 模板类型
 * 
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface MobanleixingDao extends BaseMapper<MobanleixingEntity> {
	
	List<MobanleixingVO> selectListVO(@Param("ew") Wrapper<MobanleixingEntity> wrapper);
	
	MobanleixingVO selectVO(@Param("ew") Wrapper<MobanleixingEntity> wrapper);
	
	List<MobanleixingView> selectListView(@Param("ew") Wrapper<MobanleixingEntity> wrapper);

	List<MobanleixingView> selectListView(Pagination page,@Param("ew") Wrapper<MobanleixingEntity> wrapper);
	
	MobanleixingView selectView(@Param("ew") Wrapper<MobanleixingEntity> wrapper);
	
}

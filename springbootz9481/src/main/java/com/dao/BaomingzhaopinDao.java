package com.dao;

import com.entity.BaomingzhaopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BaomingzhaopinVO;
import com.entity.view.BaomingzhaopinView;


/**
 * 报名招聘
 * 
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface BaomingzhaopinDao extends BaseMapper<BaomingzhaopinEntity> {
	
	List<BaomingzhaopinVO> selectListVO(@Param("ew") Wrapper<BaomingzhaopinEntity> wrapper);
	
	BaomingzhaopinVO selectVO(@Param("ew") Wrapper<BaomingzhaopinEntity> wrapper);
	
	List<BaomingzhaopinView> selectListView(@Param("ew") Wrapper<BaomingzhaopinEntity> wrapper);

	List<BaomingzhaopinView> selectListView(Pagination page,@Param("ew") Wrapper<BaomingzhaopinEntity> wrapper);
	
	BaomingzhaopinView selectView(@Param("ew") Wrapper<BaomingzhaopinEntity> wrapper);
	
}

package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianlishangchuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianlishangchuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianlishangchuanView;


/**
 * 简历上传
 *
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface JianlishangchuanService extends IService<JianlishangchuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianlishangchuanVO> selectListVO(Wrapper<JianlishangchuanEntity> wrapper);
   	
   	JianlishangchuanVO selectVO(@Param("ew") Wrapper<JianlishangchuanEntity> wrapper);
   	
   	List<JianlishangchuanView> selectListView(Wrapper<JianlishangchuanEntity> wrapper);
   	
   	JianlishangchuanView selectView(@Param("ew") Wrapper<JianlishangchuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianlishangchuanEntity> wrapper);
   	
}


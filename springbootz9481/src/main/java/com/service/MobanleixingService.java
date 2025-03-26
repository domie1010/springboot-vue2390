package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MobanleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MobanleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MobanleixingView;


/**
 * 模板类型
 *
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface MobanleixingService extends IService<MobanleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MobanleixingVO> selectListVO(Wrapper<MobanleixingEntity> wrapper);
   	
   	MobanleixingVO selectVO(@Param("ew") Wrapper<MobanleixingEntity> wrapper);
   	
   	List<MobanleixingView> selectListView(Wrapper<MobanleixingEntity> wrapper);
   	
   	MobanleixingView selectView(@Param("ew") Wrapper<MobanleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MobanleixingEntity> wrapper);
   	
}


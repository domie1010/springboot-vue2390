package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaopinhuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhaopinhuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhaopinhuiView;


/**
 * 招聘会
 *
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface ZhaopinhuiService extends IService<ZhaopinhuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhaopinhuiVO> selectListVO(Wrapper<ZhaopinhuiEntity> wrapper);
   	
   	ZhaopinhuiVO selectVO(@Param("ew") Wrapper<ZhaopinhuiEntity> wrapper);
   	
   	List<ZhaopinhuiView> selectListView(Wrapper<ZhaopinhuiEntity> wrapper);
   	
   	ZhaopinhuiView selectView(@Param("ew") Wrapper<ZhaopinhuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhaopinhuiEntity> wrapper);
   	
}


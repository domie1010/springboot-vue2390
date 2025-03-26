package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaomingzhaopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaomingzhaopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaomingzhaopinView;


/**
 * 报名招聘
 *
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface BaomingzhaopinService extends IService<BaomingzhaopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaomingzhaopinVO> selectListVO(Wrapper<BaomingzhaopinEntity> wrapper);
   	
   	BaomingzhaopinVO selectVO(@Param("ew") Wrapper<BaomingzhaopinEntity> wrapper);
   	
   	List<BaomingzhaopinView> selectListView(Wrapper<BaomingzhaopinEntity> wrapper);
   	
   	BaomingzhaopinView selectView(@Param("ew") Wrapper<BaomingzhaopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaomingzhaopinEntity> wrapper);
   	
}


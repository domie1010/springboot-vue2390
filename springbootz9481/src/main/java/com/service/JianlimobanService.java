package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianlimobanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianlimobanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianlimobanView;


/**
 * 简历模板
 *
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
public interface JianlimobanService extends IService<JianlimobanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianlimobanVO> selectListVO(Wrapper<JianlimobanEntity> wrapper);
   	
   	JianlimobanVO selectVO(@Param("ew") Wrapper<JianlimobanEntity> wrapper);
   	
   	List<JianlimobanView> selectListView(Wrapper<JianlimobanEntity> wrapper);
   	
   	JianlimobanView selectView(@Param("ew") Wrapper<JianlimobanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianlimobanEntity> wrapper);
   	
}


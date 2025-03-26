package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JianlimobanDao;
import com.entity.JianlimobanEntity;
import com.service.JianlimobanService;
import com.entity.vo.JianlimobanVO;
import com.entity.view.JianlimobanView;

@Service("jianlimobanService")
public class JianlimobanServiceImpl extends ServiceImpl<JianlimobanDao, JianlimobanEntity> implements JianlimobanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianlimobanEntity> page = this.selectPage(
                new Query<JianlimobanEntity>(params).getPage(),
                new EntityWrapper<JianlimobanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianlimobanEntity> wrapper) {
		  Page<JianlimobanView> page =new Query<JianlimobanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JianlimobanVO> selectListVO(Wrapper<JianlimobanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianlimobanVO selectVO(Wrapper<JianlimobanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianlimobanView> selectListView(Wrapper<JianlimobanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianlimobanView selectView(Wrapper<JianlimobanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

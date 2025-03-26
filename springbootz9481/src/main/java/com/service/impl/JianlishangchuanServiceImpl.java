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


import com.dao.JianlishangchuanDao;
import com.entity.JianlishangchuanEntity;
import com.service.JianlishangchuanService;
import com.entity.vo.JianlishangchuanVO;
import com.entity.view.JianlishangchuanView;

@Service("jianlishangchuanService")
public class JianlishangchuanServiceImpl extends ServiceImpl<JianlishangchuanDao, JianlishangchuanEntity> implements JianlishangchuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianlishangchuanEntity> page = this.selectPage(
                new Query<JianlishangchuanEntity>(params).getPage(),
                new EntityWrapper<JianlishangchuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianlishangchuanEntity> wrapper) {
		  Page<JianlishangchuanView> page =new Query<JianlishangchuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JianlishangchuanVO> selectListVO(Wrapper<JianlishangchuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianlishangchuanVO selectVO(Wrapper<JianlishangchuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianlishangchuanView> selectListView(Wrapper<JianlishangchuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianlishangchuanView selectView(Wrapper<JianlishangchuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

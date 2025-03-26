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


import com.dao.ZhaopinhuiDao;
import com.entity.ZhaopinhuiEntity;
import com.service.ZhaopinhuiService;
import com.entity.vo.ZhaopinhuiVO;
import com.entity.view.ZhaopinhuiView;

@Service("zhaopinhuiService")
public class ZhaopinhuiServiceImpl extends ServiceImpl<ZhaopinhuiDao, ZhaopinhuiEntity> implements ZhaopinhuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhaopinhuiEntity> page = this.selectPage(
                new Query<ZhaopinhuiEntity>(params).getPage(),
                new EntityWrapper<ZhaopinhuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhaopinhuiEntity> wrapper) {
		  Page<ZhaopinhuiView> page =new Query<ZhaopinhuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhaopinhuiVO> selectListVO(Wrapper<ZhaopinhuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhaopinhuiVO selectVO(Wrapper<ZhaopinhuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhaopinhuiView> selectListView(Wrapper<ZhaopinhuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhaopinhuiView selectView(Wrapper<ZhaopinhuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

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


import com.dao.MobanleixingDao;
import com.entity.MobanleixingEntity;
import com.service.MobanleixingService;
import com.entity.vo.MobanleixingVO;
import com.entity.view.MobanleixingView;

@Service("mobanleixingService")
public class MobanleixingServiceImpl extends ServiceImpl<MobanleixingDao, MobanleixingEntity> implements MobanleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MobanleixingEntity> page = this.selectPage(
                new Query<MobanleixingEntity>(params).getPage(),
                new EntityWrapper<MobanleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MobanleixingEntity> wrapper) {
		  Page<MobanleixingView> page =new Query<MobanleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MobanleixingVO> selectListVO(Wrapper<MobanleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MobanleixingVO selectVO(Wrapper<MobanleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MobanleixingView> selectListView(Wrapper<MobanleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MobanleixingView selectView(Wrapper<MobanleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

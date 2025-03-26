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


import com.dao.BaomingzhaopinDao;
import com.entity.BaomingzhaopinEntity;
import com.service.BaomingzhaopinService;
import com.entity.vo.BaomingzhaopinVO;
import com.entity.view.BaomingzhaopinView;

@Service("baomingzhaopinService")
public class BaomingzhaopinServiceImpl extends ServiceImpl<BaomingzhaopinDao, BaomingzhaopinEntity> implements BaomingzhaopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaomingzhaopinEntity> page = this.selectPage(
                new Query<BaomingzhaopinEntity>(params).getPage(),
                new EntityWrapper<BaomingzhaopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaomingzhaopinEntity> wrapper) {
		  Page<BaomingzhaopinView> page =new Query<BaomingzhaopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BaomingzhaopinVO> selectListVO(Wrapper<BaomingzhaopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BaomingzhaopinVO selectVO(Wrapper<BaomingzhaopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BaomingzhaopinView> selectListView(Wrapper<BaomingzhaopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaomingzhaopinView selectView(Wrapper<BaomingzhaopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}

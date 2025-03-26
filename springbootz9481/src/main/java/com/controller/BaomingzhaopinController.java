package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.BaomingzhaopinEntity;
import com.entity.view.BaomingzhaopinView;

import com.service.BaomingzhaopinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 报名招聘
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
@RestController
@RequestMapping("/baomingzhaopin")
public class BaomingzhaopinController {
    @Autowired
    private BaomingzhaopinService baomingzhaopinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaomingzhaopinEntity baomingzhaopin,
		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fabushijianstart, 
    		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fabushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			baomingzhaopin.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaomingzhaopinEntity> ew = new EntityWrapper<BaomingzhaopinEntity>();
		if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
        	if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);
		PageUtils page = baomingzhaopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baomingzhaopin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaomingzhaopinEntity baomingzhaopin, HttpServletRequest request){
        EntityWrapper<BaomingzhaopinEntity> ew = new EntityWrapper<BaomingzhaopinEntity>();
		PageUtils page = baomingzhaopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baomingzhaopin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaomingzhaopinEntity baomingzhaopin){
       	EntityWrapper<BaomingzhaopinEntity> ew = new EntityWrapper<BaomingzhaopinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baomingzhaopin, "baomingzhaopin")); 
        return R.ok().put("data", baomingzhaopinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaomingzhaopinEntity baomingzhaopin){
        EntityWrapper< BaomingzhaopinEntity> ew = new EntityWrapper< BaomingzhaopinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baomingzhaopin, "baomingzhaopin")); 
		BaomingzhaopinView baomingzhaopinView =  baomingzhaopinService.selectView(ew);
		return R.ok("查询报名招聘成功").put("data", baomingzhaopinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaomingzhaopinEntity baomingzhaopin = baomingzhaopinService.selectById(id);
        return R.ok().put("data", baomingzhaopin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaomingzhaopinEntity baomingzhaopin = baomingzhaopinService.selectById(id);
        return R.ok().put("data", baomingzhaopin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaomingzhaopinEntity baomingzhaopin, HttpServletRequest request){
    	baomingzhaopin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baomingzhaopin);
        baomingzhaopinService.insert(baomingzhaopin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaomingzhaopinEntity baomingzhaopin, HttpServletRequest request){
    	baomingzhaopin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baomingzhaopin);
        baomingzhaopinService.insert(baomingzhaopin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BaomingzhaopinEntity baomingzhaopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baomingzhaopin);
        baomingzhaopinService.updateById(baomingzhaopin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baomingzhaopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<BaomingzhaopinEntity> wrapper = new EntityWrapper<BaomingzhaopinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = baomingzhaopinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

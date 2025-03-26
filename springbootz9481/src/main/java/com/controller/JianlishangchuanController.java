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

import com.entity.JianlishangchuanEntity;
import com.entity.view.JianlishangchuanView;

import com.service.JianlishangchuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 简历上传
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-29 21:10:33
 */
@RestController
@RequestMapping("/jianlishangchuan")
public class JianlishangchuanController {
    @Autowired
    private JianlishangchuanService jianlishangchuanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianlishangchuanEntity jianlishangchuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianlishangchuan.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianlishangchuanEntity> ew = new EntityWrapper<JianlishangchuanEntity>();
		PageUtils page = jianlishangchuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlishangchuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianlishangchuanEntity jianlishangchuan, HttpServletRequest request){
        EntityWrapper<JianlishangchuanEntity> ew = new EntityWrapper<JianlishangchuanEntity>();
		PageUtils page = jianlishangchuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianlishangchuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianlishangchuanEntity jianlishangchuan){
       	EntityWrapper<JianlishangchuanEntity> ew = new EntityWrapper<JianlishangchuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianlishangchuan, "jianlishangchuan")); 
        return R.ok().put("data", jianlishangchuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianlishangchuanEntity jianlishangchuan){
        EntityWrapper< JianlishangchuanEntity> ew = new EntityWrapper< JianlishangchuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianlishangchuan, "jianlishangchuan")); 
		JianlishangchuanView jianlishangchuanView =  jianlishangchuanService.selectView(ew);
		return R.ok("查询简历上传成功").put("data", jianlishangchuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianlishangchuanEntity jianlishangchuan = jianlishangchuanService.selectById(id);
        return R.ok().put("data", jianlishangchuan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianlishangchuanEntity jianlishangchuan = jianlishangchuanService.selectById(id);
        return R.ok().put("data", jianlishangchuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianlishangchuanEntity jianlishangchuan, HttpServletRequest request){
    	jianlishangchuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianlishangchuan);
        jianlishangchuanService.insert(jianlishangchuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianlishangchuanEntity jianlishangchuan, HttpServletRequest request){
    	jianlishangchuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianlishangchuan);
        jianlishangchuanService.insert(jianlishangchuan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JianlishangchuanEntity jianlishangchuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianlishangchuan);
        jianlishangchuanService.updateById(jianlishangchuan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianlishangchuanService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JianlishangchuanEntity> wrapper = new EntityWrapper<JianlishangchuanEntity>();
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

		int count = jianlishangchuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}

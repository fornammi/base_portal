package nammi.rule.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nammi.rule.constant.DimItemEnum;
import nammi.rule.constant.OperatorCompareEnum;
import nammi.rule.model.DimInfo;
import nammi.rule.service.DimInfoService;


@Controller
@RequestMapping(value = "/dim/*")//根路径
public class DimController {
	
	@Resource
	private DimInfoService dimInfoService;

	@RequestMapping(value="toDimPage.htm")
	public ModelAndView toDimPage(){
		ModelAndView mv = new ModelAndView("rule/dim_query");
		return mv;
		//return "rule/dim_query";
	}
	
	
	@RequestMapping(value="dim.htm", params="method=queryData")
	public ModelAndView queryData(){
		ModelAndView mv = new ModelAndView("rule/dim_list");
		//dimList
		Map map = new HashMap();
		List<DimInfo> dimList = dimInfoService.queryDimInfoByMap(map);
		mv.addObject("dataList", dimList);
		//dimItemList
		mv.addObject("dimItemList", DimItemEnum.dimItemList);
		//操作符
		mv.addObject("operatorCompareMap", OperatorCompareEnum.operatorCompareMap);
		
		return mv;
	}
	
	
	@RequestMapping(value="dim.htm", params="method=preSave")
	public ModelAndView preSave(){
		ModelAndView mv = new ModelAndView("rule/dim_pre_save");
		
		return mv;
	}
	
}

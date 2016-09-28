package com.ziroom.ssm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ziroom.ssm.exception.CommonException;
import com.ziroom.ssm.po.Goods;
import com.ziroom.ssm.service.GoodsService;
import com.ziroom.ssm.vo.GoodsQueryVo;
import com.ziroom.ssm.vo.GoodsVo;

/**
* 
* @ClassName GoodsController 
* @Description 商品信息控制类
* @author dfx
* @date 2016年6月16日 上午10:10:12 
*
*/
@Controller
@RequestMapping("/goods")//窄化url
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	//回显页面固定数据
	@ModelAttribute("goodsType")
	public Map<String, Object> goodsType() throws Exception{
		Map<String, Object> goodsType = new HashMap<String, Object>();
		goodsType.put("001", "手机");
		goodsType.put("002", "电脑");
		goodsType.put("003", "汽车");
		goodsType.put("004", "水杯");
		return goodsType;
	}
	
	//商品列表
	@RequestMapping("/getGoodsList")
	public ModelAndView getGoodsList() throws CommonException{
		ModelAndView modelAndView = new ModelAndView();
		List<Goods> goods = new ArrayList<Goods>();
		try {
			goods = goodsService.getGoodsList();
			//System.out.println(1/0);
		} catch (Exception e) {
			throw new CommonException("查询商品列表失败");
		}
		modelAndView.addObject("goods", goods);
		modelAndView.setViewName("goodslist");
		return modelAndView;
	}
	
	//查询商品详情
	@RequestMapping(value = "/getGoodById", method=RequestMethod.GET)
	public String getGoodById(Model model, @RequestParam("good_id")Integer id){
		try {
			GoodsVo goodsInfo = goodsService.getGoodById(id);
			model.addAttribute("good", goodsInfo);
		} catch (Exception e) {
			model.addAttribute("errorInfo", "获取商品信息失败");
			e.printStackTrace();
		}
		return "goodsdetail";
		//return "goodsdetaildisplay"; //数据回显
	}
	
	//修改商品
	@RequestMapping("/updateGoods")
	public String updateGoods(Integer id, Goods goods, MultipartFile multipartFile){
		try {
			//获取原始文件名
			String originalFilename = multipartFile.getOriginalFilename();
			//新文件名
			String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.indexOf("."));
			//上传图片
			File file = new File("E:\\upload\\" + fileName);
			//判断是否存在文件夹
			if(!file.exists()){
				file.mkdirs();
			}
			//上传
			multipartFile.transferTo(file);
			goods.setPic(fileName);//存储图片url
			goodsService.updateGoods(id, goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/goods/getGoodsList.action";
	}
	
	//修改商品数据回显
	@RequestMapping(value = "/updateGoodsDisplay",method = {RequestMethod.POST})
	public String updateGoodsDisplay(Model model, Integer id, 
			//回显POJO数据
			@ModelAttribute("good") GoodsQueryVo goods){
		try {
			//简单类型数据回显
			model.addAttribute("id", id);
			goodsService.updateGoods(id, goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "goodsdetaildisplay";
	}
	
	//测试RESTful
	@ResponseBody // 返回json数据
	@RequestMapping(value = "/testRestFul/{id}",method = {RequestMethod.GET})
	public GoodsVo testRestFul(Model model, @PathVariable("id")Integer id) throws Exception{
		GoodsVo goodsInfo = goodsService.getGoodById(id);
		return goodsInfo;
	}

}

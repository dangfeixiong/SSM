package com.ziroom.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ziroom.ssm.mapper.GoodsMapper;
import com.ziroom.ssm.po.Goods;
import com.ziroom.ssm.service.GoodsService;
import com.ziroom.ssm.vo.GoodsVo;
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	//获取商品列表
	public List<Goods> getGoodsList() throws Exception {
		List<Goods> goods = goodsMapper.getGoodsList();
		return goods;
	}

	//商品详情
	public GoodsVo getGoodById(Integer id) throws Exception {
		return goodsMapper.getGoodById(id);
	}

	//修改商品详情
	public void updateGoods(Integer id, Goods goods) throws Exception {
		//查询商品
		Goods good = goodsMapper.getGoodById(id);
		//实体赋值
		BeanUtils.copyProperties(goods, good);
		//修改商品
		goodsMapper.updateGoodsById(good);
		
	}

}

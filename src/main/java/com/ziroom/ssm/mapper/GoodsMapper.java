package com.ziroom.ssm.mapper;

import java.util.List;

import com.ziroom.ssm.po.Goods;
import com.ziroom.ssm.vo.GoodsVo;

public interface GoodsMapper {
    
    //获取商品列表
	List<Goods> getGoodsList() throws Exception;
	
	//获取商品详情
	GoodsVo getGoodById(Integer id) throws Exception;
	
	//修改商品
	int updateGoodsById(Goods goods) throws Exception;
}
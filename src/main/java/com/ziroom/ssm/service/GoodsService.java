package com.ziroom.ssm.service;

import java.util.List;

import com.ziroom.ssm.po.Goods;
import com.ziroom.ssm.vo.GoodsVo;

public interface GoodsService {

	List<Goods> getGoodsList() throws Exception ;

	GoodsVo getGoodById(Integer id) throws Exception ;

	void updateGoods(Integer id, Goods goods) throws Exception;

}

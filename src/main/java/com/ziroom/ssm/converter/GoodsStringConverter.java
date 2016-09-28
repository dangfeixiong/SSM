package com.ziroom.ssm.converter;

import org.springframework.core.convert.converter.Converter;
//处理所有String类型
public class GoodsStringConverter implements Converter<String, String>{

	@Override
	public String convert(String source) {
		if(source != null){
			return source.trim();
		}
		return null;
	}

}

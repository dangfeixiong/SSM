package com.ziroom.ssm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//日期类型统一处理
public class GoodsDateConverter implements Converter<String, Date>{

	private static final String DATEFORMATE = "yyyy-MM-dd HH:mm:ss";
	
	@Override
	public Date convert(String source) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATEFORMATE);
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

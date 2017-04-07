package com.baobaotao.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class UtilTest {
	public void test(){
		/*Resource rs = new ClassPathResource("log4j.properties");
		EncodedResource es = new EncodedResource(rs);
		String content = FileCopyUtils.copyToString(es.getReader());
		System.out.println(content);*/
	}
	public void test2(){
		ResourcePatternResolver rpr=new PathMatchingResourcePatternResolver();
		Resource resources=rpr.getResource("classpath*:log4j.properties");
		System.out.println(resources.getDescription());
	}
	public static void main(String[] args) throws IOException, ParseException {
		
	}
}

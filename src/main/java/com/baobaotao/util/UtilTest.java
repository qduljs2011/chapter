package com.baobaotao.util;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.FileCopyUtils;

import jdk.nashorn.internal.runtime.ECMAException;

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
	public static void main(String[] args) throws IOException {
		new UtilTest().test2();
	}
}

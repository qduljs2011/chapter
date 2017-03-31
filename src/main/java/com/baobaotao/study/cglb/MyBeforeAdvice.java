package com.baobaotao.study.cglb;

import java.lang.reflect.Method;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice{
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("欢迎");
	}
	
}

package com.baobaotao.study.processor;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

public class MyInstantionAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if("car".equals(beanName)){
			System.out.println(" 调用了 InstantiationAwareBeanPostProcessorAdapter 的postProcessBeforeInstantiation方法");
		}
		return null;
	}

	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if("car".equals(beanName)){
			System.out.println("调用了 InstantiationAwareBeanPostProcessorAdapter 的 postProcessAfterInstantiation");
		}
		return true;
	}

	@Override
	public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
			String beanName) throws BeansException {
		// TODO Auto-generated method stub
		if("car".equals(beanName)){
			System.out.println("调用了 InstantiationAwareBeanPostProcessorAdapter 的postProcessPropertyValues");
		}
		return pvs;
	}
	
}

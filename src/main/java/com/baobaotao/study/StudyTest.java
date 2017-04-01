package com.baobaotao.study;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.baobaotao.study.attr.Boss;
import com.baobaotao.study.attr.Car;
import com.baobaotao.study.cglb.MyBeforeAdvice;
import com.baobaotao.study.cglb.NativeWaiter;
import com.baobaotao.study.cglb.Waiter;
import com.baobaotao.study.conf.Beans;

public class StudyTest {
	public void test1(){
		BeanFactory bf=new XmlBeanFactory(new PathMatchingResourcePatternResolver().getResource("classpath:studyservlet.xml"));
		Car car=bf.getBean(Car.class);
		System.out.println(car.toString());
	}
	public void test2(){
		ApplicationContext ac=new AnnotationConfigApplicationContext(Beans.class);
		Car car=ac.getBean(Car.class);
		System.out.println(car);
	}
	public void test3(){
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("studyservlet.xml");
		Car car=ac.getBean(Car.class);
		System.out.println(car);
		ac.close();
	}
	public void test4(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("studyservlet.xml");
		Boss boss=ac.getBean(Boss.class);
		List<Car> list=boss.getFavorites();
		list.forEach(o1->System.out.println(o1.getBrand()));
		
	}
	public void test5(){
		Locale local=Locale.CHINA;
		NumberFormat format=NumberFormat.getCurrencyInstance(local);
		System.out.println(format.format(12.25));
	}
	public void test6(){
		Waiter waiter=new NativeWaiter();
		MyBeforeAdvice advice=new MyBeforeAdvice();
		ProxyFactory pf=new ProxyFactory();
		pf.addAdvice(advice);
		pf.setTarget(waiter);
		Waiter proWaiter=(Waiter)pf.getProxy();
		proWaiter.greetTo("江山");
	}
	public static void main(String[] args) {
	}
}

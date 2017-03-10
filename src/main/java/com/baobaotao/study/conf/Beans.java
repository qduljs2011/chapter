package com.baobaotao.study.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baobaotao.study.attr.Car;

@Configuration
public class Beans {
	@Bean
	public Car getCar(){
		Car car=new Car();
		car.setBrand("宝马");
		car.setColor("土豪黑");
		car.setMaxSpeed(200.9);
		return car;
	}
}

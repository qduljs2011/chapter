package com.baobaotao.study.designmodel.decorate;

public class People {
	private String name;
	public People(){
		super();
	}
	public People(String name){
		this.name=name;
	}
	public void showSelf() {
		System.out.println("打扮的"+name);
	}
	
}

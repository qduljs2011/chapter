package com.baobaotao.study.designmodel.decorate;

public  class Decorator extends People{
	private People people;
	public Decorator(People people){
		this.people=people;
	}
	@Override
	public void showSelf() {
		if(people!=null){
			people.showSelf();
		}
	}
}

package com.baobaotao.study.designmodel.decorate;

public class TxueDecorator extends Decorator{

	public TxueDecorator(People people) {
		super(people);
	}

	@Override
	public void showSelf() {
		System.out.println("穿T恤的牛仔库");
		super.showSelf();
	}
	
}

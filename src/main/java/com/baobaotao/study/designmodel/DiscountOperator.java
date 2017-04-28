package com.baobaotao.study.designmodel;

public class DiscountOperator implements Operator {
	private double rate;
	public DiscountOperator(double rate){
		this.rate=rate;
	}
	@Override
	public double operate(double money) {
		return money*rate;
	}

}

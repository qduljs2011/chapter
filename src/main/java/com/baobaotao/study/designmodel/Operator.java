package com.baobaotao.study.designmodel;

public interface Operator {
	double operate(double money);
	public static Operator getOperator(String type){
		if(type.equals("二折")){
			return new DiscountOperator(0.2);
		}
		if(type.equals("三折")){
			return new DiscountOperator(0.3);
		}
		if(type.equals("四折")){
			return new DiscountOperator(0.4);
		}
		if(type.equals("八折")){
			return new DiscountOperator(0.8);
		}
		return null;
	}
}

package com.baobaotao.study.designmodel.decorate;

import javax.swing.Box;

import org.springframework.jdbc.core.JdbcTemplate;

public class MojingDecorator extends Decorator{

	public MojingDecorator(People people) {
		super(people);
	}

	@Override
	public void showSelf() {
		System.out.println("戴墨镜的");
		super.showSelf();
	}
	
	public static void main(String[] args) {
		People people=new People("小明");
		TxueDecorator txue=new TxueDecorator(people);
		MojingDecorator mojing=new MojingDecorator(txue);
		mojing.showSelf();
	}
}

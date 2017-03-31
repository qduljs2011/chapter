package com.baobaotao.study.cglb;

public class NativeWaiter implements Waiter{

	@Override
	public void greetTo(String name) {
		System.out.println("greet to"+name);
	}

	@Override
	public void serveTo(String name) {
		System.out.println("serve To"+name);
	}

}

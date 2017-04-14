package com.baobaotao.study.awt;

public class Cursor {
	public static void main(String[] args) {
		Cursor cursor=new Cursor();
		People people=old->{return old=1l;};
		cursor.updateAndGet(people);
	}
	public long updateAndGet(People p){
		long a1=p.anyMethod(12);
		if(a1>0) return 1;
		return -1;
	}
}

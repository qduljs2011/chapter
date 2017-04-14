package com.baobaotao.util;

public class ObjectUtil {
	public static int getInt(Object obj){
		if(obj==null) return 0;
		try{
			return Integer.parseInt(obj.toString());
		}catch(Exception e){
			return 0;
		}
	}
	
	public static double getDoub(Object obj){
		if(obj==null) return 0;
		try{
			return Double.parseDouble(obj.toString());
		}catch(Exception e){
			return 0;
		}
	}
	public static void main(String[] args) {
		System.out.println(null==null);
	}
}

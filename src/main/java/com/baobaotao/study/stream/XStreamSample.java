package com.baobaotao.study.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Locale;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamSample {
	private static XStream xstream;
	static{
		xstream=new XStream(new DomDriver());
		xstream.alias("loginLog", LoginLog.class);
		xstream.alias("user", User.class);
		//设置类成员别名
		xstream.aliasField("id", User.class, "userId");
		//
		xstream.aliasAttribute(LoginLog.class, "userId", "id");
		xstream.useAttributeFor(LoginLog.class, "userId");
		//
		xstream.addImplicitCollection(User.class, "logs");
		//注册转换器
		xstream.registerConverter(new DateConverter(Locale.getDefault()));
	}
	public static User getUser(){
		LoginLog log=new LoginLog();
		log.setIp("192.168.0.1");
		log.setLoginDate(new Date());
		//
		LoginLog log2=new LoginLog();
		log2.setIp("192.168.0.23");
		log2.setLoginDate(new Date());
		//
		User user=new User();
		user.setUserId(1);
		user.setUserName("xstream");
		user.addLog(log);
		user.addLog(log2);
		return user;
	}
	
	public static void objectToXML()throws Exception{
		User user=getUser();
		FileOutputStream fos=new FileOutputStream("H:/datatest/XStreamSample.xml");
		xstream.toXML(user,fos);
	}
	
	public static void XMLToObject() throws Exception{
		FileInputStream fis=new FileInputStream("H:/datatest/XStreamSample.xml");
		User user=(User)xstream.fromXML(fis);
		for(LoginLog log:user.getLogs()){
			System.out.println(log.getIp());
		}
	}
	public static void main(String[] args) throws Exception {
		XStreamSample.objectToXML();
		XStreamSample.XMLToObject();
	}
}

package com.baobaotao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baobaotao.service.ProductService;
@Controller
@RequestMapping("/es")
public class EsController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/addIndex.do")
	@ResponseBody
	public String addProductIndex(){
		String msg=productService.bulkAddIndex();
		return msg;
	}
	
	@RequestMapping("/searchIndex.do")
	@ResponseBody
	public JSONObject searchIndex(String keyWord){
		JSONObject obj=new JSONObject();
		JSONArray proArr=productService.searchProduct(keyWord);
		if(proArr==null){
			obj.put("status", "no");
			obj.put("msg", "未查询到数据");
			return obj;
		}
		obj.put("status","ok");
		obj.put("proArr", proArr);
		return obj;
	}
}

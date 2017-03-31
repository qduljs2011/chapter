package com.baobaotao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}

package com.baobaotao.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.dao.ProductDao;
import com.baobaotao.domain.Product;
import com.baobaotao.esclient.EsService;

@Service
public class ProductService {
	private static Logger log=LoggerFactory.getLogger(ProductService.class);
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private EsService esService;

	public String bulkAddIndex() {
		List<Product> productList=productDao.getProductLimit();
		esService.bulkIndexProduct(productList);
		return null;
	}
	
}	

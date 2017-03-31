package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.Product;
import com.baobaotao.util.ObjectUtil;

@Repository
public class ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Product> getProductLimit() {
		String sql="select * from tianmao_by_day limit 5000";
		 List<Product> productList=jdbcTemplate.query(sql,new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();
				product.setId(rs.getInt("id"));
				product.setDataId(rs.getString("data_id"));
				product.setProductName(rs.getString("product_name"));
				product.setDetailUrl(rs.getString("detail_url"));
				product.setSaleLog(ObjectUtil.getInt(rs.getString("sale_log")));
				product.setProductImg(rs.getString("product_img"));
				product.setProductShop(rs.getString("product_shop"));
				product.setCreateTime(rs.getDate("create_time"));
				product.setApprovalNumber(rs.getString("approval_number"));
				product.setFactory(rs.getString("factory"));
				return product;
			}
			 
		});
		return productList;
	}
	
}

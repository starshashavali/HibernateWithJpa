package com.tcs.test;

import com.tcs.dao.ProductDao;
import com.tcs.dao.impl.ProductDaoImpl;
import com.tcs.domain.Product;

public class Test {
public static void main(String[] args) {
	
	ProductDao dao=new ProductDaoImpl();
	
	//Product entity=new Product();
	Product product = dao.updateProduct(101, 399.9);
	System.out.println(product);
/*	entity.setId(101);
	entity.setName("Mobile");
	entity.setPrice(109.9);
	entity.setQuantity(6);
	dao.saveProduct(entity);*/
	
	//Product product = dao.loadProductById(101);
	
	
/*	//findById
	Product product = dao.loadProductById(101);
	System.out.println(product);
	
	Product product = dao.updateProduct(101, 299.9);
	product.setPrice(299.9);
	dao.saveProduct(product);*/
	//dao.deleteProduct(101);*/
}
}

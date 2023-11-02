package com.tcs.dao;

import com.tcs.domain.Product;

public interface ProductDao {

	Product saveProduct(Product product);

	Product loadProductById(Integer id);

	Product updateProduct(Integer id, Double price);

	void deleteProduct(Integer id);

}

package com.tcs.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tcs.dao.ProductDao;
import com.tcs.domain.Product;

public class ProductDaoImpl implements ProductDao {

	private EntityManagerFactory factory; 
	public ProductDaoImpl() {
		factory= Persistence.createEntityManagerFactory("test");
	}

	@Override
	public Product saveProduct(Product product) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try {
			entityManager.persist(product);
			transaction.commit();
			System.out.println("Product is saved...");
		} catch (Exception e) {
			transaction.rollback();
			System.out.println(" erroe Occured...");
		} finally {
			entityManager.close();
		}

		return product;
	}

	@Override
	public Product loadProductById(Integer id) {
		EntityManager entityManager = factory.createEntityManager();// find() early load
		// getRefferal() lazy load
		Product product = entityManager.find(Product.class, id);
		entityManager.close();
		return product;
	}

	@Override
	public Product updateProduct(Integer id, Double price) {
		EntityManager entitymanager = factory.createEntityManager();
		Product product = entitymanager.find(Product.class, id);
		EntityTransaction transaction = entitymanager.getTransaction();
		transaction.begin();
		product.setPrice(price);
		transaction.commit();
		entitymanager.close();
		return product;
	}

	@Override
	public void deleteProduct(Integer id) {
		EntityManager entityManager = factory.createEntityManager();
		Product product = entityManager.find(Product.class, id);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(product);
		transaction.commit();
		entityManager.close();

	}

}

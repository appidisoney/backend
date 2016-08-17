package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.Dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {

	// to write test case for product, we need productDAO and product object
	
@Autowired
ProductDAO productDAO;

@Autowired
Product product;

AnnotationConfigApplicationContext context;

//you can write a method to initialize the objects

@Before
public void init()
{
	context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcartbackend");
	context.refresh();
	
	productDAO = (ProductDAO) context.getBean("productDAO");
	product = (Product) context.getBean("product");
		
	}

	@Test
	public void deleteProductTestCase()
	{
	    product.setId("PRD_001");
	    boolean flag = productDAO.delete(product);
	  
		assertEquals("deleteProductTestCase", flag, false);
	    
	}
	
	@Test
	public void addProductTestCsae()
	{
		product.setId("mob_001");
		product.setName("i_phone");
		product.setDescription("This is I_phone");
		product.setPrice(15000);
		
		productDAO.save(product);
		assertEquals("addProductTestCase" , productDAO.save(product), true);
	}
	
	@Test
	public void listProductTestCase()
	{
	   assertEquals("listProductTestCase" ,productDAO.list().size(), 2);
	}
	
	
	@Test
	public void updateProductTestCase()
	{
	product.setId("mob_004");
	product.setName("i_phone");
	product.setDescription("This is I_phone");
	product.setPrice(5000);
	assertEquals("getProductTestCase" , productDAO.update(product), true);
	}
	
	@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase" , productDAO.get("mob_008"), null);
	}
}

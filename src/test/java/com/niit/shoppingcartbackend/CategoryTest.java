package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.Dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {
	
	
	public static void main(String[] args) {
	      
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcartbackend");
		context.refresh();
		
		CategoryDAO categoryDAO =   (CategoryDAO) context.getBean("categoryDAO");
		Category category =   (Category) context.getBean("category");
		
		category.setId("CN100");
		category.setName("CGNAme001");
		category.setDescription("this is category 001 description");
		if (categoryDAO.save(category)== true)
		{
		System.out.println("Categroy created successfully");
		}
		else
		{
			System.out.println("category created unsuccessfully");
			
		}
		
		
	}
	
}




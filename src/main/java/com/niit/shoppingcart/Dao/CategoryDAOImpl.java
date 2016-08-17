package com.niit.shoppingcart.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;


	@Repository("categoryDAO")
	public class CategoryDAOImpl implements CategoryDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		public CategoryDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public boolean save(Category category){
			sessionFactory.getCurrentSession().save(category);
			return false;
		}
		/*
		@Transactional
		public void delete(String id){
		     Category categoryToDelete = new Category();
			categoryToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(categoryToDelete);
		}
		
		@Transactional
		public Category get(String id){
			String hql = "from Category where id=" + "'" +id +"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>)query.list();
			if(listCategory!= null && !listCategory.isEmpty()){
				return listCategory.get(0);
			}
			return null;
			}
		
		@Transactional
      public List<Category> list(){
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>)
			sessionFactory.getCurrentSession()
			.createCriteria(Category.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listCategory;}
		*/
		public boolean save1(Category category) {
			//TODP Auto-generated method stub
			return false;
		}

		public boolean update(Category category) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean delete(Category category) {
			// TODO Auto-generated method stub
			return false;
		}

		public Category get(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Category> list() {
			// TODO Auto-generated method stub
			return null;
		}
	}
		
		
		
		


package com.niit.shoppingcart.Dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;

@SuppressWarnings("deprecation")
	@Repository("productDAO")
	public class ProductDAOImpl implements ProductDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		public ProductDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		@Transactional
		public void saveOrUpdate(Product product){
			sessionFactory.getCurrentSession().saveOrUpdate(product);
		} 
		@Transactional
		public void delete(String id){
		     Product product = new Product();
			product.setId(id);
			sessionFactory.getCurrentSession().delete(product);
		}
		@Transactional
		public Product get(String id){
			String hql = "from Product where id=" + "'" +id +"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			@SuppressWarnings("unchecked")
			List<Product> listCategory = (List<Product>)((Criteria) query).list();
			if(listCategory!= null && !listCategory.isEmpty()){
				return listCategory.get(0);
			}
			return null;
			}
		
		@Transactional
      public List<Product> list(){
			@SuppressWarnings("unchecked")
			List<Product> listProduct = (List<Product>)
			sessionFactory.getCurrentSession()
			.createCriteria(Product.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listProduct;
		}
		public boolean save(Product product) {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean update(Product product) {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean delete(Product product) {
			// TODO Auto-generated method stub
			return false;
		}
}


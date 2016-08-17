package com.niit.shoppingcart.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcart.Dao.CategoryDAO;
import com.niit.shoppingcart.Dao.CategoryDAOImpl;
import com.niit.shoppingcart.Dao.ProductDAO;
import com.niit.shoppingcart.Dao.ProductDAOImpl;
import com.niit.shoppingcart.Dao.SupplierDAO;
import com.niit.shoppingcart.Dao.SupplierDAOImpl;
import com.niit.shoppingcart.Dao.UserDetailsDAO;
import com.niit.shoppingcart.Dao.UserDetailsDAOImpl;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;

@Configuration
@ComponentScan("com.niit.shoppingcart")
@EnableTransactionManagement

public class Applicationcontextconfig {

	@Bean(name = "datasource")

	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");//h2 driver
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/niitdb");//h2 url
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		return dataSource;
	}

	private Properties getHibernateproperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		//properties.put("hibernate.hbm2ddl.auto","update");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateproperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		System.out.println("session");
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTranactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	/*@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
		return new CategoryDAOImpl(sessionFactory);

	}

	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO geProductDAO(SessionFactory sessionFactory) {
		return new ProductDAOImpl(sessionFactory);

	}

	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO geSupplisDAO(SessionFactory sessionFactory) {
		return new SupplierDAOImpl(sessionFactory);

	}*/

	@Autowired
	@Bean(name = "userDetailsDAO")
	public UserDetailsDAO getUserDetailsDAO(SessionFactory sessionFactory) {
		return new UserDetailsDAOImpl(sessionFactory);

	}
}

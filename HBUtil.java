package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Category;
import com.model.Product;


public class HBUtil 
{
	public static SessionFactory sf=new Configuration()
			.addAnnotatedClass(Category.class).addAnnotatedClass(Product.class)
			.setProperties(myProperties()).buildSessionFactory();
	
	public static Properties myProperties() 
	{
		Properties p=new Properties();
		p.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		p.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/category");
		p.setProperty("hibernate.connection.username","root");
		p.setProperty("hibernate.connection.password","");
		p.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		p.setProperty("hibernate.hbm2ddl.auto","update");
		p.setProperty("hibernate.show_sql","true");
		p.setProperty("hibernate.formate_sql","true");
		
		return p;
	}

}

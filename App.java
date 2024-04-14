package com.demo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Category;
import com.model.Product;
import com.util.HBUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Session user1=HBUtil.sf.openSession();
       Transaction tx= user1.beginTransaction();
       // select all category.
       /*List<Category> list=user1.createQuery("from Category",Category.class).list();
       System.out.println(list);*/
       
       //select a category by id.
       //Category c=user1.createQuery("from Category where id=:a",Category.class).setParameter("a",12).uniqueResult();
       //System.out.println(c);
       
       //insert new category in category table.
       /*Category c1=new Category();
       c1.setName("book");
       user1.save(c1);*/
       
       //update category from category table.
       /*Category c2=new Category();
       c2.setId(6);
       c2.setName("sport");
       user1.saveOrUpdate(c2);*/
       
       
       /*//select all product
       List<Product> l=user1.createQuery("from Product",Product.class).list();
       System.out.println(l);
       
       //select product by id.
       Product p=user1.createQuery("from Product where id=:a",Product.class).setParameter("a",12).uniqueResult();
       System.out.println(p);
       
       //insert a new product into a product table.
       Product p1=new Product();
       p1.setName("biology");
       user1.save(p1);*/
       
       //update product by id.
       /*Product p2=new Product();
       p2.setId(10);
       p2.setName("azithromycine");
       user1.saveOrUpdate(p2);*/
       
       /*List<Product> plist=user1.createQuery("from Product",Product.class).list();
       for(Product p:plist)
    	   System.out.println(p.getName()+"------"+p.getCategory());*/
       
       //pagination.......
       int group=3;
       int page=0;
       while(true) 
       {
    	   System.out.println("page no "+(++page));
    	   System.out.println("--------------------------------------------");
    	   List<Product> list=user1.createQuery("from Product",Product.class)
    			   .setFirstResult((page-1)*group).setMaxResults(group).list();
    	   if(list.isEmpty())
    		   break;
    	   else
    		   for(Product p:list)
    			   System.out.println(p);
       }
       
       tx.commit();
       user1.close();
    }
}

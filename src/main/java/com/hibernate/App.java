package com.hibernate;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

public class App {

    public static void main(String[] args) {

        System.out.println("Hibernate many to many (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Stock stock = new Stock();
        stock.setStockCode("3000");
        stock.setStockName("LAKSHYA");

        Category category1 = new Category("WOW", "WOW_COMPANY");
        Category category2 = new Category("NOW", "NOW_COMPANY");

        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);

        stock.setCategories(categories);

        session.save(stock);

        session.getTransaction().commit();
        System.out.println("Done");
    }
}
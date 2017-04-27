package com.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class App {

    public static void main(String[] args) {

        System.out.println("Hibernate many to many (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Stock stock = new Stock();
        stock.setStockCode("300024");
        stock.setStockName("LAKSHYA_04");

        Category category1 = new Category("WOW_04", "WOW_COMPANY_04");
        Category category2 = new Category("NOW_04", "NOW_COMPANY_04");

        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);

        stock.setCategories(categories);

        session.save(stock);

        session.getTransaction().commit();

        Query query = session.createQuery("from Stock where stockCode = :code ");
        query.setParameter("code", "300023");
        List list = query.list();

        System.out.println(list);

        System.out.println("Done");
    }
}
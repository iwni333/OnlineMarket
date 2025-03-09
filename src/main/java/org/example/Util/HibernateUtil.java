package org.example.Util;

import org.example.Models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(OrderItem.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(CartProduct.class)
                .addAnnotatedClass(Cart.class);
        return configuration.buildSessionFactory();
    }
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}

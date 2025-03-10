package org.example.Service;

import org.example.Models.Product;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> findAll() {
        List<Product> products = null;
        try(Session session = HibernateUtil.getSession()){
            Transaction transaction = session.beginTransaction();
           try {
               products = session.createQuery("from Product", Product.class).getResultList();
               transaction.commit();
           }catch(Exception e){
               transaction.rollback();
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }
}

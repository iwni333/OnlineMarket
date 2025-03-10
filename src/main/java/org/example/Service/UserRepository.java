package org.example.Service;

import org.example.Models.User;
import org.example.Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {


    public List<User> findAll() {
        List<User> users = null;
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                users = session.createQuery("from User", User.class).getResultList();
                transaction.commit();
            } catch (Exception e) {

                transaction.rollback();
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }
}


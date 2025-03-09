package org.example.DAO;

import org.example.Models.User;
import org.example.Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                ResultSet resultSet = (ResultSet) session.createQuery("from User");
                while (resultSet.next()) {
                    String role = resultSet.getString("role");
                    User.Role roleEnum = User.Role.valueOf(role);
                    users.add(new User(resultSet.getInt("id"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            roleEnum));
                    transaction.commit();
                }
            } catch (Exception e) {
                transaction.rollback();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }
}

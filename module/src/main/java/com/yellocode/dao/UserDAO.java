package com.yellocode.dao;


import com.yellocode.domain.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDAO {

    public User getById(Long id) {
        User user = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }

    public List<User> getByEmail(String email) {
        List<User> users = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            // JPQL
            Query query = session.createQuery("select u from User u where email = ?", User.class);
            query.setParameter(0, email);
            users = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public List<User> getAll() {
        List<User> users = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            CriteriaQuery query = session.getCriteriaBuilder().createQuery(User.class);
            query.from(User.class);
            users = session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return users;
    }

    public void save(User user) {
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void update(User user) {
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void delete(User user) {
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

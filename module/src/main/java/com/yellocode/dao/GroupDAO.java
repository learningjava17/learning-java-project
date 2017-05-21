package com.yellocode.dao;


import com.yellocode.domain.Group;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GroupDAO {


    public Group getById(Long id) {
        Group group  = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            group = session.get(Group.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return group;
    }

    public List<Group> getAll() {
        List<Group> groups = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            CriteriaQuery query = session.getCriteriaBuilder().createQuery(Group.class);
            query.from(Group.class);
            groups = session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return groups;
    }

    public void save(Group group) {
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            session.beginTransaction();
            session.save(group);
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

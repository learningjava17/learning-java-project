package com.yellocode.dao;


import com.yellocode.domain.Track;
import com.yellocode.domain.User;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class TrackDAO {

    public Track getById(Long id) {
        Track track = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            track = session.get(Track.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return track;
    }
    public List<Track> getAll() {
        List<Track> tracks = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            CriteriaQuery query = session.getCriteriaBuilder().createQuery(User.class);
            query.from(User.class);
            tracks = session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return tracks;
    }

    public void save(Track track) {
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            session.beginTransaction();
            session.save(track);
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

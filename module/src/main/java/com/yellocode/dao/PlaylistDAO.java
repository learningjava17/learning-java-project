package com.yellocode.dao;


import com.yellocode.domain.Playlist;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PlaylistDAO {

    public Playlist getById(Long id) {
        Playlist playlist = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            playlist = session.get(Playlist.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return playlist;
    }

    public List<Playlist> getAll() {
        List<Playlist> playlists = null;
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            CriteriaQuery query = session.getCriteriaBuilder().createQuery(Playlist.class);
            query.from(Playlist.class);
            playlists = session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return playlists;
    }

    public void save(Playlist playlist) {
        Session session = null;
        try {
            session = ManagerSessionFactory.getSession();
            session.beginTransaction();
            session.save(playlist);
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

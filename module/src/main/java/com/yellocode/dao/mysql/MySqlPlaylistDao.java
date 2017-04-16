package com.yellocode.dao.mysql;


import com.yellocode.dao.PlaylistDAO;
import com.yellocode.dao.entity.PlaylistEntity;
import com.yellocode.dao.exception.DaoException;

import java.util.List;

public class MySqlPlaylistDao extends MySqlBaseDao implements PlaylistDAO{
    public List<PlaylistEntity> loadAllPlaylist() throws DaoException {
        return null;
    }

    public PlaylistEntity loadUserById(Integer userId) throws DaoException {
        return null;
    }

    public void updatePlaylist(Integer trackId) throws DaoException {

    }

    public void removePlaylist(String playlistName) throws DaoException {

    }
}

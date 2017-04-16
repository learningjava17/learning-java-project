package com.yellocode.dao;


import com.yellocode.dao.entity.PlaylistEntity;
import com.yellocode.dao.exception.DaoException;

import java.util.List;

public interface PlaylistDAO {

    List<PlaylistEntity> loadAllPlaylist() throws DaoException;

    PlaylistEntity loadUserById(Integer userId) throws DaoException;

    void updatePlaylist(Integer trackId) throws DaoException;

    void removePlaylist(String playlistName) throws DaoException;
}

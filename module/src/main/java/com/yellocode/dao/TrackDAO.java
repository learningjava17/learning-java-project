package com.yellocode.dao;


import com.yellocode.dao.entity.TrackEntity;
import com.yellocode.dao.exception.DaoException;

import java.util.List;

public interface TrackDAO {

    List<TrackEntity> loadAllTracks() throws DaoException;

    TrackEntity loadTrackByName(String trackName) throws DaoException;

    TrackEntity addTrack(TrackEntity track) throws DaoException;

}

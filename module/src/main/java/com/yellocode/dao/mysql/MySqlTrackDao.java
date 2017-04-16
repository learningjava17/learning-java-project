package com.yellocode.dao.mysql;


import com.yellocode.dao.TrackDAO;
import com.yellocode.dao.entity.TrackEntity;
import com.yellocode.dao.exception.DaoException;

import java.util.List;

public class MySqlTrackDao extends MySqlBaseDao implements TrackDAO{

    public List<TrackEntity> loadAllTracks() throws DaoException {
        return null;
    }

    public TrackEntity loadTrackByName(String trackName) throws DaoException {
        return null;
    }

    public TrackEntity addTrack(TrackEntity track) throws DaoException {
        return null;
    }
}

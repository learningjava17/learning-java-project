package com.yellocode.dao.mysql;


import com.yellocode.dao.GroupDAO;
import com.yellocode.dao.entity.GroupEntity;
import com.yellocode.dao.entity.UserEntity;
import com.yellocode.dao.exception.DaoException;

import java.util.List;

public class MySqlGroupDao extends MySqlBaseDao implements GroupDAO{
    public List<GroupEntity> loadAllGroups() throws DaoException {
        return null;
    }

    public GroupEntity CreateNewGroup(String groupName) throws DaoException {
        return null;
    }

    public void updateGroup(UserEntity user) throws DaoException {

    }

    public void removeGroup(Integer groupName) throws DaoException {

    }
}

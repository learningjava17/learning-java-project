package com.yellocode.dao;


import com.yellocode.dao.entity.GroupEntity;
import com.yellocode.dao.entity.UserEntity;
import com.yellocode.dao.exception.DaoException;

import java.util.List;

public interface GroupDAO {

    List<GroupEntity> loadAllGroups() throws DaoException;

    GroupEntity CreateNewGroup(String groupName) throws DaoException;

    void updateGroup(UserEntity user) throws DaoException;

    void removeGroup(Integer groupName) throws DaoException;
}

package com.yellocode.dao;


import com.yellocode.dao.entity.UserEntity;
import com.yellocode.dao.exception.DaoException;

import java.util.List;

public interface UserDAO {

    List<UserEntity> loadAllUsers() throws DaoException;

    UserEntity loadUserById(Integer userId) throws DaoException;

    UserEntity storeUser(UserEntity user) throws DaoException;

    void storeUsers(List<UserEntity> users) throws DaoException;

    void updateUser(UserEntity user) throws DaoException;

    void removeUser(Integer userId) throws DaoException;

}

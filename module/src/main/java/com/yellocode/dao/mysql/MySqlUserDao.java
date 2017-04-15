package com.yellocode.dao.mysql;

import com.yellocode.dao.UserDAO;
import com.yellocode.dao.entity.UserEntity;
import com.yellocode.dao.exception.DaoException;
import com.yellocode.dao.mysql.db.ConnectionPool;
import com.yellocode.dao.mysql.db.ResultSetConverter;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlUserDao extends MySqlBaseDao implements UserDAO {

    public List<UserEntity> loadAllUsers() throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        List<UserEntity> result = new ArrayList<UserEntity>();

        try {
            connection = ConnectionPool.getPool().getConnection();
            statement = connection.prepareStatement("SELECT * from users");
            set = statement.executeQuery();

            while (set.next()) {
                UserEntity entity = ResultSetConverter.createUserEntity(set);
                result.add(entity);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            ConnectionPool.getPool().closeDbResources(connection, statement, set);
        }

        return result;
    }

    public UserEntity loadUserById(Integer userId) throws DaoException {
        if (userId == null) {
            return null;
        }

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        try {
            connection = ConnectionPool.getPool().getConnection();

            statement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
            statement.setInt(1, userId);

            set = statement.executeQuery();

            if (set.next()) {
                UserEntity entity = ResultSetConverter.createUserEntity(set);
                return entity;
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            ConnectionPool.getPool().closeDbResources(connection, statement, set);
        }

        return null;
    }

    public UserEntity storeUser(UserEntity user) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getPool().getConnection();

            statement = connection.prepareStatement("INSERT INTO USERS (first_name, last_name, email,) VALUES (?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());

            statement.executeUpdate();

            Integer storedId = loadStoredId(statement);
            UserEntity storedUser = loadUserById(storedId);
            return storedUser;

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            ConnectionPool.getPool().closeDbResources(connection, statement);
        }
    }

    public void storeUsers(List<UserEntity> users) throws DaoException {
        for (UserEntity user : users) {
            storeUser(user);
        }
    }

    public void updateUser(UserEntity user) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getPool().getConnection();

            statement = connection.prepareStatement("UPDATE USERS SET first_name = ?, last_name = ?, email = ? WHERE id = ?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            ConnectionPool.getPool().closeDbResources(connection, statement);
        }
    }

    public void removeUser(Integer userId) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getPool().getConnection();

            statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(4, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            ConnectionPool.getPool().closeDbResources(connection, statement);
        }
    }

}

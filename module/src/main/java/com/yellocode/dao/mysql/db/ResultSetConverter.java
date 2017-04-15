package com.yellocode.dao.mysql.db;

import com.yellocode.dao.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ResultSetConverter {

    private ResultSetConverter() {
        throw new AssertionError("Class contains static methods only. You should not instantiate it!");
    }

    public static UserEntity createUserEntity(ResultSet set) throws SQLException {
        Integer userId = set.getInt("id");
        String name = set.getString("name");
        String password = set.getString("password");
        String email = set.getString("email");

        UserEntity entity = new UserEntity();

        entity.setId(userId);
        entity.setName(name);
        entity.setPassword(password);
        entity.setEmail(email);

        return entity;
    }

}

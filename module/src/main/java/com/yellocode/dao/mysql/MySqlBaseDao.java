package com.yellocode.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MySqlBaseDao {

    protected Integer loadStoredId(Statement statement) throws SQLException {
        ResultSet set = null;

        try {
            set = statement.getGeneratedKeys();

            if (set.next()) {
                Integer storedId = set.getInt(1);
                return storedId;
            }
        } finally {
            if (set != null) {
                set.close();
            }
        }

        return null;
    }

}

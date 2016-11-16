package com.urise.webapp.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Admin on 15.11.16.
 */
public interface ConnectionFactory {
    Connection getConnection() throws SQLException;
}

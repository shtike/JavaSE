package com.urise.webapp.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Admin on 17.11.16.
 */
public interface SqlExecutor <T>{

T execute(PreparedStatement st) throws SQLException;

}

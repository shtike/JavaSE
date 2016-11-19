package com.urise.webapp.sql;

import java.sql.Connection;
import java.sql.SQLException;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by Admin on 19.11.16.
 */
public interface SqlTransaction<T> {
   T  execute (Connection conn) throws SQLException;
}

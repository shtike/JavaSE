package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.sql.ConnectionFactory;

import java.sql.*;
import java.util.List;

/**
 * Created by Admin on 15.11.16.
 */
public class SQLStorage implements Storage {
    public final ConnectionFactory connectionFactory;

    public SQLStorage(String dbUrl, String dbUser, String dbPassword) {
        connectionFactory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @Override
    public void clear() {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM resume")) {
            ps.execute();
        } catch (SQLException e) {
            throw new StorageException(e);
        }

    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
       try (Connection conn = connectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM resume WHERE r.uuid=?")){
ps.setString(1,uuid);
           ResultSet rs = ps.executeQuery();
           if (!rs.next()){
               throw new NotExistStorageException(uuid);
           }
           Resume r = new Resume(uuid, rs.getString("full_name"));
       } catch (SQLException e){
           throw new StorageException(e);
        }
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isResumeExist(Resume resume) {
        return false;
    }
}

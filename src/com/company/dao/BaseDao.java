package com.company.dao;

import com.company.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao <K, T extends Entity>{
    List<T> findAll() throws DaoException;
    T findEntityById (K id);
    boolean delete(T t);
    boolean deleteById (K id);
    boolean create(T t);
    T update (T t);

    default void close (Statement statement) {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    default void close (Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

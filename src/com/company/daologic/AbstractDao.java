package com.company.daologic;

import com.company.dao.DaoException;
import com.company.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract  class AbstractDao <T,K extends Entity> {
    protected Connection connection;

    public abstract List<T> findAll() throws DaoException;
    public  abstract T findEntityById (K id);
    public  abstract boolean delete(T t);
    public abstract boolean deleteById (K id);
    public  abstract boolean create(T t);
    abstract T update (T t);

    public void close(Statement statement) {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close (Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void setConnection (Connection connection) {
        this.connection = connection;
    }

}

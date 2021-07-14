package com.company.daologic;

import com.company.Actor;
import com.company.Category;
import com.company.dao.DaoException;
import com.company.entity.Entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao <T,K extends Entity> extends AbstractDao <T,K>{
    private static final String SQL_SELECT_ALL_ACTORS = "SELECT * FROM category";
    @Override
    public List<T> findAll() throws DaoException {
        List <Category> categories = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ACTORS);
            while (resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
                categories.add(category);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new DaoException(e);
        }
        return (List<T>)categories;
    }

    @Override
    public T findEntityById(K id) {
        return null;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean deleteById(K id) {
        return false;
    }

    @Override
    public boolean create(T t) {
        return false;
    }

    @Override
    T update(T t) {
        return null;
    }

    @Override
    public void close(Statement statement) {
        super.close(statement);
    }

    @Override
    public void close(Connection connection) {
        super.close(connection);
    }

    @Override
    void setConnection(Connection connection) {
        super.setConnection(connection);
    }
}

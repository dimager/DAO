package com.company.daologic;

import com.company.Actor;
import com.company.dao.DaoException;
import com.company.entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDao<T,K extends Entity> extends AbstractDao <T,K>{
    private static final String SQL_SELECT_ALL_ACTORS = "SELECT * FROM actor";

    @Override
    public List<T> findAll() throws DaoException {
        List <Actor> actors = new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_ACTORS);
            while (resultSet.next()){
                Actor actor = new Actor();
                actor.setId(resultSet.getInt(1));
                actor.setFirstName(resultSet.getString(2));
                actor.setLastName(resultSet.getString(3));
                actors.add(actor);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new DaoException(e);
        }
        return (List<T>)actors;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public boolean create(T t) {
        return false;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public Actor findEntityById(Entity id) {
        return null;
    }

    @Override
    public boolean deleteById(Entity id) {
        return false;
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

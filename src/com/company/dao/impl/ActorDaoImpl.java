package com.company.dao.impl;

import com.company.Actor;
import com.company.dao.ActorDao;
import com.company.dao.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActorDaoImpl implements ActorDao {

    private static final String SQL_SELECT_ALL_ACTORS = "SELECT * FROM actor";
    private static final String SQL_SELECT_ACTOR_BY_LASTNAME = "SELECT * from actor WHERE last_name=?";

    @Override
    public List<Actor> findActorByLastname(String patternName) throws DaoException {
      List <Actor> actors = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","!Pa$$w0rd");

            preparedStatement = connection.prepareStatement(SQL_SELECT_ACTOR_BY_LASTNAME);
            preparedStatement.setString(1,patternName);
            ResultSet resultSet = preparedStatement.executeQuery();
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
        finally {
            close(preparedStatement);
            close(connection);
        }
        return actors;
    }

    @Override
    public List<Actor> findAll() throws DaoException {
        List <Actor> actors = new ArrayList<>();
        Connection connection = null;
       Statement statement = null;
        try {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","!Pa$$w0rd");
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
        finally {
            close(statement);
            close(connection);
        }
        return actors;
    }

    @Override
    public Actor findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Actor actor) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean create(Actor actor) {
        return false;
    }

    @Override
    public Actor update(Actor actor) {
        return null;
    }
}

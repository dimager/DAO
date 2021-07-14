package com.company.daologic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntityTransaction {

    private Connection connection;

    public void begin (AbstractDao dao, AbstractDao ... daos){
        if (connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","!Pa$$w0rd");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        dao.setConnection(connection);
        for (AbstractDao daoElement : daos){
            daoElement.setConnection(connection);
        }
    }
    public void end(){
        try {
            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        connection = null;
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void rollback(){
        try {
            connection.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}

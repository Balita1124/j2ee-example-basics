/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.dao;

import com.main.beans.Author;
import com.main.beans.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author rico.fauchard
 */
public class DAOImpl implements DAO {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/books?autoReconnect=true&useSSL=false",
                "root", "");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    @Override
    public List<HashMap> findAll(String table) {
        String sql = "SELECT * FROM " + table + ";";
        Connection connection = null;
        ResultSet resultSet = null;
        List<HashMap> result = new ArrayList<HashMap>();
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) { 
                HashMap hm = new HashMap();
                hm.put("id", resultSet.getLong("id"));
                hm.put("book_title", resultSet.getString("book_title"));
                hm.put("category_id", resultSet.getLong("category_id"));

                result.add(hm);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public ResultSet findByid(String table, int id) {
        String sql = "SELECT * FROM " + table + " where id=" + String.valueOf(id) + ";";
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return resultSet;
    }

}

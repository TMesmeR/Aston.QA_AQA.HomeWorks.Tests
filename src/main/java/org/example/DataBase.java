package org.example;

import java.sql.*;

public class DataBase {
    Connection connection=null;

    public void Connection()
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            Statement statement = connection.createStatement();
            String createTable = "CREATE TABLE products(" +
                    "ID INT Primary Key NOT NULL AUTO_INCREMENT," +
                    "ProductName varchar(20, Price Int)";
            statement.executeUpdate(createTable);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String ProductName = resultSet.getString("ProductName");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

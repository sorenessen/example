package com.example.database;

import java.sql.*;
import java.text.MessageFormat;

/**
 * Created by soren on 8/16/2016.
 */

public class App {
    public static final String JOBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String JOBC_URL = "jdbc:mysql://localhost/sample";
    public static final String JOBC_USER = "root";
    public static final String JOBC_PASSWORD = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException  {
        Statement statement = null;
        try {
            Class.forName(JOBC_DRIVER);
            Connection connection = DriverManager.getConnection(JOBC_URL,
                    JOBC_USER, JOBC_PASSWORD);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select id, firstname, lastname, email " + "from customer");
            System.out.println("First name\tlastname\tEmail");
            int count = 0;
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("%s\t%s\t%s%n", firstname, lastname, email);
                count++;
            }
            System.out.println("--");
            System.out.println(MessageFormat.format("Rows: {0}", count));
        }finally{
            if (statement != null) {
                statement.close();
            }

        }
    }
}

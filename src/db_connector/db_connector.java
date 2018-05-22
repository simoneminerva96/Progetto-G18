package db_connector;


import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class db_connector {
    public static void main (String [] args) {
        String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";



        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;



        try {
            connection = getConnection(connectionString);
            Statement stm = connection.createStatement();

            ResultSet test = stm.executeQuery("SELECT * FROM ADVERTISMENT");

            while (test.next()) {
                System.out.println(test.getString("SPORT")+ " " +test.getString("LOCATION"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                // gestione errore in chiusura
            }
        }

    }
}



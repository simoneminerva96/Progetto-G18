package dao;

import advertisment.Periodicity;
import user.*;
import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;

public class UserDAO {


    public static boolean checkUser(String userName) throws ClassNotFoundException, SQLException {
        boolean r = false;
        Connection con = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM USERS WHERE USERNAME = '"+userName+"'");
            if (res.next()) {
                System.out.println("User already exists");
                r = false;
            }
            else {
                r = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        con.close();

        return r;

    }




    public static boolean addUser(String userName, String password, String name, String surname, Sex sex, int age) throws ClassNotFoundException, SQLException{
        boolean r = false;
        Connection con = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stmt = con.createStatement();
            int count = stmt.executeUpdate("INSERT INTO USERS (USERNAME, PASSWORD_P, NAME_PLAYER, SURNAME_PLAYER, SEX, AGE) VALUES ('"+userName+"','"+password+"', '"+name+"', '"+surname+"', '"+sex+"', '"+age+"')");
            if (count == 0) {
                System.out.println("Error");
            }
            else {
                System.out.println("User registered.");
                r = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        con.close();
        return r;
    }


    public static String getPassword (String userName) throws ClassNotFoundException, SQLException{
        Connection con = null;
        String password = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stm = con.createStatement();

            ResultSet res = stm.executeQuery("SELECT * FROM USERS WHERE USERNAME = '"+userName+"'");
            res.next();
            password = res.getString("PASSWORD_P");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        con.close();
        return password;

    }


    public static boolean deleteUser (String userName) throws ClassNotFoundException, SQLException{
        boolean r = false;
        Connection con = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stmt = con.createStatement();

            int count = stmt.executeUpdate("DELETE FROM USERS WHERE USERNAME = '"+userName+"'");

            if (count != 0) {
                r = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return r;
    }




}

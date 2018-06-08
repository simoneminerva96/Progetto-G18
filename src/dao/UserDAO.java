package dao;

import advertisment.Periodicity;
import user.*;
import java.sql.*;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.println;

public class UserDAO {


    public static boolean checkUser(String userName)  {
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
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }

        return r;

    }




    public static boolean addUser(String userName, String password, String name, String surname, Sex sex, int age) {
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
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }

        return r;
    }


    public static String getPassword (String userName) {
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
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }


        return password;

    }


    public static boolean deleteUser (String userName) {
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
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }

        return r;
    }


    public static User getUser(String userName) {
        Connection con = null;

        String password = null;
        String name = null;
        String surname = null;
        String sex1 = null;
        Sex sex = null;
        int age = 0;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM USERS WHERE USERNAME = '"+userName+"'");
            res.next();

            password = res.getString("PASSWORD_P");
            name = res.getString("NAME_PLAYER");
            surname = res.getString("SURNAME_PLAYER");
            sex1 = res.getString("SEX");
            if (sex1.equals("M")) {
                sex = Sex.M;
            }
            else if (sex1.equals("F")) {
                sex = Sex.F;
            }
            age = res.getInt("AGE");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }


        User u = new User(userName, password, name, surname, sex, age);
        return u;
    }

}

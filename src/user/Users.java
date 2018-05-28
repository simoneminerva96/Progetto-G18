package user;

import java.sql.*;
import java.util.ArrayList;
import static java.sql.DriverManager.getConnection;

public class Users {
    private String userName;
    private String password;
    private String nameP;
    private String surname;
    private Sex sex;
    private int age;
    private boolean loggedIn;
    private ArrayList<Integer> eventSelected;

    public Users (String userName, String password, String nameP, String surname, Sex sex, int age){
        this.userName = userName;
        this.password = password;
        this.nameP = nameP;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        loggedIn = false;
        this.eventSelected = new ArrayList<>();
    }





    public Sex getSex() {
        return sex;
    }





    public boolean signUp() throws ClassNotFoundException, SQLException {

        boolean r = false;
        Connection con = null;
        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stmt = con.createStatement();
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM USERS WHERE USERNAME = '"+userName+"'");
            if (res.next()) {
                System.out.println("User already exists");
            }
            else {
                int count = stmt.executeUpdate("INSERT INTO USERS (USERNAME, PASSWORD_P, NAME_PLAYER, SURNAME_PLAYER, SEX, AGE) VALUES ('"+userName+"','"+password+"', '"+nameP+"', '"+surname+"', '"+sex+"', '"+age+"')");
                if (count == 0) {
                    r = false;
                }
                else {
                    r = true;
                    System.out.println("User registered");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        con.close();

        return r;

    }





    public boolean logIn(String userName, String password) throws ClassNotFoundException, SQLException {
        Connection con = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM USERS WHERE USERNAME = '"+this.userName+"'");

            //System.out.println(res.getString("PASSWORD_P"));
            if (res.next()) {
                Statement stm1 = con.createStatement();
                if (res.getString("PASSWORD_P").equals(password)) {
                    System.out.println("Login succeffull");
                    loggedIn = true;
                }
                else {
                    System.out.println("Incorrect username or password");
                }
            }
            else {
                System.out.println("User does not exists");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        con.close();
        return loggedIn;
    }





    public boolean deleteProfile () throws ClassNotFoundException, SQLException {
        Connection con = null;
        boolean r = false;
        if (loggedIn == true) {
            try {
                String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
                Class.forName("com.mysql.jdbc.Driver");
                con = getConnection(connectionString);
                Statement stm = con.createStatement();
                int count = stm.executeUpdate("DELETE FROM USERS WHERE USERNAME = '"+this.userName+"'");
                if (count != 0) {
                    System.out.println("User deleted correctly");
                    r = true;
                    loggedIn = false;
                }
                else {
                    System.out.println("An error occurred during deleting");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        con.close();
        return r;
    }







    public boolean logOut() {
        if (loggedIn == true) {
            loggedIn = false;
            System.out.println("Logout successfull");
        }
        return loggedIn;
    }






    public boolean showEvents (SportType sport, Level level) throws ClassNotFoundException, SQLException {
        Connection con = null;

        boolean r = false;

        if (loggedIn == true) {
            try {
                String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
                Class.forName("com.mysql.jdbc.Driver");
                con = getConnection(connectionString);
                Statement stm = con.createStatement();
                ResultSet res = stm.executeQuery("SELECT * FROM ADVERTISMENT WHERE (SPORT = '"+sport+"' AND LEVEL_EVENT = '"+level+"' AND SEX = '"+getSex()+"')");
                if (res.next()) {
                    System.out.println(res.getString("COD") + ": " + res.getString("SPORT") + ", " +res.getString("LOCATION") + ", " + res.getString("EVENT_DATE") + ", " + res.getString("EVENT_HOUR") + ". Role required: " + res.getString("ROLE_REQUEST"));
                    eventSelected.add(res.getInt("COD"));
                    while (res.next()) {
                        System.out.println(res.getString("COD") + ": " + res.getString("SPORT") + ", " +res.getString("LOCATION") + ", " + res.getString("EVENT_DATE") + ", " + res.getString("EVENT_HOUR") + ". Role required: " + res.getString("ROLE_REQUEST"));
                        eventSelected.add(res.getInt("COD"));
                        r = true;
                    }
                }
                else {
                    System.out.println("Event not found");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            con.close();
        } else {
            System.out.println("User not loggedin");
        }
        return r;
    }








    public boolean selectEvent(int cod) throws ClassNotFoundException, SQLException {
        boolean r = false;
        Connection con = null;

        if (eventSelected.isEmpty()) {
            System.out.println("Error: no events showed");
        }
        else {
            if (eventSelected.contains(cod)) {
                r = true;
                System.out.println("event selected: " + cod);
                eventSelected.clear();
                try {
                    String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
                    Class.forName("com.mysql.jdbc.Driver");
                    con = getConnection(connectionString);
                    Statement stm = con.createStatement();
                    int count = stm.executeUpdate("DELETE FROM ADVERTISMENT WHERE COD = '"+cod+"'");
                    if (count != 0) {
                        System.out.println("Success");
                    }
                    else {
                        r = false;
                        System.out.println("Error");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            }
            else {
                System.out.println("Event does not exist or can't be chosed");
            }
        }
        con.close();
        return r;
    }
}

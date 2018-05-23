import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Users {
    private String userName;
    private String password;
    private String nameP;
    private String surname;
    private Sex sex;
    private int age;
    private boolean loggedIn;

    public Users (String userName, String password, String nameP, String surname, Sex sex, int age){
        this.userName = userName;
        this.password = password;
        this.nameP = nameP;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        loggedIn = false;
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
                if (res.wasNull()) {
                        System.out.println("Event not found");
                }
                else {
                    while (res.next()) {
                    System.out.println(res.getString("LOCATION") + " " + res.getString("EVENT_DATE") + " " + res.getString("EVENT_HOUR"));
                    r = true;
            }
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
}

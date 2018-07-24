package dao;

import java.sql.*;
import java.util.ArrayList;

import Controller.UserController;
import user.*;
import advertisment.*;

import static GUI.Profile.c;
import static java.sql.DriverManager.getConnection;


public class AdvertismentDAO {

    //the methods return the ArrayList of the codes of the filtered events
    public static ArrayList<Integer> getAdvertisment (SportType sport, Level level, Periodicity periodicity) {
        UserController userController = c;
        User u = userController.getUser();

        ArrayList<Integer> eventSelected = new ArrayList<>();


        Connection con = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stm = con.createStatement();

            ResultSet res = stm.executeQuery("SELECT * FROM ADVERTISMENT WHERE (SPORT = '"+sport+"' AND LEVEL_EVENT = '"+level+"' AND SEX = '"+u.sex+"' AND AGE_MIN <= '"+u.age+"' AND AGE_MAX >= '"+u.age+"' AND PERIODICITY = '"+periodicity+"')");
            if (res.next()) {
                if (res.getString("SPORT").equals("TENNIS") || res.getString("SPORT").equals("BASKET") ) {
                    System.out.println(res.getString("COD") + ": " + res.getString("SPORT") + ", " +res.getString("LOCATION") + ", " + res.getString("EVENT_DATE") + ", " + res.getString("EVENT_HOUR"));
                }
                else {
                    System.out.println(res.getString("COD") + ": " + res.getString("SPORT") + ", " + res.getString("LOCATION") + ", " + res.getString("EVENT_DATE") + ", " + res.getString("EVENT_HOUR") + ". Role required: " + res.getString("ROLE_REQUEST"));
                }
                eventSelected.add(res.getInt("COD"));
                while (res.next()) {
                    if (res.getString("SPORT").equals("TENNIS") || res.getString("SPORT").equals("BASKET") ) {
                        System.out.println(res.getString("COD") + ": " + res.getString("SPORT") + ", " +res.getString("LOCATION") + ", " + res.getString("EVENT_DATE") + ", " + res.getString("EVENT_HOUR"));
                    }
                    else {
                        System.out.println(res.getString("COD") + ": " + res.getString("SPORT") + ", " + res.getString("LOCATION") + ", " + res.getString("EVENT_DATE") + ", " + res.getString("EVENT_HOUR") + ". Role required: " + res.getString("ROLE_REQUEST"));
                    }
                    eventSelected.add(res.getInt("COD"));


                }
            }
            else {
                System.out.println("Event not found");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }



        return eventSelected;
    }

    //the methods returns the ArrayList of the filtered event
    public static ArrayList<String> ShowEvent (SportType sport, Level level, Periodicity periodicity) {
        UserController userController = c;
        User u = userController.getUser();

        ArrayList<String> ShowEvents = new ArrayList<>();

        Connection con = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stm = con.createStatement();

            ResultSet res = stm.executeQuery("SELECT * FROM ADVERTISMENT WHERE (SPORT = '"+sport+"' AND LEVEL_EVENT = '"+level+"' AND SEX = '"+u.sex+"' AND AGE_MIN <= '"+u.age+"' AND AGE_MAX >= '"+u.age+"' AND PERIODICITY = '"+periodicity+"')");
            if (res.next()) {
                ShowEvents.add(res.getString("COD") + ": " + res.getString("SPORT") + ", " + res.getString("LOCATION") + ", " + res.getString("EVENT_DATE") + ", " + res.getString("EVENT_HOUR") + ". Role required: " + res.getString("ROLE_REQUEST"));
                while (res.next()) {
                    ShowEvents.add(res.getString("COD") + ": " + res.getString("SPORT") + ", " + res.getString("LOCATION") + ", " + res.getString("EVENT_DATE") + ", " + res.getString("EVENT_HOUR") + ". Role required: " + res.getString("ROLE_REQUEST"));
                }
            }
            else {
                System.out.println("Event not found");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }

        return ShowEvents;
    }









    public static boolean checkAdvertisment (int cod) {
        boolean r = false;
        Connection con = null;

        try{
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stm = con.createStatement();

            ResultSet res = stm.executeQuery("SELECT * FROM ADVERTISMENT WHERE COD = '"+cod+"'");

            if (res.next()) {
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






    //the method deletes an advertisement when someone subscribes it
    public static boolean deleteAdvertisment (int cod) {
        boolean r = false;

        Connection con = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stmt = con.createStatement();

            int count = stmt.executeUpdate("DELETE FROM ADVERTISMENT WHERE COD = '"+cod+"'");

            if (count != 0) {
                r = true;
                System.out.println("Event deleted successfully");
            }

            else {
                System.out.println("Error");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }



        return r;
    }




    //the methods create a new code for the advertisement
    public static int checkCod()  {
        int newCod = 0;

        Connection con = null;

        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stm = con.createStatement();

            ResultSet res = stm.executeQuery("SELECT * FROM ADVERTISMENT");


            while (res.next()) {
                if (res.isLast()) {
                    newCod = res.getInt("COD") + 1;
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }



        return newCod;
    }





    //the methods allow to check the correct update of an advertisement
    public static boolean addAdvertisment(Advertisment advertisment) {
        boolean r = false;

        Connection con = null;
        int cod = checkCod();
        try {
            String connectionString = "jdbc:mysql://localhost:3306/selection?user=root&password=qazxswedc4321@";
            Class.forName("com.mysql.jdbc.Driver");
            con = getConnection(connectionString);
            Statement stmt = con.createStatement();

            int count = stmt.executeUpdate("INSERT INTO ADVERTISMENT (COD, SPORT, LOCATION, EVENT_DATE, EVENT_HOUR, ROLE_REQUEST, PERIODICITY, AGE_MIN, AGE_MAX, LEVEL_EVENT, SEX) VALUES ('"+cod+"', '"+advertisment.getSport()+"', '"+advertisment.getLocation()+"', '"+java.sql.Date.valueOf(advertisment.getDate())+"', '"+java.sql.Time.valueOf(advertisment.getTime())+"', '"+advertisment.getRole()+"', '"+advertisment.getPeriodicity()+"', '"+advertisment.getAgeMin()+"', '"+advertisment.getAgeMax()+"', '"+advertisment.getLevel()+"', '"+advertisment.getSex()+"' )");

            if (count != 0) {
                System.out.println("Event added successfully");
                r = true;
            }
            else {
                System.out.println("Error");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());
        }

        return r;
    }
}

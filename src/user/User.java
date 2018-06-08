package user;

import dao.*;
import advertisment.*;

import java.sql.*;
import java.util.ArrayList;
import static java.sql.DriverManager.getConnection;

public class User {
    private String userName;
    private String password;
    private String nameP;
    private String surname;
    private Sex sex;
    private int age;
    private boolean loggedIn;
    private ArrayList<Integer> eventSelected;

    public User(String userName, String password, String nameP, String surname, Sex sex, int age){
        this.userName = userName;
        this.password = password;
        this.nameP = nameP;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        loggedIn = false;
        this.eventSelected = new ArrayList<>();
    }





    public int getAge() {
        return age;
    }





    public Sex getSex() {
        return sex;
    }





    public boolean signUp() {

        boolean r = false;

        if (UserDAO.checkUser(userName) == false) {
            r = false;
        }
        else {
            if(UserDAO.addUser(userName, password, nameP, surname, sex, age) == true) {
                r = true;
            }
            else {
                r = false;
            }
        }
        return r;

    }





    public boolean logIn(String userName, String password) {
        if (UserDAO.checkUser(userName) == false) {
            if (UserDAO.getPassword(userName).equals(password)) {
                loggedIn = true;
                System.out.println("Login succesffull");
            }
            else  {
                System.out.println("Incorrect username or password");
            }
        }

        else {
            System.out.println("User does not exists");
        }
        return loggedIn;
    }






    public boolean deleteProfile () {
        boolean r = false;
        if (loggedIn == true) {
            if (UserDAO.deleteUser(userName) == true) {
                System.out.println("User deleted successfully");
                r = true;
            }
            else {
                System.out.println("An error occurred during deleting");
            }
        }
        else {
            System.out.println("You can't delete your profile if you are not logged in");
        }
        return r;
    }







    public boolean logOut() {
        if (loggedIn == true) {
            loggedIn = false;
            System.out.println("Logout successfull");
        }
        return loggedIn;
    }






    public boolean showEvents (SportType sport, Level level, Periodicity periodicity)  {


        boolean r = false;

        if (loggedIn == true) {
            eventSelected.addAll(AdvertismentDAO.getAdvertisment(sport, level, periodicity, getAge(), sex));
            if (eventSelected.isEmpty()) {
                r = false;
            }
            else {
                r = true;
            }
        }
        return r;
    }








    public boolean selectEvent(int cod)  {
        boolean r = false;


        if (eventSelected.isEmpty()) {
            System.out.println("Error: no events showed");
        }
        else {
            if (eventSelected.contains(cod)) {
                r = true;
                System.out.println("Event selected: " + cod);
                eventSelected.clear();
                AdvertismentDAO.deleteAdvertisment(cod);
            }
            else {
                System.out.println("Event does not exist or can't be chosed");
            }
        }

        return r;
    }





    public boolean addEvent (Advertisment advertisment) {
        boolean r = false;


        if (advertisment.checkDate() == true) {

            if (loggedIn == true) {

                r = AdvertismentDAO.addAdvertisment(advertisment);
            }
            else {
                System.out.println("Error: you are not logged in");
            }
        }

        return r;
    }






    public User getUser() {
        User user = UserDAO.getUser(userName);
        user.toString();
        return user;
    }






    @Override
    public String toString() {
        return userName + " " + password + " " + nameP + " " + surname + " " + sex + " " + age;
    }
}

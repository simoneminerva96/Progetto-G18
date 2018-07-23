package user;

import dao.*;



public class User {
    private String userName;
    private String password;
    private String nameP;
    private String surname;
    public static Sex sex;
    public static int age;
    private boolean loggedIn;

    public User(String userName, String password, String nameP, String surname, Sex sex, int age){
        this.userName = userName;
        this.password = password;
        this.nameP = nameP;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        loggedIn = false;
    }

    public int getAge() {

        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public String getUserName() {
        return userName;
    }


    public String getNameP() {
        return nameP;
    }

    public String getSurname() {
        return surname;
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
                System.out.println("Login successful");
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



    public boolean deleteProfile(String userName) {
        boolean r = false;
        if (UserDAO.deleteUser(userName) == true) {
                        System.out.println("User deleted successfully");
                        r = true;
        }
        else {
            System.out.println("An error occurred during deleting");
        }
        return r;
    }







    public boolean logOut() {
        if (loggedIn == true) {
            loggedIn = false;
            System.out.println("Logout successful");
        }
        return loggedIn;
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

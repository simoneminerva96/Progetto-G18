package Controller;


import dao.UserDAO;
import user.Sex;
import user.User;

/**
 * Class that connect GUI to the method of the class User
 */
public class UserController {
    public String userName, password, name, surname;
    public String userName1;
    public int age;
    public Sex sex;
    public UserDAO u = new UserDAO();
    public User user = new User(userName, password, name, surname, sex, age);

    //The method allows sign up.
    public User signUp(String userName, String password, String nameP, String surname, Sex sex, int age){
        user = new User(userName, password, nameP, surname, sex, age);
        user.signUp();
        return user;
    }

    //The method allwos log in
    public boolean logIn(String userName, String password) {
        boolean r = false;
        r = user.logIn( userName, password);
        if(r == true) {
            userName1 = userName;
            System.out.println(userName1);
        }
        return r;

    }

    public User getUser(){
        return u.getUser(userName1);
    }

    //The method allows to delete the profile
    public void DeleteProfile(String userName){
          user.deleteProfile(userName);
    }

}

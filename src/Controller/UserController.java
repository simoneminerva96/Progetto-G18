package Controller;


import user.Sex;
import user.User;

public class UserController {
    public String userName, password, name, surname;
    public int age;
    public Sex sex;
    public User user = new User(userName, password, name, surname, sex, age);

    public User signUp(String userName, String password, String nameP, String surname, Sex sex, int age){
        user = new User(userName, password, nameP, surname, sex, age);
        user.signUp();
        return user;
    }

    public boolean logIn(String userName, String password) {
        boolean r = false;
        r = user.logIn( userName, password);
        return r;

    }

    public void DeleteProfile(String userName){
           user.deleteProfile(userName);
    }
}

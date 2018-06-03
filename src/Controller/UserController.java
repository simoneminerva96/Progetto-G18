package Controller;

import dao.UserDAO;
import user.Sex;


import java.sql.SQLException;

public class UserController {

    private static void checkUser() throws SQLException, ClassNotFoundException {
        try {
            UserDAO.checkUser("");
        } catch (SQLException e) {
            throw e;
        }
    }

    private static void addUser () throws SQLException, ClassNotFoundException {
        try {
            UserDAO.addUser("","", "", "",Sex.values(), 0);
        } catch (SQLException e) {
            throw e;
        }
    }

    private static void deleteUser () throws SQLException, ClassNotFoundException {
        try {
            UserDAO.deleteUser("");
        } catch (SQLException e) {
            throw e;
        }
    }

    private static void getPassword () throws SQLException, ClassNotFoundException {
        try {
            UserDAO.getPassword("");
        } catch (SQLException e) {
            throw e;
        }
    }

}

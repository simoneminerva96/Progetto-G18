package tester;


import Controller.AdvertisementController;
import Controller.UserController;
import advertisment.Advertisment;
import dao.AdvertismentDAO;
import dao.UserDAO;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import user.SportType;
import user.User;


public class JunitTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(User.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}

import java.sql.SQLException;

public class TesterAddUsers {

    public static void main (String [] args) throws java.lang.ClassNotFoundException, SQLException {

       // db_connector con = new db_connector();

        Users u = new Users("ANDRE", "111", "ANDREA", "CARRA", Sex.M, 21);
        Users u1 = new Users("MARA", "222", "MARA", "GARZIA", Sex.F, 41);

       //u.addUsers();

       u.logIn("ANDRE", "111");
       u.showEvents(SportType.CALCETTO, Level.MEDIUM);

    }
}

import java.sql.SQLException;

public class TesterAddUsers {

    public static void main (String [] args) throws java.lang.ClassNotFoundException, SQLException {

       // db_connector con = new db_connector();

        Users u = new Users("ANDRE", "111", "ANDREA", "CARRA", "M", 21);


       u.addUsers();

    }
}

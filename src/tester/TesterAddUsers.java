package tester;
import java.sql.SQLException;
import user.*;
public class TesterAddUsers {

    public static void main (String [] args) throws java.lang.ClassNotFoundException, SQLException {

        // db_connector con = new db_connector();
        Users u = new Users("ANDRE", "111", "ANDREA", "CARRA", Sex.M, 21);
        Users u1 = new Users("MARA", "222", "MARA", "GARZIA", Sex.F, 41);
        Users u2 = new Users("DORIANO", "323", "DORIANO", "CARRA", Sex.M, 61);
        Users u3 = new Users("SIMO", "123", "SIMONE", "COSI", Sex.M, 28);
        Users u4 = new Users("IL_BUSSI", "Migliore", "MARCO", "TAMBUSSI", Sex.M, 21);
        Users u5 = new Users("ze", "321", "ALESSANDRO", "ZERBA", Sex.M, 22);
        Users u6 = new Users("MIRQO", "1997", "MIRKO","DE SORICELLIS", Sex.M, 21);
        //u3.signUp();
        //u4.signUp();
        //u5.signUp();
        //u6.signUp();

        u6.logIn("MIRQO", "1997");
        u6.deleteProfile();


    }
}

package tester;
import advertisment.*;
import java.sql.SQLException;
import java.sql.Time;


import user.*;
public class TesterAddUsers {

    public static void main (String [] args) throws java.lang.ClassNotFoundException, SQLException {

        // db_connector con = new db_connector();
        User u = new User("ANDRE", "111", "ANDREA", "CARRA", Sex.M, 21);
        User u1 = new User("MARA", "222", "MARA", "GARZIA", Sex.F, 41);
        User u2 = new User("DORIANO", "323", "DORIANO", "CARRA", Sex.M, 61);
        User u3 = new User("SIMO", "123", "SIMONE", "COSI", Sex.M, 28);
        User u4 = new User("IL_BUSSI", "Migliore", "MARCO", "TAMBUSSI", Sex.M, 21);
        User u5 = new User("ze", "321", "ALESSANDRO", "ZERBA", Sex.M, 22);
        User u6 = new User("MIRQO", "1997", "MIRKO","DE SORICELLIS", Sex.M, 21);
        //u3.signUp();
        //u4.signUp();
        //u5.signUp();
        u6.signUp();

        u6.logIn("MIRQO", "1997");

        Location l1 = new Location("STRADELLA", "VIA G. BOVIO 68", "LOMBARDIA", "PV");
        Advertisment a1 = new Advertisment(SportType.CALCETTO, l1, "2018-09-12", "18:00:00", Role.PORTIERE, Periodicity.GIORNALIERA,18, 21, Level.HIGH, Sex.M );
        Advertisment a2 = new Advertisment(SportType.TENNIS, l1, "2018-06-08", "17:00:00", Role.NONE, Periodicity.SETTIMANALE, 18, 21, Level.HIGH, Sex.F);
        //u6.addEvent(a1);


        u6.getUser();
        //u6.showEvents(SportType.CALCETTO, Level.HIGH, Periodicity.GIORNALIERA);
        //u6.addEvent(a2);
        //u3.logIn("SIMO", "123");
        //u3.showEvents(SportType.BASKET, Level.LOW);
    }
}

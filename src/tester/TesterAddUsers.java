package tester;
import advertisment.*;
import java.sql.SQLException;
import java.sql.Time;


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
        u6.signUp();

        u6.logIn("MIRQO", "1997");

        Location l1 = new Location("STRADELLA", "VIA G. BOVIO 68", "LOMBARDIA", "PV");
        Advertisment a1 = new Advertisment(SportType.CALCETTO, l1, "2018-09-12", "18:00:00", Role.PORTIERE, Periodicity.GIORNLIERA,18, 21, Level.HIGH, Sex.M );
        Advertisment a2 = new Advertisment(SportType.TENNIS, l1, "2018-06-08", "17:00:00", Role.NONE, Periodicity.SETTIMANALE, 18, 21, Level.HIGH, Sex.F);
        //u6.addEvent(a1);

        u6.showEvents(SportType.CALCETTO, Level.HIGH, Periodicity.GIORNLIERA);
        //u6.addEvent(a2);
        //u3.logIn("SIMO", "123");
        //u3.showEvents(SportType.BASKET, Level.LOW);
    }
}

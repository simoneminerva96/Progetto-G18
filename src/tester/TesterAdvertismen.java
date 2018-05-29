package tester;

import advertisment.Advertisment;
import advertisment.Location;
import advertisment.Periodicity;
import advertisment.Role;
import user.Level;
import user.Sex;
import user.SportType;

import java.sql.Time;
import java.time.Month;
import java.util.Date;

import static java.util.Date.*;
import static java.util.Calendar.SEPTEMBER;

public class TesterAdvertismen {
    public static void main (String[] args) {


        Location l1 = new Location("STRADELLA", "VIA G. BOVIO 68", "LOMBARDIA", "PV");
        Advertisment a1 = new Advertisment(SportType.CALCETTO, l1, "2018-09-12", "18:00:00", Role.PORTIERE, Periodicity.SETTIMANALE, 18, 21, Level.HIGH, Sex.M );

        a1.checkDate();

    }
}


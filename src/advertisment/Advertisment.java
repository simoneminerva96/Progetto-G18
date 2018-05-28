package advertisment;

import user.Level;
import user.Sex;
import user.SportType;

import java.sql.Date;
import java.sql.Time;

public class Advertisment {
    private SportType sport;
    private Sex sex;
    private Level level;
    private Location location;
    private Role role;
    private java.util.Date date;
    private Time time;
    private int ageMin;
    private int ageMax;

    public Advertisment (SportType sport, Location location, java.util.Date date, Time time, Role role, int ageMin, int ageMax, Level level, Sex sex) {
        this.sport = sport;
        this.location = location;
        this.date = date;
        this.time = time;
        this.role = role;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.level = level;
        this.sex = sex;
    }

    public boolean checkDate () {
        boolean r = false;
        java.util.Date d = new Date(System.currentTimeMillis());
        if (d.before(date)) {
            r = true;

        }
        else {
            System.out.println("You can't choose a date in the past");

        }
        return r;
    }
}

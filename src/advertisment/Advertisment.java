package advertisment;

import user.Level;
import user.Sex;
import user.SportType;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class Advertisment {
    private SportType sport;
    private Sex sex;
    private Level level;
    private Location location;
    private Role role;
    private Periodicity periodicity;
    private String date;
    private String time;
    private int ageMin;
    private int ageMax;

    public Advertisment (SportType sport, Location location, String date, String time, Role role, Periodicity periodicity, int ageMin, int ageMax, Level level, Sex sex) {
        this.sport = sport;
        this.location = location;
        this.date = date;
        this.time = time;
        this.role = role;
        this.periodicity= periodicity;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.level = level;
        this.sex = sex;
    }




    public boolean checkDate () {
        boolean r = false;
        java.sql.Date d = java.sql.Date.valueOf(LocalDate.now());

        if (d.before(java.sql.Date.valueOf(date))) {
            r = true;
        }
        else {
            System.out.println("You can't choose a date in the past");

        }
        return r;
    }





    public SportType getSport() {
        return sport;
    }






    public String getLocation() {
        return location.toString();
    }





    public String getDate() {
        return date;
    }






    public String getTime() {
        return time;
    }






    public Role getRole() {
        return role;
    }






    public int getAgeMax() {
        return ageMax;
    }







    public int getAgeMin() {
        return ageMin;
    }







    public Level getLevel() {
        return level;
    }







    public Sex getSex() {
        return sex;
    }





    public  Periodicity getPeriodicity() {
        return periodicity;
    }


}

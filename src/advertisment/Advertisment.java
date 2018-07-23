package advertisment;

import dao.AdvertismentDAO;
import user.Level;
import user.Sex;
import user.SportType;
import java.time.LocalDate;
import java.util.ArrayList;


public class Advertisment {
    private SportType sport;
    private static Sex sex;
    private Level level;
    private Location location;
    private Role role;
    private Periodicity periodicity;
    private String date;
    private String time;
    private int ageMin;
    private int ageMax;
    private static ArrayList<Integer> eventSelected;


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
        this.eventSelected = new ArrayList<>();
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




    public boolean addEvent (Advertisment advertisment) {
        boolean r = false;


        if (advertisment.checkDate() == true) {

                r = AdvertismentDAO.addAdvertisment(advertisment);
        }

        return r;
    }









    public static boolean showEvents(SportType sport, Level level, Periodicity periodicity)  {

        boolean r = false;

            eventSelected.addAll(AdvertismentDAO.getAdvertisment(sport, level, periodicity));
            if (eventSelected.isEmpty()) {
                r = false;
            }
            else {
                r = true;
            }

        return r;
    }



    public static boolean selectEvent(int cod)  {
        boolean r = false;


        if (eventSelected.isEmpty()) {
            System.out.println("Error: no events showed");
        }
        else {
            if (eventSelected.contains(cod)) {
                r = true;
                System.out.println("Event selected: " + cod);
                eventSelected.clear();
                AdvertismentDAO.deleteAdvertisment(cod);
            }
            else {
                System.out.println("Event does not exist or can't be chosen");
            }
        }

        return r;
    }



}

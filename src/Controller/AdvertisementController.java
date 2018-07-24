package Controller;


import advertisment.Advertisment;
import advertisment.Location;
import advertisment.Periodicity;
import advertisment.Role;
import user.Level;
import user.Sex;
import user.SportType;

/**
 * Class that connect GUI to the to the method of the class Advertisment
 */

public class AdvertisementController {
    public SportType sport;
    public Sex sex;
    public Level level;
    public Location location;
    public Role role;
    public Periodicity periodicity;
    public String date;
    public String time;
    public int ageMin;
    public int ageMax;

    public Advertisment advertisment = new Advertisment(sport, location, date, time, role, periodicity, ageMin, ageMax, level, sex);

    //The method allows to create a new advertisement.
    public Advertisment AddEvent(SportType sport1, Location location1, String date1, String time1, Role role1, Periodicity periodicity1, int ageMin1, int ageMax1, Level level1, Sex sex1){
        advertisment = new Advertisment(sport1, location1, date1, time1, role1, periodicity1, ageMin1, ageMax1, level1, sex1);
        advertisment.addEvent(advertisment);
        return advertisment;
    }

    //The method allows to filter events
    public static void ShowAdvertisments(SportType sport, Level level, Periodicity periodicity){
       Advertisment.showEvents(sport, level, periodicity);

    }

    //The method allows to selcet the choosen event
    public static void SelectEvent(int cod){
        Advertisment.selectEvent(cod);
    }



}


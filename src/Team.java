

public class Team {
    private Level levelEvent;
    private Sex sex;
    private String ageRange;        //Reange di eta`
    private SportType sport;

    public Team(SportType sport, Level levelEvent,String ageRange, Sex sex ) {
        this.sport = sport;
        this.levelEvent = levelEvent;
        this.ageRange = ageRange;
        this.sex = sex;
    }
}

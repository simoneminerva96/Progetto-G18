package advertisment;

public class Location {
    private String region;
    private String city;
    private String province;
    private String address;

    public Location(String city, String address, String region, String province) {
        this.city = city;
        this.address = address;
        this.region = region;
        this.province = province;
    }


    @Override
    public String toString() {
        return city + "" + address + "" + region + "" + province;
    }
}

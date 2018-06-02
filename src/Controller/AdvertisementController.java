package Controller;

import advertisment.Advertisment;
import advertisment.Periodicity;
import dao.AdvertismentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import user.Level;
import user.Sex;
import user.SportType;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdvertisementController {

    private SportType sport;
    private Level level;
    private Periodicity periodicity;
    private int age;
    private Sex sex;

    //Search an advertisement
    private void getAdvertisement (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Advertisement information
            ArrayList<Integer> Ad = AdvertismentDAO.getAdvertisment(sport, level, periodicity, age, sex);
            //Populate Advertisement on TableView and Display on TextArea
            populateAndShowAdvertisement((ObservableList<Advertisment>) actionEvent);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    //Search all advertisements

    private void getAdvertisements(Advertisment actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Advertisements information
            ArrayList<Integer> List = AdvertismentDAO.getAdvertisment(sport, level, periodicity, age, sex);
            //Populate Advertisements on TableView
            populateAdvertisement(actionEvent);
        } catch (SQLException e){
            System.out.println("Error occurred while getting advertisements information from DB.\n" + e);
            throw e;
        }
    }

    //Populate Advertisements

    private void populateAdvertisement (Advertisment Ad) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Advertisment> List = FXCollections.observableArrayList();
        //Add advertisements to the ObservableList
        List.add(Ad);

    }


    //Populate Advertisement for TableView and Display Advertisements on TextArea

    private void populateAndShowAdvertisement(ObservableList<Advertisment> Ad) throws ClassNotFoundException {
        if (Ad != null) {
            populateAdvertisement((Advertisment) Ad);
        } else {

        }
    }

    //Populate Advertisements for TableView

    private void populateEmployees (ObservableList<Advertisment> Ad) throws ClassNotFoundException {

    }



    //Insert an advertisement to the DB

    private static void addAdvertisment (Advertisment advertisment) throws SQLException, ClassNotFoundException {
        try {
            AdvertismentDAO.addAdvertisment(advertisment);
        } catch (SQLException e) {
            throw e;
        }
    }

    //Delete an advertisement with a given advertisement COD from DB

    private void deleteAdvertisment (int COD) throws SQLException, ClassNotFoundException {
        try {
            AdvertismentDAO.deleteAdvertisment(COD);
        } catch (SQLException e) {
            throw e;
        }
    }
}


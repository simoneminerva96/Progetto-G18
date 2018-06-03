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


    //Search an advertisement
    private ArrayList<Integer> getAdvertisement (ActionEvent actionEvent, SportType sport, Level level, Periodicity periodicity, int age, Sex sex) throws ClassNotFoundException, SQLException {
        ArrayList<Integer> Ad;
        try {
            //Get Advertisement information
            Ad = AdvertismentDAO.getAdvertisment(sport, level, periodicity, age, sex);
            //Populate Advertisement on TableView and Display on TextArea
            populateAndShowAdvertisement((ObservableList<Advertisment>) actionEvent);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return Ad;
    }

    private static void checkAdvertisement (int cod) throws SQLException, ClassNotFoundException {
        try {
            AdvertismentDAO.checkAdvertisment(cod);
        } catch (SQLException e) {
            throw e;
        }
    }

    private static void checkCod () throws SQLException, ClassNotFoundException {
        try {
            AdvertismentDAO.checkCod();
        } catch (SQLException e) {
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
        }
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


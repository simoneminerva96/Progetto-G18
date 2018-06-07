package GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.logging.Level;

public class NewAdvertisement {
    public static void display(String title){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15,15,15,15));
        grid.setVgap(8);
        grid.setHgap(10);

        //Sport Label
        Label sportLabel = new Label("Sport:");
        GridPane.setConstraints(sportLabel,0,0);

        ObservableList <String> sportList= FXCollections.observableArrayList(
                "Calcetto","Pallavolo","Basket","Tennis"
        );
        ComboBox comboBoxSport= new ComboBox(sportList);
        comboBoxSport.setPromptText("Choose sport");
        GridPane.setConstraints(comboBoxSport,1,0);



        Label roleLabel = new Label("Role:");
        GridPane.setConstraints(roleLabel,0,1);

        ObservableList calcettoList = FXCollections.observableArrayList(
                "Portiere","Giocatore"
        );



        ObservableList pallavoloList = FXCollections.observableArrayList(
                "Palleggiatore", "Giocatore"
        );

        ObservableList tennisList = FXCollections.observableArrayList(
                "None"
        );

        ObservableList basketList = FXCollections.observableArrayList(
                "None"
        );


        final ComboBox comboBoxRole= new ComboBox();
        GridPane.setConstraints(comboBoxRole,1,1);

        comboBoxSport.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                switch (newValue.toString()){
                    case "Calcetto":
                        comboBoxRole.setItems(calcettoList);
                        break;
                    case "Pallavolo":
                        comboBoxRole.setItems(pallavoloList);
                        break;
                    case "Tennis":
                        comboBoxRole.setItems(tennisList);
                        break;
                    case "Basket":
                        comboBoxRole.setItems(basketList);
                        break;
                }
            }
        });
        comboBoxRole.setPromptText("Choose role");


        //Level Label
        Label levelLabel = new Label("Level:");
        GridPane.setConstraints(levelLabel,0,2);

        //Level Input
        ObservableList<String> level = FXCollections.observableArrayList(
                "Low",
                "Medium",
                "High"
        );
        ComboBox comboBoxLevel = new ComboBox(level);
        comboBoxLevel.setPromptText("Choose level");
        GridPane.setConstraints(comboBoxLevel,1,2);

        //Time Label
        Label timeLabel = new Label("Time:");
        GridPane.setConstraints(timeLabel,0,3);

        //Hour Input
        ObservableList<String> hour= FXCollections.observableArrayList(
                "00",
                "01",
                "02",
                "03",
                "04",
                "05",
                "06",
                "07",
                "08",
                "09",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20",
                "21",
                "22",
                "23"
        );
        ComboBox comboBoxHour = new ComboBox(hour);
        comboBoxHour.setPromptText("H.");
        GridPane.setConstraints(comboBoxHour,1,3);

        //Input Mins

        ObservableList<String> mins=FXCollections.observableArrayList(
                "00",
                "01",
                "02",
                "03",
                "04",
                "05",
                "06",
                "07",
                "08",
                "09",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20",
                "21",
                "22",
                "23",
                "24",
                "25",
                "26",
                "27",
                "28",
                "29",
                "30",
                "31",
                "32",
                "33",
                "34",
                "35",
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45",
                "46",
                "47",
                "48",
                "49",
                "50",
                "51",
                "52",
                "53",
                "54",
                "55",
                "56",
                "57",
                "58",
                "59"
        );
        ComboBox comboBoxMins= new ComboBox(mins);
        comboBoxMins.setPromptText("M.");
        GridPane.setConstraints(comboBoxMins,2,3);

        Label dataLabel= new Label("Day of play:");
        GridPane.setConstraints(dataLabel,0,4);

        ObservableList<String> day = FXCollections.observableArrayList(
                "-",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20",
                "21",
                "22",
                "23",
                "24",
                "25",
                "26",
                "27",
                "28",
                "29",
                "30",
                "31"
        );
        ComboBox comboBoxday= new ComboBox(day);
        comboBoxday.setPromptText("D.");
        GridPane.setConstraints(comboBoxday,1,4);

        ObservableList<String> mounth= FXCollections.observableArrayList(
                "-",
                "Genuary",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "Dicember"

        );

        ComboBox comboBoxmounth= new ComboBox(mounth);
        comboBoxmounth.setPromptText("M.");
        GridPane.setConstraints(comboBoxmounth,2,4);

        Label locationLabel= new Label("Location:");
        GridPane.setConstraints(locationLabel,0,5);

        ObservableList<String> Region= FXCollections.observableArrayList(
                "-",
                "Abruzzo",
                "Basilicata",
                "Calabria",
                "Campania",
                "Emilia-Romagna",
                "Friuli-Venezia-Giulia",
                "Lazio",
                "Liguria",
                "Lombardia",
                "Marche",
                "Piemonte",
                "Puglia",
                "Sardegna",
                "Sicilia",
                "Toscana",
                "Trentino-Alto Adige",
                "Umbria",
                "Valle d'Aosta",
                "Veneto"

        );

        ComboBox comboBoxRegion= new ComboBox(Region);
        comboBoxRegion.setPromptText("Choose region");
        GridPane.setConstraints(comboBoxRegion,1,5);

        //Province

        ObservableList AbruzzoList = FXCollections.observableArrayList(
                "AQ","CH","PE","TE"
        );
        ObservableList BasilicataList = FXCollections.observableArrayList(
                "MT", "PZ"
        );
        ObservableList CalabriaList = FXCollections.observableArrayList(
                "CZ","CS","KR","RC","VV"
        );
        ObservableList CampaniaList = FXCollections.observableArrayList(
                "AV","BN","CE","NA","SA"
        );
        ObservableList EmiliaRomagnaList = FXCollections.observableArrayList(
                "BO","FE","FC","MO","PR","PC","RA","RE","RN"
        );
        ObservableList FriuliList = FXCollections.observableArrayList(
                "GO","PN","TS","UD"
        );
        ObservableList LazioList = FXCollections.observableArrayList(
                "FR","LT","RI","RM","VT"
        );
        ObservableList LiguriaList = FXCollections.observableArrayList(
                "GE","IM","SP","SV"
        );
        ObservableList LombardiaList = FXCollections.observableArrayList(
                "BG","BS","CO","CR","LC","LO","MN","MI","MB","PV","SO","VA"
        );
        ObservableList MarcheList = FXCollections.observableArrayList(
                "AN","AP","FM","MC","PU"
        );
        ObservableList PiemonteList = FXCollections.observableArrayList(
                "AL","AT","BI","CN","NO","TO","VB","VC"
        );
        ObservableList PugliaList = FXCollections.observableArrayList(
                "BA","BT","BR","FG","LE","TA"
        );
        ObservableList SardegnaList = FXCollections.observableArrayList(
                "CA","CI","VS","NU","OG","OT","OR","SS"
        );
        ObservableList SiciliaList = FXCollections.observableArrayList(
                "AG","CL","CT","EN","ME","PA","RG","SR","TP"
        );
        ObservableList ToscanaList = FXCollections.observableArrayList(
                "AR","FI","GR","LI","LU","MS","PI","PT","PO","SI"
        );
        ObservableList TrentinoList = FXCollections.observableArrayList(
                "BZ","TN"
        );
        ObservableList UmbriaList = FXCollections.observableArrayList(
                "PG","TR"
        );
        ObservableList ValledaostaList = FXCollections.observableArrayList(
                "AO"
        );
        ObservableList VenetoList = FXCollections.observableArrayList(
                "BL","PD","RO","TV","VE","VR","VI"
        );


        final ComboBox comboBoxProvince= new ComboBox();
        GridPane.setConstraints(comboBoxProvince,2,5);

        comboBoxRegion.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                switch (newValue.toString()){
                    case "Abruzzo":
                        comboBoxProvince.setItems(AbruzzoList);
                        break;
                    case "Basilicata":
                        comboBoxProvince.setItems(BasilicataList);
                        break;
                    case "Calabria":
                        comboBoxProvince.setItems(CalabriaList);
                        break;
                    case "Campania":
                        comboBoxProvince.setItems(CampaniaList);
                        break;
                    case "Emilia-Romagna":
                        comboBoxProvince.setItems(EmiliaRomagnaList);
                        break;
                    case "Friuli-Venezia-Giulia":
                        comboBoxProvince.setItems(FriuliList);
                        break;
                    case "Lazio":
                        comboBoxProvince.setItems(LazioList);
                        break;
                    case "Liguria":
                        comboBoxProvince.setItems(LiguriaList);
                        break;
                    case "Lombardia":
                        comboBoxProvince.setItems(LombardiaList);
                        break;
                    case "Marche":
                        comboBoxProvince.setItems(MarcheList);
                        break;
                    case "Piemonte":
                        comboBoxProvince.setItems(PiemonteList);
                        break;
                    case "Puglia":
                        comboBoxProvince.setItems(PugliaList);
                        break;
                    case "Sardegna":
                        comboBoxProvince.setItems(SardegnaList);
                        break;
                    case "Sicilia":
                        comboBoxProvince.setItems(SiciliaList);
                        break;
                    case "Toscana":
                        comboBoxProvince.setItems(ToscanaList);
                        break;
                    case "Trentino-Alto Adige":
                        comboBoxProvince.setItems(TrentinoList);
                        break;
                    case "Umbria":
                        comboBoxProvince.setItems(UmbriaList);
                        break;
                    case "Valle d'Aosta":
                        comboBoxProvince.setItems(ValledaostaList);
                        break;
                    case "Veneto":
                        comboBoxProvince.setItems(VenetoList);
                        break;
                }
            }
        });
        comboBoxProvince.setPromptText("Choose province");




        //Age Label
        Label AgeLabel = new Label("Age:");
        GridPane.setConstraints(AgeLabel,0,6);

        //AgeMin Input
        ObservableList<String> AgeMin= FXCollections.observableArrayList(

                "10",
                "20",
                "30",
                "40",
                "50",
                "60",
                "70",
                "80",
                "90",
                "100"

        );
        ComboBox comboBoxAgeMin = new ComboBox(AgeMin);
        comboBoxAgeMin.setPromptText("Age Min");
        GridPane.setConstraints(comboBoxAgeMin,1,6);

        //Input AgeMax

        ObservableList<String> AgeMax=FXCollections.observableArrayList(
                "10",
                "20",
                "30",
                "40",
                "50",
                "60",
                "70",
                "80",
                "90",
                "100"
        );
        ComboBox comboBoxAgeMax = new ComboBox(AgeMax);
        comboBoxAgeMax.setPromptText("Age Max");
        GridPane.setConstraints(comboBoxAgeMax,2,6);



        //Periodicity Label
        Label periodicyLabel= new Label("Periodicità:");
        GridPane.setConstraints(periodicyLabel,0,7);

        //check box Giornaliero
        CheckBox checkBoxGiornaliero = new CheckBox("Giornaliero");
        GridPane.setConstraints(checkBoxGiornaliero,1,7);

        //Check box Settimanale
        CheckBox checkBoxSettimanale= new CheckBox("Settimanale");
        GridPane.setConstraints(checkBoxSettimanale,2,7);

        //Check box Mensile
        CheckBox checkBoxMensile = new CheckBox("Mensile");
        GridPane.setConstraints(checkBoxMensile,3,7);


        grid.getChildren().addAll(sportLabel,comboBoxSport,roleLabel,comboBoxRole,levelLabel,comboBoxLevel,timeLabel,comboBoxHour,comboBoxMins, dataLabel,comboBoxday,comboBoxmounth, locationLabel, comboBoxRegion, comboBoxProvince, periodicyLabel,checkBoxGiornaliero,checkBoxSettimanale,checkBoxMensile, AgeLabel, comboBoxAgeMin, comboBoxAgeMax);

        TextArea area = new TextArea();
        area.setPromptText("Write a new advertisement here");

        Button create= new Button("Create");
        create.setOnAction(event -> {
            window.close();
        });

        VBox layout = new VBox(50);
        layout.getChildren().addAll(grid,area,create);

        Scene scene= new Scene(layout,500,500);
        window.setScene(scene);
        window.show();

    }

}

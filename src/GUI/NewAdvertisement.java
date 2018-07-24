package GUI;

import Controller.AdvertisementController;
import advertisment.Advertisment;
import advertisment.Location;
import advertisment.Periodicity;
import advertisment.Role;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import user.Level;
import user.Sex;
import user.SportType;


public class NewAdvertisement {
    public static void display(String title){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        //grid creation
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15,15,15,15));
        grid.setVgap(8);
        grid.setHgap(10);

        //creation of sport combo box
        Label sportLabel = new Label("Sport:");
        GridPane.setConstraints(sportLabel,0,0);

        ObservableList <SportType> sportList= FXCollections.observableArrayList(
                SportType.CALCETTO,
                SportType.PALLAVOLO,
                SportType.TENNIS,
                SportType.BASKET
        );
        ComboBox comboBoxSport= new ComboBox(sportList);
        comboBoxSport.setPromptText("Choose sport");
        GridPane.setConstraints(comboBoxSport,1,0);


        //creation of "calcetto" roles combo box
        Label roleLabel = new Label("Role:");
        GridPane.setConstraints(roleLabel,0,1);

        ObservableList <Role> calcettoList = FXCollections.observableArrayList(
                Role.PLAYER,
                Role.PORTIERE
        );


        //creation of "pallavolo" roles combo box
        ObservableList <Role> pallavoloList = FXCollections.observableArrayList(
                Role.PLAYER,
                Role.PALLEGGIATORE
        );

        //creation of "tennis" roles combo box
        ObservableList <Role> tennisList = FXCollections.observableArrayList(
                Role.NONE
        );

        //creation of "basket" roles combo box
        ObservableList <Role> basketList = FXCollections.observableArrayList(
                Role.NONE
        );


        final ComboBox comboBoxRole= new ComboBox();
        GridPane.setConstraints(comboBoxRole,1,1);

        //it allows to select a role according to the choosen sport
        comboBoxSport.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                switch (newValue.toString()){
                    case "CALCETTO":
                        comboBoxRole.setItems(calcettoList);
                        break;
                    case "PALLAVOLO":
                        comboBoxRole.setItems(pallavoloList);
                        break;
                    case "TENNIS":
                        comboBoxRole.setItems(tennisList);
                        break;
                    case "BASKET":
                        comboBoxRole.setItems(basketList);
                        break;
                }
            }
        });
        comboBoxRole.setPromptText("Choose role");


        //creation of level combobox
        Label levelLabel = new Label("Level:");
        GridPane.setConstraints(levelLabel,0,2);

        ObservableList<Level> level = FXCollections.observableArrayList(
                Level.LOW,
                Level.MEDIUM,
                Level.HIGH
        );
        ComboBox comboBoxLevel = new ComboBox(level);
        comboBoxLevel.setPromptText("Choose level");
        GridPane.setConstraints(comboBoxLevel,1,2);

        //creation of times combobox
        Label timeLabel = new Label("Time:");
        GridPane.setConstraints(timeLabel,0,3);


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

        //create day's combobox
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

        ObservableList<Integer> month= FXCollections.observableArrayList(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12

        );

        ComboBox comboBoxmonth= new ComboBox(month);
        comboBoxmonth.setPromptText("M.");
        GridPane.setConstraints(comboBoxmonth,2,4);

        ObservableList<Integer> year= FXCollections.observableArrayList(
                2018,
                2019,
                2020,
                2021,
                2022,
                2023,
                2024,
                2025

        );

        ComboBox comboBoxyear= new ComboBox(year);
        comboBoxyear.setPromptText("Y.");
        GridPane.setConstraints(comboBoxyear,3,4);

        //creations of location's comboboxs and textfields
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

        TextField cityInput = new TextField();
        cityInput.setPromptText("City");
        GridPane.setConstraints(cityInput,3,5);

        TextField addressInput = new TextField();
        addressInput.setPromptText("Address");
        GridPane.setConstraints(addressInput,4,5);




        //combobox agemin and agemax
        Label AgeLabel = new Label("Age:");
        GridPane.setConstraints(AgeLabel,0,6);


        ObservableList<Integer> AgeMin= FXCollections.observableArrayList(

                14,
                20,
                30,
                40,
                50,
                60,
                70

        );
        ComboBox comboBoxAgeMin = new ComboBox(AgeMin);
        comboBoxAgeMin.setPromptText("Age Min");
        GridPane.setConstraints(comboBoxAgeMin,1,6);


        ObservableList<Integer> AgeMax=FXCollections.observableArrayList(
                14,
                20,
                30,
                40,
                50,
                60,
                70
        );
        ComboBox comboBoxAgeMax = new ComboBox(AgeMax);
        comboBoxAgeMax.setPromptText("Age Max");
        GridPane.setConstraints(comboBoxAgeMax,2,6);

        //Sex combobox
        Label SexLabel = new Label("Sex:");
        GridPane.setConstraints(SexLabel,0,8);

        ObservableList<Sex> sex=FXCollections.observableArrayList(
               Sex.M,
               Sex.F

        );
        ComboBox comboBoxSex = new ComboBox(sex);
        comboBoxSex.setPromptText("Choose sex");
        GridPane.setConstraints(comboBoxSex,1,8);



        //Periodicity combobox
        Label periodicityLabel= new Label("Periodicity:");
        GridPane.setConstraints(periodicityLabel,0,7);

        ObservableList<Periodicity> periodicity = FXCollections.observableArrayList(
               Periodicity.GIORNALIERA,
                Periodicity.SETTIMANALE,
                Periodicity.MENSILE,
                Periodicity.NONE
        );
        ComboBox comboBoxPeriodicity = new ComboBox(periodicity);
        comboBoxPeriodicity.setPromptText("Choose periodicity");
        GridPane.setConstraints(comboBoxPeriodicity,1,7);


        //this buttons allows to create a new event
        Button create= new Button("Create");
        GridPane.setConstraints(create,0,10);
        create.setOnAction(event -> {
            AdvertisementController advertisementController = new AdvertisementController();
            Location l = new Location(""+cityInput.getText(),", "+addressInput.getText(),", "+comboBoxRegion.getValue(),", "+comboBoxProvince.getValue());
            String date = comboBoxyear.getValue()+"-"+comboBoxmonth.getValue()+"-"+comboBoxday.getValue();
            String time = comboBoxHour.getValue()+":"+comboBoxMins.getValue()+":00";
            advertisementController.AddEvent((SportType) comboBoxSport.getValue(),l, date, time, (Role)comboBoxRole.getValue(), (Periodicity)comboBoxPeriodicity.getValue(), (int)comboBoxAgeMin.getValue(), (int)comboBoxAgeMax.getValue(),(user.Level) comboBoxLevel.getValue(), (Sex)comboBoxSex.getValue());
            window.close();
        });


        //the elements are put in a grid
        grid.getChildren().addAll(sportLabel,comboBoxSport,roleLabel,comboBoxRole,levelLabel,comboBoxLevel,timeLabel,comboBoxHour,comboBoxMins, dataLabel,comboBoxday,comboBoxmonth, comboBoxyear, locationLabel, comboBoxRegion, comboBoxProvince, cityInput, addressInput, periodicityLabel, comboBoxPeriodicity, AgeLabel, comboBoxAgeMin, comboBoxAgeMax, SexLabel, comboBoxSex, create);



        VBox layout = new VBox(50);
        layout.getChildren().addAll(grid);

        Scene scene= new Scene(layout,750,360);
        window.setScene(scene);
        window.show();

    }

}

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
                "Non"
        );

        ObservableList basketList = FXCollections.observableArrayList(
                "Non"
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
        comboBoxHour.setPromptText("h.");
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
        comboBoxMins.setPromptText("m.");
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
        comboBoxday.setPromptText("-");
        GridPane.setConstraints(comboBoxday,1,4);

        ObservableList<String> mounth= FXCollections.observableArrayList(
                "-",
                "genuary",
                "february",
                "march",
                "april",
                "may",
                "june",
                "july",
                "august",
                "september",
                "october",
                "november",
                "dicember"

        );

        ComboBox comboBoxmounth= new ComboBox(mounth);
        comboBoxmounth.setPromptText("-");
        GridPane.setConstraints(comboBoxmounth,2,4);

        grid.getChildren().addAll(sportLabel,comboBoxSport,roleLabel,comboBoxRole,levelLabel,comboBoxLevel,timeLabel,comboBoxHour,comboBoxMins,dataLabel,comboBoxday,comboBoxmounth);

        TextArea area = new TextArea();
        area.setPromptText("Write a new advertisement here");

        Button create= new Button("Create");
        create.setOnAction(event -> {
            window.close();
        });

        VBox layout = new VBox(30);
        layout.getChildren().addAll(grid,area,create);

        Scene scene= new Scene(layout,500,500);
        window.setScene(scene);
        window.show();

    }

}

package GUI;

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

        //Sport Label
        Label sportLabel = new Label("Sport:");
        GridPane.setConstraints(sportLabel,0,0);

        //Sport Input
        TextField sportInput = new TextField();
        sportInput.setPromptText("Sport");
        GridPane.setConstraints(sportInput,1,0);

        //Role Label
        Label roleLabel = new Label("Role:");
        GridPane.setConstraints(roleLabel,0,1);

        //Role Input
        TextField roleInput = new TextField();
        roleInput.setPromptText("Role");
        GridPane.setConstraints(roleInput,1,1);

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

        grid.getChildren().addAll(sportLabel,sportInput,roleLabel,roleInput,levelLabel,comboBoxLevel,timeLabel,comboBoxHour,comboBoxMins);

        TextArea area = new TextArea();
        area.setPromptText("Write a new advertisement here");

        Button create= new Button("Create");
        create.setOnAction(event -> window.close());

        VBox layout = new VBox(30);
        layout.getChildren().addAll(grid,area,create);

        Scene scene= new Scene(layout,400,400);
        window.setScene(scene);
        window.show();

    }

}

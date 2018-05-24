package GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

;import java.awt.event.ActionListener;

public class HomePage {

    public static void display(String title){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        GridPane grid= new GridPane();
        grid.setPadding(new Insets(40,40,40,40));
        grid.setVgap(8);
        grid.setHgap(10);


        Label sportLabel= new Label("Sport:");
        GridPane.setConstraints(sportLabel, 0,2);
        ObservableList <String> sportList= FXCollections.observableArrayList(
                "Calcetto","Pallavolo","Basket","Tennis"
        );
        ComboBox comboBoxSport= new ComboBox(sportList);
        comboBoxSport.setPromptText("Choose sport");

        GridPane.setConstraints(comboBoxSport,0,3);



        Label roleLabel = new Label("Role:");
        GridPane.setConstraints(roleLabel,0,4);

        ObservableList calcettoList = FXCollections.observableArrayList(
                "Portiere","Giocatore"
        );



        ObservableList pallavoloList = FXCollections.observableArrayList(
                "Palleggiatore", "Giocatore"
        );

        ObservableList tennisList = FXCollections.observableArrayList(
                "Null"
        );

        ObservableList basketList = FXCollections.observableArrayList(
                "Null"
        );


        final ComboBox comboBoxRole= new ComboBox();


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
        GridPane.setConstraints(comboBoxRole,0,5);

        Label levelLabel = new Label("Level:");
        GridPane.setConstraints(levelLabel,0,6);
        ObservableList<String>level= FXCollections.observableArrayList(
                "Low",
                "Medium",
                "High"
        );
        ComboBox comboBoxLevel= new ComboBox(level);
        comboBoxLevel.setPromptText("Choose level");
        GridPane.setConstraints(comboBoxLevel, 0,7);

        Button sourchButton= new Button("Sourch");
        GridPane.setConstraints(sourchButton,0,8);

        Button newAdvertisement = new Button("New Advertisement");
        newAdvertisement.setOnAction(event -> NewAdvertisement.display("New Advertisement"));
        GridPane.setConstraints(newAdvertisement,12,0);

        Button profileButton = new Button("GUI.Profile");
        profileButton.setOnAction(event -> {
            Profile.display("GUI.Profile");
            window.close();
        });
        GridPane.setConstraints(profileButton,13,0);

        Button logOut= new Button("Log Out");
        logOut.setOnAction(event -> {
            LogIn.display("Log In");
            window.close();
        });
        GridPane.setConstraints(logOut,14,0);

        WebView advArea = new WebView();
        GridPane.setConstraints(advArea,13,2);


        grid.getChildren().addAll(sportLabel,comboBoxSport,roleLabel,comboBoxRole,levelLabel,comboBoxLevel,newAdvertisement,profileButton,logOut, advArea);

        StackPane layout = new StackPane();
        Scene scene;
        scene= new Scene(grid,700,700);
        window.setScene(scene);
        window.showAndWait();

    }
}

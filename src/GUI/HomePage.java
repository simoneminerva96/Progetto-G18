package GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;


public class HomePage {

    public static void display(String title){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);


        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: Blue;");

        VBox vBox= new VBox();
        vBox.setPadding(new Insets(15,12,15,12));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.BOTTOM_LEFT);


        Text text= new Text("Filtra");
        text.setFont(Font.font("Arial", FontWeight.BOLD,14));


        Label sportLabel= new Label("Sport:");
        ObservableList <String> sportList= FXCollections.observableArrayList(
                "Calcetto","Pallavolo","Basket","Tennis"
        );
        ComboBox comboBoxSport= new ComboBox(sportList);
        comboBoxSport.setPromptText("Choose sport");



        Label roleLabel = new Label("Role:");

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


        Label levelLabel = new Label("Level:");
        ObservableList<String>level= FXCollections.observableArrayList(
                "Low",
                "Medium",
                "High"
        );
        ComboBox comboBoxLevel= new ComboBox(level);
        comboBoxLevel.setPromptText("Choose level");
        GridPane.setConstraints(comboBoxLevel, 0,7);

        Button sourchButton= new Button("Surch");

        Button newAdvertisement = new Button("New Advertisement");
        newAdvertisement.setOnAction(event -> NewAdvertisement.display("New Advertisement"));
        newAdvertisement.setPrefSize(100,20);

        Button profileButton = new Button("Profile");
        profileButton.setOnAction(event -> {
            Profile.display("Profile");
            window.close();
        });
        profileButton.setPrefSize(100,20);

        Button logOut= new Button("Log Out");
        logOut.setOnAction(event -> {
            LogIn.display("Log In");
            window.close();
        });
        logOut.setPrefSize(100,20);


        TextArea advArea = new TextArea();
        advArea.getScrollLeft();
        advArea.setPromptText("New Advertisement Soon...");


        hbox.getChildren().addAll(newAdvertisement,profileButton,logOut);
        vBox.getChildren().addAll(text,sportLabel,comboBoxSport,roleLabel,comboBoxRole,levelLabel,comboBoxLevel,sourchButton);

        BorderPane borderPane= new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setBottom(vBox);
        borderPane.setCenter(advArea);


        StackPane layout = new StackPane();
        Scene scene;
        scene= new Scene(borderPane,700,700);
        window.setScene(scene);
        window.showAndWait();

    }
}

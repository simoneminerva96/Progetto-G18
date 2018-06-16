package GUI;


import Controller.AdvertisementController;
import advertisment.Advertisment;
import advertisment.Periodicity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import user.Level;
import user.SportType;


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

        HBox periodicity= new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing (50);


        VBox vBox= new VBox();
        vBox.setPadding(new Insets(15,12,15,12));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.BOTTOM_LEFT);


        Text text= new Text("Filtra");
        text.setFont(Font.font("Arial", FontWeight.BOLD,14));


        Label sportLabel= new Label("Sport:");
        ObservableList <SportType> sportList= FXCollections.observableArrayList(
                SportType.CALCETTO,
                SportType.PALLAVOLO,
                SportType.TENNIS,
                SportType.BASKET
        );
        ComboBox comboBoxSport= new ComboBox(sportList);
        comboBoxSport.setPromptText("Choose sport");



        Label levelLabel = new Label("Level:");
        ObservableList<Level>level= FXCollections.observableArrayList(
                Level.LOW,
                Level.MEDIUM,
                Level.HIGH

        );
        ComboBox comboBoxLevel= new ComboBox(level);
        comboBoxLevel.setPromptText("Choose level");
        GridPane.setConstraints(comboBoxLevel, 0,5);

        //Periodicity Label
        Label periodicityLabel= new Label("Periodicity:");

        ObservableList <Periodicity> period = FXCollections.observableArrayList(
                Periodicity.GIORNALIERA,
                Periodicity.SETTIMANALE,
                Periodicity.MENSILE,
                Periodicity.NONE
        );
        ComboBox comboBoxPeriodicity = new ComboBox(period);
        comboBoxPeriodicity.setPromptText("Choose periodicity");

        ListView <String> advArea = new ListView<>();
        ObservableList<String> viewAdvs =FXCollections.observableArrayList (
        );
        advArea.setItems(viewAdvs);



        Button searchButton= new Button("Search");
        searchButton.setOnAction(event -> {
            AdvertisementController advertisementController = new AdvertisementController();
            advertisementController.ShowAdvertisments((SportType) comboBoxSport.getValue(), (user.Level) comboBoxLevel.getValue(), (Periodicity) comboBoxPeriodicity.getValue());
        });


        Button newAdvertisement = new Button("New Advertisement");
        newAdvertisement.setOnAction(event -> NewAdvertisement.display("New Advertisement"));
        newAdvertisement.setPrefSize(150,20);

        Button profileButton = new Button("Profile");
        profileButton.setOnAction(event -> {
            Profile.display("Profile");
            window.close();
        });
        profileButton.setPrefSize(100,20);

        Button logOut= new Button("Log Out");
        logOut.setOnAction(event -> {
            window.close();
            LogIn.display("");

        });
        logOut.setPrefSize(100,20);




        hbox.getChildren().addAll(newAdvertisement,profileButton,logOut);
        vBox.getChildren().addAll(text,sportLabel,comboBoxSport,levelLabel,comboBoxLevel, periodicityLabel, comboBoxPeriodicity,searchButton);

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

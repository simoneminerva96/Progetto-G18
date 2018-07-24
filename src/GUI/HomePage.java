package GUI;


import Controller.AdvertisementController;
import advertisment.Periodicity;
import dao.AdvertismentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import user.Level;
import user.SportType;

import java.util.StringTokenizer;

/**
 * This class creates the window of the home page wher the user can filter the events,
 * connects with the page of new advertisement's creation and with the profile and he can log out
 * from his account.
 */


public class HomePage {

        public static void display(String title){

            //window creation
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        //create a vertical box
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: LightBlue;");

        //create an horizontal box
        HBox hhbox= new HBox();
        hhbox.setPadding(new Insets(15, 12, 15, 12));
        hhbox.setSpacing (50);

        //create a vertical box
        VBox vBox= new VBox();
        vBox.setPadding(new Insets(15,12,15,12));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.BOTTOM_LEFT);

        //add a text
        Text text= new Text("Filtra");
        text.setFont(Font.font("Arial", FontWeight.BOLD,14));


        //create a sport filter comboBox
        Label sportLabel= new Label("Sport:");
        ObservableList <SportType> sportList= FXCollections.observableArrayList(
                SportType.CALCETTO,
                SportType.PALLAVOLO,
                SportType.TENNIS,
                SportType.BASKET
        );
        ComboBox comboBoxSport= new ComboBox(sportList);
        comboBoxSport.setPromptText("Choose sport");



        //create a level filter comboBox
        Label levelLabel = new Label("Level:");
        ObservableList<Level>level= FXCollections.observableArrayList(
                Level.LOW,
                Level.MEDIUM,
                Level.HIGH

        );
        ComboBox comboBoxLevel= new ComboBox(level);
        comboBoxLevel.setPromptText("Choose level");
        GridPane.setConstraints(comboBoxLevel, 0,5);

        //create a periodicity filter comboBox
        Label periodicityLabel= new Label("Periodicity:");

        ObservableList <Periodicity> period = FXCollections.observableArrayList(
                Periodicity.GIORNALIERA,
                Periodicity.SETTIMANALE,
                Periodicity.MENSILE,
                Periodicity.NONE
        );
        ComboBox comboBoxPeriodicity = new ComboBox(period);
        comboBoxPeriodicity.setPromptText("Choose periodicity");

        //create the window that shows filtered events
        ListView <String> list = new ListView<>();

        //create the button that allows to applay a filter
        Button searchButton= new Button("Search");
        searchButton.setOnAction(event -> {
            AdvertisementController advertisementController = new AdvertisementController();
            advertisementController.ShowAdvertisments((SportType) comboBoxSport.getValue(), (user.Level) comboBoxLevel.getValue(), (Periodicity) comboBoxPeriodicity.getValue());
            ObservableList<String> viewAdvs =FXCollections.observableArrayList (AdvertismentDAO.ShowEvent((SportType) comboBoxSport.getValue(), (user.Level) comboBoxLevel.getValue(), (Periodicity) comboBoxPeriodicity.getValue()));
            list.setItems(viewAdvs);
        });

        //allows to subscribe an event with a double click
        list.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                        if(event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {


                              String str = event.getTarget().toString();

                              StringTokenizer strTok = new StringTokenizer(str,"\"");
                              System.out.println(str);

                              strTok.nextToken();

                              String str2 = strTok.nextToken();

                              StringTokenizer strTok2 = new StringTokenizer(str2, ":");

                              String tok01 = strTok2.nextToken();

                              int cod = Integer.parseInt(tok01);


                              AdvertisementController.SelectEvent(cod);

                              AdvBooking.display("Advertisement booking");

                              window.close();


                        }
                }
        });





        //create the button that opens a new advertisement window
        Button newAdvertisement = new Button("New Advertisement");
        newAdvertisement.setOnAction(event -> NewAdvertisement.display("New Advertisement"));
        newAdvertisement.setPrefSize(150,20);

        //create the button that opens the profile
        Button profileButton = new Button("Profile");
        profileButton.setOnAction(event -> {
            Profile.display("Profile");
            window.close();
        });
        profileButton.setPrefSize(100,20);

        //create the button that makes log out
        Button logOut= new Button("Log Out");
        logOut.setOnAction(event -> {
            window.close();
            LogIn.display("");

        });
        logOut.setPrefSize(100,20);



        //add to Vbox and Hbox the elements
        hbox.getChildren().addAll(newAdvertisement,profileButton,logOut);
        vBox.getChildren().addAll(text,sportLabel,comboBoxSport,levelLabel,comboBoxLevel, periodicityLabel, comboBoxPeriodicity,searchButton);

        BorderPane borderPane= new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setBottom(vBox);
        borderPane.setCenter(list);


        StackPane layout = new StackPane();
        Scene scene;
        scene= new Scene(borderPane,700,700);
        window.setScene(scene);
        window.showAndWait();

    }
}

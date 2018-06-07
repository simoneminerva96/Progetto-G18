package GUI;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        ObservableList <String> sportList= FXCollections.observableArrayList(
                "Calcetto","Pallavolo","Basket","Tennis"
        );
        ComboBox comboBoxSport= new ComboBox(sportList);
        comboBoxSport.setPromptText("Choose sport");



        Label levelLabel = new Label("Level:");
        ObservableList<String>level= FXCollections.observableArrayList(
                "Low",
                "Medium",
                "High"
        );
        ComboBox comboBoxLevel= new ComboBox(level);
        comboBoxLevel.setPromptText("Choose level");
        GridPane.setConstraints(comboBoxLevel, 0,5);

        //Periodicity Label
        Label periodicyLabel= new Label("Periodicità:");

        //check box Giornaliero
        CheckBox checkBoxGiornaliero = new CheckBox("Giornaliero");


        //Check box Settimanale
        CheckBox checkBoxSettimanale= new CheckBox("Settimanale");


        //Check box Mensile
        CheckBox checkBoxMensile = new CheckBox("Mensile");

        Label locationLabel = new Label("Location:");
        ObservableList<String>location= FXCollections.observableArrayList(
                "_",
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

        ComboBox comboBoxLocation= new ComboBox(location);
        comboBoxLocation.setPromptText("Choose region");
        GridPane.setConstraints(comboBoxLocation, 1,6);



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
        GridPane.setConstraints(comboBoxProvince,2,6);

        comboBoxLocation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
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


        Button searchButton= new Button("Search");

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
            window.close();
            LogIn.display("");

        });
        logOut.setPrefSize(100,20);


        ListView advArea = new ListView();


        hbox.getChildren().addAll(newAdvertisement,profileButton,logOut);
        periodicity.getChildren().addAll(checkBoxGiornaliero,checkBoxSettimanale,checkBoxMensile);
        vBox.getChildren().addAll(text,sportLabel,comboBoxSport,levelLabel,comboBoxLevel,locationLabel,comboBoxLocation, comboBoxProvince, periodicyLabel,periodicity,searchButton);

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

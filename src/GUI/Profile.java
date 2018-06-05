package GUI;

import GUI.HomePage;
import GUI.LogIn;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Profile {

    public static void display(String title){
        Stage window= new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40,40,40,40));
        grid.setVgap(8);
        grid.setHgap(10);;

        Label name= new Label("Name:");
        GridPane.setConstraints(name,0,0);

        TextField nameField= new TextField();
        GridPane.setConstraints(nameField,1,0);

        Label surname = new Label("Surname:");
        GridPane.setConstraints(surname,0,1);

        TextField surnameField= new TextField();
        GridPane.setConstraints(surnameField,1,1);

        Label username= new Label("Username:");
        GridPane.setConstraints(username,0,2);

        TextField usernameField = new TextField();
        GridPane.setConstraints(usernameField,1,2);

        Label data= new Label("Day of Birth:");
        GridPane.setConstraints(data,0,3);

        TextField dataField= new TextField();
        GridPane.setConstraints(dataField,1,3);

        Label sex= new Label("Sex:");
        GridPane.setConstraints(sex,0,4);

        TextField sexField = new TextField();
        GridPane.setConstraints(sexField,1,4);



        Button closeProfile= new Button("Close");
        GridPane.setConstraints(closeProfile,1,5);

        closeProfile.setOnAction(event -> {
            HomePage.display("Home Page");
            window.close();
        });

        Button logOut= new Button("Log Out");
        GridPane.setConstraints(logOut,2,5);

        logOut.setOnAction(event -> {
            LogIn.display("GUI.LogIn");
            window.close();
        });

        grid.getChildren().addAll(name,nameField,surname, surnameField,username, usernameField, data,dataField, sex,sexField, closeProfile,logOut);

        Scene scene= new Scene(grid,500,500);
        window.setScene(scene);
        window.show();
    }
}

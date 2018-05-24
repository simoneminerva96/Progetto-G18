package GUI;

import GUI.HomePage;
import GUI.LogIn;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

        Label name= new Label("Name:");
        GridPane.setConstraints(name,0,0);

        Label surname = new Label("Surname:");
        GridPane.setConstraints(surname,0,1);

        Label username= new Label("Username:");
        GridPane.setConstraints(username,0,2);

        Label data= new Label("Day of Birth:");
        GridPane.setConstraints(data,0,3);

        Label sex= new Label("Sex:");
        GridPane.setConstraints(sex,0,4);

        Button closeProfile= new Button("Close");
        GridPane.setConstraints(closeProfile,0,5);
        closeProfile.setOnAction(event -> {
            HomePage.display("Home Page");
            window.close();
        });

        Button logOut= new Button("Log Out");
        GridPane.setConstraints(logOut,1,5);
        logOut.setOnAction(event -> {
            LogIn.display("GUI.LogIn");
            window.close();
        });

        grid.getChildren().addAll(name,surname,username,data,sex,closeProfile,logOut);

        Scene scene= new Scene(grid,300,200);
        window.setScene(scene);
        window.show();
    }
}

package GUI;

import GUI.HomePage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class LogIn {

    public static void display(String title){
        Stage window= new Stage();
        window.setTitle("Log In");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label
        Label nameLabel = new Label("Username");
        GridPane.setConstraints(nameLabel,0,0);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput,1,0);

        //Pass Label
        Label passLable= new Label("Password");
        GridPane.setConstraints(passLable,0,1);

        //Pass Input
        PasswordField passInput= new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        Button logInButton = new Button("Log In");
        GridPane.setConstraints(logInButton, 1,2);
        logInButton.setOnAction(event -> {
           HomePage.display("Home Page");
            window.close();
        });

        grid.getChildren().addAll(nameLabel,nameInput,passLable,passInput,logInButton);


        Scene scene= new Scene(grid,500,300);
        window.setScene(scene);


        window.show();

    }

}

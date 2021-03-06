package GUI;

import Controller.UserController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 * This class opens a window where the user can access whith his username and his password.
 */
public class LogIn {



    public static void display(String title){
        Stage window= new Stage();
        window.setTitle("LogIn");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);


        Text welcomeText= new Text("Please, log in to start");
        welcomeText.setFont(Font.font("Verdana", FontWeight.LIGHT,20));
        GridPane.setConstraints(welcomeText,0,0);

        //Name Label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,2);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput,1,2);

        //Pass Label
        Label passLable= new Label("Password:");
        GridPane.setConstraints(passLable,0,3);

        //Pass Input
        PasswordField passInput= new PasswordField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput,1,3);

        //grid creation
        Button logInButton = new Button("LogIn");
        GridPane.setConstraints(logInButton, 1,4);

        //It makes log in and go to home page if user and passwors are correct and go to error in login if one of them is wrong
        logInButton.setOnAction(event -> {

            UserController userController = new UserController();
            Profile.setController(userController);
            window.close();
            if(userController.logIn(nameInput.getText(),passInput.getText()) == true) {
                HomePage.display("HomePage");

            }else if (userController.logIn(nameInput.getText(), passInput.getText()) == false){
                ErrorInLogIn.display("Error!");
            }


        });

        //all elements are added to a grid
        grid.getChildren().addAll(welcomeText,nameLabel,nameInput,passLable,passInput,logInButton);


        Scene scene= new Scene(grid,500,300);
        window.setScene(scene);


        window.show();

    }


}

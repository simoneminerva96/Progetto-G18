package tester;

import Controller.UserController;
import GUI.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import user.Sex;
import user.User;

import java.sql.SQLException;

public class Main extends Application{


    Stage window;

    public static void main(String [] args){
        launch(args);
    }


    private UserController userController = new UserController();


    @Override
    public void start(Stage primaryStage) throws Exception {
        UserController c = new UserController();

        window= primaryStage;
        primaryStage.setTitle("SignUp");





        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40,40,40,40));
        grid.setVgap(8);
        grid.setHgap(10);

        Text welcomeText= new Text("If you dont't have an account,\nplease sign up!");
        welcomeText.setFont(Font.font("Ariel", FontWeight.LIGHT, 20));
        GridPane.setConstraints(welcomeText,0,0);
        //username Label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,2);

        //username Input
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

        //Name Label
        Label namevLabel = new Label("Name:");
        GridPane.setConstraints(namevLabel,0,4);

        //Name input
        TextField namevInput= new TextField();
        namevInput.setPromptText("Name");
        GridPane.setConstraints(namevInput,1,4);

        //Surname label
        Label surnameLabel= new Label("Surname:");
        GridPane.setConstraints(surnameLabel, 0,5);

        //Surname input
        TextField surnameInput = new TextField();
        surnameInput.setPromptText("Surname");
        GridPane.setConstraints(surnameInput,1,5);

        //Birthday Label
        Label birthdayLabel= new Label("Day of Birth:");
        GridPane.setConstraints(birthdayLabel,0,6);

        //day of birthday


        ObservableList<Integer> ageList= FXCollections.observableArrayList(
                14,
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                25,
                26,
                27,
                28,
                29,
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37,
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50,
                51,
                52,
                53,
                54,
                55,
                56,
                57,
                58,
                59,
                60,
                61,
                62,
                63,
                64,
                65,
                66,
                67,
                68,
                69,
                70

        );
        ComboBox ageField = new ComboBox(ageList);
        ageField.setPromptText("Age");
        GridPane.setConstraints(ageField,1,6);




        //Sex label
        Label sexLabel= new Label("Sex:");
        GridPane.setConstraints(sexLabel,0,7);

        //Sex Input
        ObservableList<Sex> sex = FXCollections.observableArrayList(

                Sex.M,
                Sex.F
        );
        ComboBox comboBoxsex = new ComboBox(sex);
        comboBoxsex.setPromptText("Choose text");
        GridPane.setConstraints(comboBoxsex,1,7);

        Button SignUpButton = new Button("SignUp");
        GridPane.setConstraints(SignUpButton,1,8);
        SignUpButton.setOnAction(event -> {

            userController.signUp(nameInput.getText(),passInput.getText(), namevInput.getText(), surnameInput.getText(), (Sex) comboBoxsex.getValue(),(int) ageField.getValue());
            LogIn.display("LogIn");
            window.close();

        });

        Button logInButton = new Button("LogIn");
        GridPane.setConstraints(logInButton,2,8);
        logInButton.setOnAction(event -> {
            LogIn.display("LogIn");
            window.close();
        });


        grid.getChildren().addAll(welcomeText,nameLabel, nameInput, passLable,passInput, namevLabel, namevInput,surnameLabel, surnameInput, birthdayLabel, ageField, sexLabel, comboBoxsex, SignUpButton, logInButton);


        Scene scene= new Scene(grid,600,500);
        window.setScene(scene);


        window.show();

    }
}

package GUI;

import Controller.UserController;
import GUI.LogIn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tester.*;
import user.Sex;

import java.io.Serializable;
import java.sql.SQLException;


public class SignUp {

    public static void display(String title){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40,40,40,40));
        grid.setVgap(8);
        grid.setHgap(10);

        Text welcomeText= new Text("If you dont't have an account,\n please sign up!");
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
        Label birthdayLabel= new Label("Age:");
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
        comboBoxsex.setPromptText("Choose sex");
        GridPane.setConstraints(comboBoxsex,1,7);

        //this button allows sign up
        Button SignUpButton = new Button("Sign Up");
        GridPane.setConstraints(SignUpButton,1,8);
        SignUpButton.setOnAction(event -> {
            UserController userController = new UserController();
            userController.signUp(nameInput.getText(),passInput.getText(), namevInput.getText(), surnameInput.getText(),(Sex)comboBoxsex.getValue(),(int)ageField.getValue());
            LogIn.display("Log In");
            window.close();
        });

        // this button allows to go to log in (if your account already exist)
        Button logInButton =new Button("Log In");
        GridPane.setConstraints(logInButton,2,8);
        logInButton.setOnAction(event -> {
            LogIn.display("Log In");
            window.close();
        });


        grid.getChildren().addAll(welcomeText,nameLabel, nameInput, passLable,passInput, namevLabel, namevInput,surnameLabel, surnameInput, birthdayLabel, ageField, sexLabel, comboBoxsex, SignUpButton, logInButton);


        Scene scene= new Scene(grid,700,500);
        window.setScene(scene);


        window.show();

    }



}

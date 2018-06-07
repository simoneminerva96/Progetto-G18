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
        //userame Label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,2);

        //userame Input
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

        ObservableList<Integer> dayList= FXCollections.observableArrayList(
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
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
                31
        );
        ComboBox dayField = new ComboBox(dayList);
        dayField.setPromptText("D.");
        GridPane.setConstraints(dayField,1,6);

        ObservableList<String> month= FXCollections.observableArrayList(
                "-",
                "Genuary",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "Dicember"

        );

        ComboBox comboBoxmonth= new ComboBox(month);
        comboBoxmonth.setPromptText("M.");
        GridPane.setConstraints(comboBoxmonth,2,6);

        ObservableList<Integer> Years= FXCollections.observableArrayList(
                1900,
                1901,
                1900,
                1901,
                1902,
                1903,
                1904,
                1905,
                1906,
                1907,
                1908,
                1909,
                1910,
                1911,
                1912,
                1913,
                1914,
                1915,
                1916,
                1917,
                1918,
                1919,
                1920,
                1921,
                1922,
                1923,
                1924,
                1925,
                1926,
                1927,
                1928,
                1929,
                1930,
                1931,
                1932,
                1933,
                1934,
                1935,
                1936,
                1937,
                1938,
                1939,
                1940,
                1941,
                1942,
                1943,
                1944,
                1945,
                1946,
                1947,
                1948,
                1949,
                1950,
                1951,
                1952,
                1953,
                1954,
                1955,
                1956,
                1957,
                1958,
                1959,
                1960,
                1961,
                1962,
                1963,
                1964,
                1965,
                1966,
                1967,
                1968,
                1969,
                1970,
                1971,
                1972,
                1973,
                1974,
                1975,
                1976,
                1977,
                1978,
                1979,
                1980,
                1981,
                1982,
                1983,
                1984,
                1985,
                1986,
                1987,
                1988,
                1989,
                1990,
                1991,
                1992,
                1993,
                1994,
                1995,
                1996,
                1997,
                1998,
                1999,
                2000,
                2001,
                2002,
                2003,
                2004,
                2005,
                2006,
                2007,
                2008,
                2009,
                2010,
                2011,
                2012,
                2013,
                2014,
                2015,
                2016,
                2017
        );

        ComboBox comboBoxYears= new ComboBox(Years);
        comboBoxYears.setPromptText("Y.");
        GridPane.setConstraints(comboBoxmonth,3,6);


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

        Button SignUpButton = new Button("Sign Up");
        GridPane.setConstraints(SignUpButton,1,8);
        SignUpButton.setOnAction(event -> {
            UserController userController = new UserController();
            userController.signUp(nameInput.getText(),passInput.getText(), namevInput.getText(), surnameInput.getText(),(Sex)comboBoxsex.getValue(),(int)dayField.getValue());
            LogIn.display("Log In");
            window.close();
        });

        Button logInButton =new Button("Log In");
        GridPane.setConstraints(logInButton,2,8);
        logInButton.setOnAction(event -> {
            LogIn.display("Log In");
            window.close();
        });


        grid.getChildren().addAll(welcomeText,nameLabel, nameInput, passLable,passInput, namevLabel, namevInput,surnameLabel, surnameInput, birthdayLabel, dayField, comboBoxmonth, comboBoxYears, sexLabel, comboBoxsex, SignUpButton, logInButton);


        Scene scene= new Scene(grid,700,500);
        window.setScene(scene);


        window.show();

    }



}

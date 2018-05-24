package GUI;

import GUI.LogIn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

        //userame Label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel,0,0);

        //userame Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput,1,0);

        //Pass Label
        Label passLable= new Label("Password:");
        GridPane.setConstraints(passLable,0,1);

        //Pass Input
        PasswordField passInput= new PasswordField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput,1,1);

        //Name Label
        Label namevLabel = new Label("Name:");
        GridPane.setConstraints(namevLabel,0,2);

        //Name input
        TextField namevInput= new TextField();
        namevInput.setPromptText("Name");
        GridPane.setConstraints(namevInput,1,2);

        //Surname label
        Label surnameLabel= new Label("Surname:");
        GridPane.setConstraints(surnameLabel, 0,3);

        //Surname input
        TextField surnameInput = new TextField();
        surnameInput.setPromptText("Surname");
        GridPane.setConstraints(surnameInput,1,3);

        //Birthday Label
        Label birthdayLabel= new Label("Day of Birth:");
        GridPane.setConstraints(birthdayLabel,0,4);

        //day of birthday

        ObservableList<String> day = FXCollections.observableArrayList(
                "-",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20",
                "21",
                "22",
                "23",
                "24",
                "25",
                "26",
                "27",
                "28",
                "29",
                "30",
                "31"
        );
        ComboBox comboBoxday= new ComboBox(day);
        comboBoxday.setPromptText("-");
        comboBoxday.setVisibleRowCount(31);
        GridPane.setConstraints(comboBoxday,1,4);

        //mounth of birth
        ObservableList<String> mounth= FXCollections.observableArrayList(
                "-",
                "genuary",
                "february",
                "march",
                "april",
                "may",
                "june",
                "july",
                "august",
                "september",
                "october",
                "november",
                "dicember"

        );

        ComboBox comboBoxmounth= new ComboBox(mounth);
        comboBoxmounth.setPromptText("-");
        GridPane.setConstraints(comboBoxmounth,2,4);

        ObservableList<String> year = FXCollections.observableArrayList(
                "-",
                "1930",
                "1931",
                "1932",
                "1933",
                "1934",
                "1935",
                "1936",
                "1937",
                "1938",
                "1939",
                "1940",
                "1930",
                "1931",
                "1932",
                "1933",
                "1934",
                "1935",
                "1936",
                "1937",
                "1938",
                "1939",
                "1940",
                "1941",
                "1942",
                "1943",
                "1944",
                "1945",
                "1946",
                "1947",
                "1948",
                "1949",
                "1950",
                "1951",
                "1952",
                "1953",
                "1954",
                "1955",
                "1956",
                "1957",
                "1958",
                "1959",
                "1960",
                "1961",
                "1962",
                "1963",
                "1964",
                "1965",
                "1966",
                "1967",
                "1968",
                "1969",
                "1970",
                "1971",
                "1972",
                "1973",
                "1974",
                "1975",
                "1976",
                "1977",
                "1978",
                "1979",
                "1980",
                "1981",
                "1982",
                "1983",
                "1984",
                "1985",
                "1986",
                "1987",
                "1988",
                "1989",
                "1990",
                "1991",
                "1992",
                "1993",
                "1994",
                "1995",
                "1996",
                "1997",
                "1998",
                "1999",
                "2000",
                "2001",
                "2002",
                "2003",
                "2004",
                "2005",
                "2006",
                "2007",
                "2008",
                "2009",
                "2010",
                "2011",
                "2012",
                "2013",
                "2014",
                "2015",
                "2016",
                "2017",
                "2018"

        );

        ComboBox comboBoxyears= new ComboBox(year);
        comboBoxyears.setPromptText("-");
        GridPane.setConstraints(comboBoxyears,3,4);

        //Sex label
        Label sexLabel= new Label("Sex:");
        GridPane.setConstraints(sexLabel,0,5);

        //Sex Input
        ObservableList<String> sex = FXCollections.observableArrayList(
                "-",
                "M",
                "F"
        );
        ComboBox comboBoxsex = new ComboBox(sex);
        comboBoxsex.setPromptText("Choose sex");
        GridPane.setConstraints(comboBoxsex,1,5);

        Button SignUpButton = new Button("Sign Up");
        GridPane.setConstraints(SignUpButton,1,6);
        SignUpButton.setOnAction(event -> {
            LogIn.display("Log In");
            window.close();
        });

        Button logInButton =new Button("Log In");
        GridPane.setConstraints(logInButton,2,6);
        logInButton.setOnAction(event -> {
            LogIn.display("Log In");
            window.close();
        });


        grid.getChildren().addAll(nameLabel, nameInput, passLable,passInput, namevLabel, namevInput,surnameLabel, surnameInput, birthdayLabel, comboBoxday,comboBoxmounth,comboBoxyears, sexLabel, comboBoxsex, SignUpButton, logInButton);


        Scene scene= new Scene(grid,700,500);
        window.setScene(scene);


        window.show();

    }



}

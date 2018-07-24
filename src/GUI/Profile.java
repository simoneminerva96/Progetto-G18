package GUI;



import Controller.UserController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import user.User;


public class Profile {

    public static UserController c = new UserController();


    public static void setController(UserController userController) {
        c = userController;
    }

    public static void display(String title){
        Stage window= new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(40,40,40,40));
        grid.setVgap(8);
        grid.setHgap(10);

        UserController userController = c;

        User u = userController.getUser();

        //the profile show user's data
        Label name= new Label("Name: ");
        GridPane.setConstraints(name,0,0);


        Label nameField= new Label(u.getNameP());
        GridPane.setConstraints(nameField,1,0);

        Label surname = new Label("Surname: ");
        GridPane.setConstraints(surname,0,1);

        Label surnameField= new Label(u.getSurname());
        GridPane.setConstraints(surnameField,1,1);

        Label username= new Label("Username: ");
        GridPane.setConstraints(username,0,2);

        Label usernameField = new Label(u.getUserName());
        GridPane.setConstraints(usernameField,1,2);

        Label data= new Label("Age: ");
        GridPane.setConstraints(data,0,3);

        Label dataField= new Label(""+u.getAge());
        GridPane.setConstraints(dataField,1,3);

        Label sex= new Label("Sex: ");
        GridPane.setConstraints(sex,0,4);

        Label sexField = new Label(""+u.getSex());
        GridPane.setConstraints(sexField,1,4);


        //this button allows to return to the home page
        Button closeProfile= new Button("Close");
        GridPane.setConstraints(closeProfile,1,5);

        closeProfile.setOnAction(event -> {
            window.close();
            HomePage.display("Home Page");
        });

        //this button allows to log out
        Button logOut= new Button("Log Out");
        GridPane.setConstraints(logOut,2,5);

        logOut.setOnAction(event -> {
            LogIn.display("LogIn");
            window.close();
        });

        //this button allows to delete the prifile
        Button Delete = new Button("Delete Profile");
        GridPane.setConstraints(Delete, 3, 5);
        Delete.setOnAction(event -> {

            userController.DeleteProfile(u.getUserName());
            SignUp.display("SignUp");
            window.close();
        });

        grid.getChildren().addAll(name,nameField,surname, surnameField,username, usernameField, data,dataField, sex,sexField, closeProfile,logOut, Delete);

        Scene scene= new Scene(grid,500,500);
        window.setScene(scene);
        window.show();
    }
}

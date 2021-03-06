package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class opens a window that reports an error in log in. The username or the password may
 * be wrong or the sign up may be not done.
 */


public class ErrorInLogIn {
    static boolean answer;

    public static boolean display(String title){


        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);


        Label label = new Label();
        Text errorMessage= new Text("Error in username or password!");
        errorMessage.setFont(Font.font("Arial", FontWeight.BOLD,10));


        Button returnLog = new Button("Return to Log In");
        Button signUp = new Button("Close All and Sign Up");


        returnLog.setOnAction(event -> {
            answer = true;
            LogIn.display("LogIn");
            window.close();
        });

        signUp.setOnAction(event -> {
            answer = false;
            SignUp.display("SignUp");
            window.close();
        });

        //the elements are on a vertical box
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(errorMessage,label, returnLog, signUp);


        Scene scene= new Scene(layout,500,500);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}

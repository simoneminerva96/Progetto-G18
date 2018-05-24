package GUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ErrorInLogIn {
    static boolean answer;

    public static boolean display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        Label label = new Label();
        label.setText(message);

        Button returnLog = new Button("return to Log In");
        Button signUp = new Button("Close All and Sign Up");


        returnLog.setOnAction(event -> {
            answer= true;
            LogIn.display("Log In");
            window.close();
        });

        signUp.setOnAction(event -> {
            answer = false;
            SignUp.display("Sign Up");
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, returnLog, signUp);


        Scene scene= new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}

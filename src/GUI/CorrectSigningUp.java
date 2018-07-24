package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CorrectSigningUp {
    static boolean answer;

    public static boolean display(String title){

        //window creation
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        //message creation
        Label label = new Label();
        Text successMessage= new Text("Successful registration!");
        successMessage.setFont(Font.font("Arial", FontWeight.BOLD,10));

        //button creation
        Button Close = new Button("Close");


        //the ActionListener return to Home page
        Close.setOnAction(event -> {
            answer = true;
            HomePage.display("HomePage");
            window.close();
        });


        //the elements are in a vertical box
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(successMessage,label, Close);


        Scene scene= new Scene(layout,500,500);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}



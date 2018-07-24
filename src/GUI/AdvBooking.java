package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class generates a window that confirms the happened booking for an event.
 */
public class AdvBooking {
    static boolean answer;

    public static boolean display(String title){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinHeight(250);

        Label label = new Label();
        Text errorMessage= new Text("Booking successful!");
        errorMessage.setFont(Font.font("Arial", FontWeight.BOLD,10));

        Button returnHome = new Button("Return to HomePage");


        returnHome.setOnAction(event -> {

            HomePage.display("Home Page");
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(errorMessage,label, returnHome);


        Scene scene= new Scene(layout,500,500);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}

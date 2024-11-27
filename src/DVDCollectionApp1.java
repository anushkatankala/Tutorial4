import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class DVDCollectionApp1 extends Application {
    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        DVDButtonPane buttonPane = new DVDButtonPane();
        buttonPane.relocate(30,200);

        // Create the labels
        Label titleLabel = new Label("Title");
        titleLabel.relocate(10,10);
        Label yearLabel = new Label("Year");
        yearLabel.relocate(220,10);
        Label lengthLabel = new Label("Length");
        lengthLabel.relocate(290, 10);

        // Create the lists
        String[] titles = {"Star Wars", "Java is cool", "Mary Poppins", "The Green Mile"};
        ObservableList<String> titlesInList = FXCollections.observableArrayList(titles);
        ListView<String> titlesList = new ListView<>(titlesInList);
        titlesList.setPrefSize(200,150);
        titlesList.relocate(10,40);

        String[] years = {"1978", "2002", "1968", "1999"};
        ObservableList<String> yearsInList = FXCollections.observableArrayList(years);
        ListView<String> yearsList = new ListView<>(yearsInList);
        yearsList.setPrefSize(60,150);
        yearsList.relocate(220,40);

        String[] lengths = {"124", "93", "126", "148"};
        ObservableList<String> lengthsInList = FXCollections.observableArrayList(lengths);
        ListView<String> lengthsList = new ListView<>(lengthsInList);
        lengthsList.setPrefSize(60,150);
        lengthsList.relocate(290,40);

        aPane.getChildren().addAll(titleLabel, yearLabel, lengthLabel, titlesList,
                yearsList, lengthsList, buttonPane);
        Scene scene = new Scene(aPane, 360, 240);
        primaryStage.setTitle("My DVD Collection");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

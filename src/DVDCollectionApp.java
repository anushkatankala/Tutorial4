import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class DVDCollectionApp extends Application {
    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        // Create the labels
        Label titleLabel = new Label("Title");
        titleLabel.relocate(10,20);
        Label yearLabel = new Label("Year");
        yearLabel.relocate(220,20);
        Label lengthLabel = new Label("Length");
        lengthLabel.relocate(290, 20);

        // Create the lists
        String[] titles = {"Star Wars", "Java is cool", "Mary Poppins", "The Green Mile"};
        ObservableList<String> titlesInList = FXCollections.observableArrayList(titles);
        ListView<String> titlesList = new ListView<>(titlesInList);
        titlesList.setPrefSize(200,150);
        titlesList.relocate(10,50);

        String[] years = {"1978", "2002", "1968", "1999"};
        ObservableList<String> yearsInList = FXCollections.observableArrayList(years);
        ListView<String> yearsList = new ListView<>(yearsInList);
        yearsList.setPrefSize(60,150);
        yearsList.relocate(220,50);

        String[] lengths = {"124", "93", "126", "148"};
        ObservableList<String> lengthsInList = FXCollections.observableArrayList(lengths);
        ListView<String> lengthsList = new ListView<>(lengthsInList);
        lengthsList.setPrefSize(60,150);
        lengthsList.relocate(290,50);

        // Create buttons
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); " + "-fx-text-fill: rgb(255,255,255);");
        addButton.setPrefSize(95,30);
        addButton.relocate(10, 205);

        Button deleteButton = new Button("Delete");
        deleteButton.setPrefSize(95,30);
        deleteButton.relocate(115, 205);
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(100,0,0); " + "-fx-text-fill: rgb(255,255,255);");

        Button statsButton = new Button("Stats");
        statsButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); " + "-fx-text-fill: rgb(0,0,0);");
        statsButton.setPrefSize(60,30);
        statsButton.relocate(290,205);

        // Create the buttons
        // The following code shows how to set the font,
        // background color and text color of a button:
        // b.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); " +
        //     "-fx-text-fill: rgb(255,255,255);");
        //the 3 rgb values represent the red/green/blue values for the color your want
        // ... ADD CODE HERE ... //

        // Don't forget to add the components to the window, set the title,
        // make it non-resizable, set Scene dimensions and then show the stage
        // ... ADD CODE HERE ... //
        aPane.getChildren().addAll(titleLabel, yearLabel, lengthLabel, titlesList,
                yearsList, lengthsList, addButton, deleteButton, statsButton);
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

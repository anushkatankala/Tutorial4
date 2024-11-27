import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.collections.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DVDCollectionApp2 extends Application {
    private DVDCollection model;

    public DVDCollectionApp2() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        // Create the labels
        Label label1 = new Label("DVDs");
        label1.relocate(10,10);
        Label label2 = new Label("Title");
        label2.relocate(10,202);
        Label label3 = new Label("Year");
        label3.relocate(10, 242);
        Label label4 = new Label("Length");
        label4.relocate(120,242);

        // Create the TextFields
        TextField tField = new TextField();
        tField.relocate(50,200);
        tField.setPrefSize(500,30);
        TextField yField = new TextField();
        yField.relocate(50,240);
        yField.setPrefSize(55,30);
        TextField lField = new TextField();
        lField.relocate(180,240);
        lField.setPrefSize(45,30);

        // Create the lists
        ListView<DVD> tList = new ListView<DVD>();
        ObservableList<DVD> dvdList = FXCollections.observableArrayList(model.getDVDList());
        tList.setItems(dvdList);

        tList.relocate(10,40);
        tList.setPrefSize(540,150);

        // Create the buttons
        DVDButtonPane buttonPane = new DVDButtonPane();
        buttonPane.relocate(250,240);

        tList.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DVD select = tList.getSelectionModel().getSelectedItem();
                tField.setText(select.getTitle());
                yField.setText("" + select.getYear());
                lField.setText("" + select.getDuration());

            }
        });

        // Add all the components to the window
        aPane.getChildren().addAll(label1, label2, label3, label4, tField, yField,
                lField, tList, buttonPane);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 560,280));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

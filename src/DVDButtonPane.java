import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.layout.Pane;

public class DVDButtonPane extends Pane {
    private Button addButton;
    private Button deleteButton;

    public DVDButtonPane (){
        Pane buttonPane = new Pane();
        buttonPane.setStyle("-fx-background-color: white; " +
                "-fx-border-color: gray; " +
                "-fx-padding: 4 4;");
        addButton = new Button("Add");
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); " + "-fx-text-fill: rgb(255,255,255);");
        addButton.setPrefSize(90,30);
        addButton.relocate(0, 0);

        deleteButton = new Button("Delete");
        deleteButton.setPrefSize(90,30);
        deleteButton.relocate(100, 0);
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(100,0,0); " + "-fx-text-fill: rgb(255,255,255);");

        Button statsButton = new Button("Stats");
        statsButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(255,255,255); " + "-fx-text-fill: rgb(0,0,0);");
        statsButton.setPrefSize(90,30);
        statsButton.relocate(210,0);

        this.getChildren().addAll(addButton, deleteButton, statsButton);
    }

    public Button getAddButton() {
        return addButton;
    }
    public Button getDeleteButton(){
        return deleteButton;
    }
}

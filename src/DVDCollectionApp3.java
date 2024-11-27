import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.*;

public class DVDCollectionApp3 extends Application {
    private DVDCollection model;

    public DVDCollectionApp3() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane aPane = new Pane();

        // Create the view
        DVDCollectionView view = new DVDCollectionView();
        aPane.getChildren().add(view);

        view.getButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                String t = javax.swing.JOptionPane.showInputDialog("Please enter the DVD title: ");
                String y = javax.swing.JOptionPane.showInputDialog("Please enter the DVD year: ");
                String l = javax.swing.JOptionPane.showInputDialog("Please enter the DVD length: ");
                DVD d = new DVD(t, Integer.parseInt(y), Integer.parseInt(l));
                model.add(d);
                view.update(model);

            }
        });

        view.getTitleList().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                int s = view.getTitleList().getSelectionModel().getSelectedIndex();
                view.update(model, s);

                view.getButtonPane().getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String select = view.getTitleList().getSelectionModel().getSelectedItem();
                        for (DVD i : model.getDVDList()){
                            if (i.getTitle().equals(select)){
                                model.remove(select);
                                view.update(model);
                            }
                        }
                    }
                });
            }
        });

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
        view.update(model);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

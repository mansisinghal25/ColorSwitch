package ColourSwitchGame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{


        //AnchorPane homePage = (AnchorPane) FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        //AnchorPane Instructions = (AnchorPane) FXMLLoader.load(getClass().getResource("InstructionPage.fxml"));


        //Scene scene = new Scene(Instructions,480,650);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = (Parent)loader.load();

        HomePage controller = (HomePage) loader.getController();

        //set stage
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}

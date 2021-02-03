package ColourSwitchGame;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PauseMenu implements Initializable {
    private Stage primaryStage;
    public game controller;
    public SaveDataList list;
    public SaveData data;

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void goHomePage(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = (Parent)loader.load();
        HomePage controller = (HomePage) loader.getController();
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void ResumeGame(MouseEvent mouseEvent) throws IOException {
        try {
            data = (SaveData)ResourceManager.load("game1.bin");
            System.out.println(data.name);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root = (Parent)loader.load();
            controller = (game) loader.getController();
//            controller.loaded_game = data;
//            controller.resumed = true;
            controller.score=Integer.parseInt(data.name);
            controller.score_label.setText(String.valueOf(controller.score));

            controller.ball.setFill(Paint.valueOf(data.ball_colour));
            controller.a.setLayoutY(data.position1);
            controller.aa.setLayoutY(data.position2);
            controller.a1.setLayoutY(data.position3);
            controller.a2.setLayoutY(data.position4);

            controller.ball.setCenterY(data.ball_position);


            System.out.println("here"+ controller.resumed);
            controller.setPrimaryStage(primaryStage);
            //controller.ResumeTheGame();
            Scene scene = new Scene(root,480,650);
            primaryStage.setTitle("Colour Switch");
            primaryStage.setScene(scene);
            primaryStage.show();

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }

    }

    public void SavedExit(MouseEvent mouseEvent) throws IOException, ClassNotFoundException, NullPointerException {
        data = (SaveData)ResourceManager.load("game1.bin");
        list= (SaveDataList)ResourceManager.load("gamelist.bin");
        list.list_ofSavedGames.add(data);

        try{
           ResourceManager.save(list,"gamelist.bin");
        }
        catch (Exception e) {
            System.out.println("Couldn't save: " + e.getMessage());
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Parent root = (Parent)loader.load();
        HomePage controller = (HomePage) loader.getController();
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
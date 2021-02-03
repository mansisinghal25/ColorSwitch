package ColourSwitchGame;

import java.io.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ExitMenu implements Initializable {
    private Stage primaryStage;
    @FXML
    Label exit_score,high_score,no_of_stars;

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            SaveData data = (SaveData)ResourceManager.load("highscore.bin");
            System.out.println(data.name);
            high_score.setText(data.name);
            //SaveData data2 = (SaveData)ResourceManager.load("totalstars.bin");
            String data2 = (String) ResourceManager.load("totalstars.bin");
            System.out.println(data2);
            no_of_stars.setText(data2);
        }
        catch (Exception e) {
            e.printStackTrace();
            SaveData d = new SaveData();
            d.name ="0";
            try {
                ResourceManager.save("0","totalstars.bin");
                ResourceManager.save(d,"totalstars.bin");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            //System.out.println("Couldn't load save data: " + e.getMessage());
        }
//
//        try {
//            SaveData data2 = (SaveData)ResourceManager.load("totalstars.bin");
//            System.out.println(data2.name);
//            no_of_stars.setText(data2.name);
//        }
//        catch (Exception e) {
//            System.out.println("Couldn't load save data fuck: " + e.getMessage());
//            e.printStackTrace();
//        }

    }

    public void reviveGame(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        String temp = (String) ResourceManager.load("totalstars.bin");
        ResourceManager.save(String.valueOf(Integer.parseInt(temp)-50),"totalstars.bin");

        try {
            SaveData data = (SaveData)ResourceManager.load("game1.bin");
            System.out.println(data.name);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root = (Parent)loader.load();
            game controller = (game) loader.getController();
//            controller.loaded_game = data;
//            controller.resumed = true;
            controller.score=Integer.parseInt(data.name);
            controller.score_label.setText(String.valueOf(controller.score));

            controller.ball.setFill(Paint.valueOf(data.ball_colour));
            controller.a.setLayoutY(data.position1);
            controller.aa.setLayoutY(data.position2);
            controller.a1.setLayoutY(data.position3);
            controller.a2.setLayoutY(data.position4);

            controller.ball.setCenterY(data.ball_position-40);

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

    public void SaveExit(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void NoSaveEnd(MouseEvent mouseEvent) {
        System.exit(0);
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

    public void restartGame(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
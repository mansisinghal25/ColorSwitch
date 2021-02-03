package ColourSwitchGame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ResumeGame implements Initializable {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    ImageView g1,g2,g3,g4,g5,g6,g7,g8,g9;
    @FXML
    Label gno1,gno2,gno3,gno4,gno5,gno6,gno7,gno8,gno9;
    @FXML
    Label gs1,gs2,gs3,gs4,gs5,gs6,gs7,gs8,gs9;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setScores();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int size= datalist.list_ofSavedGames.size();
        if(size<0)
        {
            g1.setVisible(false);
            gno1.setVisible(false);
            gs1.setVisible(false);
        }
        if(size<1)
        {
            g2.setVisible(false);
            gno2.setVisible(false);
            gs2.setVisible(false);
        }
        if(size<2)
        {
            g3.setVisible(false);
            gno3.setVisible(false);
            gs3.setVisible(false);
        }
        if(size<3)
        {
            g4.setVisible(false);
            gno4.setVisible(false);
            gs4.setVisible(false);
        }
        if(size<5)
        {
            g5.setVisible(false);
            gno5.setVisible(false);
            gs5.setVisible(false);
        }
        if(size<6)
        {
            g6.setVisible(false);
            gno6.setVisible(false);
            gs6.setVisible(false);
        }
        if(size<7)
        {
            g7.setVisible(false);
            gno7.setVisible(false);
            gs7.setVisible(false);
        }
        if(size<8)
        {
            g8.setVisible(false);
            gno8.setVisible(false);
            gs8.setVisible(false);
        }
        if(size<9)
        {
            g9.setVisible(false);
            gno9.setVisible(false);
            gs9.setVisible(false);
        }



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

    public void setScores() throws IOException, ClassNotFoundException {
        datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        int size= datalist.list_ofSavedGames.size();
        try {
            if(size>0)    gs1.setText(datalist.list_ofSavedGames.get(0).name);
            if(size>1)    gs2.setText(datalist.list_ofSavedGames.get(1).name);
            if(size>2)    gs3.setText(datalist.list_ofSavedGames.get(2).name);
            if(size>3)    gs4.setText(datalist.list_ofSavedGames.get(3).name);
            if(size>4)    gs5.setText(datalist.list_ofSavedGames.get(4).name);
            if(size>5)    gs6.setText(datalist.list_ofSavedGames.get(5).name);
            if(size>6)    gs7.setText(datalist.list_ofSavedGames.get(6).name);
            if(size>7)    gs8.setText(datalist.list_ofSavedGames.get(7).name);
            if(size>8)    gs9.setText(datalist.list_ofSavedGames.get(8).name);
        }

        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("not full");
        }
    }

    SaveDataList datalist;
    public void gotoGame1(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
            SaveData data = datalist.list_ofSavedGames.get(0);
            System.out.println(data.name);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root = (Parent)loader.load();
            game controller = (game) loader.getController();
            controller.score=Integer.parseInt(data.name);
            controller.score_label.setText(String.valueOf(controller.score));

            controller.ball.setFill(Paint.valueOf(data.ball_colour));
            controller.a.setLayoutY(data.position1);
            controller.aa.setLayoutY(data.position2);
            controller.a1.setLayoutY(data.position3);
            controller.a2.setLayoutY(data.position4);
            controller.ball.setCenterY(data.ball_position);

            datalist.list_ofSavedGames.remove(0);
            ResourceManager.save(datalist,"gamelist.bin");

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

    public void gotoGame2(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
        SaveData data = datalist.list_ofSavedGames.get(1);
        System.out.println(data.name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.score=Integer.parseInt(data.name);
        controller.score_label.setText(String.valueOf(controller.score));

        controller.ball.setFill(Paint.valueOf(data.ball_colour));
        controller.a.setLayoutY(data.position1);
        controller.aa.setLayoutY(data.position2);
        controller.a1.setLayoutY(data.position3);
        controller.a2.setLayoutY(data.position4);

        controller.ball.setCenterY(data.ball_position);
        gs2.setText(String.valueOf(controller.score));

        datalist.list_ofSavedGames.remove(1);
        ResourceManager.save(datalist,"gamelist.bin");

        System.out.println("here"+ controller.resumed);
        controller.setPrimaryStage(primaryStage);
        //controller.ResumeTheGame();
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gotoGame3(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
        SaveData data = datalist.list_ofSavedGames.get(2);
        System.out.println(data.name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.score=Integer.parseInt(data.name);
        controller.score_label.setText(String.valueOf(controller.score));

        controller.ball.setFill(Paint.valueOf(data.ball_colour));
        controller.a.setLayoutY(data.position1);
        controller.aa.setLayoutY(data.position2);
        controller.a1.setLayoutY(data.position3);
        controller.a2.setLayoutY(data.position4);

        controller.ball.setCenterY(data.ball_position);
        gs3.setText(String.valueOf(controller.score));

        datalist.list_ofSavedGames.remove(2);
        ResourceManager.save(datalist,"gamelist.bin");

        System.out.println("here"+ controller.resumed);
        controller.setPrimaryStage(primaryStage);
        //controller.ResumeTheGame();
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gotoGame4(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
        SaveData data = datalist.list_ofSavedGames.get(3);
        System.out.println(data.name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.score=Integer.parseInt(data.name);
        controller.score_label.setText(String.valueOf(controller.score));

        controller.ball.setFill(Paint.valueOf(data.ball_colour));
        controller.a.setLayoutY(data.position1);
        controller.aa.setLayoutY(data.position2);
        controller.a1.setLayoutY(data.position3);
        controller.a2.setLayoutY(data.position4);

        controller.ball.setCenterY(data.ball_position);
        gs4.setText(String.valueOf(controller.score));

        datalist.list_ofSavedGames.remove(3);
        ResourceManager.save(datalist,"gamelist.bin");

        System.out.println("here"+ controller.resumed);
        controller.setPrimaryStage(primaryStage);
        //controller.ResumeTheGame();
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gotoGame5(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
        SaveData data = datalist.list_ofSavedGames.get(4);
        System.out.println(data.name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.score=Integer.parseInt(data.name);
        controller.score_label.setText(String.valueOf(controller.score));

        controller.ball.setFill(Paint.valueOf(data.ball_colour));
        controller.a.setLayoutY(data.position1);
        controller.aa.setLayoutY(data.position2);
        controller.a1.setLayoutY(data.position3);
        controller.a2.setLayoutY(data.position4);

        controller.ball.setCenterY(data.ball_position);

        datalist.list_ofSavedGames.remove(4);
        ResourceManager.save(datalist,"gamelist.bin");

        System.out.println("here"+ controller.resumed);
        controller.setPrimaryStage(primaryStage);
        //controller.ResumeTheGame();
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gotoGame6(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
        SaveData data = datalist.list_ofSavedGames.get(5);
        System.out.println(data.name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.score=Integer.parseInt(data.name);
        controller.score_label.setText(String.valueOf(controller.score));

        controller.ball.setFill(Paint.valueOf(data.ball_colour));
        controller.a.setLayoutY(data.position1);
        controller.aa.setLayoutY(data.position2);
        controller.a1.setLayoutY(data.position3);
        controller.a2.setLayoutY(data.position4);

        controller.ball.setCenterY(data.ball_position);

        datalist.list_ofSavedGames.remove(5);
        ResourceManager.save(datalist,"gamelist.bin");

        System.out.println("here"+ controller.resumed);
        controller.setPrimaryStage(primaryStage);
        //controller.ResumeTheGame();
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gotoGame7(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
        SaveData data = datalist.list_ofSavedGames.get(6);
        System.out.println(data.name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.score=Integer.parseInt(data.name);
        controller.score_label.setText(String.valueOf(controller.score));

        controller.ball.setFill(Paint.valueOf(data.ball_colour));
        controller.a.setLayoutY(data.position1);
        controller.aa.setLayoutY(data.position2);
        controller.a1.setLayoutY(data.position3);
        controller.a2.setLayoutY(data.position4);

        controller.ball.setCenterY(data.ball_position);

        datalist.list_ofSavedGames.remove(6);
        ResourceManager.save(datalist,"gamelist.bin");

        System.out.println("here"+ controller.resumed);
        controller.setPrimaryStage(primaryStage);
        //controller.ResumeTheGame();
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gotoGame8(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
        SaveData data = datalist.list_ofSavedGames.get(7);
        System.out.println(data.name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.score=Integer.parseInt(data.name);
        controller.score_label.setText(String.valueOf(controller.score));

        controller.ball.setFill(Paint.valueOf(data.ball_colour));
        controller.a.setLayoutY(data.position1);
        controller.aa.setLayoutY(data.position2);
        controller.a1.setLayoutY(data.position3);
        controller.a2.setLayoutY(data.position4);

        controller.ball.setCenterY(data.ball_position);

        datalist.list_ofSavedGames.remove(7);
        ResourceManager.save(datalist,"gamelist.bin");

        System.out.println("here"+ controller.resumed);
        controller.setPrimaryStage(primaryStage);
        //controller.ResumeTheGame();
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void gotoGame9(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        try {
            datalist = (SaveDataList)ResourceManager.load("gamelist.bin");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't load save data: " + e.getMessage());
        }
        SaveData data = datalist.list_ofSavedGames.get(8);
        System.out.println(data.name);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();
        controller.score=Integer.parseInt(data.name);
        controller.score_label.setText(String.valueOf(controller.score));

        controller.ball.setFill(Paint.valueOf(data.ball_colour));
        controller.a.setLayoutY(data.position1);
        controller.aa.setLayoutY(data.position2);
        controller.a1.setLayoutY(data.position3);
        controller.a2.setLayoutY(data.position4);

        controller.ball.setCenterY(data.ball_position);

        datalist.list_ofSavedGames.remove(8);
        ResourceManager.save(datalist,"gamelist.bin");

        System.out.println("here"+ controller.resumed);
        controller.setPrimaryStage(primaryStage);
        //controller.ResumeTheGame();
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
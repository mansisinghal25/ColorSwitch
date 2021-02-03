package ColourSwitchGame;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HomePage implements Initializable {
    private Stage primaryStage;

    @FXML
    private ImageView crcles;
    @FXML
    private ImageView play;
    @FXML
    private Label ans,stars;

    boolean music_off=false;

    MediaPlayer mediaPlayer;
    public void music()
    {

        String s= "/Users/mansisinghal/IdeaProjects/ColourSwitch/src/ColourSwitchGame/bg.mp3";

        Media m= new Media(Paths.get(s).toUri().toString());
        mediaPlayer= new MediaPlayer(m);
        mediaPlayer.play();
        if(music_off){
        mediaPlayer.stop();}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RotateTransition transition1 = new RotateTransition(Duration.millis(3000),crcles);
        transition1.setAxis(Rotate.Z_AXIS);
        transition1.setByAngle(360);
        transition1.setCycleCount(Animation.INDEFINITE);
        transition1.setInterpolator(Interpolator.LINEAR);
        transition1.play();
        //music();
        try {
            SaveData data = (SaveData)ResourceManager.load("highscore.bin");
            System.out.println(data.name);
            ans.setText(data.name);
            //SaveData data2 = (SaveData)ResourceManager.load("totalstars.bin");
            String data2 = (String) ResourceManager.load("totalstars.bin");
            System.out.println(data2);
            stars.setText(data2);
        }
        catch (Exception e) {
            e.printStackTrace();
            try {
                SaveData d = new SaveData();
                d.name="0";
                ResourceManager.save("0","totalstars.bin");
                ResourceManager.save(d,"highscore.bin");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            System.out.println("Couldn't load save data: " + e.getMessage());
        }

    }


    public void OpenInstructions(MouseEvent mouseEvent) throws IOException {
        //music_off=true;
        //music();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InstructionPage.fxml"));
        Parent root = (Parent)loader.load();
        InstructionController controller = (InstructionController) loader.getController();

        //set stage
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void exitApp(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void playGame(MouseEvent mouseEvent) throws IOException {
        //music_off=true;
        //music();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        Parent root = (Parent)loader.load();
        game controller = (game) loader.getController();

        //set stage
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void resumeGame(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResumeGame.fxml"));
        Parent root = (Parent)loader.load();
        ResumeGame controller = (ResumeGame) loader.getController();

        //set stage
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void OpenGift(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Gift.fxml"));
        Parent root = (Parent)loader.load();
        Gift controller = (Gift) loader.getController();

        //set stage
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

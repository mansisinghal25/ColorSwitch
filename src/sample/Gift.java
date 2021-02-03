package ColourSwitchGame;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Gift implements Initializable {
    private Stage primaryStage;
    @FXML
    AnchorPane wheel;
    @FXML
    Label giftlabel;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            rotateWheel();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void rotateWheel() throws IOException, ClassNotFoundException {
        int x= (int) (Math.random() * 360);


        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(x);
        rotate2.setCycleCount(1);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setDuration(Duration.millis(1000));
        rotate2.setNode(wheel);
        rotate2.play();

        System.out.println(x);
        String a = (String)ResourceManager.load("totalstars.bin");

        if((x<30 && x>0) || (x<360 && x>330))
        {
            ResourceManager.save(String.valueOf(Integer.parseInt(a)+10),"totalstars.bin");
        }
        else if(x<90 && x>30)
        {
            ResourceManager.save(String.valueOf(Integer.parseInt(a)+30),"totalstars.bin");
        }
        else if(x<150 && x>90)
        {
            ResourceManager.save(String.valueOf(Integer.parseInt(a)+20),"totalstars.bin");
        }
        else if(x<210 && x>150)
        {
            ResourceManager.save(String.valueOf(Integer.parseInt(a)+100),"totalstars.bin");
        }
        else if(x<270 && x>210)
        {
            ResourceManager.save(String.valueOf(Integer.parseInt(a)+5),"totalstars.bin");
        }
        else if(x<330 && x>270)
        {
            ResourceManager.save(String.valueOf(Integer.parseInt(a)+50),"totalstars.bin");
        }
    }

    private void updateStars() {
        String data = null;
        try {
            data = (String) ResourceManager.load("totalstars.bin");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ResourceManager.save("0","totalstars.bin");
            System.out.println(giftlabel.getText());
            //ResourceManager.save(String.valueOf(Integer.parseInt(data)+Integer.parseInt(giftlabel.getText())),"totalstars.bin");
        } catch (IOException e) {
            e.printStackTrace();
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

}
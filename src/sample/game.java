package ColourSwitchGame;

import javafx.animation.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import static javafx.scene.shape.Shape.intersect;

public class game implements Initializable {
    private Stage primaryStage;
    private AnimationTimer timer;

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }
    @FXML
    AnchorPane a,aa,a1,a2,a3,a4,a5,a6,a7,a8;
    @FXML
    AnchorPane acs1,acs2,acs3,acs4,acs5;
    @FXML
    Ellipse ball;
    @FXML
    Button play_button;
    @FXML
    ImageView star1,star2,star3,star4,star5;
    @FXML
    Arc switcher1,switcher2,switcher3,switcher4,switcher5;
    @FXML
    Arc a1a1,a1a2,a1a3,a1a4,a2a1,a2a2,a2a3,a2a4;
    @FXML
    Line a3a1,a3a2,a3a3,a3a4,a4a1,a4a2,a4a3,a4a4,a4a5,a4a6,a4a7,a4a8;
    @FXML
    Rectangle a5a1,a5a2,a5a3,a5a4;
    @FXML
    Circle a6a1,a6a2,a6a3,a6a4,a6a5,a6a6,a6a7,a6a8,a6a9,a6a10,a6a11,a6a12,a6a13,a6a14,a6a15,a6a16;
    @FXML
    Arc a7a1,a7a2,a7a3,a7a4,a8a1,a8a2,a8a3,a8a4;
    @FXML
    javafx.scene.control.Label score_label;
    @FXML
    javafx.scene.control.Label click_to_play;
    @FXML
    Circle starc1, starc2, starc3,starc4 ,starc5;

    boolean once= false;
    boolean start= false;
    double velocity =1;
    double acceleration =1;
    int score=0;
    boolean c1=false,c2=false,c3=false,c4=false,c5=false;
    boolean helper1=false,helper2=false,helper3=false,helper4=false,helper5=false;
    double velo=2;
    double acc =0.25;
    boolean resumed=false;
    boolean resumed_flag=false;

    SaveData loaded_game;
    MediaPlayer mP,mP2,mP3;
    public void starmusic()
    {
        String s= "/Users/mansisinghal/IdeaProjects/ColourSwitch/src/ColourSwitchGame/star-collect-sound.mp3";
        Media m= new Media(Paths.get(s).toUri().toString());
        mP= new MediaPlayer(m);
        mP.play();
    }
    public void overmusic()
    {
        String s= "/Users/mansisinghal/IdeaProjects/ColourSwitch/src/ColourSwitchGame/game_over_sound.mp3";
        Media m= new Media(Paths.get(s).toUri().toString());
        mP2= new MediaPlayer(m);
        mP2.play();
    }
    public void ballsound()
    {
        String s= "/Users/mansisinghal/IdeaProjects/ColourSwitch/src/ColourSwitchGame/ball_music.mp3";
        Media m= new Media(Paths.get(s).toUri().toString());
        mP3= new MediaPlayer(m);
        mP3.play();
    }
    public void ResumeTheGame(){
        score = Integer.parseInt(loaded_game.name);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(Animation.INDEFINITE);
        rotate1.setInterpolator(Interpolator.LINEAR);
        rotate1.setDuration(Duration.millis(3000));
        rotate1.setNode(a1);
        rotate1.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(-360);
        rotate2.setCycleCount(5000);
        rotate2.setInterpolator(Interpolator.LINEAR);
        rotate2.setDuration(Duration.millis(3000));
        rotate2.setNode(a2);
        rotate2.play();

        RotateTransition rotate3 = new RotateTransition();
        rotate3.setAxis(Rotate.Z_AXIS);
        rotate3.setByAngle(-360);
        rotate3.setCycleCount(5000);
        rotate3.setInterpolator(Interpolator.LINEAR);
        rotate3.setDuration(Duration.millis(3000));
        rotate3.setNode(a3);
        rotate3.play();

        PathTransition pt2 = new PathTransition();
        pt2.setNode(a4);
        pt2.setDuration(Duration.seconds(4));
        Rectangle rectangl= new Rectangle(480,0);
        pt2.setPath(rectangl);
        pt2.setCycleCount(100);
        pt2.play();

        RotateTransition rotate5 = new RotateTransition();
        rotate5.setAxis(Rotate.Z_AXIS);
        rotate5.setByAngle(360);
        rotate5.setCycleCount(5000);
        rotate5.setInterpolator(Interpolator.LINEAR);
        rotate5.setDuration(Duration.millis(3000));
        rotate5.setNode(a5);
        rotate5.play();

        RotateTransition rotate6 = new RotateTransition();
        rotate6.setAxis(Rotate.Z_AXIS);
        rotate6.setByAngle(360);
        rotate6.setCycleCount(5000);
        rotate6.setInterpolator(Interpolator.LINEAR);
        rotate6.setDuration(Duration.millis(3000));
        rotate6.setNode(a6);
        rotate6.play();

        RotateTransition rotate7 = new RotateTransition();
        rotate7.setAxis(Rotate.Z_AXIS);
        rotate7.setByAngle(360);
        rotate7.setCycleCount(5000);
        rotate7.setInterpolator(Interpolator.LINEAR);
        rotate7.setDuration(Duration.millis(3000));
        rotate7.setNode(a7);
        rotate7.play();

        RotateTransition rotate8 = new RotateTransition();
        rotate8.setAxis(Rotate.Z_AXIS);
        rotate8.setByAngle(-360);
        rotate8.setCycleCount(5000);
        rotate8.setInterpolator(Interpolator.LINEAR);
        rotate8.setDuration(Duration.millis(3000));
        rotate8.setNode(a8);
        rotate8.play();

        timer = new MyTimer(this);
        timer.start();
        //System.out.println("resumed: " + resumed);


    }

    public void jump() {
        ballsound();
        once = true;
        acceleration = -0.5;
        System.out.println("resumed: " + resumed);
    }

    public void play_func() {
        start=true; jump(); click_to_play.setVisible(false);
    }

    public void openPauseMenu(MouseEvent mouseEvent) throws Exception {
        //timer.stop();
        SavedExit();
        System.out.println("pauseeeeeeeeee"+ball.getCenterY());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pauseMenu.fxml"));
        Parent root = (Parent)loader.load();
        PauseMenu controller = (PauseMenu) loader.getController();
        controller.setPrimaryStage(primaryStage);
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void SavedExit() throws Exception {
        timer.stop();
        System.out.println("Balllllllllllllll"+ ball.getCenterY());
        savehighscore();
        SaveForResuming();
        totalstars();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExitMenu.fxml"));
        Parent root = (Parent)loader.load();
        ExitMenu controller = (ExitMenu) loader.getController();
        controller.setPrimaryStage(primaryStage);
        controller.exit_score.setText(String.valueOf(score));
        Scene scene = new Scene(root,480,650);
        primaryStage.setTitle("Colour Switch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void random(String col)
    {
        int x= (int) (Math.random() * 3);
        if(ball.getFill().equals(Color.valueOf("#7712ea")))
        {
            if(x==0)
                ball.setFill(Paint.valueOf("#fffb00"));
            else if(x==1)
                ball.setFill(Paint.valueOf("#1ceae3"));
            else
                ball.setFill(Paint.valueOf("#f81056"));
        }

        else if(ball.getFill().equals(Color.valueOf("#fffb00")))
        {
            if(x==0)
                ball.setFill(Paint.valueOf("#7712ea"));
            else if(x==1)
                ball.setFill(Paint.valueOf("#1ceae3"));
            else
                ball.setFill(Paint.valueOf("#f81056"));
        }

        else if(ball.getFill().equals(Color.valueOf("#1ceae3")))
        {
            if(x==0)
                ball.setFill(Paint.valueOf("#7712ea"));
            else if(x==1)
                ball.setFill(Paint.valueOf("#fffb00"));
            else
                ball.setFill(Paint.valueOf("#f81056"));
        }

        else if(ball.getFill().equals(Color.valueOf("#f81056")))
        {
            if(x==0)
                ball.setFill(Paint.valueOf("#7712ea"));
            else if(x==1)
                ball.setFill(Paint.valueOf("#fffb00"));
            else
                ball.setFill(Paint.valueOf("#1ceae3"));
        }
        //System.out.println(x);
    }

    public void cs_collision() {
        Shape intersect1 = intersect(ball,switcher1);
        if(intersect1.getBoundsInLocal().getWidth()!=-1 && c1==false){
            //System.out.println("Ball collided with switcher");
            acs1.setVisible(false);
            random(String.valueOf(ball.getFill()) );
            c1=true;
        }

        Shape intersect2 = intersect(ball,switcher2);
        if(intersect2.getBoundsInLocal().getWidth()!=-1 && c2==false){
            // System.out.println("Ball collided with switcher");
            acs2.setVisible(false);
            random(String.valueOf(ball.getFill()) );
            c2=true;
        }

        Shape intersect3 = intersect(ball,switcher3);
        if(intersect3.getBoundsInLocal().getWidth()!=-1 && c3==false){
            //System.out.println("Ball collided with switcher");
            acs3.setVisible(false);
            random(String.valueOf(ball.getFill()) );
            c3=true;
        }

        Shape intersect4 = intersect(ball,switcher4);
        if(intersect4.getBoundsInLocal().getWidth()!=-1 && c4==false){
            //System.out.println("Ball collided with switcher");
            acs4.setVisible(false);
            random(String.valueOf(ball.getFill()) );
            c4=true;
        }

        Shape intersect5 = intersect(ball,switcher5);
        if(intersect5.getBoundsInLocal().getWidth()!=-1 && c5==false){
            // System.out.println("Ball collided with switcher");
            acs5.setVisible(false);
            random(String.valueOf(ball.getFill()) );
            c5=true;
        }
    }

    public void starCollision(){
        if(!helper1){
            Shape intersect1 = intersect(ball,starc1);
            if(intersect1.getBoundsInLocal().getWidth()!=-1){
                // System.out.println("Ball collided with star");
                star1.setVisible(false);
                helper1=true;
                score++;
                score_label.setText(String.valueOf(score));
                starmusic();
            }}
        if(!helper2){
            Shape intersect2 = intersect(ball,starc2);
            if(intersect2.getBoundsInLocal().getWidth()!=-1){
                //System.out.println("Ball collided with star");
                star2.setVisible(false);
                helper2=true;
                score++;
                score_label.setText(String.valueOf(score));
                starmusic();
            }}
        if(!helper3){
            Shape intersect3 = intersect(ball,starc3);
            if(intersect3.getBoundsInLocal().getWidth()!=-1){
                //System.out.println("Ball collided with star");
                star3.setVisible(false);
                helper3=true;
                score++;
                score_label.setText(String.valueOf(score));
                starmusic();
            }}
        if(!helper4){
            Shape intersect4 = intersect(ball,starc4);
            if(intersect4.getBoundsInLocal().getWidth()!=-1){
                //System.out.println("Ball collided with star");
                star4.setVisible(false);
                helper4=true;
                score++;
                score_label.setText(String.valueOf(score));
                starmusic();
            }}
        if(!helper5){
            Shape intersect5 = intersect(ball,starc5);
            if(intersect5.getBoundsInLocal().getWidth()!=-1){
                // System.out.println("Ball collided with star");
                star5.setVisible(false);
                helper5=true;
                score++;
                score_label.setText(String.valueOf(score));
                starmusic();
            }}
    }

    public void ObstacleArcs(Arc arc) throws Exception {
        Shape intersect = intersect(ball,arc);
        if(intersect.getBoundsInLocal().getWidth()!=-1 && !(ball.getFill().equals(arc.getStroke())) ) {
            overmusic();
            //System.out.println(arc.getStroke());
            //System.out.println(ball.getFill());
            SavedExit();
        }
    }

    public void ObstacleLine(Line line) throws Exception {
        Shape intersect = intersect(ball,line);
        if(intersect.getBoundsInLocal().getWidth()!=-1 && !(ball.getFill().equals(line.getStroke())) ) {
            overmusic();
//            System.out.println(line.getStroke());
//            System.out.println(ball.getFill());
            SavedExit();
        }
    }

    public void ObstacleRectangle(Rectangle rectange) throws Exception {
        Shape intersect = intersect(ball,rectange);
        if(intersect.getBoundsInLocal().getWidth()!=-1 && !(ball.getFill().equals(rectange.getFill())) ) {
            overmusic();
//            System.out.println(rectange.getStroke());
//            System.out.println(ball.getFill());
            SavedExit();
        }
    }

    public void ObstacleCircle(Circle circle) throws Exception {
        Shape intersect = intersect(ball,circle);
        if(intersect.getBoundsInLocal().getWidth()!=-1 && !(ball.getFill().equals(circle.getFill())) ) {
            overmusic();
//            System.out.println(circle.getStroke());
//            System.out.println(ball.getFill());
            SavedExit();
        }
    }

    public void Obstacle1() throws Exception {
        ObstacleArcs(a1a1);
        ObstacleArcs(a1a2);
        ObstacleArcs(a1a3);
        ObstacleArcs(a1a4);
        ObstacleArcs(a2a1);
        ObstacleArcs(a2a2);
        ObstacleArcs(a2a3);
        ObstacleArcs(a2a4);
    }

    public void Obstacle2() throws Exception {
        ObstacleLine(a3a1);
        ObstacleLine(a3a2);
        ObstacleLine(a3a3);
        ObstacleLine(a3a4);
    }

    public void Obstacle3() throws Exception {
        ObstacleLine(a4a1);
        ObstacleLine(a4a2);
        ObstacleLine(a4a3);
        ObstacleLine(a4a4);
        ObstacleLine(a4a5);
        ObstacleLine(a4a6);
        ObstacleLine(a4a7);
        ObstacleLine(a4a8);
    }

    public void Obstacle4() throws Exception {
        ObstacleRectangle(a5a1);
        ObstacleRectangle(a5a2);
        ObstacleRectangle(a5a3);
        ObstacleRectangle(a5a4);
    }

    public void Obstacle5() throws Exception {
        ObstacleCircle(a6a1);
        ObstacleCircle(a6a2);
        ObstacleCircle(a6a3);
        ObstacleCircle(a6a4);
        ObstacleCircle(a6a5);
        ObstacleCircle(a6a6);
        ObstacleCircle(a6a7);
        ObstacleCircle(a6a8);
        ObstacleCircle(a6a9);
        ObstacleCircle(a6a10);
        ObstacleCircle(a6a11);
        ObstacleCircle(a6a12);
        ObstacleCircle(a6a13);
        ObstacleCircle(a6a14);
        ObstacleCircle(a6a15);
        ObstacleCircle(a6a16);
    }

    public void Obstacle6() throws Exception {
        ObstacleArcs(a7a1);
        ObstacleArcs(a7a2);
        ObstacleArcs(a7a3);
        ObstacleArcs(a7a4);
        ObstacleArcs(a8a1);
        ObstacleArcs(a8a2);
        ObstacleArcs(a8a3);
        ObstacleArcs(a8a4);
    }
    public void savehighscore() throws Exception {

        //data.name = String.valueOf(2);
        try {
            SaveData data = new SaveData();
            data.name = String.valueOf(score);
            SaveData data2 = (SaveData) ResourceManager.load("highscore.bin");
            if(Integer.parseInt(data2.name)<score)
                ResourceManager.save(data,"highscore.bin");
        }
        catch (Exception e) {
            //System.out.println("Couldn't save: " + e.getMessage());
            SaveData data1 = new SaveData();
            data1.name = String.valueOf(score);
            ResourceManager.save(data1,"highscore.bin");

        }
    }

    public void SaveForResuming() throws Exception {
        SaveData data = new SaveData();
        data.name = String.valueOf(score);
        data.ball_colour= String.valueOf(ball.getFill());
        data.ball_position= ball.getCenterY();
        data.position1= a.getLayoutY();
        data.position2= aa.getLayoutY();
        data.position3= a1.getLayoutY();
        data.position4= a2.getLayoutY();
        System.out.println(data.name);
        System.out.println(String.valueOf(ball.getFill()));
        System.out.println(data.ball_position);
        System.out.println(data.position1);
        System.out.println(data.position2);
        System.out.println(data.position3);
        System.out.println(data.position4);

        try{
            ResourceManager.save(data,"game1.bin");
        }
        catch (Exception e) {
            System.out.println("Couldn't save: " + e.getMessage());
        }
    }

    public void totalstars() throws Exception {

        try {
            SaveData data = new SaveData();
            String data2 = (String) ResourceManager.load("totalstars.bin");
            data.name = String.valueOf(score);
            ResourceManager.save(String.valueOf(Integer.parseInt(data.name)+Integer.parseInt(data2)),"totalstars.bin");
            // ResourceManager.save(String.valueOf(Integer.parseInt(data.name)),"totalstars.bin");

        }
        catch (Exception e) {
            //System.out.println("Couldn't save: " + e.getMessage());
            ResourceManager.save(String.valueOf(score),"totalstars.bin");
        }
    }


    public void ballDropped() throws Exception {
        if(ball.getCenterY() > 650)
            SavedExit();
    }
}


class MyTimer extends AnimationTimer {
    game game;
    double baseline= 410;
    double distancetravelled= 0;

    MyTimer(game g) {
        this.game = g;
    }


    @Override
    public void handle(long now) {
        try {
            doHandle(now);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doHandle(long now) throws Exception {
        if(game.start) {
            if (game.velocity < 4) {
                game.velocity += game.acceleration;

                //System.out.println("velo:"+ game.velocity);
                //move_screen();
            }
            if (game.once && game.velocity > -5) {
                game.velocity += game.acceleration;
                // System.out.println("velo:"+ game.velocity);
                //move_screen();
            } else {
                game.once = false;
                game.acceleration = 0.5;
                //move_screen();
            }
            //move_screen();
            secondtry();
            game.ball.setCenterY(game.ball.getCenterY() + game.velocity);
            game.starCollision();
            game.cs_collision();
            game.Obstacle1();
            game.Obstacle2();
            game.Obstacle3();
            game.Obstacle4();
            game.Obstacle5();
            game.Obstacle6();
            game.ballDropped();
//            if(!game.resumed_flag && game.resumed && game.loaded_game != null){
//                game.ResumeTheGame();
//                game.resumed_flag = true;
//                game.score_label.setText(String.valueOf(game.score));
//                System.out.println("yes");
            //}

            if(game.a.getLayoutY()>2000)
            {
                game.a.setLayoutY(-300);
                game.acs1.setVisible(true);
                game.star2.setVisible(true);
                game.acs2.setVisible(true);
            }

            if(game.aa.getLayoutY()>2200)
            {
                game.aa.setLayoutY(-100);
                game.acs3.setVisible(true);
                game.acs4.setVisible(true);
                game.acs5.setVisible(true);
                game.star3.setVisible(true);
                game.star4.setVisible(true);
                game.star5.setVisible(true);
                game.c1=false; game.c2=false; game.c3=false; game.c4=false; game.c5=false;
                game.helper1=false; game.helper2=false; game.helper3=false; game.helper4=false; game.helper5=false;
            }

            if(game.a1.getLayoutY()>2000)
            {
                game.a1.setLayoutY(-300);
            }

            if(game.a2.getLayoutY()>2000)
            {
                game.a2.setLayoutY(-300);
                game.star1.setVisible(true);
            }
        }
    }
    public void secondtry(){

        if(game.once){
            if (game.velo < 7.5){
                game.velo  = game.velo + game.acc;
            }
            if(game.velo >= 7.5){
                game.velo = 5;
            }
            System.out.println(game.velo);
            game.a.setLayoutY(game.a.getLayoutY() + game.velo );
            game.aa.setLayoutY(game.aa.getLayoutY() +game.velo );
            game.a1.setLayoutY(game.a1.getLayoutY() +game.velo );
            game.a2.setLayoutY(game.a2.getLayoutY() + game.velo );
        }
    }


    public void move_screen()
    {
        if( game.once && this.baseline > game.ball.getCenterY())
        {
            this.distancetravelled= this.baseline-game.ball.getCenterY();
//            game.a.setLayoutY(game.a.getLayoutY() + this.distancetravelled);
//            game.aa.setLayoutY(game.aa.getLayoutY() + this.distancetravelled);
//            game.a1.setLayoutY(game.a1.getLayoutY() + this.distancetravelled);
//            game.a2.setLayoutY(game.a2.getLayoutY() + this.distancetravelled);

            this.baseline -= this.distancetravelled;
            //  System.out.println(game.a.getLayoutY());
        }

        if(game.ball.getCenterY() > 410)
        {
            this.baseline=410;
        }

        else if(game.ball.getCenterY() > this.baseline)
        {
            this.baseline+=5;
        }
    }

}
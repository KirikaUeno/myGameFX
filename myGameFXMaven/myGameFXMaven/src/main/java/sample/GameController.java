package sample;

import company.Constants;
import company.MoveAction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import objects.Player;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private Player player = new Player();

    @FXML
    private ImageView gameBackground;
    @FXML
    private ImageView playerImage;
    @FXML
    private Label label;
    @FXML
    private Button gameButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameBackground.setImage(new Image((new File(Constants.BACKGROUND_IMAGE_URL)).toURI().toString()));
        playerImage.setImage(new Image((new File(Constants.SKIN2_IMAGE_URL)).toURI().toString()));
        label.setText("");

        Timeline timer = new Timeline(
                new KeyFrame(new Duration(Constants.gameSpeed), e->update())
        );
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void keyPressed(KeyEvent e){
        new MoveAction(e, player,true);
    }

    public void keyReleased(KeyEvent e) throws IOException {
        if(e.getCode()==KeyCode.ESCAPE){
            Stage stage = (Stage) gameButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("startMenu.fxml"));
            stage.getScene().setRoot(root);
        } else new MoveAction(e, player,false);
    }

    private void update(){
        player.move();
        playerImage.setLayoutX(player.getX());
        playerImage.setLayoutY(player.getY());
        label.setText(Arrays.toString(player.getPressedButtons()));
    }
}
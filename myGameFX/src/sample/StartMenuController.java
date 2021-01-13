package sample;

import company.Constants;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartMenuController implements Initializable {


    @FXML
    private Button exit;
    @FXML
    private Button play;
    @FXML
    private Button settings;
    @FXML
    private ImageView menuImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuImage.setImage(new Image((new File(Constants.MENUBACKGROUND_IMAGE_URL)).toURI().toString()));
    }

    public void playAction(ActionEvent e) throws IOException {
        switchToGame();
    }

    public void settingAction(ActionEvent e){

    }

    public void exitAction(ActionEvent e){
        Stage stage = (Stage)exit.getScene().getWindow();
        stage.close();
    }

    public void switchToGame() throws IOException {
        Stage stage = (Stage)exit.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("gameLayout.fxml"));
        stage.getScene().setRoot(root);
    }
}

package sample;

import company.Constants;
import company.MoveAction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import objects.Player;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

public class GameController implements Initializable {
    private final Player player = new Player();

    @FXML
    private ImageView gameBackground;
    @FXML
    private ImageView playerImage;
    @FXML
    private Label label;
    @FXML
    private Button gameButton;
    @FXML
    private Button saveButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button toMainMenuButton;
    @FXML
    private Button toDesktopButton;
    @FXML
    private AnchorPane inGameMenu;
    @FXML
    private ImageView inGameMenuImage;
    @FXML
    private AnchorPane gamePanel;
    @FXML
    private AnchorPane savePanel;
    @FXML
    private Button saveSaveButton;
    @FXML
    private Button saveBackButton;
    @FXML
    private Label saveSuccess;
    @FXML
    private AnchorPane loadPanel;
    @FXML
    private Button loadLoadButton;
    @FXML
    private Button loadBackButton;
    @FXML
    private Label loadSuccess;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameBackground.setImage(new Image((new File(Constants.BACKGROUND_IMAGE_URL)).toURI().toString()));
        playerImage.setImage(new Image((new File(Constants.SKIN2_IMAGE_URL)).toURI().toString()));
        inGameMenuImage.setImage(new Image((new File(Constants.INGAME_MENU_IMAGE_URL)).toURI().toString()));
        inGameMenu.setDisable(true);
        inGameMenu.setVisible(false);
        savePanel.setDisable(true);
        savePanel.setVisible(false);
        loadPanel.setDisable(true);
        loadPanel.setVisible(false);

        Timeline timer = new Timeline(
                new KeyFrame(new Duration(Constants.gameSpeed), e->update())
        );
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    public void inGameKeyPressed(KeyEvent e){
        new MoveAction(e, player,true);
    }

    public void inGameKeyReleased(KeyEvent e) throws IOException {
        if(e.getCode()==KeyCode.ESCAPE){
            inGameMenu.setVisible(true);
            inGameMenu.setDisable(false);
            gamePanel.setDisable(true);
        } else new MoveAction(e, player,false);
    }

    private void update(){
        player.move();
        playerImage.setLayoutX(player.getX());
        playerImage.setLayoutY(player.getY());
        label.setText(Arrays.toString(player.getPressedButtons()));
    }

    public void saveAction(ActionEvent e){
        savePanel.setVisible(true);
        savePanel.setDisable(false);
        inGameMenu.setDisable(true);
    }

    public void saveSaveAction(ActionEvent e){
        try {
            FileWriter writer = new FileWriter("save/save.txt");
            writer.write(""+player.getX()+" "+player.getY());
            writer.close();
            saveSuccess.setText("saved successfully!");
            Timeline timer = new Timeline(
                    new KeyFrame(new Duration(2000), ev->saveSuccess.setText(""))
            );
            timer.setCycleCount(1);
            timer.play();
        } catch (IOException er) {
            saveSuccess.setText("error occurred! check save folder");
            Timeline timer = new Timeline(
                    new KeyFrame(new Duration(2000), ev->saveSuccess.setText(""))
            );
            timer.setCycleCount(1);
            timer.play();
            er.printStackTrace();
        }
    }

    public void saveBackAction(ActionEvent e){
        savePanel.setVisible(false);
        savePanel.setDisable(true);
        inGameMenu.setDisable(false);
    }

    public void loadAction(ActionEvent e){
        loadPanel.setVisible(true);
        loadPanel.setDisable(false);
        inGameMenu.setDisable(true);
    }

    public void loadLoadAction(ActionEvent e){
        try {
            Scanner reader = new Scanner(new File("save/save.txt"));
            player.setX(reader.nextInt());
            player.setY(reader.nextInt());
            playerImage.setLayoutX(player.getX());
            playerImage.setLayoutY(player.getY());
            reader.close();
            loadSuccess.setText("loaded successfully!");
            Timeline timer = new Timeline(
                    new KeyFrame(new Duration(2000), ev->loadSuccess.setText(""))
            );
            timer.setCycleCount(1);
            timer.play();
        } catch (FileNotFoundException er) {
            loadSuccess.setText("error occurred! check save/save.txt file!");
            Timeline timer = new Timeline(
                    new KeyFrame(new Duration(2000), ev->loadSuccess.setText(""))
            );
            timer.setCycleCount(1);
            timer.play();
            er.printStackTrace();
        }

    }

    public void loadBackAction(ActionEvent e){
        loadPanel.setVisible(false);
        loadPanel.setDisable(true);
        inGameMenu.setDisable(false);
    }

    public void toMainMenuAction(ActionEvent e) throws IOException {
        Stage stage = (Stage) toMainMenuButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("startMenu.fxml"));
        stage.getScene().setRoot(root);
    }

    public void toDesktopAction(ActionEvent e){
        Stage stage = (Stage)saveButton.getScene().getWindow();
        stage.close();
    }

    public void inGameMenuKeyReleased(KeyEvent e) throws IOException {
        if(e.getCode()==KeyCode.ESCAPE) {
            inGameMenu.setDisable(true);
            gamePanel.setDisable(false);
            inGameMenu.setVisible(false);
        }
    }

    public void savePanelKeyReleased(KeyEvent e) throws IOException {
        if(e.getCode()==KeyCode.ESCAPE) {
            savePanel.setVisible(false);
            savePanel.setDisable(true);
            inGameMenu.setDisable(false);
        }
    }

    public void loadPanelKeyReleased(KeyEvent e) throws IOException {
        if(e.getCode()==KeyCode.ESCAPE) {
            loadPanel.setVisible(false);
            loadPanel.setDisable(true);
            inGameMenu.setDisable(false);
        }
    }
}
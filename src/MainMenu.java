import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


import java.awt.*;
import java.io.IOException;
import java.net.URI;


public class MainMenu {
    @FXML
    public Pane pane;

    @FXML
    public void openSetting(MouseEvent mouseEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SettingUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane.getChildren().removeAll();
        pane.getChildren().setAll(root);
    }
    @FXML
    public void openUser(MouseEvent mouseEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("UserUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane.getChildren().removeAll();
        pane.getChildren().setAll(root);
    }
    @FXML
    public void openServer(MouseEvent mouseEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("ServerUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane.getChildren().removeAll();
        pane.getChildren().setAll(root);
    }
}

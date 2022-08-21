import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.EnumSet;

public class SettingUI {
    public static Stage stage = new Stage();
    @FXML
    Slider slider;
    @FXML
    public void changeVolume(MouseEvent mouseEvent) {
        EsmFamil.mediaPlayer.setVolume(slider.getValue()/100.0);
    }
    @FXML
    public void guideOpen(MouseEvent mouseEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("guide.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void aboutOpen(MouseEvent mouseEvent) {
        try {
            Desktop.getDesktop().browse(URI.create("https://t.me/@amir_akhond81"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

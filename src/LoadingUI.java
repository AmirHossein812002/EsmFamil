import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class LoadingUI {
    public static BooleanProperty able = new SimpleBooleanProperty(true);
    public static Text text= new Text("درحال انتظار برای پیوستن...");
    @FXML
    Text wait;
    @FXML
    ProgressIndicator loading;
    @FXML
    Button start;
    @FXML
    public void startC(MouseEvent mouseEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ServerUI.stage.setScene(new Scene(root));
        ServerUI.stage.show();
    }
    @FXML
    public void initialize() {
        start.disableProperty().bind(able);
        loading.visibleProperty().bind(able);
        wait.textProperty().bind(text.textProperty());
    }
}

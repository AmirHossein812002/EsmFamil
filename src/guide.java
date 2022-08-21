import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class guide {
    @FXML
    public void closeGuide (MouseEvent mouseEvent){
        SettingUI.stage.close();
    }

}


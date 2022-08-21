import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserUI {
    @FXML
    Button save;
    @FXML
    TextField userName;
    @FXML
    TextField passWord;
    @FXML
    public void save(MouseEvent mouseEvent) throws IOException {
        File file = new File(EsmFamil.user[0] + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("unActive UserName");
        fileWriter.close();

        file = new File(userName.getText() + ".txt");
        fileWriter = new FileWriter(file);
        fileWriter.write(passWord.getText());
        fileWriter.close();
        EsmFamil.user[0] = userName.getText();
        EsmFamil.user[1] = passWord.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("save");
        alert.setContentText("Saved");
        alert.setHeaderText("Saved");
        alert.show();
    }
    public void initialize() {
        userName.setText(EsmFamil.user[0]);
        passWord.setText(EsmFamil.user[1]);
    }
}

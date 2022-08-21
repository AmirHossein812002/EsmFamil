import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp {
    public boolean show = false;
    public boolean showRe = false;
    @FXML
    Label lightOn;
    @FXML
    TextField passWordTxt;
    @FXML
    TextField userName;
    @FXML
    PasswordField passWord;
    @FXML
    PasswordField passWordRe;
    @FXML
    TextField passWordTxtRe;
    @FXML
    Label lightOnRe;
    @FXML
    public void signUp(MouseEvent mouseEvent) throws IOException {
        File file = new File(userName.getText() + ".txt");
        String showStr;
        String showStrRe;
        if (show)
            showStr = passWordTxt.getText();
        else
            showStr = passWord.getText();
        if (showRe)
            showStrRe = passWordTxtRe.getText();
        else
            showStrRe = passWordRe.getText();
        if (file.exists()) {
            userName.setStyle("-fx-border-color: red;");
        } else {
            if (showStr.equals(showStrRe)) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
                fileWriter.append(passWord.getText());
                fileWriter.close();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("login.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                EsmFamil.stage.setScene(scene);
            } else {
                passWord.setStyle("-fx-border-color: red;");
                passWordRe.setStyle("-fx-border-color: red;");
            }
        }
    }
    @FXML
    public void cancel(MouseEvent mouseEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        EsmFamil.stage.setScene(scene);
    }
    @FXML
    public void showPassword(MouseEvent mouseEvent) {
        show = !show;
        if (show) {
            passWord.setVisible(false);
            passWordTxt.setText(passWord.getText());
            passWordTxt.setVisible(true);
            lightOn.setStyle("-fx-background-color: linear-gradient(to left, #5babf0, transparent);");
        } else {
            passWordTxt.setVisible(false);
            passWord.setText(passWordTxt.getText());
            passWord.setVisible(true);
            lightOn.setStyle("-fx-background-color: transparent;");
        }
    }
    @FXML
    public void showPassWordRe(MouseEvent mouseEvent) {
        showRe = !showRe;
        if (showRe) {
            passWordRe.setVisible(false);
            passWordTxtRe.setText(passWordRe.getText());
            passWordTxtRe.setVisible(true);
            lightOnRe.setStyle("-fx-background-color: linear-gradient(to left, #5babf0, transparent);");
        } else {
            passWordTxtRe.setVisible(false);
            passWordRe.setText(passWordTxtRe.getText());
            passWordRe.setVisible(true);
            lightOnRe.setStyle("-fx-background-color: transparent;");
        }
    }
}

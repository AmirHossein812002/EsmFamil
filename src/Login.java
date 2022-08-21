import com.sun.javafx.scene.control.behavior.PasswordFieldBehavior;
import com.sun.javafx.scene.control.skin.TextFieldSkin;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    public static boolean show = false;
    @FXML
    Label lightOn;
    @FXML
    Button login;
    @FXML
    Button signUp;
    @FXML
    TextField userName;
    @FXML
    PasswordField passWord;
    @FXML
    ImageView flashLight;
    @FXML
    TextField passWordTxt;
    @FXML
    public void login(MouseEvent mouseEvent) throws FileNotFoundException {
        String password;
        if (show) {
            password = passWordTxt.getText();
        } else {
            password = passWord.getText();
        }
        File file = new File(userName.getText() + ".txt");
        if (file.exists()) {
            Scanner scanner = new Scanner(file);
            String pass = scanner.next();
            if (pass.equals("unActive UserName")) {
                userName.setStyle("-fx-background-color: red;");
            } else
            if (pass.equals(password)) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                EsmFamil.user[0] = userName.getText();
                EsmFamil.user[1] = password;

                Scene scene = new Scene(root);
                EsmFamil.stage.setScene(scene);
            } else {
                passWord.setStyle("-fx-border-color: red;");
            }
        } else {
            userName.setStyle("-fx-border-color: red;");
        }
    }
    @FXML
    public void signUp(MouseEvent mouseEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
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

}

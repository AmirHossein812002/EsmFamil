import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SelectionUI {
    public static GameModule gameModule = new GameModule();
    public static boolean[] clicked = new boolean[11];
    static {
        for (int i = 0; i < 10; i++) {
            clicked[i] = false;
        }
    }
    public static int num = 5;
    @FXML
    Button button;
    @FXML
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;
    @FXML
    Button button7;
    @FXML
    Button button8;
    @FXML
    Button button9;
    @FXML
    Button button10;

    @FXML
    public void buttonC(MouseEvent mouseEvent) {
        if (clicked[0] == false && num > 0) {
            button.setStyle("-fx-background-color: #5babf0;" +
                            "-fx-background-radius: 0px;" +
                            "-fx-text-fill: white;");
            num--;
            clicked[0] = true;
        }else if (clicked[0] == true) {
            button.setStyle("-fx-background-color: #596575;" +
                            "-fx-background-radius: 0px;" +
                            "-fx-text-fill: white;");
            num++;
            clicked[0] = false;
        }
    }
    @FXML
    public void buttonC1(MouseEvent mouseEvent) {
        if (clicked[1] == false && num > 0) {
            button1.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[1] = true;
        }else if (clicked[1] == true) {
            button1.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[1] = false;
        }
    }
    @FXML
    public void buttonC2(MouseEvent mouseEvent) {
        if (clicked[2] == false && num > 0) {
            button2.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[2] = true;
        }else if (clicked[2] == true) {
            button2.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[2] = false;
        }
    }
    @FXML
    public void buttonC3(MouseEvent mouseEvent) {
        if (clicked[3] == false && num > 0) {
            button3.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[3] = true;
        }else if (clicked[3] == true) {
            button3.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[3] = false;
        }
    }
    @FXML
    public void buttonC4(MouseEvent mouseEvent) {
        if (clicked[4] == false && num > 0) {
            button4.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[4] = true;
        }else if (clicked[4] == true) {
            button4.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[4] = false;
        }
    }
    @FXML
    public void buttonC5(MouseEvent mouseEvent) {
        if (clicked[5] == false && num > 0) {
            button5.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[5] = true;
        }else if (clicked[5] == true) {
            button5.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[5] = false;
        }
    }
    @FXML
    public void buttonC6(MouseEvent mouseEvent) {
        if (clicked[6] == false && num > 0) {
            button6.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[6] = true;
        }else if (clicked[6] == true) {
            button6.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[6] = false;
        }
    }
    @FXML
    public void buttonC7(MouseEvent mouseEvent) {
        if (clicked[7] == false && num > 0) {
            button7.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[7] = true;
        }else if (clicked[7] == true) {
            button7.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[7] = false;
        }
    }
    @FXML
    public void buttonC8(MouseEvent mouseEvent) {
        if (clicked[8] == false && num > 0) {
            button8.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[8] = true;
        }else if (clicked[8] == true) {
            button8.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[8] = false;
        }
    }
    @FXML
    public void buttonC9(MouseEvent mouseEvent) {
        if (clicked[9] == false && num > 0) {
            button9.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[9] = true;
        }else if (clicked[9] == true) {
            button9.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[9] = false;
        }
    }
    @FXML
    public void buttonC10(MouseEvent mouseEvent) {
        if (clicked[10] == false && num > 0) {
            button10.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num--;
            clicked[10] = true;
        }else if (clicked[10] == true) {
            button10.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 0px;" +
                    "-fx-text-fill: white;");
            num++;
            clicked[10] = false;
        }
    }
    @FXML
    public void nextC(MouseEvent mouseEvent) {
        String[] catagories = new String[5];
        int n = 0;
        if (num == 0) {
            if (clicked[0])
                catagories[n++] = button.getText();
            if (clicked[1])
                catagories[n++] = button1.getText();
            if (clicked[2])
                catagories[n++] = button2.getText();
            if (clicked[3])
                catagories[n++] = button3.getText();
            if (clicked[4])
                catagories[n++] = button4.getText();
            if (clicked[5])
                catagories[n++] = button5.getText();
            if (clicked[6])
                catagories[n++] = button6.getText();
            if (clicked[7])
                catagories[n++] = button7.getText();
            if (clicked[8])
                catagories[n++] = button8.getText();
            if (clicked[9])
                catagories[n++] = button9.getText();
            if (clicked[10])
                catagories[n++] = button10.getText();
            gameModule = new GameModule(catagories);

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("MoodUI.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            ServerUI.stage.setScene(new Scene(root));
            ServerUI.stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("number error!");
            alert.setHeaderText("خطا");
            alert.setContentText("لطفا 5 دسته را انتخاب کنید");
            alert.show();
        }
    }
}

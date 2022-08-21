import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class MoodUI {
    public static Server server = null;
    private boolean selected = false;
    public static BooleanProperty next = new SimpleBooleanProperty(false);
    @FXML
    Text timeTxt;
    @FXML
    Text turnTxt;
    @FXML
    Button timer;
    @FXML
    Button finishPressed;
    @FXML
    Spinner<Integer> timeSpinner;
    @FXML
    Spinner<Integer> turnSpinner;
    @FXML
    public void nextC(MouseEvent mouseEvent) {
        if (selected) {
            if (timeSpinner.isDisable()) {
                SelectionUI.gameModule.setMood(Mood.FinishPressed);
            } else {
                SelectionUI.gameModule.setMood(Mood.Timer);
                SelectionUI.gameModule.setTime(timeSpinner.getValue());
            }
            SelectionUI.gameModule.setTurn(turnSpinner.getValue());
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("LoadingUI.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            File portFile = new File("port.txt");
            PrintWriter printWriter = null;
            Scanner scanner = null;
            try {
                scanner = new Scanner(portFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int portAvailable = scanner.nextInt();
            scanner.close();
            try {
                printWriter = new PrintWriter(portFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            printWriter.write("");
            printWriter.println(portAvailable + 1);
            printWriter.close();

            Host host = new Host(EsmFamil.user[0], portAvailable, SelectionUI.gameModule);
            ServerUI.host = host;
            EsmFamil.hosts.add(host);

            File file = new File("host.txt");
            try {
                printWriter = new PrintWriter(new FileWriter(file, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
            printWriter.println(EsmFamil.user[0]);
            printWriter.println(portAvailable);
            if (SelectionUI.gameModule.getMood() == Mood.Timer)
                printWriter.println("T");
            else
                printWriter.println("F");
            printWriter.println(SelectionUI.gameModule.getTurn());
            printWriter.println(SelectionUI.gameModule.getTime());
            String[] catagories = new String[5];
            catagories = SelectionUI.gameModule.getCatagories();
            printWriter.println(catagories[0]);
            printWriter.println(catagories[1]);
            printWriter.println(catagories[2]);
            printWriter.println(catagories[3]);
            printWriter.println(catagories[4]);

            printWriter.close();

            ServerUI.stage.setScene(new Scene(root));
            server = new Server(host);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not selection ERROR!");
            alert.setContentText("لطفا موردی را انتخاب کنید!");
            alert.setHeaderText("خطا در انتخاب");
            alert.show();
        }
    }
    @FXML
    public void timer(MouseEvent mouseEvent){
        if (selected) {
            timer.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 25px;" +
                    "-fx-text-fill: white;");
            finishPressed.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 25px;" +
                    "-fx-text-fill: white;");
            timeSpinner.setDisable(false);
        } else {
            timer.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 25px;" +
                    "-fx-text-fill: white;");
            finishPressed.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 25px;" +
                    "-fx-text-fill: white;");
            timeSpinner.setDisable(false);
            selected = true;
        }
    }
    @FXML
    public void finishPressed(MouseEvent mouseEvent) {
        if (selected) {
            finishPressed.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 25px;" +
                    "-fx-text-fill: white;");
            timer.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 25px;" +
                    "-fx-text-fill: white;");
            timeSpinner.setDisable(true);
        } else {
            finishPressed.setStyle("-fx-background-color: #5babf0;" +
                    "-fx-background-radius: 25px;" +
                    "-fx-text-fill: white;");
            timer.setStyle("-fx-background-color: #596575;" +
                    "-fx-background-radius: 25px;" +
                    "-fx-text-fill: white;");
            timeSpinner.setDisable(true);
            selected = true;
        }
    }
    @FXML
    public void initialize() {
        timeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(20, 300, 20));
        turnSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20, 1));
        timeTxt.textProperty().bind(timeSpinner.valueProperty().asString());
        turnTxt.textProperty().bind(turnSpinner.valueProperty().asString());
    }
}

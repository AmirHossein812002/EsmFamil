import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerUI {
    public static Stage stage = new Stage();
    public static Client client;
    public static Host host;
    static {
        stage.setResizable(false);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (MoodUI.server != null) {
                    File file = new File("host.txt");
                    try {
                        PrintWriter printWriter = new PrintWriter(file);
                        printWriter.write("");
                        printWriter.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                stage.close();
            }
        });
    }
    @FXML
    VBox vBox;
    @FXML
    Button makeServer;
    @FXML
    public void makeServer(MouseEvent mouseEvent) {
        stage.setResizable(false);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SelectionUI.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void refresh(MouseEvent mouseEvent) {
        try {
            EsmFamil.updateHost();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean exist = false;
        for (int i = 0; i < EsmFamil.hosts.size(); i++) {
            exist = false;
            for (int j = 0; j < vBox.getChildren().size(); j++) {
                if(((HostCard)(vBox.getChildren().get(j))).getPort() == EsmFamil.hosts.get(i).getPort()) {
                    exist = true;
                }
            }
            if (exist)
                continue;
            else
                vBox.getChildren().add(EsmFamil.hosts.get(i).getHostCard());
        }
    }
    @FXML
    public void initialize() {
        for (int i = 0; i < EsmFamil.hosts.size(); i++) {
            vBox.getChildren().add(EsmFamil.hosts.get(i).getHostCard());
        }
    }
}

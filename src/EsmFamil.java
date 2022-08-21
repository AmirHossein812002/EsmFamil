import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EsmFamil extends Application {
    public static Stage stage = new Stage();
    public static MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get("Hans Zimmer - Cornfield Chase.mp3").toUri().toString()));
    public static String[] user = new String[2];
    public static ArrayList<Host> hosts = new ArrayList<Host>();
    public static void updateHost() throws FileNotFoundException {
        hosts = new ArrayList<Host>();
        File file = new File("host.txt");
        Scanner scanner = new Scanner(file);
        String[] catagories = new String[5];
        while (scanner.hasNext()) {
            String name = scanner.next();
            scanner.nextLine();
            int port = scanner.nextInt();
            scanner.nextLine();
            String mood = scanner.next();
            scanner.nextLine();
            int turn = scanner.nextInt();
            scanner.nextLine();
            int time = scanner.nextInt();
            scanner.nextLine();
            catagories[0] = scanner.next();
            scanner.nextLine();
            catagories[1] = scanner.next();
            scanner.nextLine();
            catagories[2] = scanner.next();
            scanner.nextLine();
            catagories[3] = scanner.next();
            scanner.nextLine();
            catagories[4] = scanner.next();
            scanner.nextLine();
            GameModule gameModule = new GameModule(catagories);
            if (mood.equals("F")) {
                gameModule.setMood(Mood.FinishPressed);
            } else {
                gameModule.setMood(Mood.Timer);
            }
            gameModule.setTime(time);
            gameModule.setTurn(turn);
            hosts.add(new Host(name, port, gameModule));
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){
        try {
            updateHost();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        stage.setResizable(false);

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);

        stage.setScene(scene);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();
        stage.show();
    }
}

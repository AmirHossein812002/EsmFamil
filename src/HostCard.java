import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HostCard extends Parent {
    public static LinearGradient blue = new LinearGradient("-fx-fill: linear-gradient(#2193b0, #6dd5ed);");
    public static LinearGradient gray = new LinearGradient("-fx-fill: linear-gradient(#0F2027, #203A43, #2C5364);");
    public static LinearGradient orange = new LinearGradient("-fx-fill: linear-gradient(#f12711, #f5af19);");
    public static LinearGradient purple = new LinearGradient("-fx-fill: linear-gradient(#654ea3, #eaafc8);");
    public static LinearGradient green = new LinearGradient("-fx-fill: linear-gradient(#a8ff78, #78ffd6);");
    public static LinearGradient red = new LinearGradient("-fx-fill: linear-gradient(#FF512F, #DD2476);");
    public static LinearGradient black = new LinearGradient("-fx-fill: linear-gradient(#000000, #434343);");
    public static ArrayList<LinearGradient> linearGradients = new ArrayList<LinearGradient>();

    static {
        linearGradients.add(blue);
        linearGradients.add(gray);
        linearGradients.add(orange);
        linearGradients.add(purple);
        linearGradients.add(green);
        linearGradients.add(red);
        linearGradients.add(black);
    }
    private String hostName;
    private int port;
    private GameModule gameModule;

    public HostCard(String hostName, int port, GameModule gameModule) {
        this.hostName = hostName;
        this.port = port;
        this.gameModule = gameModule;

        Pane pane = new Pane();
        pane.setPrefSize(350, 100);
        pane.setStyle("-fx-background-color: white;");

        Circle circle = new Circle(40);
        Random rnd = new Random();
        circle.setStyle(linearGradients.get(rnd.nextInt(7)).getCode());
        circle.setLayoutY(50);
        circle.setLayoutX(55);

        FontAwesomeIcon server = new FontAwesomeIcon();
        server.setGlyphName("SERVER");
        server.setSize("3em");
        server.setLayoutX(37);
        server.setLayoutY(62);
        server.setFill(Color.WHITE);

        Text name = new Text(hostName);
        name.setFill(Color.BLACK);
        name.setFont(Font.font("2  Kamran", FontWeight.BOLD, 24));
        name.setLayoutX(140);
        name.setLayoutY(40);

        Text portNum = new Text(Integer.toString(port));
        portNum.setFill(Color.BLACK);
        portNum.setFont(Font.font("2  Kamran", FontWeight.BOLD, 24));
        portNum.setLayoutX(140);
        portNum.setLayoutY(70);

        getChildren().addAll(pane, circle, server, name, portNum);
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Host host = new Host(hostName, port, gameModule);
                ServerUI.host = host;
                ServerUI.client = new Client(host);
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("Game.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ServerUI.stage.setScene(new Scene(root));
                ServerUI.stage.show();
            }
        });
    }

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public GameModule getGameModule() {
        return gameModule;
    }
}

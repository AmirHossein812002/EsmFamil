import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class WordCard extends Parent {
    private String word;
    public WordCard(String txt) {
        this.word = txt;
        Pane pane = new Pane();
        pane.setPrefSize(156, 52);
        pane.setStyle("-fx-background-color: #5babf0;");

        Text text = new Text(txt);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("2  Kamran", FontWeight.BOLD, 36));
        text.setLayoutY(30);
        text.setLayoutX(50);

        getChildren().addAll(pane, text);
    }

    public String getWord() {
        return word;
    }
}

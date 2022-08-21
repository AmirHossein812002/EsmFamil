import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.ArrayList;

public class Game {
    private IntegerProperty millis = new SimpleIntegerProperty(0);
    private int seconds = 0;
    private int minutes = 0;

    private ArrayList<String> words = new ArrayList<String>();

    public static BooleanProperty stop = new SimpleBooleanProperty(false);
    public static BooleanProperty able = new SimpleBooleanProperty(false);
    public static BooleanProperty start = new SimpleBooleanProperty(false);

    public static StringProperty[] catagories = new SimpleStringProperty[5];
    public static String[] otherCatagories = new String[5];

    public static StringProperty wordGame = new SimpleStringProperty("...");

    public static IntegerProperty turn = new SimpleIntegerProperty(1);
    public static IntegerProperty totScore = new SimpleIntegerProperty(0);

    public static int turnNum = ServerUI.host.getGameModule().getTurn();

    public static BooleanProperty winnerShow = new SimpleBooleanProperty(false);
    public static BooleanProperty looseShow = new SimpleBooleanProperty(false);
    public static BooleanProperty drawShow = new SimpleBooleanProperty(false);

    @FXML
    ImageView winner;
    @FXML
    ImageView looser;
    @FXML
    ImageView draw;
    @FXML
    Text scoreTxt;
    @FXML
    Button startB;
    @FXML
    Text wordTxt;
    @FXML
    Spinner<String> wordSpinner;
    @FXML
    Button stopB;
    @FXML
    Text firstTxt;
    @FXML
    Text secondTxt;
    @FXML
    Text thirdTxt;
    @FXML
    Text forthTxt;
    @FXML
    Text fifthTxt;
    @FXML
    TextField first;
    @FXML
    TextField second;
    @FXML
    TextField third;
    @FXML
    TextField forth;
    @FXML
    TextField fifth;
    @FXML
    Text stopWatch;
    @FXML
    public void stopC(MouseEvent mouseEvent) {
        Game.stop.setValue(true);
    }
    @FXML
    public void startC(MouseEvent mouseEvent) {
        if (!wordSpinner.getValue().equals("..."))
            start.setValue(true);
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("خطا در انتخاب حرف");
            alert.setHeaderText("خطا در انتخاب حرف");
            alert.setContentText("لطفاً حرفی را انتخاب کنید!");
            alert.show();
        }
    }
    @FXML
    public void firstChecker(KeyEvent keyEvent) {
        if (!first.getText().equals("")) {
            if (!first.getText().substring(0, 1).equals(wordGame.getValue())) {
                if (!(first.getText().substring(0, 1).equals("آ") && wordGame.getValue().equals("ا"))) {
                    first.setText("");
                    first.setStyle("-fx-border-color: red;" +
                            "-fx-border-radius: 25px;");
                }
            }
        }
    }
    @FXML
    public void secondChecker(KeyEvent keyEvent) {
        if (!second.getText().equals("")) {
            if (!second.getText().substring(0, 1).equals(wordGame.getValue())) {
                if (!(second.getText().substring(0, 1).equals("آ") && wordGame.getValue().equals("ا"))) {
                    second.setText("");
                    second.setStyle("-fx-border-color: red;" +
                            "-fx-border-radius: 25px;");
                }
            }
        }
    }
    @FXML
    public void thirdChecker(KeyEvent keyEvent) {
        if (!third.getText().equals("")) {
            if (!third.getText().substring(0, 1).equals(wordGame.getValue())) {
                if (!(third.getText().substring(0, 1).equals("آ") && wordGame.getValue().equals("ا"))) {
                    third.setText("");
                    third.setStyle("-fx-border-color: red;" +
                            "-fx-border-radius: 25px;");
                }
            }
        }
    }
    @FXML
    public void forthChecker(KeyEvent keyEvent) {
        if (!forth.getText().equals("")) {
            if (!forth.getText().substring(0, 1).equals(wordGame.getValue())) {
                if (!(forth.getText().substring(0, 1).equals("آ") && wordGame.getValue().equals("ا"))) {
                    forth.setText("");
                    forth.setStyle("-fx-border-color: red;" +
                            "-fx-border-radius: 25px;");
                }
            }
        }
    }
    @FXML
    public void fifthChecker(KeyEvent keyEvent) {
        if (!fifth.getText().equals("")) {
            if (!fifth.getText().substring(0, 1).equals(wordGame.getValue())) {
                if (!(fifth.getText().substring(0, 1).equals("آ") && wordGame.getValue().equals("ا"))) {
                    fifth.setText("");
                    fifth.setStyle("-fx-border-color: red;" +
                            "-fx-border-radius: 25px;");
                }
            }
        }
    }
    @FXML
    public void initialize() {
        first.setText("");
        second.setText("");
        third.setText("");
        forth.setText("");
        fifth.setText("");

        words.add("...");
        words.add("ا");
        words.add("ب");
        words.add("پ");
        words.add("ت");
        words.add("ث");
        words.add("ج");
        words.add("چ");
        words.add("ح");
        words.add("خ");
        words.add("د");
        words.add("ذ");
        words.add("ر");
        words.add("ز");
        words.add("ژ");
        words.add("س");
        words.add("ش");
        words.add("ص");
        words.add("ض");
        words.add("ط");
        words.add("ظ");
        words.add("ع");
        words.add("غ");
        words.add("ف");
        words.add("ق");
        words.add("ک");
        words.add("گ");
        words.add("ل");
        words.add("م");
        words.add("ن");
        words.add("و");
        words.add("ه");
        words.add("ی");

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> change(stopWatch)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);


        catagories[0] = new SimpleStringProperty();
        catagories[1] = new SimpleStringProperty();
        catagories[2] = new SimpleStringProperty();
        catagories[3] = new SimpleStringProperty();
        catagories[4] = new SimpleStringProperty();

        catagories[0].bind(first.textProperty());
        catagories[1].bind(second.textProperty());
        catagories[2].bind(third.textProperty());
        catagories[3].bind(forth.textProperty());
        catagories[4].bind(fifth.textProperty());

        if (ServerUI.host.getGameModule().getMood() == Mood.Timer) {
            stopB.setDisable(true);
        }

        firstTxt.setText(ServerUI.host.getGameModule().getCatagories()[0]);
        first.setPromptText(ServerUI.host.getGameModule().getCatagories()[0]);
        secondTxt.setText(ServerUI.host.getGameModule().getCatagories()[1]);
        second.setPromptText(ServerUI.host.getGameModule().getCatagories()[1]);
        thirdTxt.setText(ServerUI.host.getGameModule().getCatagories()[2]);
        third.setPromptText(ServerUI.host.getGameModule().getCatagories()[2]);
        forthTxt.setText(ServerUI.host.getGameModule().getCatagories()[3]);
        forth.setPromptText(ServerUI.host.getGameModule().getCatagories()[3]);
        fifthTxt.setText(ServerUI.host.getGameModule().getCatagories()[4]);
        fifth.setPromptText(ServerUI.host.getGameModule().getCatagories()[4]);

        scoreTxt.textProperty().bind(totScore.asString());

        if (MoodUI.server == null) {
            startB.setDisable(true);
            wordSpinner.setDisable(true);
            wordTxt.textProperty().bind(wordGame);
        } else {
            wordTxt.textProperty().bind(wordSpinner.valueProperty());
            wordGame.bind(wordSpinner.valueProperty());
        }
        start.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (start.getValue()) {
                    first.setText("");
                    second.setText("");
                    third.setText("");
                    forth.setText("");
                    fifth.setText("");
                    stopWatch.setText("00:00");
                    millis.setValue(0);
                    seconds = 0;
                    minutes = 0;
                    timeline.play();
                }
            }
        });

        turn.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).equals(wordGame.getValue())) {
                        words.remove(i);
                        break;
                    }
                }

                timeline.stop();
                first.setStyle("-fx-border-color: transparent;");
                second.setStyle("-fx-border-color: transparent;");
                third.setStyle("-fx-border-color: transparent;");
                forth.setStyle("-fx-border-color: transparent;");
                fifth.setStyle("-fx-border-color: transparent;");

                if (turn.getValue().equals(1)) {
                     if (MoodUI.server == null) {
                         startB.setDisable(true);
                         wordSpinner.setDisable(true);
                         wordGame.unbind();
                         wordTxt.textProperty().bind(wordGame);
                     } else {
                         startB.setDisable(false);
                         wordSpinner.setDisable(false);
                         wordTxt.textProperty().bind(wordSpinner.valueProperty());
                         wordGame.bind(wordSpinner.valueProperty());
                     }
                } else {
                    if (MoodUI.server != null) {
                        startB.setDisable(true);
                        wordSpinner.setDisable(true);
                        wordGame.unbind();
                        wordTxt.textProperty().bind(wordGame);
                    } else {
                        startB.setDisable(false);
                        wordSpinner.setDisable(false);
                        wordTxt.textProperty().bind(wordSpinner.valueProperty());
                        wordGame.bind(wordSpinner.valueProperty());
                    }
                }
            }
        });

        ObservableList<String> word= FXCollections.observableList(words);
        wordSpinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(word));

        millis.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (ServerUI.host.getGameModule().getMood() == Mood.Timer)
                    if (getSeconds() == ServerUI.host.getGameModule().getTime()) {
                        seconds = 0;
                        minutes = 0;
                        stop.setValue(true);
                        millis.setValue(0);
                    }
            }
        });
        winner.visibleProperty().bind(winnerShow);
        looser.visibleProperty().bind(looseShow);
        draw.visibleProperty().bind(drawShow);
    }
    private void change(Text timer) {
        if(millis.getValue() == 1000) {
            seconds++;
            millis.setValue(0);
        }
        if(seconds == 60) {
            minutes++;
            seconds = 0;
        }
        timer.setText((((minutes/10) == 0) ? "0" : "") + minutes + ":"
                + (((seconds/10) == 0) ? "0" : "") + seconds);
        int plus = millis.getValue() + 1;
        millis.setValue(plus);
    }
    private int getSeconds() {
        return (minutes * 60 + millis.getValue() / 1000 + seconds);
    }
}

package hangman;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.awt.*;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class Main extends Application {
    private final GridPane grid = new GridPane();

    @Override
    public void start(Stage stage) {
        setupStage(stage);
    }
    public void init() throws Exception {
        super.init();
        buildUI();
    }
    private void buildUI() {
        grid.setHgap(10); // gap between columns
        grid.setVgap(10); // gap between rows
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setGridLinesVisible(false);
        Button l = new Button("HangMan v0.1");
        grid.add(l, 0, 0);
        grid.add(new Label("HHH"), 1, 4);
        GridPane.setMargin(l, new Insets(10, 10, 10, 10));

        Timeline timeline = new Timeline();

// Tworzymy punkt docelowy: w czasie 2 sekund zmień właściwość layoutX na 400
        KeyValue kv = new KeyValue(l.layoutXProperty(), 100);
        KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);

        timeline.getKeyFrames().add(kf);
        timeline.setCycleCount(Timeline.INDEFINITE); // Animacja w nieskończonej pętli
        timeline.setAutoReverse(true);

        timeline.play();
    }

    public static void main(String[] args) {
        launch();
    }

    private void setupStage(Stage stage) {
        Scene scene = new Scene(grid, 600, 600);
        stage.setTitle("GridPane");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}



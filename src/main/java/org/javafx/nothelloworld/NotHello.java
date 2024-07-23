package org.javafx.nothelloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NotHello extends Application {
    private static final int MESSAGE_X = 75;
    private static final int MESSAGE_Y = 100;

    private static final int PREFFERED_WIDTH = 300;
    private static final int PREFFERED_HEIGHT = 200;

    public void start(Stage stage){
        Text message = new Text(MESSAGE_X, MESSAGE_Y, "Not a hello world");
        Pane root = new Pane(message);
        root.setPrefSize(PREFFERED_WIDTH, PREFFERED_HEIGHT);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Not a hello world programm");
        stage.show();
    }

}

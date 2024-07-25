package org.javafx.event.mouse;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MouseTest extends Application {
    private static final int PREFFERED_WIDTH = 300;
    private static final int PREFFERED_HEIGHT = 200;
    private static final int RADIUS = 5;
    private Scene scene;
    private Pane root;
    private Circle selected;
    private Circle makeDot(double x, double y){
        Circle dot = new Circle(x,y, RADIUS);
        dot.setOnMouseEntered(mouseEvent -> {
            scene.setCursor(Cursor.CROSSHAIR);
        });
        dot.setOnMouseExited(mouseEvent -> {
            scene.setCursor(Cursor.DEFAULT);
        });
        dot.setOnMouseDragged(mouseEvent -> {
            dot.setCenterX(mouseEvent.getX());
            dot.setCenterY(mouseEvent.getY());
        });
        dot.setOnMousePressed(mouseEvent -> {
            if(mouseEvent.getClickCount() >1){
                root.getChildren().remove(selected);
                select(null);
            }
            else{
                select(dot);
            }
            mouseEvent.consume();
        });
        dot.setOnKeyPressed(keyEvent -> {
            KeyCode code = keyEvent.getCode();
            int distance = keyEvent.isShiftDown() ? 10 : 1;
            if (code == KeyCode.DELETE){
                root.getChildren().remove(dot);
            }
            else if (code == KeyCode.UP){
                dot.setCenterY((dot.getCenterY() - distance));
            }
            else if (code == KeyCode.DOWN){
                dot.setCenterY((dot.getCenterY() + distance));
            }
            else if (code == KeyCode.LEFT) {
                dot.setCenterX(dot.getCenterX() - distance);
            }
            else if (code == KeyCode.RIGHT) {
                dot.setCenterX(dot.getCenterX() + distance);
            }
        });
        return dot;
    }
    private void select(Circle dot){
        if (selected == dot) return;
        if (selected != null){
            selected.setFill(Color.BLACK);
        }
        selected = dot;
        if(selected!=null){
            selected.requestFocus();
            selected.setFill(Color.RED);
        }
    }

    public void start(Stage stage){
        root = new Pane();
        root.setOnMousePressed(mouseEvent -> {
            double x = mouseEvent.getX();
            double y = mouseEvent.getY();
            Circle dot =makeDot(x,y);
            root.getChildren().add(dot);
            select(dot);
        });
        scene = new Scene(root);
        root.setPrefSize(PREFFERED_WIDTH, PREFFERED_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("MouseTest");
        stage.show();
    }
}

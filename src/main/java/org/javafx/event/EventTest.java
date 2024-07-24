package org.javafx.event;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.*;

import java.util.List;
import java.util.Random;

public class EventTest extends Application {

    public void start(Stage stage){
        Button button = new Button("Random Font");
        Text message = new Text("Times New Roman");
        message.setFont(Font.font("Gloucester MT Extra Condensed", 100));
        List<String> families = Font.getFamilies();
        Random generator = new Random();
        button.setOnAction(actionEvent -> {
            String newFamily = families.get(
                    generator.nextInt(families.size())
            );
            message.setText(newFamily);
            message.setFont(Font.font(newFamily, message.getFont().getSize()));
        });
        Slider slider = new Slider();
        slider.setValue(100);
        slider.valueProperty().addListener(property ->{
            double newSize = slider.getValue();
            message.setFont(Font.font(
                    message.getFont().getFamily(), newSize)
            );
        });
        Text sizeMessage = new Text("Window size: ");
        sizeMessage.textProperty().bind(Bindings.format("Window size: %1$.0fx%2$.0f", stage.widthProperty(), stage.heightProperty()));
        VBox root = new VBox(button, slider, message,sizeMessage);
        root.setPrefSize(1500, 300);
        Scene scene = new Scene(root);
        stage.setTitle("EventTest");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            if(slider.getValue() == 100){
                event.consume(); //препятствует закрытию окна
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Move the slider before quitting.");
                alert.showAndWait();
            }
        });
        stage.show();
    }

}

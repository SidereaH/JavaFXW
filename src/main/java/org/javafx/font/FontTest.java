package org.javafx.font;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.geometry.*;

public class FontTest extends Application {
    private static final int PREFFERED_WIDTH = 400;
    private static final int PREFFERED_HEIGHT = 400;
    public void start(Stage stage){
        //сообщение в точке (0,0)
        Text message = new Text("Bonjour le monde!");
        Font f = Font.font("Lucida Bright", FontWeight.BOLD, 36);
        message.setFont(f);
        //размеры изображения

        Bounds messageBounds = message.getBoundsInParent();
        double ascent = -messageBounds.getMinY();
        double descent = messageBounds.getMaxY();
        double width = messageBounds.getWidth();


        //оцентровка сообщения по горизонтали

        double baseY = 100;
        double topY = baseY-ascent;
        double leftX = (PREFFERED_WIDTH - width)/2;
        message.relocate(leftX, topY);

        //прямоугольник и линия

        Rectangle rect = new Rectangle(leftX, topY, width, ascent+ descent);
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.GRAY);
        Line baseline = new Line(leftX, baseY, leftX+width, baseY);
        baseline.setStroke(Color.GRAY);
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //оцентровка сообщения под сообщением
        ImageView image = new ImageView("https://www.culture.ru/_next/image?url=https%3A%2F%2Fcdn.culture.ru%2Fimages%2F50a77653-438f-5231-a562-6dafc357d3e8%2Fw_884%2Ch_442%2Cc_fill%2Cg_center%2F7eb88146103616e228235d6fc16d4d28-jpg.webp&w=1080&q=75");
        Bounds imageBounds = image.getBoundsInParent();
        image.relocate((PREFFERED_WIDTH - imageBounds.getWidth())/2, baseY+ descent);
        Pane root = new Pane(message,rect, baseline,image);
        root.setPrefSize(PREFFERED_WIDTH, PREFFERED_HEIGHT);
        stage.setScene(new Scene(root));
        stage.setTitle("FontTest");
        stage.show();
    }
}

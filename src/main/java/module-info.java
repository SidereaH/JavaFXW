module org.nothelloworld.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.javafx to javafx.fxml;
    exports org.javafx.draw;
    exports org.javafx.nothelloworld;
    exports org.javafx.font;
    opens org.javafx.nothelloworld to javafx.fxml;
}
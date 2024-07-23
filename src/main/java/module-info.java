module org.nothelloworld.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.nothelloworld.demo to javafx.fxml;
    exports org.nothelloworld.demo;
}
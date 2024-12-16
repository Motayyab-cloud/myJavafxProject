module com.example.new1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.new1 to javafx.fxml;
    exports com.example.new1;
}
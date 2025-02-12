module com.lukarus {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.lukarus to javafx.fxml;
    exports com.lukarus;
}

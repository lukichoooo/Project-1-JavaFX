module com.lukarus {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    opens com.lukarus to javafx.fxml;
    exports com.lukarus;
}

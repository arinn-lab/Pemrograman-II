module deliveryapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens deliveryapp to javafx.fxml;
    exports deliveryapp;
}
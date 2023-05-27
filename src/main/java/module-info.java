module com.jpegtranformer {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jpegtranformer to javafx.fxml;
    exports com.jpegtranformer;
}

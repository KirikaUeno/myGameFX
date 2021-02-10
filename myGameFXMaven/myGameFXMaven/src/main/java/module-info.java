module com.company {
    requires javafx.controls;
    requires javafx.fxml;

    opens sample to javafx.fxml;
    exports sample;
}
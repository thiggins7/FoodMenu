module com.example.foodsite {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.foodsite to javafx.fxml;
    exports com.example.foodsite;
}
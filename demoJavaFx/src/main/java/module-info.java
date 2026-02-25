module com.example.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demojavafx to javafx.fxml;
    exports com.example.demojavafx;
    opens com.example.demojavafx.Controllers to javafx.fxml;
    exports com.example.demojavafx.Controllers;
}
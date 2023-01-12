module com.example.practicajavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practicajavafx to javafx.fxml;
    exports com.example.practicajavafx;
}
module com.example.patino_eick_javafx_crud_guia {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.patino_eick_javafx_crud_guia to javafx.fxml;
    exports com.example.patino_eick_javafx_crud_guia;
}
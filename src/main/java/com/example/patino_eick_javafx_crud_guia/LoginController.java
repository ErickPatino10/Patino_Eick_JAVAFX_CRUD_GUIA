package com.example.patino_eick_javafx_crud_guia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.application.Platform;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;

    @FXML
    private void ingresar() {

        String user = txtUsuario.getText();
        String pass = txtPassword.getText();

        // LOGIN SIMPLE (puedes luego conectarlo a BD)
        if (user.equals("admin") && pass.equals("1234")) {

            try {
                // Cargar CRUD
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("jugadores.fxml")
                );

                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("CRUD Jugadores");
                stage.setScene(new Scene(root));
                stage.show();

                // cerrar login
                Stage loginStage = (Stage) txtUsuario.getScene().getWindow();
                loginStage.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Usuario o contraseña incorrectos");
            alert.showAndWait();
        }
    }

    @FXML
    private void salir() {
        Platform.exit();
    }
}
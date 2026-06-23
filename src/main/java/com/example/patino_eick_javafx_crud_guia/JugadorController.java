package com.example.patino_eick_javafx_crud_guia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class JugadorController {

    @FXML private TextField txtCedula;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtEdad;
    @FXML private TextField txtCorreo;
    @FXML private ComboBox<String> cbPosicion;
    @FXML private ComboBox<String> cbPiernaHabil;
    @FXML private ComboBox<String> cbEquipo;
    @FXML private TextArea txtObservaciones;

    @FXML private TableView<Jugador> tabla;

    @FXML private TableColumn<Jugador,Integer> colId;
    @FXML private TableColumn<Jugador,String> colCedula;
    @FXML private TableColumn<Jugador,String> colNombre;
    @FXML private TableColumn<Jugador,String> colApellido;
    @FXML private TableColumn<Jugador,Integer> colEdad;
    @FXML private TableColumn<Jugador,String> colCorreo;
    @FXML private TableColumn<Jugador,String> colPosicion;
    @FXML private TableColumn<Jugador,String> colPiernaHabil;
    @FXML private TableColumn<Jugador,String> colEquipo;

    private final JugadorDAO dao = new JugadorDAO();

    @FXML
    public void initialize(){

        cbPosicion.setItems(FXCollections.observableArrayList(
                "Portero",
                "Defensa",
                "Mediocampista",
                "Delantero"
        ));

        cbPiernaHabil.setItems(FXCollections.observableArrayList(
                "Derecha",
                "Izquierda",
                "Ambas"
        ));

        cbEquipo.setItems(FXCollections.observableArrayList(
                "Barcelona SC",
                "Emelec",
                "Liga de Quito",
                "Independiente del Valle"
        ));

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colPosicion.setCellValueFactory(new PropertyValueFactory<>("posicion"));
        colPiernaHabil.setCellValueFactory(new PropertyValueFactory<>("piernaHabil"));
        colEquipo.setCellValueFactory(new PropertyValueFactory<>("equipo"));

        cargarTabla();
    }

    @FXML
    private void guardar() {

        try {

            Jugador j = new Jugador();

            j.setCedula(txtCedula.getText());
            j.setNombre(txtNombre.getText());
            j.setApellido(txtApellido.getText());
            j.setEdad(Integer.parseInt(txtEdad.getText()));
            j.setCorreo(txtCorreo.getText());
            j.setPosicion(cbPosicion.getValue());
            j.setPiernaHabil(cbPiernaHabil.getValue());
            j.setEquipo(cbEquipo.getValue());
            j.setObservaciones(txtObservaciones.getText());

            dao.insertar(j);

            cargarTabla();
            nuevo();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void nuevo(){

        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();
        txtCorreo.clear();
        txtObservaciones.clear();

        cbPosicion.setValue(null);
        cbPiernaHabil.setValue(null);
        cbEquipo.setValue(null);
    }

    @FXML
    private void eliminar(){

        Jugador j = tabla.getSelectionModel().getSelectedItem();

        if(j!=null){

            dao.eliminar(j.getId());

            cargarTabla();
        }
    }

    private void cargarTabla(){

        ObservableList<Jugador> lista =
                FXCollections.observableArrayList(dao.listar());

        tabla.setItems(lista);
    }

}
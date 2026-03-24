package com.example.demolistviewfile.controllers;

import com.example.demolistviewfile.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {

    @FXML private Label lblMsg;
    @FXML private ListView<String> listView;
    @FXML private TextField txtName;
    @FXML private TextField txtEmail;
    @FXML private TextField txtEdad;

    private ObservableList<String> data = FXCollections.observableArrayList();
    private PersonService service = new PersonService();

    @FXML
    public void initialize() {
        listView.setItems(data);
        loadFromFile();
    }

    @FXML
    public void onReload() {
        loadFromFile();
    }

    @FXML
    public void onAddPerson() {
        try {

            String name = txtName.getText();
            String email = txtEmail.getText();
            String edadTexto = txtEdad.getText();


            if (name.isBlank() || email.isBlank() || edadTexto.isBlank()) {
                throw new IllegalArgumentException("Todos los campos son obligatorios.");
            }

            int edad = Integer.parseInt(edadTexto);


            service.addPerson(name, email, edad);


            lblMsg.setText("Usuario creado correctamente");
            lblMsg.setStyle("-fx-text-fill: green");

            limpiarCampos();
            loadFromFile();

        } catch (NumberFormatException e) {
            lblMsg.setText("Error: La edad debe ser un número válido.");
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IllegalArgumentException e) {
            lblMsg.setText(e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        } catch (IOException e) {
            lblMsg.setText("Error al guardar en archivo.");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile() {
        try {
            List<String> items = service.loadForListView();
            data.setAll(items);
        } catch (IOException e) {
            lblMsg.setText("Error al cargar datos.");
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    private void limpiarCampos() {
        txtName.clear();
        txtEmail.clear();
        txtEdad.clear();
    }
}
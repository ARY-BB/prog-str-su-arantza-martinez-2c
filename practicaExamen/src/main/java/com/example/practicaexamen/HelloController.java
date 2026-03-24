package com.example.practicaexamen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> Parentesco; // Este es tu ComboBox
    @FXML
    private ListView<Object> listaVista;

    private String[] parentesco = {
            "Padre","Madre","Hermano","Hermana","Abuelo","Abuela","Tio","Tia"
    };

    private ObservableList<Object> listaContacto = FXCollections.observableArrayList();

    //public void initialize(){
        // Aquí llenamos el ComboBox con el arreglo
        //Parentesco.getItems().addAll(opcionesParentesco);
        //listaVista.setItems(listaContacto);

    //}

    @FXML
    public void Agregar(){
        String nombre = txtNombre.getText();
        String telefono = txtTelefono.getText();
        String parSelect = Parentesco.getValue();

        if(nombre.isBlank() || telefono.isBlank() || parSelect == null){
            System.out.println("no deje campos vacios");
            return;
        }

        if(telefono.length() != 10){
            System.out.println("tiene que tener 10 digitos");
            return;
        }

        // REGLA: No repetir nombres
        for (Object obj : listaContacto) {
            Contacto c = (Contacto) obj;
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("El nombre ya existe");
                return;
            }
        }

        Contacto nuevo = new Contacto(nombre, telefono, parSelect);
        listaContacto.add(nuevo);
        limpiar();
    }

    @FXML
    public void buscar() {
        String nombreABuscar = txtNombre.getText().trim();
        // ERROR CORREGIDO: Debes definir una variable (c) para recorrer la lista
        for (Object obj : listaContacto) {
            Contacto c = (Contacto) obj;
            if (c.getNombre().equalsIgnoreCase(nombreABuscar)) {
                txtTelefono.setText(c.getTelefono());
                Parentesco.setValue(c.getParentesco()); // Usamos 'Parentesco' que es el ComboBox
                return;
            }
        }
        System.out.println("contacto no encontrado");
    }

    @FXML
    public void actualizar() {
        String nombre = txtNombre.getText().trim();
        for (Object obj : listaContacto) {
            Contacto contactoActual = (Contacto) obj;
            if (contactoActual.getNombre().equalsIgnoreCase(nombre)) {
                contactoActual.setTelefono(txtTelefono.getText());
                contactoActual.setParentesco(Parentesco.getValue());

                listaVista.refresh();
                System.out.println("contacto actualizado");
                return;
            }
        }
    }

    @FXML
    public void delete(){
        int index = listaVista.getSelectionModel().getSelectedIndex();
        if(index >= 0){
            listaContacto.remove(index);
            limpiar();
            System.out.println("se elimino correctamente");
        } else {
            System.out.println("seleccione un contacto ");
        }
    }

    @FXML
    public void limpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        Parentesco.setValue(null); // Limpia la selección del ComboBox
    }
}
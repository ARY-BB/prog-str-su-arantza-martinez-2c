package com.example.demojavafx.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class FormController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtEdad;
    @FXML
    private Label lblResultado;

    public void OnValidate(ActionEvent event){
        String nombre =txtNombre.getText()==null ? "": txtNombre.getText();
        String email =txtEmail.getText()==null ? "": txtEmail.getText();
        String edad =txtEdad.getText()==null ? "": txtEdad.getText();

        List<String> errores=new ArrayList<>();
        //validacion de campo nombre

        if(nombre.isBlank() || nombre.length()<3){
            errores.add("el nombre es requerido");
        }
        if(email.isBlank() || !email.contains("@") || !email.contains(".")){
            errores.add("el email es invalido");
        }
        int edadValida=0;
        try{
            edadValida=Integer.parseInt(edad);
            if (edadValida<=0 || edadValida>120){
                System.out.println("edad fuera de rango");
            }
        }catch(Exception e){
            System.out.println("dato no numerico");
        }
        if(errores.isEmpty()){
            lblResultado.setText("el formulario es correcto");
            lblResultado.setStyle("-fx-text-fill: green;");
        }else{
            lblResultado.setText("error de: "+String.join(",",errores));
            lblResultado.setStyle("-fx-text-fill: red;");
        }
    }
}

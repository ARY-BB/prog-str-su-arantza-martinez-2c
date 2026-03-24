package com.example.practicaexamen;

public class Contacto {
    private static String Nombre;
    private static String Telefono;
    private static String Parentesco;

    public Contacto(String nombre, String telefono, String parentesco){
        this.Nombre=nombre;
        this.Telefono=telefono;
        this.Parentesco=parentesco;
    }
    public static String getNombre(){/// LOS GET OBTIENEN LA INFO
        return Nombre;
    }

    public static void setTelefono(String text) {
    }

    public static void setParentesco(String value) {
    }

    public static String getTelefono(){
        return Telefono;
    }

    public static String getParentesco() {
        return Parentesco;
    }
    @Override
    public String toString(){
        return Nombre + "-"+ Parentesco+"-"+Telefono;
    }
}

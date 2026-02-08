import java.util.Scanner;
public class Validator {
    public boolean leerBoolean(String msg, Scanner sc) {
        while (true) {
            System.out.println(msg);
            String input = sc.next().toLowerCase();
            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("el valor debe ser true o false");
                sc.nextLine();
            }
        }
    }
    public int leerIntEnRango(Scanner sc, String msg) {
        int valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor > 0 && valor < 100) {
                    return valor;
                }
                System.out.println("el numero ingresado debe ser positivo");
            } else {
                System.out.println("el valor no tiene que salir del rango de asistencia");
                sc.nextLine();
            }
        }
    }
    public double [] leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double[] cali=new double [3];
        int contador=0;
        while (contador<3) {
            System.out.println(msg +" " +(contador+1) +": ");
            if (sc.hasNextDouble()) {
                double entrada = sc.nextDouble();
                if (entrada <= max && entrada >= min) {
                    cali[contador] = entrada;
                    contador++;
                }else{
                System.out.printf("la calificacion debe de estar entre ", min, max);
            }
            } else {
                System.out.println("ingrese un numero valido ");
                sc.next();
            }
        }return cali;
    }
    public String leerTextoNoVacio(Scanner sc, String msg){
        String valor="";
        while(true){
            System.out.println(msg);
            valor=sc.nextLine();
            if(valor.isBlank()){
                System.out.println("favor de no dejar esto vacio");
                continue;
            }if(valor.matches(".*\\d.*")){
                System.out.println("ingresa letras no numeros");
                continue;
            }break;
        }return valor;
    }
}

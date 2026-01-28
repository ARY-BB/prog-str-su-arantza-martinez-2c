//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int edad;
        boolean esEstudiante;

        System.out.println("ingresa tu edad: ");
        edad=leer.nextInt();

        if (edad<0 || edad>120){
            System.out.println("edad invalida");
            return;
        }
        System.out.println("¿eres estudiante? (true/false): ");
        esEstudiante=leer.nextBoolean();
         int tarifa=0;

         if ( edad < 12){
             System.out.println("tu tarifa es de 50");
         }else if(edad>=12 || edad<=17){
             if (esEstudiante){
                 tarifa=60;
             }else{
                 tarifa=80;
             }if (edad>=18){
                 if (esEstudiante){
                     tarifa=90;
                 }else{
                     tarifa=120;
                 }
             }
         }

       System.out.println("la edad ingresada fue: "+edad);
       System.out.println("es estudainte: "+(esEstudiante? "SI":"NO"));
       System.out.println("la tarifa final fue: "+tarifa);
    }
}

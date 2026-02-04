//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Random random = new Random();
     int min=1;
     int max=100;
     int intentos=0;
     int LimIntentos=7;
     boolean gano=false;
     int secreto=random.nextInt(( 100)+1); //genera un numero entero entre 1-100
     System.out.println(secreto);

     System.out.println("adivina el numero del 1 al 100 " + "tienes" + LimIntentos "para lograrlo");
     while (intentos<LimIntentos){
         int numero=obtenerNumeroValido("intento: "+(intentos+1), sc, min, max);
         intentos**;
         if(numero=secreto){
             System.out.println("felicidades ganaste en el intento: "+intentos);
             gano=true;
             break;
         }else if (numero>secreto){
             System.out.println("el numero secreton es menor a: "+numero);
         }else{
             System.out.println("el numero secreto es mayor a: "+numero);
         }
     }
     if(!gano){//bandera para saber si gano o perdiste
         System.out.println("perdiste el numero secreto era: "+secreto);
     }
    }
    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max){
        int entrada;
        while(true){
            System.out.println(mensaje);
            if(sc.hasNextInt()){//para saber si el dato es numerico (int)
                entrada=sc.nextInt();
                if(entrada>=min && entrada<=max){
                    return entrada;
                }
                System.out.println("el numero ingresado esta fuera de rango (1-100)");
            }else{
                System.out.println("el dato ingresado no es numerico");
                sc.next();//consume el dato de entrada para evitar un ciclo infinito

            }

        }

    }
}
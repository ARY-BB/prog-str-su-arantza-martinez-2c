import java.util.Scanner;
import java.util.Random;
public class Main{
    public static void main(String[] args){
        Scanner lector = new Scanner(System.in);
        Random generador = new Random();
        int numeroS = generador.nextInt( 100)+1;
        int IntentosG =0;
        int LimiteInt = 7;

        int erroresRango =0;
        int erroresLetras=0;

        System.out.println("adivina un numero del 1-100");
        while (IntentosG<LimiteInt){
            System.out.println("intento: "+(IntentosG +1 )+ "de" + LimiteInt + "");
            System.out.print("escribe un numero: ");

            if(lector.hasNextInt()){
                int suposicion=lector.nextInt();

                if(suposicion<1 || suposicion>100){
                    System.out.println("el numero esta entre 1-100");
                    erroresRango++;

                }else{
                    IntentosG++;
                    if(suposicion==numeroS){
                        System.out.println("felicidades adivinaste");
                        break;
                    }else if (suposicion<numeroS){
                        System.out.println("el numero es mas alto");
                    }else{
                        System.out.println("el numero es mas bajo");
                    }
                }
            }else{
                System.out.println("error eso no es un numero");
                erroresLetras++;
                lector.next();
            }
        }
        System.out.println("partida acabada");
        System.out.println("el numero era: "+numeroS);
        System.out.println("errores de rango: "+erroresRango);
        System.out.println("errores por meter letras: "+erroresLetras);
        System.out.println("gracias por participar");
        lector.close();
    }
}
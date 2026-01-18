import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        int limite = pedirEntero();


        int sumaTotal = sumarHastaN(limite);

        System.out.println("El resultado es: " + sumaTotal);
    }

    public static int pedirEntero() {
        Scanner leer = new Scanner(System.in);
        System.out.print("Dame un numero que sea entero: ");
        return leer.nextInt();
    }

    /**

     *
     * @param n Se ocupa ese valor para saber hasta donde dejara de sumar
     * @return regresa el valor de sumarHastaN
     */

    public static int sumarHastaN(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        return total;
    }
}
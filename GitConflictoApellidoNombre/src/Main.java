import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double IVA= 0.16;
        double subtotal=0;
        subtotal = pedirDouble(scanner, "Subtotal: ");
        double total = subtotal;
        double totalconIVA;
        double  DESCUENTO = 0.10;
        double UMBRAL_DESCUENTO = 1000.0;
        double  total = total - (total * DESCUENTO);
        double total = subtotal + (subtotal * IVA);
        double calculartotalconIVA;
        totalconIVA=calculartotalconIVA=calculartotalconIVA( IVA, subtotal);
        System.out.printf("Total a pagar: %.2f%n", total);
    }

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }
    public static double calculartotalconIVA(double IVA, double subtotal ){
         return subtotal+(subtotal*IVA);
    }
}


import java.util.Scanner;
public class InputValidator {
    public int leerIntEnRango(Scanner sc, String msg) {
        int valor = 0;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor > 0 && valor < 2001) {
                    return valor;
                }
                System.out.println("el numero esta fuera del rango");
            } else {
                System.out.println("no es numerico");
                sc.nextLine();
            }
        }
    }

    public double leerDoubleEnRango(Scanner sc, String msg) {
        double valor = 0.0;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor > 0.1 && valor < 51) {
                    return valor;
                }
                System.out.println("el numero esta fuera del rango");
            } else {
                System.out.println("no es numerico");
                sc.nextLine();
            }
        }
    }

    public boolean leerBoolean(String msg, Scanner sc) {
        while (true) {
            System.out.println(msg);
            String input = sc.next().toLowerCase();
            if (input.equals("true")) {
                return true;
            } else if (input.equals("false")) {
                return false;
            } else {
                System.out.println("el valor debe ser true o false ");
                sc.nextLine();
            }
        }
    }

    public int validarServicio(String msg, Scanner sc) {
        int valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor > 0 && valor < 3) {
                    return valor;
                }
                System.out.println("el numero ingresado no esta en el rango ");
            } else {
                System.out.println("el valor no es numerico");
                sc.nextLine();
            }
        }
    }
}
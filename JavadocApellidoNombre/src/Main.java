import java.util.Scanner; //choice=eleccion

/**
 * proyecto: JavadocApellidoNombre
 * Descripcion: programa con menu para calculos
 */
        public class Main{
    public static void main(String[] args){
        Scanner Scanner=new Scanner(System.in);
        Double peso, IMC, base, fahrenheit;
        Double altura, area, C, radio;
        int choice;
        Scanner leer=new Scanner(System.in);
        do{
            System.out.println("menu de opcciones: ");
            System.out.println("1. Calcular el IMC");
            System.out.println("2. calcular el area de un rectangulo");
            System.out.println("3. convertir C° a F°");
            System.out.println("4. calcular el area de un circulo");
            System.out.println("5. Salir");
            System.out.println("escoje el que dese realisar: ");

            choice=Scanner.nextInt();
            switch (choice){
                case 1:
                    /**
                     * calcular el IMC indice de masa corporal
                     * @param peso se ingreso el peso del usuario en kilogramos
                     * @param altura se ingreso la altura del usuario en metros
                     * @return se dio el valor del IMC ya calculado
                     */
                    System.out.println("ingresa tu peso en KG: ");
                            peso = leer.nextDouble();
                    System.out.println("ingresa tu estatura en M: ");
                            altura = leer.nextDouble();
                    IMC=peso/altura;
                    System.out.println("tu IMC es: "+IMC);
                    break;
                case 2:
                    /**
                     * se saco el area de un rectangulo
                     * @param base se ingreso la base del usuario
                     * @param altura se ingreso la altura del cuadrado
                     * @return el area del rectangulo
                     */
                    System.out.println("ingresa la base del rectangulo: ");
                            base = leer.nextDouble();
                    System.out.println("ingresa la altura del rectangulo: ");
                            altura = leer.nextDouble();
                    area=base*altura;
                    System.out.println("el area del rectangulo es: "+area);
                    break;
                case 3:
                    /**
                     * se convirtieron grados celcius a fahrenheit
                     * @param C se ingresaron los grados celcius
                     * @return grados en fahrenheit
                     */
                    System.out.println("ingrese los grados celcius (°C): ");
                            C = leer.nextDouble();
                    fahrenheit=(C*1.8)+32;
                    System.out.println("en grados fahrenheit serian: "+fahrenheit);
                    break;
                case 4:
                    /**
                     * calcular el area de un circulo
                     * @param radio se pidio el radio del circulo
                     * @return el area del circulo
                     */
                    System.out.println("ingresa el radio del circulo: ");
                            radio = leer.nextDouble();
                    area=3.1416*radio*radio;
                    System.out.println("el area de tu circulo es: "+area);
                    break;
                case 5:
                    System.out.println("saliendo del programa");
                    break;
                default:
                    System.out.println("porfavor intente de nuevo");
            }
            System.out.println();

        }while (choice !=5);
        Scanner.close();
    }
        }
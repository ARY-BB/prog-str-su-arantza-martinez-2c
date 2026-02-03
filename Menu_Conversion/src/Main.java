import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner leer=new Scanner(System.in);
            double C, F, Km, Millas;
            double valor;
            int opccion=0;
            int c_CtoF=0, c_FtoC=0, c_KmToMillas=0, c_MillasToKm=0;

            do{
                System.out.println("bienvenido a este menu de conversiones");
                System.out.println("seleccione la opccion que desee");
                System.out.println("1-°C a °F, 2-°F a °C, 3-Km a Millas, 4-Millas a Km, 5-Salir: ");
                try{
                    opccion=Integer.parseInt(leer.nextLine());
                    if (opccion>=1 && opccion<=4){
                    switch (opccion){
                        case 1:
                            c_CtoF++;
                           valor=capturarEntero(leer, "ingresar el valor a convertir: ");
                            F= (valor*1.8)+32;
                            System.out.println("el grado convertido es: "+F);
                            break;
                        case 2:
                            c_FtoC++;
                            valor=capturarEntero(leer, "ingresar el valor a convertir: ");
                            C=(valor-32/1.8);
                            System.out.println("los grados F a celcius es: "+C);
                            break;
                        case 3:
                            c_KmToMillas++;
                            valor=capturarEntero(leer, "ingresar el valor a convertir: ");
                            Millas=(valor/0.62137);
                            System.out.println("el valor a millas seria: "+Millas);
                            break;
                        case 4:
                            c_MillasToKm++;
                            valor=capturarEntero(leer, "ingresar el valor a convertir: ");
                            Km=(valor*160934);
                            System.out.println("las millas ingresadas a Km son: "+Km);
                            break;
                    }
                    }else if (opccion !=5){
                        System.out.println("error ingrese un numero del 1-5");
                    }
                }catch (NumberFormatException e){
                    System.out.println("error debe ingresar un numero entero");
                }
            }while (opccion !=5);
            Resumen(c_CtoF, c_FtoC, c_KmToMillas, c_MillasToKm);
            leer.close();
    }public static int capturarEntero(Scanner sc, String mensaje ){
        System.out.println(mensaje);
        return Integer.parseInt(sc.nextLine());
    }public static void Resumen(int c1, int c2, int c3, int c4){
        int total = c1+c2+c3+c4;
        System.out.println("RESUMEN FINAL");
        System.out.println("°C a °F: "+c1);
        System.out.println("°F a °C: "+c2);
        System.out.println("Km a Millas: "+c3);
        System.out.println("Millas a Km: "+c4);
        System.out.println("total de conversiones: "+total);
    }
}

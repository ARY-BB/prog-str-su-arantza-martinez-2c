import java.util.Scanner;
public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
       Scanner leer=new Scanner(System.in);
       int opccion;
       double a;
        double b;

       System.out.println("MENU");
       System.out.println("1-suma 2-resta 3-multiplicar 4-dividir");
        System.out.println("seleccione la operacion que desee realizar:");
        opccion=leer.nextInt();



        switch (opccion){
            case 1:
                System.out.println("operacion suma");
                System.out.println("ingrese un numero para la operacion: ");
                 a=leer.nextDouble();
                System.out.println("ingrese otro numero para la operacion: ");
                 b=leer.nextDouble();

                System.out.println("valores: "+a + " "+b);
                System.out.println("tu resultado es: " + (a+b));
                break;
            case 2:
                System.out.println("operacion resta");

                System.out.println("ingrese un numero para la operacion: ");
                 a=leer.nextDouble();
                System.out.println("ingrese otro numero para la operacion: ");
                 b=leer.nextDouble();
                System.out.println("valores: "+ a + " " +b);
                System.out.println("tu resultado es: " + (a-b));
                break;
            case 3:
                System.out.println("operacion multiplicar");
                System.out.println("ingrese un numero para la operacion: ");
                a=leer.nextDouble();
                System.out.println("ingrese otro numero para la operacion: ");
                b=leer.nextDouble();
                System.out.println("valores: "+a + " "+b);
                System.out.println("tu resultado es: " + (a*b));
                break;
            case 4:
                System.out.println("operacion dividir");
                System.out.println("ingrese un numero para la operacion: ");
                a=leer.nextDouble();
                System.out.println("ingrese otro numero para la operacion: ");
                b=leer.nextDouble();
                System.out.println("valores: "+a + " "+b);
                  if (b==0){
                      System.out.println("no se puede dividir entre 0");
                  }else{
                System.out.println("tu resultado es: " + (a/b));}
                break;
            default:
                System.out.println("opccion invalida");
        }

    }
}

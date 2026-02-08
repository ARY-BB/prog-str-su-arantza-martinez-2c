import java.util.Scanner;
public class Main{
  public static void main(String[] args){
    ShippingCalculator ShippingCalculator=new ShippingCalculator();
    InputValidator InputValidator=new InputValidator();
    Scanner sc=new Scanner(System.in);
    //IPO

    //INPUT
    double pesoKg= InputValidator.leerDoubleEnRango(sc,"ingresa el peso del paquete que quieres enviar ");
    int distanciaKm= InputValidator.leerIntEnRango(sc,"ingresa la distancia que tendra el paquete ");
    int tipoServicio= InputValidator.validarServicio( "cual es el tipo de servicio (1.-Estandar, 2.-Expres)",sc);
    boolean esZonaRemota= InputValidator.leerBoolean("es zona remota? (true/false)",sc);
    //PROSSES
    ShippingCalculator.process(pesoKg, distanciaKm, tipoServicio, esZonaRemota);

    //OUPUT
    double sub= ShippingCalculator.calcularSubtotal(pesoKg,distanciaKm,tipoServicio, esZonaRemota);
    double iva= ShippingCalculator.getCalcularIVA(sub);
    double total= ShippingCalculator.calcularTotal(sub, iva);

    String servicioTexto=(tipoServicio==1) ? "estandar": "express";
    System.out.println("ticket de envio");
    System.out.println("servicio: "+servicioTexto);
    System.out.println("peso: "+pesoKg + "Kg");
    System.out.println("distancia: "+distanciaKm+ "Km");
    System.out.println("zona remota: "+(esZonaRemota? "si": "no"));

    System.out.println("subtotal: "+sub);
    System.out.println("IVA: "+iva);
    System.out.println("total: "+total);
    sc.close();
  }
}
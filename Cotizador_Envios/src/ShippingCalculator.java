public class ShippingCalculator {
    private double IVA=0.16;
    private final double PRECIO_EXPRESS=90;
    private final double PRECIO_ESTANDAR=50;
    private double  calcularIVA, calcularTotal;
    private double subtotal;
    public void process(double pesoKg, int distanciaKm,int tipoServicio, boolean esZonaRemota){
        calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        this.calcularIVA=getCalcularIVA(subtotal);
        calcularTotal(subtotal, this.calcularIVA);
    }
    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota){
        double subtotal=0;
        if (tipoServicio==1){
            //estandar
            subtotal+=PRECIO_ESTANDAR;
            double costoKgpesos=12*pesoKg;
            subtotal=subtotal+costoKgpesos;
        }else {
            //express
            subtotal += PRECIO_EXPRESS;
            double costoKgpesos = 12 * pesoKg;
            subtotal=subtotal+costoKgpesos;
        }if(distanciaKm<=50){
            subtotal+=20;
        }else if(distanciaKm<=200){
            subtotal+=60;
        }else{
            subtotal+=120;
        }if(zonaRemota){
            subtotal=subtotal*1.10;
        }
        return subtotal;
    }
    public double getCalcularIVA(double subtotal){
        double iva;
        iva=subtotal*IVA;
        return iva;
    }
    public double calcularTotal(double subtotal, double IVA){
        calcularTotal=subtotal+IVA;
        return calcularTotal;
    }
}

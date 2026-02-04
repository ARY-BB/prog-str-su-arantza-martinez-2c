public class Ticket {

    public Ticket(){
        //es un constructor este es una buena practica
    }
    public final double DESCUENTO=0.10;
    public final double PRECIO=10;
    public double subtotal;
    public double descuentoCalculado;
    public double total;

    public void process(int cantidad){
        calcularsubtotal(cantidad);
        calcularDescuento(this.subtotal);
        calcularTotal(this.subtotal);
    }
    private void calcularsubtotal(int cantidad){
        this.subtotal=cantidad*PRECIO;
    }
    private void calcularDescuento(double subtotal){
        this.descuentoCalculado=subtotal=DESCUENTO;
    }
    private void calcularTotal(double subtotal){
        this.total =subtotal-this.descuentoCalculado;
    }
    public void imprimirTicket(double cantidad){
        System.out.println("--Ticket--");
        System.out.println("la cantidad de calculos fue: "+cantidad);
        System.out.println("el subtotal fue: "+this.subtotal);
        System.out.println("el descuento calculado fue de: "+this.descuentoCalculado);
        System.out.println("el total del Ticket es de: "+total);
    }
}

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        GradeService GradeService=new GradeService();
        Validator Validator=new Validator();
        Scanner sc=new Scanner(System.in);

        //INPUT
        String nombredelAlumno=Validator.leerTextoNoVacio(sc, "introduce un nombre: ");
        double[] calificacionesParciales=Validator.leerDoubleEnRango(sc,  "ingrese calificacion: ",0, 100);
        int asistencia=Validator.leerIntEnRango(sc, "ingresa el numero de asistencias: ");
        boolean entregaProyecto=Validator.leerBoolean("escriba si entrego proyecto (true/false): ",sc);

        double promedio= GradeService.calcularPromedio(calificacionesParciales [0], calificacionesParciales [1], calificacionesParciales[2]);
        double notaFinal= GradeService.calcularFinal(promedio, asistencia);
        String estado= GradeService.determinarEstado(notaFinal, asistencia, entregaProyecto);

        imprimirReporte(nombredelAlumno, calificacionesParciales, promedio, asistencia, entregaProyecto, notaFinal, estado);
    }
    public static void imprimirReporte(String nom, double [] c, double p, int a, boolean pr, double f,String est){
        System.out.println("REPORTE " + nom.toUpperCase());
        System.out.printf("PARCIALES: [%.1f, %.1f, %.1f]\n" ,c[0],c[1],c[2]);
        System.out.printf("promedio por parciales: %.2f\n" ,p);
        System.out.println("Asistencia: " +a+ "%");
        System.out.println ("Proyecto Entregado: "+(pr? "si" : "no"));
        System.out.printf("Calificacion Final: (70%% prom / 30%% asis): %.2f\n", f);
        System.out.println("estado final: "+est);
    }
}
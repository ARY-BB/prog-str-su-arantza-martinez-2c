public class GradeService {
    public double calcularPromedio(double a, double b, double c){
        return (a+b+c)/3.0;
    }public double calcularFinal(double promedio, int asistencia){
        return (promedio *0.7)+(asistencia*0.3);
        }
        public String determinarEstado(double notaFinal, int asistencia, boolean entregoProyecto){
        if (asistencia<80){
            return "reprobado por asistencia";
        }
        if (!entregoProyecto){
            return "reprobado por proyecto";
        }
        if (notaFinal>=7){
            return "aprobado";
        }else{
            return "reprobado por calificacion";
        }
    }
}

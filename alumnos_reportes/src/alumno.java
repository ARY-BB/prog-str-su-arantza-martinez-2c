public class alumno {
    int id;
    String nombre;
    double promedio;
    boolean activo;

    @Override
    public String toString() {
        return "alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", promedio=" + promedio +
                ", activo=" + activo +
                '}';
    }

    public alumno(int id, String nombre, double promedio){
        this.id=id;
        this.nombre=nombre;
        this.promedio=promedio;
        this.activo=true;
    }
}

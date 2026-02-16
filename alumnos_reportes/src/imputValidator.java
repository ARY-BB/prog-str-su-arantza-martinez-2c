import org.w3c.dom.ls.LSOutput;

public class imputValidator {
    private alumno[] alumnos = new alumno[25];
    private int contador = 0;

    public boolean darAlta(int id, String nombre, double promedio) {
        if (contador >= alumnos.length) {
            System.out.println("error ya no hay espacio para otro alumno");
            return false;
        }
        if (id <= 0) return false;
        if (nombre.isEmpty()) return false;
        if (promedio < 0 || promedio > 10) return false;
        if (buscarIndice(id) != -1) {
            System.out.println("Error: El ID ya existe.");
            return false;
        }
        alumnos[contador] = new alumno(id, nombre, promedio);
        contador++;
        return true;
    }
    public alumno buscarActivo(int id) {
        int posicion = buscarIndice(id);
        if (posicion == -1) return null;

        if (alumnos[posicion].activo == true) {
            return alumnos[posicion];
        }
        return null;
    }
    public int buscarIndice(int id) {
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].id == id) return i;
        }
        return -1;
    }
    public boolean actualizarPromedio(int id, double promedio) {
        alumno a = buscarActivo(id);
        if (a != null && promedio >= 0 && promedio <= 10) {
            a.promedio = promedio;
            return true;
        }
        return false;
    }
    public boolean bajaLogica(int id) {
        alumno a = buscarActivo(id);
        if (a != null) {
            a.activo = false;
            return true;
        }
        return false;
    }
    public void listarActivos() {
        boolean hay = false;
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].activo) {
                System.out.println(alumnos[i]);
                hay = true;
            }
        }
        if (!hay) System.out.println("no hay alumnos activos");
    }
    public void reportes() {
        double suma = 0, cont = 0, excelente = 0;


        double max = -1;
        String nombreMax = "";
        double idMax = 0;


        double min = 11;
        String nombreMin = "";
        double idMin = 0;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i] != null && alumnos[i].activo) {
                double prom = alumnos[i].promedio;
                suma += prom;
                cont++;

                if (prom >= 8.00) {
                    excelente++;
                }


                if (prom > max) {
                    max = prom;
                    nombreMax = alumnos[i].nombre;
                    idMax = alumnos[i].id;
                }


                if (prom < min) {
                    min = prom;
                    nombreMin = alumnos[i].nombre;
                    idMin = alumnos[i].id;
                }
            }
        }


        if (cont > 0) {
            System.out.println("El promedio general es de: " + (suma / cont));
            System.out.println("Alumnos con promedio >= 8.00: " + excelente);
            System.out.println("El promedio máximo es: id: " + idMax + " nombre: " + nombreMax + " promedio: " + max);
            System.out.println("El promedio mínimo es: id: " + idMin + " nombre: " + nombreMin + " promedio: " + min);
        } else {
            System.out.println("No hay alumnos activos para generar reportes.");
        }
    }
    }




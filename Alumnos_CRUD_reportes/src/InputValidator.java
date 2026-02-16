public class InputValidator {
    private alumno[] alumnos = new alumno[25];
    private int contador = 0;

    // 1) Alta con todas las validaciones
    public boolean darAlta(int id, String nombre, double promedio) {
        if (id <= 0 || nombre.trim().isEmpty() || promedio < 0 || promedio > 10) return false;
        if (buscarIndice(id) != -1) return false; // ID repetido

        if (contador < alumnos.length) {
            alumnos[contador++] = new alumno(id, nombre, promedio);
            return true;
        }
        return false;
    }

    // Buscar solo si está activo
    public alumno buscarActivo(int id) {
        int index = buscarIndice(id);
        if (index != -1 && alumnos[index].activo) {
            return alumnos[index];
        }
        return null;
    }

    private int buscarIndice(int id) {
        for (int i = 0; i < contador; i++) {
            if (alumnos[i].id == id) return i;
        }
        return -1;
    }

    public boolean actualizarPromedio(int id, double nuevoPromedio) {
        alumno a = buscarActivo(id);
        if (a != null && nuevoPromedio >= 0 && nuevoPromedio <= 10) {
            a.promedio = nuevoPromedio;
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
        if (!hay) System.out.println("No hay alumnos activos.");
    }

    // 6) Reportes (La parte que te faltaba)
    public void generarReportes() {
        double suma = 0, max = -1, min = 11;
        alumno aMax = null, aMin = null;
        int activos = 0, excelentes = 0;

        for (int i = 0; i < contador; i++) {
            if (alumnos[i].activo) {
                activos++;
                double p = alumnos[i].promedio;
                suma += p;
                if (p >= 8.0) excelentes++;
                if (p > max) { max = p; aMax = alumnos[i]; }
                if (p < min) { min = p; aMin = alumnos[i]; }
            }
        }

        if (activos == 0) {
            System.out.println("No hay datos para reportes.");
            return;
        }

        System.out.println("--- REPORTES ---");
        System.out.println("Promedio General Activos: " + (suma / activos));
        System.out.println("Mayor Promedio: " + aMax);
        System.out.println("Menor Promedio: " + aMin);
        System.out.println("Alumnos con Promedio >= 8.0: " + excelentes);
    }

}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Creamos la instancia del validador que contiene el arreglo
        InputValidator sistema = new InputValidator();
        int opcion;

        do {
            System.out.println("\n========= CONTROL DE ALUMNOS =========");
            System.out.println("1) Alta de Alumno");
            System.out.println("2) Buscar por ID (Activos)");
            System.out.println("3) Actualizar Promedio");
            System.out.println("4) Baja Lógica");
            System.out.println("5) Listar Alumnos Activos");
            System.out.println("6) Reportes Generales");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID (número positivo): ");
                    int id = sc.nextInt();
                    sc.nextLine(); // Limpiar el salto de línea
                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();
                    System.out.print("Promedio (0.0 - 10.0): ");
                    double promedio = sc.nextDouble();

                    if (sistema.darAlta(id, nombre, promedio)) {
                        System.out.println(" Alumno registrado correctamente.");
                    } else {
                        System.out.println(" Error: ID repetido o datos fuera de rango.");
                    }
                    break;

                case 2:
                    System.out.print("ID a buscar: ");
                    int idB = sc.nextInt();
                    alumno encontrado = sistema.buscarActiva(idB);
                    if (encontrado != null) {
                        System.out.println(" Resultado: " + encontrado);
                    } else {
                        System.out.println("⚠ No se encontró el alumno o está inactivo.");
                    }
                    break;

                case 3:
                    System.out.print("ID del alumno a actualizar: ");
                    int idU = sc.nextInt();
                    System.out.print("Nuevo promedio: ");
                    double nuevoP = sc.nextDouble();
                    if (sistema.actualizarPromedio(idU, nuevoP)) {
                        System.out.println(" Promedio actualizado.");
                    } else {
                        System.out.println(" No se pudo actualizar (ID no existe o promedio inválido).");
                    }
                    break;

                case 4:
                    System.out.print("ID para dar de baja: ");
                    if (sistema.bajaLogica(sc.nextInt())) {
                        System.out.println(" El alumno ha sido desactivado.");
                    } else {
                        System.out.println(" Error: El ID no existe o ya está inactivo.");
                    }
                    break;

                case 5:
                    System.out.println("--- LISTA DE ALUMNOS ACTIVOS ---");
                    sistema.listarActivos();
                    break;

                case 6:
                    sistema.generarReportes();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
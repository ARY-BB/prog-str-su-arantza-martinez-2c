import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static GestionPersonas gestion = new GestionPersonas();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> alta();
                case 2 -> buscar();
                case 3 -> baja();
                case 4 -> gestion.listarActivas();
                case 5 -> actualizar();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Error: Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE GESTIÓN ---");
        System.out.println("1) Alta\n2) Buscar por ID\n3) Baja lógica\n4) Listar activas\n5) Actualizar nombre\n0) Salir");
    }

    private static void alta() {
        int id = leerIdValido();
        String nombre = leerCadenaNoVacia("Nombre: ");
        if (gestion.agregarPersona(id, nombre)) {
            System.out.println("Persona agregada con éxito.");
        } else {
            System.out.println("Error: ID ya existe o arreglo lleno.");
        }
    }

    private static void buscar() {
        int id = leerEntero("ID a buscar: ");
        Persona p = gestion.buscarActiva(id);
        System.out.println(p != null ? p : "Persona no encontrada o inactiva.");
    }

    private static void baja() {
        int id = leerEntero("ID para baja lógica: ");
        if (gestion.bajaLogica(id)) {
            System.out.println("Baja procesada correctamente.");
        } else {
            System.out.println("Error: No se encontró la persona activa.");
        }
    }

    private static void actualizar() {
        int id = leerEntero("ID para actualizar: ");
        String nombre = leerCadenaNoVacia("Nuevo nombre: ");
        if (gestion.actualizarNombre(id, nombre)) {
            System.out.println("Nombre actualizado.");
        } else {
            System.out.println("Error: Persona no encontrada o inactiva.");
        }
    }

    // MÉTODOS DE VALIDACIÓN
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero.");
            }
        }
    }

    private static int leerIdValido() {
        int id;
        do {
            id = leerEntero("ID (debe ser > 0): ");
            if (id <= 0) System.out.println("Error: El ID debe ser mayor a cero.");
        } while (id <= 0);
        return id;
    }

    private static String leerCadenaNoVacia(String mensaje) {
        String cadena;
        do {
            System.out.print(mensaje);
            cadena = sc.nextLine().trim();
            if (cadena.isEmpty()) System.out.println("Error: El nombre no puede estar vacío.");
        } while (cadena.isEmpty());
        return cadena;
    }
}

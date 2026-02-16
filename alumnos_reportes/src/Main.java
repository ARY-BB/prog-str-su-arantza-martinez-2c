import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        imputValidator validar = new imputValidator();

        int opccion;
        do {
            System.out.println("bienvenido al control de alumnos");
            System.out.println("porfavor seleccione una opccion");
            System.out.println("1) alta alumno");
            System.out.println("2) buscar por ID");
            System.out.println("3) actualizar promedio por ID");
            System.out.println("4) baja logica por ID");
            System.out.println("5) listar activos");
            System.out.println("6) reportes");
            System.out.println("0) salir");
            opccion = sc.nextInt();
            switch (opccion) {
                case 1:
                    System.out.println("de un ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("introdusca su nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("su promedio (0.0-10.0)");
                    double promedio = sc.nextDouble();


                    if (validar.darAlta(id, nombre, promedio)) {
                        System.out.println("alumno registrado");
                    } else {
                        System.out.println("el alumno no pudo ser registrado");
                    }
                    break;

                case 2:
                    System.out.println("ingrese ID: ");
                    id = sc.nextInt();
                    alumno encontrado = (alumno) validar.buscarActivo(id);
                    if (encontrado != null) {
                        System.out.println("resultado es: " + encontrado);
                    } else {
                        System.out.println("no se encontro alumno");
                    }
                    break;

                case 3:
                    System.out.println("ingrese el id del alumno ");
                    id = sc.nextInt();
                    System.out.println("ingrese es nuevo promedio");
                    double nuevo = sc.nextDouble();
                    if (validar.actualizarPromedio(id, nuevo)) {
                        System.out.println("promedio cambiado");
                    } else {
                        System.out.println("no se pudo hacer cambios");
                    }
                    break;

                case 4:
                    System.out.println("ingrese el id para la baja: ");
                    if (validar.bajaLogica(sc.nextInt())) {
                        System.out.println("el alumno ha sido desactivado");
                    } else {
                        System.out.println("el id ya no existe");
                    }
                    break;

                case 5:
                    System.out.println("lista de los alumnos activos");
                    validar.listarActivos();
                    break;

                case 6:
                    validar.reportes();
            }
        } while (opccion != 0);
    }
}
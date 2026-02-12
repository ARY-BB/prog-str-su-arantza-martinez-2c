public class GestionPersonas {
    private Persona[] personas = new Persona[20];
    private int contador = 0;

    public boolean agregarPersona(int id, String nombre) {
        if (buscarIndicePorId(id) != -1) return false; // ID Repetido
        if (contador < personas.length) {
            personas[contador++] = new Persona(id, nombre);
            return true;
        }
        return false;
    }

    public Persona buscarActiva(int id) {
        int index = buscarIndicePorId(id);
        if (index != -1 && personas[index].isActiva()) {
            return personas[index];
        }
        return null;
    }

    public boolean bajaLogica(int id) {
        Persona p = buscarActiva(id);
        if (p != null) {
            p.setActiva(false);
            return true;
        }
        return false;
    }

    public boolean actualizarNombre(int id, String nuevoNombre) {
        Persona p = buscarActiva(id);
        if (p != null) {
            p.setNombre(nuevoNombre);
            return true;
        }
        return false;
    }

    public void listarActivas() {
        boolean hayActivas = false;
        for (Persona p : personas) {
            if (p != null && p.isActiva()) {
                System.out.println(p);
                hayActivas = true;
            }
        }
        if (!hayActivas) System.out.println("No hay personas activas en el sistema.");
    }

    private int buscarIndicePorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (personas[i].getId() == id) return i;
        }
        return -1;
    }
}
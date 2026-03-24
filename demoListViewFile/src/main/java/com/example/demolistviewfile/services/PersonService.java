package com.example.demolistviewfile.services;

import com.example.demolistviewfile.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",");
            // Validación de seguridad por si la línea del CSV está mal formada
            if (parts.length >= 3) {
                String name = parts[0];
                String email = parts[1];
                String edad = parts[2];
                result.add(name + " - " + email + " - " + edad);
            }
        }
        return result;
    }


    public void addPerson(String name, String email, int edad) throws IOException {

        validate(name, email, edad);


        repo.addNewLine(name + "," + email + "," + edad);
    }


    private void validate(String name, String email, int edad) {

        if (name == null || name.isBlank() || name.length() < 3) {
            throw new IllegalArgumentException("El nombre es incorrecto (mínimo 3 caracteres)");
        }

        String em = (email == null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")) {
            throw new IllegalArgumentException("El email es inválido");
        }

        if (edad < 18) {
            throw new IllegalArgumentException("No se puede registrar: Debe ser mayor de edad.");
        }
    }
}


package com.example.demolistviewfile.repositories;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class PersonFileRepository {

    private final Path pathFile= Paths.get("data" , "persons.csv");

    private void ensureFile() throws IOException {


        if(Files.notExists(pathFile)){/// ver si el archivo existe
            Files.createFile(pathFile);
        }
    }

    public List<String> readAllLines() throws IOException {

        return Files.readAllLines(pathFile, StandardCharsets.UTF_8);
    }

    public void addNewLine(String line) throws IOException {
        ensureFile();
        Files.writeString(pathFile, line+System.lineSeparator(),
                StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
          public void saveFile(List<String> lines) throws IOException {/// guardara en un archivo la listaq se modificara
               Files.write(pathFile, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);///ELIMINA LA LISTA Y GUARDA EL ARCHIVO el metodo
          }
}

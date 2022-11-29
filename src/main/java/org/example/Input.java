package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Elevador;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Input {

    private String path;
    private String json;

    public List<Elevador> recebeInputs() throws IOException {
        this.path = "./input.json";

        String json = String.join(" ",
                Files.readAllLines(
                        Paths.get(path),
                        StandardCharsets.UTF_8
                ));

        Type tipoLista = new TypeToken<List<Elevador>>() {}.getType();
        List<Elevador> lista = new Gson().fromJson(json, tipoLista);

        return lista;
    }
}

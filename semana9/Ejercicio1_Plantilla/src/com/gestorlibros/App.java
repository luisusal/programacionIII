package com.gestorlibros;

import com.gestorlibros.controller.Controller;
import com.gestorlibros.model.GestorLibrosModel;
import com.gestorlibros.view.View;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Creamos el MV2C

        // Creamos el modelo
        GestorLibrosModel m = new GestorLibrosModel();

        // Creamos la vista
        View v = new View();

        // Creamos el controlador
        Controller  c = new Controller(m, v);

        c.initApp();

    }
}

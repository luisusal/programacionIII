package com.gestorlibros.model;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import es.usal.progiii.tools.Rutas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestorLibrosModel {

    ArrayList<Libro> libros;

    // Path to export and import data
    Path pathToXML = Rutas.pathToFileOnDesktop("libros.xml");
    Path pathToJSON = Rutas.pathToFileOnDesktop("libros.json");
    Path pathToCSV = Rutas.pathToFileOnDesktop("libros.csv");
    Path pathToBinary = Rutas.pathToFileOnDesktop("libros.bin");

    public GestorLibrosModel() {
        libros = new ArrayList<Libro>();
    }

    // CRUD OPERATIONS
    public void addLibro(Libro l) {
        libros.add(l);
    }

    public void removeLibro(Libro l) {
        libros.remove(l);
    }

    public void updateLibro(Libro l) {
        libros.set(libros.indexOf(l), l);
    }

    public ArrayList<Libro> getLibros() {
        // Devolvemos copia para no modificar el original desde la vista.
        return new ArrayList<Libro>(this.libros);
    }

    // Export and Import data ------------------------------------------
    public int exportBooksToCSV() {
        

        ArrayList<String> lineas = new ArrayList<>();

        for (Libro l:libros){
            String libroString = l.asDelimitedString(",");
            lineas.add(libroString);
        }

        try{
            Files.write(pathToCSV,lineas,StandardCharsets.UTF_8);
            return libros.size();
        }catch(IOException e){
            return -1;
        }
    }

    public int importBooksFromCSV() {
        
        try{
            List<String> lineas = Files.readAllLines(pathToCSV,StandardCharsets.UTF_8);
            int contadorLibros = 0;
            for(String linea: lineas){
                //libros tiene ISBN,Nombre...
                Libro l = Libro.fromDelimitedString(linea, ",");
                if(l!=null){
                    if (!libros.contains(l)){
                        libros.add(l);
                        contadorLibros++;
                    }
                }
            }
            return contadorLibros;

        }catch(IOException e){
            return -1;
        }
    }

    public int exportBooksToJSON() {
        // OBJETO --> string del objeto en formato JSON ---> archivo.json
        Gson gson = new Gson();
        String json = gson.toJson(libros);

        try  {
            Files.write(pathToJSON, json.getBytes(StandardCharsets.UTF_8));
            return libros.size();
        } catch (IOException e) {
            return -1;
        }
    }

    public int importBooksFromJSON() {
        // TODO Auto-generated method stub
        // OBJETO --> string del objeto en formato JSON ---> archivo.json
        Gson gson = new Gson();
        //leer todo el contenido del archivo y almacenarlo en una string
        try {
            String json = Files.readString(pathToJSON);
            Type tipoListaLibros = new TypeToken<ArrayList<Libro>>(){}.getType();

            ArrayList<Libro> librosImportados = gson.fromJson(json, tipoListaLibros);

            //aplicamos la politica de solo aaadir libros que no esten repetidos
            int contadorLibros = 0;
            for(Libro l:    librosImportados){
                if(!libros.contains(l)){
                    libros.add(l);
                    contadorLibros++;
                }
            }
            return contadorLibros;

    }catch (IOException e) {
            return -1;
        }
    }

    public int importBooksFromXML() {
        // OBJETO --> string del objeto en formato XML ---> archivo.xml
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(pathToXML), StandardCharsets.UTF_8);
            ArrayList<Libro> librosImportados = xmlMapper.readValue(
                xml, 
                xmlMapper.getTypeFactory().constructCollectionType(ArrayList.class, Libro.class)
            );
            
            int contadorLibros = 0;
            for(Libro l: librosImportados){
                if(!libros.contains(l)){
                    libros.add(l);
                    contadorLibros++;
                }
            }
            return contadorLibros;
        } catch (IOException e) {
            return -1;
        }
    }

    public int exportBooksToXML() {
        //obj-eto --> string del objeto en formato XML ---> archivo.xml
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writeValueAsString(libros);
            Files.write(pathToXML, xml.getBytes(StandardCharsets.UTF_8));
            return libros.size();
        } catch (IOException e) {
            return -1;
        }
    }

    // Serialization and Deserialization ------------------------------------------
    public int saveStateOfTheApp(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(pathToBinary.toFile());
        ObjectOutputStream objectInputStream = new ObjectOutputStream(fileOutputStream);
        objectInputStream.writeObject(libros);
        objectInputStream.close();

        return libros.size();
        }catch(IOException e){
            return -1;
        }
    }

    public int loadStateOfTheApp(){
        try{    
            FileInputStream fileOutputStream = new FileInputStream(pathToBinary.toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileOutputStream);
            ArrayList<Libro> librosImportados = (ArrayList<Libro>) objectInputStream.readObject();
            objectInputStream.close();

            libros=librosImportados;
            return libros.size();
        }catch(IOException e){
            return -1;
        }catch(ClassNotFoundException e){
            return -1;
        }
    

    }

}

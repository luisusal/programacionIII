package model;

public class Fruta {
    private final Float IVA= 0.04;

    private final String nombre;
    private final float precioSinIva;

    public Fruta(String nombre, float precioSinIva){
        this.nombre=nombre;
        this.precioSinIva=precioSinIva;

    }

    public String getNombre(){
        return nombre;

    }
    
    public float precioConIva(){
        return precioSinIva*(1+IVA);

    }

    public float precio (float kg){
        return kg*precioConIva();
    }

}

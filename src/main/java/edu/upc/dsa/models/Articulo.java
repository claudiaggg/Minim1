package edu.upc.dsa.models;

public class Articulo {
    String nombreArticulo;
    String descripcion;
    Double precio;

    public Articulo (String nombreArticulo, String descripcion, Double precio){
        this.nombreArticulo=nombreArticulo;
        this.descripcion=descripcion;
        this.precio=precio;
    }

    public void setNombreArticulo(String nombreArticulo)
    {
        this.nombreArticulo=nombreArticulo;
    }

    public String getNombreArticulo()
    {
        return nombreArticulo;

    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion=descripcion;
    }

    public String getDescripcion()
    {
        return descripcion;

    }

    public void setPrecio(Double precio)
    {
        this.precio=precio;
    }

    public Double getPrecio()
    {
        return precio;

    }
}

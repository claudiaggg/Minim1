package edu.upc.dsa.models;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Catalogo {
    String nombre;
    List<Articulo> catalogo;

    public Catalogo (String nombre, List<Articulo> catalogo)
    {
        this.nombre=nombre;
        this.catalogo=catalogo;
    }

    public Catalogo (List<Articulo> catalogo)
    {
        this.nombre = "Catalogo simple";
        this.catalogo=catalogo;
    }

    public List<Articulo> OrdenarCatalogoDescendiente()
    {
        catalogo.sort(Comparator.comparingDouble(Articulo::getPrecio).reversed());
//        Collections.sort(this.catalogo,
//                (Articulo a1, Articulo a2) -> Double.compare(a1.getPrecio(), a2.getPrecio()));;
// productsList.sort(Comparator.comparingDouble(Product::getNumSells).reversed());
        return this.catalogo;
    }

    public List<Articulo> getCatalogo()
    {
        return catalogo;
    }
}

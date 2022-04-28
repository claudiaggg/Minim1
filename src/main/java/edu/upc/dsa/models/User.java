package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    List<PuntoInteres> puntosInteres;

    public User() {

    }

    public User(String name) {
        this.name= name;
        this.puntosInteres= new ArrayList<>();

    }

    public User(String name, List<PuntoInteres> puntosInteres) {
        this();
        this.setName(name);
        this.setPuntos(puntosInteres);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPunto(PuntoInteres p)
    {
        puntosInteres.add(p);

    }



    public List<PuntoInteres> getPuntos() {
        return puntosInteres;
    }

    public void setPuntos(List<PuntoInteres> puntosInt) {
        this.puntosInteres = puntosInt;
    }
}

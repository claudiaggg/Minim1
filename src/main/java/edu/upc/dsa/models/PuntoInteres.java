package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PuntoInteres {

    String info;
    List<User> visitas;


    public PuntoInteres() {

    }

    public PuntoInteres(String info, List<User> visitas) {
        this();
        this.setInfo(info);
        this.setVisitas(visitas);

    }

    public PuntoInteres(String info) {

        this.setInfo(info);
        this.visitas = new ArrayList<>();


    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<User> getVistias() {
        return this.visitas;
    }

    public void setVisitas(List<User> visitas) {
        this.visitas = visitas;
    }

    public List<User> getListaOrdenaAlfabeticamente() {
//        Collections.sort(this.visitas,
//                (User o1, User o2) -> Double.compare(o1.getName(), o2.getName()));

        return this.visitas;

    }


    public void addUser(User u) {
        visitas.add(u);
    }
}

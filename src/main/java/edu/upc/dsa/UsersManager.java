package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.User;

import java.util.HashMap;
import java.util.List;

public interface UsersManager {

    //public User addUser(User u);
    public void addNewUser(User u, PuntoInteres p);
    public void addLocationExisting(String NIF, String puntoInteres);
    //public int findAllLocationsUser (User u);
    //public List<PuntoInteres> findAllLocationsUser (String NIF);
    //public User getUser(String name);
    //public List<User> findAll();
    public int size();
    public List<User> listFromLocation (String nameLocation);
    public List<PuntoInteres> ConsultarInfo(String name);

}

package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.PuntoInteres;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class UsersManagerImpl implements UsersManager{
    private static UsersManager instance;
    protected HashMap<String, User> users = new HashMap<>();
    protected HashMap<String, PuntoInteres> puntos = new HashMap<>();
    //protected List<User> users;
    final static Logger logger = Logger.getLogger(UsersManagerImpl.class);

    private UsersManagerImpl() {
        //this.users= new LinkedList<>();
    }

    public static UsersManager getInstance() {
        if (instance==null) instance = new UsersManagerImpl();
        return instance;
    }
    public int size() {
        int ret = this.users.size();
        logger.info("size " + ret);

        return ret;
    }

    public void addNewUser(User u, PuntoInteres p) {
        logger.info("new User " + u.getName() + " in location: "+ p.getInfo());
        u.addPunto(p);
        p.addUser(u);

        this.users.put(u.getName(), u);
        logger.info("new User added");

        this.puntos.put(p.getInfo(), p);
        //return u;
    }

    public void addByName(String Username, String puntosInteres) {
        User u =users.get(Username);
        PuntoInteres p = puntos.get(puntosInteres); //miro que no exista en el hashmap con ese nombre
        u.addPunto(p);
        p.addUser(u);
        logger.info("new Location " + p.getInfo() + " added to the user " + u.getName());

//        PuntoInteres p = puntos.get(puntosInteres); //miro que no exista en el hashmap con ese nombre
//        if (p!=null)
//        {
//            u.addPunto(p);
//            p.addUser(u);
//
//        }
//        else
//        {
//            List<User> auxList = new ArrayList<User>();
//            auxList.add(u);
//            PuntoInteres newPunto = new PuntoInteres(puntosInteres);
//            newPunto.setVisitas(auxList);
//
//
//
//
//            u.addPunto(newPunto);
//            //newPunto.addUser(u);
//
//
//        }
//        logger.info("new User " + u.getName() + " in location: "+ p.getInfo());
//
//        //this.users.replace(u, u.getPuntos(), u.addPunto(p));
//        logger.info("new Location " + p.getInfo() + " added to the user " + u.getName());
//
//        //return u;
    }


    public void addNewByName(String name, String lugar){
        User u =users.get(name); //Intentamos sacarlo del hashmap
        PuntoInteres p = puntos.get(lugar);
        if (u!=null && p!= null) //ya existen ambos
        {
            logger.info("Este usuario "+name+ " ha pasado por " + lugar);
            u.addPunto(p); //simplemente añadimos a las respectivas colas
            p.addUser(u);
        }

        else if (u==null && p!=null) //Usuario es nuevo y p ya existe
        {
            List<PuntoInteres> listPunt = new ArrayList<>();
            listPunt.add(p); //preparo lista de puntos con ese punto
            User uAux = new User(name, listPunt);
            users.put(name, uAux);
            p.addUser(uAux);
            puntos.put(lugar,p);

        }

        else if (u!=null && p==null) //Usuario ya existe y p es nuevo
        {
            List<User> listUsuarios = new ArrayList<>();
            listUsuarios.add(u); // preparo lista de usuarios con ese user
            PuntoInteres pAux = new PuntoInteres(lugar, listUsuarios);
            puntos.put(lugar, pAux);
            u.addPunto(pAux);
            users.put(name, u);

        }
        else if (u==null && p==null)
        {
            User userTemp = new User(name);
            PuntoInteres puntTemp = new PuntoInteres(lugar);
            List<PuntoInteres> listPunt = new ArrayList<>();
            listPunt.add(puntTemp); //preparo lista de puntos con ese punto
            List<User> listUsuarios = new ArrayList<>();
            listUsuarios.add(userTemp); // preparo lista de usuarios con ese user
            User uAux = new User(name, listPunt);
            PuntoInteres pAux = new PuntoInteres(lugar, listUsuarios);
            users.put(name, uAux);
            puntos.put(lugar, pAux);


        }

    }
    public List<User> findAll (){
        List<User> listAll = new ArrayList<>(users.values());
        return listAll;
    }
    public User getUser(String name)
    {
        User u = users.get(name);
        return u;
    }

    public List<User> listFromLocation (String nameLocation)
    {
        PuntoInteres puntoAuxiliar = puntos.get(nameLocation);
        return puntoAuxiliar.getListaOrdenaAlfabeticamente();
    }

    public List<PuntoInteres> ConsultarInfo(String name)
    {
        User u =users.get(name);
        List<PuntoInteres> listAux= u.getPuntos();
        int i=0;
        while (i< listAux.size())
        {
            logger.info(u.getName() + " ha estado en " + listAux.get(i).getInfo());
            i++;
        }
        return listAux;
    }

    public List<PuntoInteres> listPlacesUserHaPasado (String nameUser)
    {
        User userAuxiliar = users.get(nameUser);
        return userAuxiliar.getPuntos();

    }


//    public User addUser(String name, List<PuntoInteres> puntosInteres) {
//        return this.addUser(new User(name, puntosInteres));
//    }

//
}

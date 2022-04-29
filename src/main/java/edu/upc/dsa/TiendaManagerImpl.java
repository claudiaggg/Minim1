package edu.upc.dsa;

import edu.upc.dsa.models.Articulo;
import edu.upc.dsa.models.Catalogo;
import edu.upc.dsa.models.Cliente;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class TiendaManagerImpl implements TiendaManager{
    private static TiendaManager instance;
    protected HashMap<String, Cliente> clientesMap = new HashMap<>();
    protected HashMap<String, Articulo> catalogoMap = new HashMap<>();

    final static Logger logger = Logger.getLogger(TiendaManagerImpl.class);

    private TiendaManagerImpl() {
//        this.clientesMap= new HashMap<>();
//        this.catalogoMap= new HashMap<>();
    }

    public static TiendaManager getInstance() {
        if (instance==null) instance = new TiendaManagerImpl();
        return instance;
    }
    public int size() {
        int ret = this.clientesMap.size();
        logger.info("size " + ret);

        return ret;
    }

    public void RegistroUsuario(String nombre, String apellidos, String fecha, String correo, String passw)
    {
        //Comprobamos que no exista ya alguien con ese correo electronico:
        Cliente c1= clientesMap.get(correo);

        if (c1==null)
        {
            Cliente c = new Cliente(nombre, apellidos, fecha,correo, passw);
            clientesMap.put(correo,c);
            logger.info("Cliente nuevo registrado: " + nombre + " " + apellidos );
        }
        else {
            logger.info("Error. Cliente " +  nombre + " " + apellidos +" ya esta registrado con ese correo electronico: " + correo
            );
        }
    }

    public void LogIn(String correo, String passw)
    {
        Cliente c= clientesMap.get(correo);
        if (c.getContraseña().equals(passw))
        {
            logger.info("Password correcta");
        }
        else {
            logger.info("Error. Password incorrecta");
        }

    }

    public void añadirArticuloAlCatalogo(String nombre, String descripcion, Double precio)
    {
        catalogoMap.put(nombre, new Articulo(nombre,descripcion,precio));
        logger.info("Producto " + nombre + " añadido correctamente");
    }

    public void comprarArticulo(String correoCliente, String articulo)
    {
        Cliente c= clientesMap.get(correoCliente);
        Articulo a= catalogoMap.get(articulo); //Asumimos que siempre existe el articulo

        if (c==null)  // Si el usuario no existe
        {
            logger.info("Este usuario, con este correo electronico" + correoCliente + "no existe");
        }
        else { // Si el usuario existe
            c.addArticuloLista(a); //Añadimos a su lista de comprados, este articulo
            double nuevoSaldo = c.getSaldo() - a.getPrecio(); //Calculamos el saldo que le quedara despues de la compra
            if (nuevoSaldo>0) //Comprobamos que sea positivo
            {
                c.setSaldo(nuevoSaldo); // Lo modificamos
                logger.info("Articulo comprado. El usuario " + c.getNombre() + " " + c.getApellidos()+ " tiene actualmente un saldo de: " + c.getSaldo()+ " dsaCoins");

            }

        }
    }

    public List<Articulo> findAllArticulosDescPorPrecio ()
    {
        List<Articulo> listAll = new ArrayList<>(catalogoMap.values());
        Catalogo c = new Catalogo(listAll);
        c.OrdenarCatalogoDescendiente();
        int i=0;
        while (i<c.getCatalogo().size())
        {
            logger.info(c.getCatalogo().get(i).getNombreArticulo() + " precio " + c.getCatalogo().get(i).getPrecio() + " dsaCoins");
            i++;
        }
        return c.getCatalogo();
    }

    public List<Articulo> articulosCompradosPor (String correo)
    {
        Cliente c = clientesMap.get(correo);
        List<Articulo> listaC= c.getListaComprados();

        return listaC;
    }

    public List<Cliente> OrdenadosAlfabeticamente ()
    {
        List<Cliente> listAll = new ArrayList<>(clientesMap.values());

        Comparator<Cliente> listComparada = Comparator
                                .comparing(Cliente::getApellidos)
                                .thenComparing(Cliente::getNombre);

        List<Cliente> listaOrdenada = listAll.stream()
                .sorted(listComparada)
                .collect(Collectors.toList());

        int i=0;
        while (i<listaOrdenada.size())
        {
            logger.info(listaOrdenada.get(i).getNombre() + " " + listaOrdenada.get(i).getApellidos());
            i++;
        }

        return listaOrdenada;

    }
}

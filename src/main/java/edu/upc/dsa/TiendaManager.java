package edu.upc.dsa;
import edu.upc.dsa.models.Cliente;
import edu.upc.dsa.models.Articulo;
import edu.upc.dsa.models.Catalogo;

import java.util.HashMap;
import java.util.List;

public interface TiendaManager {

    public int size();
    public void RegistroUsuario(String nombre, String apellidos, String fecha, String correo, String passw);
    public void LogIn(String correo, String passw);
    public void añadirArticuloAlCatalogo(String nombre, String descripcion, Double precio);
    public void comprarArticulo(String correoCliente, String articulo);
    public List<Articulo> findAllArticulosDescPorPrecio ();
    public List<Articulo> articulosCompradosPor (String correo);
    public List<Cliente> OrdenadosAlfabeticamente ();
}

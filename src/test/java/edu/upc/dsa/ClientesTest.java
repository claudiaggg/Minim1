package edu.upc.dsa;
import edu.upc.dsa.models.Articulo;
import edu.upc.dsa.models.Cliente;
import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ClientesTest {

    TiendaManager myTiendaManager;

    @Before
    public void setUp() throws Exception{
        this.myTiendaManager = TiendaManagerImpl.getInstance();
    }

    @After
    public void tearDown() {
        // this.myTiendaManager.clear();
    }

    @Test
    public void testTienda() throws Exception {
        myTiendaManager.RegistroUsuario("Claudia", "Garica Gil", "7 mayo 1999", "claudia@gmail.com", "123");
        myTiendaManager.RegistroUsuario("Pepito", "Grillo", "7 mayo 1999", "claudia@gmail.com", "1727");
        myTiendaManager.LogIn("claudia@gmail.com", "123");
        myTiendaManager.RegistroUsuario("Carla", "Lopez", "7 mayo 1999", "carla@gmail.com", "1282393");
        myTiendaManager.RegistroUsuario("Paula", "Fern", "7 mayo 1999", "paula@gmail.com", "390294f");
        myTiendaManager.añadirArticuloAlCatalogo("Patatas", "Bolsa Patatas 100g", 1.5);
        myTiendaManager.añadirArticuloAlCatalogo("Agua", "Agua mineral", 3.0);
        myTiendaManager.añadirArticuloAlCatalogo("Bocadillo", "Bocadillo atun", 7.0);
        myTiendaManager.añadirArticuloAlCatalogo("Boligrafo", "Boli azul", 0.75);
        myTiendaManager.añadirArticuloAlCatalogo("Refresco", "Cocacola", 5.0);
        myTiendaManager.comprarArticulo("claudia@gmail.com", "Patatas");
        myTiendaManager.comprarArticulo("carla@gmail.com", "Refresco");
        myTiendaManager.comprarArticulo("paula@gmail.com", "Refresco");
        myTiendaManager.comprarArticulo("paula@gmail.com", "Patatas");
        List<Articulo> catalogo1 = myTiendaManager.findAllArticulosDescPorPrecio();
        Assert.assertEquals("Bocadillo", catalogo1.get(0).getNombreArticulo());
        List<Articulo> compradosPor = myTiendaManager.articulosCompradosPor("carla@gmail.com");
        Assert.assertEquals("Refresco", compradosPor.get(0).getNombreArticulo());

    }

    @Test
    public void testAlfabeticamente() throws Exception {
        myTiendaManager.RegistroUsuario("Claudia", "Garcia Gil", "7 mayo 1999", "claudia@gmail.com", "123");
        myTiendaManager.RegistroUsuario("Pepito", "Garcia Gil", "7 mayo 1999", "pepi@gmail.com", "1727");
        myTiendaManager.RegistroUsuario("Claudia", "Fernandez Gil", "7 mayo 1999", "claudia1@gmail.com", "123");
        myTiendaManager.RegistroUsuario("Jose", "Pascual Gil", "7 mayo 1999", "pepi1@gmail.com", "1727");
        myTiendaManager.RegistroUsuario("Jose", "Alvarez Gil", "7 mayo 1999", "pepi3@gmail.com", "1727");

        List<Cliente> clientOrdenados = myTiendaManager.OrdenadosAlfabeticamente();
        Assert.assertEquals("Jose", clientOrdenados.get(0).getNombre());
        Assert.assertEquals("Claudia", clientOrdenados.get(1).getNombre());
        Assert.assertEquals("Claudia", clientOrdenados.get(2).getNombre());



    }
}

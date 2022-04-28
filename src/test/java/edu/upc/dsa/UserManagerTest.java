package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.PuntoInteres;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserManagerTest {

    UsersManager myUserManager;

    @Before
    public void setUp() throws Exception{
        this.myUserManager = UsersManagerImpl.getInstance();
    }

    @After
    public void tearDown() {
        // this.myProductManager.clear();
    }

    @Test
    public void testNum1() throws Exception {
        User u1 = new User("Claudia");
        User u2 = new User("Toni");
        PuntoInteres biblio = new PuntoInteres("Biblioteca");
        PuntoInteres cafeteria = new PuntoInteres("Cafeteria");
        PuntoInteres claseG130 = new PuntoInteres("G130");
        PuntoInteres fuente = new PuntoInteres("Fuente");
        myUserManager.addNewUser(u1,biblio);
        int s1=myUserManager.size();
        Assert.assertEquals(1, s1);
        myUserManager.addNewUser(u2,cafeteria);
        myUserManager.addNewUser(u1,cafeteria);
        myUserManager.addNewUser(u1,biblio);
        myUserManager.addNewUser(u1,claseG130);
//        myUserManager.addLocationExisting("Claudia","Cafeteria");
//        myUserManager.addLocationExisting("Claudia","Biblioteca");
//        myUserManager.addLocationExisting("Claudia","G130");
        Assert.assertEquals("Cafeteria", u1.getPuntos().get(1).getInfo());
        List<PuntoInteres> sitiosPorLosQueHaPasado = myUserManager.ConsultarInfo("Claudia");
        Assert.assertEquals("Biblioteca", sitiosPorLosQueHaPasado.get(0).getInfo());
        Assert.assertEquals("Cafeteria", sitiosPorLosQueHaPasado.get(1).getInfo());
        Assert.assertEquals("Biblioteca", sitiosPorLosQueHaPasado.get(2).getInfo());
        Assert.assertEquals("G130", sitiosPorLosQueHaPasado.get(3).getInfo());
//        List<PuntoInteres> listaU1 = myUserManager.findAllLocationsUser("Claudia");
//        Assert.assertEquals("Biblioteca",listaU1.get(0));
//        Assert.assertEquals("Cafeteria",listaU1.get(1));

    }

    @Test
    public void testNum2() throws Exception {


    }
}

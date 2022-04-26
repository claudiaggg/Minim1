package edu.upc.dsa;

import edu.upc.dsa.models.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProductMaganerTest {
    ProductManager myProductManager;


    @Before
    public void setUp() throws Exception{
        this.myProductManager = ProductManagerImpl.getInstance();
    }

    @After
    public void tearDown() {
       // this.myProductManager.clear();
    }

    @Test
    public void testGetProduct() throws Exception {
        Product product1= new Product("bocadillo", 3.0);
        myProductManager.addProduct(product1);
        int s1=myProductManager.size();
        Assert.assertEquals(1, s1);

        Product product3= new Product("zumo", 2.5);
        myProductManager.addProduct("cafe", 1.5);
        myProductManager.addProduct(product3);
        List<Product> myList= myProductManager.findAll();
        Double pp1 = myList.get(0).getPrice();
        Assert.assertEquals(1.5, pp1, 0.5);
        Double pp2 = myList.get(1).getPrice();
        Assert.assertEquals(2.5, pp2, 0.5);
        Double pp3 = myList.get(2).getPrice();
        Assert.assertEquals(3.0, pp3, 0.5);

    }

    @Test
    public void testGetPRoductBySales() throws Exception {
        Product product1= new Product("bocadillo", 3.0);
        myProductManager.addProduct(product1);
        int s1=myProductManager.size();
        Assert.assertEquals(1, s1);

        Product product3= new Product("zumo", 2.5);
        //product3.setSales(35);
        myProductManager.addProduct("cafe", 1.5);
        myProductManager.addProduct(product3);
        //List<Product> myList= myProductManager.findAllBySales();
        List<Product> myList= myProductManager.findAll();

        Double pp1 = myList.get(0).getPrice();
        Assert.assertEquals(1.5, pp1, 0.5);
        Double pp2 = myList.get(1).getPrice();
        Assert.assertEquals(2.5, pp2, 0.5);
        Double pp3 = myList.get(2).getPrice();
        Assert.assertEquals(3.0, pp3, 0.5);









        //Double p1 = ProductManagerImpl.getInstance().getProduct("bocadillo").getPrice();
        //Assert.assertEquals(3.0, p1,0.1);

//        String p2 = ProductManager.getInstance().getProduct("ca","l1");
//        Assert.assertEquals("hola", msg1Bis);
    }
}

package edu.upc.dsa;

import edu.upc.dsa.models.Track;

import java.util.List;
import edu.upc.dsa.models.Product;



public interface ProductManager {

    public Product addProduct(String id, Double price);
    public Product addProduct(Product p);
    public Product getProduct(String id);
    public List<Product> findAll();
//    public void deleteProduct(String id);
//    public Track updateProduct(Track t);

    public int size();
}

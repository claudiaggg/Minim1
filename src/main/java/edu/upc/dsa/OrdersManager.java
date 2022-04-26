package edu.upc.dsa;

import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.Order;

import java.util.List;

public interface OrdersManager {
    public Order addOrder(String client, List<Product> order);
    public Order addOrder(Order o);
    public Order getOrder(String client);
//    public List<Product> findAllOrders();
//    public void deleteProduct(String id);
//    public Track updateProduct(Track t);

    public int size();
}

package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.List;

public class Order {
    String client;
    List<Product> order;

    public Order() {

    }

    public Order(String client, List<Product> order) {
        this();
        this.setClient(client);
        this.setOrders(order);
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client=client;
    }


    public List<Product> getOrders() {
        return order;
    }

    public void setOrders(List<Product> order) {
        this.order = order;
    }



}

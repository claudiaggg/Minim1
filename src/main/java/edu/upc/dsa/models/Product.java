package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Product {

    String id;
    Double price;
    //static int lastId;

    public Product() {
        this.id = RandomUtils.getId();
    }

    public Product(String id, Double price) {
        this.setId(id);
        this.setPrice(price);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product [id="+id+", price=" + price +"]";
    }
}

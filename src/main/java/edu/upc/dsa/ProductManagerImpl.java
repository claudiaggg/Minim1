package edu.upc.dsa;

import edu.upc.dsa.models.Product;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import edu.upc.dsa.models.Track;
import org.apache.log4j.Logger;

public class ProductManagerImpl implements ProductManager{

    private static ProductManager instance;
    protected List<Product> products;
    final static Logger logger = Logger.getLogger(ProductManagerImpl.class);

    private ProductManagerImpl() {
        this.products = new LinkedList<>();
    }

    public static ProductManager getInstance() {
        if (instance==null) instance = new ProductManagerImpl();
        return instance;
    }
    public int size() {
        int ret = this.products.size();
        logger.info("size " + ret);

        return ret;
    }

    public Product addProduct(Product p) {
        logger.info("new Product " + p);

        this.products.add (p);
        logger.info("new Product added");
        return p;
    }

    public Product addProduct(String id, Double price) {
        return this.addProduct(new Product(id, price));
    }

    public Product getProduct(String id) {
        logger.info("getProduct("+id+")");

        for (Product p: this.products) {
            if (p.getId().equals(id)) {
                logger.info("getProduct("+id+"): "+p);

                return p;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Product> findAll() {
        Collections.sort(this.products,
                (Product o1, Product o2) -> Double.compare(o1.getPrice(), o2.getPrice()));

        return this.products;
    }


}

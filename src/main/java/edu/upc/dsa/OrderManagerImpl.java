package edu.upc.dsa;

import edu.upc.dsa.models.Order;
import edu.upc.dsa.models.Product;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class OrderManagerImpl implements OrdersManager{
    private static OrdersManager instance;
    protected List<Order> orders;
    final static Logger logger = Logger.getLogger(OrderManagerImpl.class);

    private OrderManagerImpl() {
        this.orders = new LinkedList<>();
    }

    public static OrdersManager getInstance() {
        if (instance==null) instance = new OrderManagerImpl();
        return instance;
    }
    public int size() {
        int ret = this.orders.size();
        logger.info("size " + ret);

        return ret;
    }

    public Order addOrder(Order o) {
        logger.info("new Order " + o);

        this.orders.add (o);
        logger.info("new Order added");
        return o;
    }

    public Order addOrder(String client, List<Product> order) {
        return this.addOrder(new Order(client, order));
    }

    public Order getOrder(String client) {
        logger.info("getProduct("+client+")");

        for (Order o: this.orders) {
            if (o.getClient().equals(client)) {
                logger.info("getOrder("+client+"): "+o);

                return o;
            }
        }

        logger.warn("not found " + client);
        return null;
    }


}

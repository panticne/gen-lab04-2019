package ch.heig.gen.lab04;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<Product>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return "{\"id\": "+id+", \"products\": [";
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append(getOrderId());

        for (int j = 0; j < getProductsCount(); j++) {
            sb.append(getProduct(j));
        }

        if (getProductsCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("]}, ");

        return sb.toString();
    }
}

package ch.heig.gen.lab04;

import java.util.ArrayList;
import java.util.List;

public class Order implements Jsonable {

    private final List<Product> products = new ArrayList<>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void toJson(JsonBuilder builder) {
        builder.startObject();
        builder.addAttribute("id", id);
        builder.addAttribute("products", products);
        builder.endObject();
    }
}

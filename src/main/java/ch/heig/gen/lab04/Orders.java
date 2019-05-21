package ch.heig.gen.lab04;

import java.util.ArrayList;
import java.util.List;

public class Orders implements Jsonable {

    private final List<Order> orders = new ArrayList<>();

    public void AddOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void toJson(JsonBuilder builder) {
        builder.startObject();
        builder.addAttribute("orders", orders);
        builder.endObject();
    }
}

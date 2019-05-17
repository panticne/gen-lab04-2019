package ch.heig.gen.lab04;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<Order>();

    public void AddOrder(Order order) {
        orders.add(order);
    }

    public int getOrdersCount() {
        return orders.size();
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");
        for (int i = 0; i < getOrdersCount(); i++) {
            sb.append(getOrder(i));
        }

        if (getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]}");

        return sb.toString();
    }
}

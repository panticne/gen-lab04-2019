package ch.heig.gen.lab04;

public class OrdersWriter {

    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        JsonBuilder builder = new JsonBuilder();
        orders.toJson(builder);
        return builder.toString();
    }
}

package ch.heig.gen.lab04;

public class OrdersWriter {
    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer sb = new StringBuffer("{\"orders\": [");
        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            sb.append(order.getOrderId());
            for (int j = 0; j < order.getProductsCount(); j++) {
                Product product = order.getProduct(j);
                sb.append(product.getCode());
                sb.append(getColorFor(product));

                if (product.getSize() != Size.NA) {
                    sb.append(getSizeFor(product));
                }
                sb.append(product.getPrice());
                sb.append(product.getCurrency());
            }

            if (order.getProductsCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }
            sb.append("]");
            sb.append("}, ");
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private String getSizeFor(Product product) {
        return "\"size\": \""+product.getSize().name()+"\", ";
    }

    private String getColorFor(Product product) {
        return product.getColor().name()+"\", ";
    }
}

package ch.heig.gen.lab04;

public class Product {
    private String code;
    private Colors color;
    private Size size;
    private double price;
    private String currency;

    public Product(String code, int color, int size, double price, String currency) {
        this.code = code;
        this.color = Colors.withId(color);
        this.size = Size.withId(size);
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public Colors getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}

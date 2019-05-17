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
        return "{\"code\": \""+code+"\", \"color\": \"";
    }

    public Colors getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public String getPrice() {
        return "\"price\": "+price+", \"currency\": \"" ;
    }

    public String getCurrency() {
        return currency+"\"}, ";
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getCode());
        sb.append(getColorFor(this));

        if (getSize() != Size.NA) {
            sb.append(getSizeFor(this));
        }
        sb.append(getPrice());
        sb.append(getCurrency());
        return sb.toString();
    }

    private String getSizeFor(Product product) {
        return "\"size\": \""+product.getSize().name()+"\", ";
    }

    private String getColorFor(Product product) {
        return product.getColor().name()+"\", ";
    }
}

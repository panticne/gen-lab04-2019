package ch.heig.gen.lab04;

public class Product implements Jsonable {

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

    @Override
    public void toJson(JsonBuilder builder) {

        builder.startObject();
        builder.addAttribute("code", code);
        builder.addAttribute("color", color.name());

        if (size != Size.NA) {
            builder.addAttribute("size", size.name());
        }

        builder.addAttribute("price", price);
        builder.addAttribute("currency", currency);
        builder.endObject();
    }
}

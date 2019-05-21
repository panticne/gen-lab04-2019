package ch.heig.gen.lab04;

public enum Size {

    XS(1), S(2), M(3), L(4), XL(5), XXL(6), NA(-1);

    private int id;

    Size(int size) {
        this.id = size;
    }

    public static Size withId(int id) {

        for (Size size : values()) {
            if (size.id == id) {
                return size;
            }
        }

        throw new IllegalArgumentException("Invalid id for Size.");
    }
}

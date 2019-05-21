package ch.heig.gen.lab04;

public enum Colors {

    blue(1), red(2), yellow(3);

    private int value;

    Colors(int value) {
        this.value = value;
    }

    public static Colors withId(int id) {

        for (Colors colors : values()) {
            if (colors.value == id) {
                return colors;
            }
        }

        throw new IllegalArgumentException("Invalid id for Size.");
    }
}

package ch.heig.gen.lab04;

public class JsonBuilder {

    private static final String OBJECT_START = "{";
    private static final String OBJECT_END = "}";

    private static final String OBJECT_ATTRIBUTE_ESCAPE = "\"";
    private static final String OBJECT_ATTRIBUTE_SEPARATOR = ": ";
    private static final String OBJECT_SEPARATOR = ", ";

    private static final String ARRAY_START = "[";
    private static final String ARRAY_END = "]";

    private final StringBuilder json = new StringBuilder();

    public void startObject() {
        json.append(OBJECT_START);
    }

    public void addAttribute(String name, Number value) {
        addAttribute(name, value.toString(), false);
    }

    public void addAttribute(String name, String value) {
        addAttribute(name, value, true);
    }

    public void addAttribute(String name, Iterable<? extends Jsonable> items) {

        addAttributePart(name, true);
        json.append(OBJECT_ATTRIBUTE_SEPARATOR);
        json.append(ARRAY_START);

        boolean wasEmpty = true;
        for (Jsonable item : items) {
            wasEmpty = false;
            item.toJson(this);
            json.append(OBJECT_SEPARATOR);
        }

        if (!wasEmpty) {
            removeLastObjectSeparator();
        }

        json.append(ARRAY_END);
        json.append(OBJECT_SEPARATOR);
    }

    private void addAttribute(String name, String value, boolean escapeValue) {
        addAttributePart(name, true);
        json.append(OBJECT_ATTRIBUTE_SEPARATOR);
        addAttributePart(value, escapeValue);
        json.append(OBJECT_SEPARATOR);
    }

    private void addAttributePart(Object part, boolean escape) {
        shouldEscape(escape);
        json.append(part);
        shouldEscape(escape);
    }

    private void shouldEscape(boolean escape) {
        if (escape) {
            json.append(OBJECT_ATTRIBUTE_ESCAPE);
        }
    }

    public void endObject() {
        removeLastObjectSeparator();
        json.append(OBJECT_END);
    }

    private void removeLastObjectSeparator() {
        //if (json.toString().endsWith(OBJECT_SEPARATOR)) {
            json.delete(json.length() - OBJECT_SEPARATOR.length(), json.length());
        //}
    }

    @Override
    public String toString() {
        return json.toString();
    }
}

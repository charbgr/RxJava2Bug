public class DummyObject {

    private final String value;

    DummyObject(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DummyObject{" +
                "value='" + value + '\'' +
                '}';
    }
}
